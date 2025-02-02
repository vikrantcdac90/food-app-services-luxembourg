pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
               echo "checked out code"
            }
        }

        stage('Build & Compile') {
            steps {
                echo "build and compile"
            }
        }

        stage('Run JUnit Tests') {
            steps {
                echo "unit test run"
            }
            post {
                always {
                    echo "success"
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
               echo "sonar analysis done"
            }
        }

        stage('Check Test Coverage') {
            steps {
               echo "test coverage"
            }
            post {
                success {
                    echo "JaCoCo Test Coverage Report Generated Successfully"
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                "docker image build"
            }
        }

        stage('Deploy') {
            steps {
                echo "deploy docker image"
            }
        }
    }

    post {
        success {
            echo "Pipeline executed successfully!"
        }
        failure {
            echo "Pipeline failed! Check the logs."
        }
    }
}
