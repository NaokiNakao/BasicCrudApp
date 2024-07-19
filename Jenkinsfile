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
                    sh 'docker stop $(docker ps -q) && docker rm $(docker ps -a -q)'
                    sh 'docker -d run --name my-api -p 8080:8080 ${DOCKER_IMAGE_NAME}'
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
