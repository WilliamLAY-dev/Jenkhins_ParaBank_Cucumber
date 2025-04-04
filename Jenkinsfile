pipeline {
    agent any

    environment {
        CLIENT_ID = '32A27E69B0AC4E539C1401643799E8E7'
        SECRET_ID = 'd62f81eb9ed859e11e54356dd8a00e4a5f0d0c2a2b52340776f6c7d6d757b962'
        XRAY_URL = 'https://xray.cloud.getxray.app/api/v2/authenticate'
        GIT_REPO = 'https://github.com/WilliamLAY-dev/Jenkhins_ParaBank_Cucumber'
    }

    stages {
        stage('Générer le token Xray') {
            steps {
                script {
                    // Exécuter la commande curl via bat sous Windows
                    def response = bat(script: """
                        curl -H "Content-Type: application/json" -X POST ^
                        --data "{ \\"client_id\\": \\"${CLIENT_ID}\\", \\"client_secret\\": \\"${SECRET_ID}\\" }" ^
                        ${XRAY_URL}
                    """, returnStdout: true).trim()

                    // Parse la réponse JSON pour extraire le token
                    def jsonResponse = readJSON text: response
                    env.XRAY_TOKEN = jsonResponse.token
                    echo "Token Xray généré avec succès."
                }
            }
        }
    }

    post {
        always {
            // Nettoyage ou actions à faire après chaque exécution
            echo 'Pipeline terminé.'
        }
    }
}
