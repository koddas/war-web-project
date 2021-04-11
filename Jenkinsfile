pipeline {
    agent any
    tools {
        maven 'Maven363'
    }
    options {
        timeout(10)
        buildDiscarder logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '5', numToKeepStr: '5')
    }
    stages {
        stage('Build') {
            steps {
                sh "mvn claen install"
            }
        }
    }
}