pipeline {
    agent any
    stages {
        stage('Info') {
            steps {
                sh "mvn -v"
            }
        }
        
        stage('Compile and Clean') {
            steps {
                sh "mvn clean compile"
            }
        }

        stage('Deploy') {
            steps {
                sh "mvn package"
            }
        }

        stage('Build Docker image'){
            steps {
                sh 'docker build -t myhealthproject/myhealth-backend:${BUILD_NUMBER} .'
            }
        }

        stage('Docker Login'){
            steps {
                 withCredentials([string(credentialsId: 'DockerId', variable: 'Dockerpwd')]) {
                    sh "docker login -u myhealthproject -p ${Dockerpwd}"
                }
            }
        }

        stage('Docker Push'){
            steps {
                sh 'docker push myhealthproject/myhealth-backend:${BUILD_NUMBER}'
            }
        }

        stage('Docker deploy'){
            steps {
                sh 'docker run -itd -p  8081:8080 myhealthproject/myhealth-backend:${BUILD_NUMBER}'
            }
        }

        stage('Archving') {
            steps {
                 archiveArtifacts '**/target/*.jar'
            }
        }
    }
}
