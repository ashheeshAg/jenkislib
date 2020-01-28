#!/usr/bin/env groovy
@Library('jenkislib@master')
  terraform (
        gitCredentialsId: 'master'
        gitRepo: 'ssh://git@myScmServer.com/repos/myRepo.git'
        ARM_CLIENT_ID: '8080'
        ARM_CLIENT_SECRET: 'dev-myproject.mycompany.com'
        ARM_TENANT_ID: 'staging-myproject.mycompany.com'
        containerName: 'production-myproject.mycompany.com'
        storageCredentialId:'skdl'
  )
  

