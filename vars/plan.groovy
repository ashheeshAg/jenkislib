def call(Map stageParams) {
 
    sh  '''
                    az login --service-principal -u stageParams.ARM_CLIENT_ID -p stageParams.ARM_CLIENT_SECRET --tenant stageParams.ARM_TENANT_ID
                  '''


              sh (script:"cd terraform-plans/create && terraform plan -out=tfplan -input=false")
			  
  }