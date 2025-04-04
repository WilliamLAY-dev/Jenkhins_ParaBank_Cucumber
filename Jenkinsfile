pipeline {
    agent any

    environment {
        CLIENT_ID = '723565485D034E88A38F489D94D11E17'
        SECRET_ID = '49061d773899f0f538536b49bc60d517787c8c591d3f68efab6de36728aa8761'
        XRAY_URL = 'https://xray.cloud.getxray.app/api/v2/authenticate'
        GIT_REPO = 'https://github.com/WilliamLAY-dev/Jenkhins_ParaBank_Cucumber'
    }

    stages {
        stage('Générer le token Xray') {
            steps {
                script {
                   def token = bat """curl -H "Content-Type: application/json" -X POST --data '{ "client_id": "723565485D034E88A38F489D94D11E17","client_secret": "49061d773899f0f538536b49bc60d517787c8c591d3f68efab6de36728aa8761" }'  https://xray.cloud.getxray.app/api/v2/authenticate"""
                   echo "Token Xray: ${token}"
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
