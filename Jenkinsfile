pipeline {
    agent any

    environment {
        GIT_REPO_URL = "https://github.com/WilliamLAY-dev/Jenkhins_ParaBank_Cucumber" // Git repository URL
        GIT_BRANCH = "main" // Git branch to use
        XRAY_CLIENT_ID = "6205FBA04AB4417D8B960E99E55FCC35"
        XRAY_CLIENT_SECRET = "5b9b5ac70c2a150b07417e1c18d30e8222aa5c744e842805ceef46fe33f7a210"
        XRAY_TOKEN = "" // Declare the token in the environment
    }

    stages {
        stage('Generate Xray Token') {
            steps {
                script {
                    def response = bat """curl -s -H "Content-Type: application/json" -X POST --data "{\\"client_id\\": \\"%XRAY_CLIENT_ID%\\", \\"client_secret\\": \\"%XRAY_CLIENT_SECRET%\\"}" https://xray.cloud.getxray.app/api/v2/authenticate"""
                    echo "Token Response: ${response}"
                    env.XRAY_TOKEN = response.replaceAll('"', '') // Update global environment variable
                }
            }
        }

        /*stage('Use Xray Token') {
            steps {
                script {
                    echo "Using Xray Token: ${env.XRAY_TOKEN}" // Example usage
                }
            }
        }*/
/*
        stage('Checkout Git Repository') {
            steps {
                script {
                    bat "git clone --branch %GIT_BRANCH% %GIT_REPO_URL% repository"
                }
            }
        }

        stage('Run Tests with Features from Git Repo') {
            steps {
                script {
                    bat 'mvn test -Dcucumber.features=src/test/resources/features/connexion.feature -Dcucumber.plugin=json:target/cucumber.json'
                }
            }
        }

        stage('Upload Test Results to Xray') {
            steps {
                script {
                    bat """
                        curl -H "Content-Type: application/json" ^
                             -H "Authorization: Bearer %XRAY_TOKEN%" ^
                             -X POST --data @target/cucumber.json ^
                             "https://xray.cloud.getxray.app/api/v2/import/execution/cucumber?projectKey=POEI20252"
                    """
                }
            }
        }*/

        stage('Publish Cucumber Reports') {
            steps {
                cucumber fileIncludePattern: 'target/cucumber.json'
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
