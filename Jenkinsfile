pipeline {
    agent any

    environment {
        GIT_REPO_URL = "https://github.com/WilliamLAY-dev/Jenkhins_ParaBank_Cucumber" // URL de ton dépôt Git
        GIT_BRANCH = "main" // Branche du dépôt à utiliser
        XRAY_CLIENT_ID = "6205FBA04AB4417D8B960E99E55FCC35"
        XRAY_CLIENT_SECRET = "5b9b5ac70c2a150b07417e1c18d30e8222aa5c744e842805ceef46fe33f7a210"
    }

    stages {
         stages {
                stage('Generate Xray Token') {
                    steps {
                        script {
                            def response = sh(
                                script: """curl -s -H "Content-Type: application/json" -X POST --data '{\"client_id\": \"${CLIENT_ID}\", \"client_secret\": \"${CLIENT_SECRET}\"}' https://xray.cloud.getxray.app/api/v2/authenticate""",
                                returnStdout: true
                            ).trim()

                            echo "Token Response: ${response}"
                        }
                    }
                }
            }
        /*stage('Cleanup Workspace') {
            steps {
                script {
                    bat 'rmdir /s /q repository || exit 0'
                }
            }
        }

        stage('Checkout Git Repository') {
            steps {
                script {
                    // Cloner le dépôt Git
                    bat "git clone --branch ${GIT_BRANCH} ${GIT_REPO_URL} repository"
                }
            }
        }

        stage('Run Tests with Features from Git Repo') {
            steps {
                script {
                    // Exécuter les tests Cucumber en utilisant les features récupérées du dépôt Git
                    bat 'mvn test -Dcucumber.features=src/test/resources/features/connexion.feature -Dcucumber.plugin=json:target/cucumber.json'
                }
            }
        }

        stage('Upload Test Results to Xray') {
            steps {
                script {
                    // Envoyer les résultats des tests vers Xray
                    bat """
                        curl -H "Content-Type: application/json" ^
                             -H "Authorization: Bearer ${XRAY_TOKEN}" ^
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
}
