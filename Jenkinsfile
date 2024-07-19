pipeline {
    agent { label 'ubuntu-server' }

    environment {
        DOCKER_IMAGE_NAME = 'basic-crud-app'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/NaokiNakao/BasicCrudApp.git'
            }
        }

        stage('Build') {
            steps {
                script {
                    sh """
                    docker build -t ${DOCKER_IMAGE_NAME} .
                    """
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    sh """
                    docker run -d --name my-api -p 8080:8080 ${DOCKER_IMAGE_NAME}
                    """
                }
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}
