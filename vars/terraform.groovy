#!/usr/bin/env groovy
def call(Map stageParams) {
 
    
   stages {
      stage('Terraform init'){
          steps {
              // Initialize the plan 
              sh  """
                  terraform init -input=false
                  """
          }
      }
      stage('Terraform plan'){
          steps {  
              
              // Get the VM image ID for the VMSS  
              sh  '''
                    az login --service-principal -u stageParams.ARM_CLIENT_ID -p stageParams.ARM_CLIENT_SECRET --tenant stageParams.ARM_TENANT_ID
                  '''


              sh (script:"cd terraform-plans/create && terraform plan -out=tfplan -input=false")
                    
          }
      }
       
      stage('Terraform apply'){
          steps {
              // Apply the plan
              sh  """  
                  cd terraform-plans/create
                  terraform apply -input=false -auto-approve "tfplan"
                  """
          }
      }
      stage('Upload tfstate'){
         steps {
              // Upload the state of the plan to Azure Blob Storage
              sh (script: "cd terraform-plans/create && tar -czvf ~/workspace/${env.JOB_NAME}/$deployment'.tar.gz' .")
              sh "pwd"
              azureUpload blobProperties: [cacheControl: '', contentEncoding: '', contentLanguage: '', contentType: '', detectContentType: true], containerName: stageParams.containerName, fileShareName: '', filesPath: '${deployment}.tar.gz', storageCredentialId: stageParams.storageCredentialId, storageType: 'blobstorage'
              
          }
      }
    }
   
    }

