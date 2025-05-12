pipeline {
    agent any
    tools {
        maven 'Maven363'
    }
    options {
        timeout(10)
        buildDiscarder logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '5', numToKeepStr: '5')
    }
    environment {
        SONAR_AUTH_TOKEN = credentials('Jenkins-token') // Replace with your actual Jenkins credentials ID
    }
    stages {
        stage('Build') {
            steps {
                sh "mvn clean install"
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('Jenkins-sonarqube') { // Replace with your Jenkins SonarQube server name
                    sh 'mvn sonar:sonar -Dsonar.login=$SONAR_AUTH_TOKEN'
                }
            }
        }
        stage('Upload Artifact to Nexus') {
            steps {
                nexusArtifactUploader artifacts: [
                    [
                        artifactId: 'wwp', 
                        classifier: '', 
                        file: 'target/wwp-1.0.0.war', 
                        type: 'war'
                    ]
                ], 
                    credentialsId: 'nexus3', 
                    groupId: 'koddas.web.war', 
                    nexusUrl: '10.0.0.91:8081', 
                    nexusVersion: 'nexus3', 
                    protocol: 'http', 
                    repository: 'samplerepo', 
                    version: '1.0.0'
            }
        }
    }
    post {
        always {
            deleteDir()
        }
        failure {
            echo "sendmail -s mvn build failed receipients@my.com"
        }
        success {
            echo "The job is successful"
        }
    }
}

