#!/usr/bin/env groovy

def call(String version, String appName, String env, String terraformDir=appName) {

    checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [[$class: 'RelativeTargetDirectory', relativeTargetDir: '']], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '1e254ac4-b4dc-4776-934a-68648fc697aa', url: '']]])
    writeFile file: "${terraformDir}/${env}/terraform.tfvars", text: """
    """
    withCredentials([usernamePassword(credentialsId: '1e254ac4-b4dc-4776-934a-68648fc697aa', passwordVariable: 'AZURE_SECRET_ACCESS_KEY', usernameVariable: 'AZURE_ACCESS_KEY_ID')]) {
        sh "terraform apply -e ${terraformDir}/${env}"
    }
}

