pipeline {
    agent any
    environment {
        CLIENT_ID = "723565485D034E88A38F489D94D11E17"
        SECRET_ID = "49061d773899f0f538536b49bc60d517787c8c591d3f68efab6de36728aa8761"
        XRAY_AUTH_URL = 'https://xray.cloud.getxray.app/api/v2/authenticate'
        GIT_REPO = 'https://github.com/WilliamLAY-dev/Jenkhins_ParaBank_Cucumber'
        XRAY_TOKEN = ""
    }

    stages {
        stage('Générer le token Xray') {
            steps {
                script {
                    def authResponse = bat(
                        script: """
                            curl -H "Content-Type: application/json" -X POST --data ^
                            "{\\"client_id\\": \\"${CLIENT_ID}\\", \\"client_secret\\": \\"${SECRET_ID}\\"}" ^
                            ${XRAY_AUTH_URL} 2> nul
                        """,
                        returnStdout: true
                    ).trim()

                    // Récupère la dernière ligne = le token
                    def lines = authResponse.readLines()
                    def token = lines[1].replaceAll('"', '').trim()

                    XRAY_TOKEN = token
                    echo "Xray Token: ${XRAY_TOKEN}"
                }
            }
        }

        stage('Importer les features de Xray') {
            steps {
                script {
                    def ImportResponse = bat(
                        script: """
                            curl -H "Content-Type: application/json" -X GET -H "Authorization: Bearer ${XRAY_TOKEN}"  "https://xray.cloud.getxray.app/api/v2/export/cucumber?keys=POEI20252-522" -o "xray_features.zip"
                        """,
                        returnStdout: true
                    ).trim()

                    echo "Features de Xray importées : ${ImportResponse}"
                    echo "Features sont sauvegardées dans le fichier xray_features.zip"
                }
            }
        }

        stage('Décompresser le fichier ZIP') {
            steps {
                script {
                    bat 'powershell -Command "Expand-Archive -Path xray_features.zip -DestinationPath src/test/resources/feature"'
                    echo "Décompression terminée"
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    bat 'mvn test' // Exécute les tests
                }
            }
        }

        stage('export resultat sur xray') {
            steps {
                script {
                    def ExportResponse = bat(
                        script: """
                            curl -H "Content-Type: application/json" -X POST -H "Authorization: Bearer ${XRAY_TOKEN}" --data @"cucumber.json" https://xray.cloud.getxray.app/api/v2/import/execution
                        """,
                        returnStdout: true
                    ).trim()

                    echo "Features de Xray exportées : ${ExportResponse}"
                }
            }
        }

        stage('Récupérer le rapport de test') {
            steps {
                script {
                    bat 'mvn surefire-report:report-only'
                    echo "Rapport de test généré"
                }
            }
        }
    }
}
