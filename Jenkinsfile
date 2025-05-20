pipeline {
    agent any

    environment {
        MAVEN_HOME = tool 'M3'
    }

    stages {
        stage('Checkout') {
            steps {
                sshagent(['git-ssh-key']) {
                    git url: 'git@github.com:koddas/war-web-project.git', branch: 'main'
                }
            }
        }

        stage('Build') {
            steps {
                sh "${MAVEN_HOME}/bin/mvn clean package"
            }
        }

        stage('Archive WAR') {
            steps {
                archiveArtifacts artifacts: '**/target/*.war', fingerprint: true
            }
        }
    }

    post {
        success {
            echo "Build successful. WAR file archived."
        }
        failure {
            echo "Build failed."
        }
    }
}
