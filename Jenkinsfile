#!/usr/bin/env groovy
pipeline {
  agent {
    label 'terraform'
  }
  environment {
        gitCredentialsId = 'master'
        gitRepo = 'ssh://git@myScmServer.com/repos/myRepo.git'
        ARM_CLIENT_ID = '8080'
        ARM_CLIENT_SECRET = 'dev-myproject.mycompany.com'
        ARM_TENANT_ID = 'staging-myproject.mycompany.com'
        containerName = 'production-myproject.mycompany.com'
        storageCredentialId=''
  }
  stages {
    stage('Tests') {
      steps {
        sh 'echo "We need to add tests here"'
      }
    }
  }
}
