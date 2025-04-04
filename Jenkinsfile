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

                    //echo "Xray Authentication Response: ${authResponse}"

                    // Récupère la dernière ligne = le token
                    def lines = authResponse.readLines()
                    def token = lines[1].replaceAll('"', '').trim()

                    XRAY_TOKEN = token
                    echo "Xray Token: ${XRAY_TOKEN}"
                }
            }
        }
    }
}
