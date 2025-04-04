pipeline {
    agent any

    environment {
        CLIENT_ID = '6205FBA04AB4417D8B960E99E55FCC35'
        SECRET_ID = '5b9b5ac70c2a150b07417e1c18d30e8222aa5c744e842805ceef46fe33f7a210'
        GIT_REPO = 'https://github.com/WilliamLAY-dev/Jenkhins_ParaBank_Cucumber'
        XRAY_TOKEN_URL = 'https://xray.cloud.xpand-it.com/api/v2/authenticate' // L'URL de l'API Xray
    }

    stages {
        stage('Récupérer le token Xray') {
            steps {
                script {
                    // Créer le payload pour la demande du token Xray
                    def payload = """{
                        "client_id": "${CLIENT_ID}",
                        "client_secret": "${SECRET_ID}"
                    }"""

                    // Effectuer la demande HTTP pour récupérer le token Xray
                    def response = httpRequest(
                        url: XRAY_TOKEN_URL,
                        httpMode: 'POST',
                        contentType: 'APPLICATION_JSON',
                        requestBody: payload
                    )

                    // Extraire le token de la réponse
                    def jsonResponse = readJSON text: response
                    env.XRAY_TOKEN = jsonResponse.token
                    echo "Token Xray généré avec succès."
                }
            }
        }

        stage('Récupérer les fichiers .feature depuis Git') {
            steps {
                script {
                    // Cloner le dépôt Git
                    echo "Clonage du dépôt Git..."
                    git url: GIT_REPO, branch: 'main'

                    // Récupérer les fichiers .feature
                    def featureFiles = findFiles(glob: '**/*.feature')

                    // Afficher les fichiers .feature trouvés
                    echo "Fichiers .feature trouvés :"
                    featureFiles.each { file ->
                        echo file.name
                    }
                }
            }
        }

        stage('Action après récupération des fichiers .feature') {
            steps {
                script {
                    // Exemple d'action : afficher le contenu des fichiers .feature (facultatif)
                    featureFiles.each { file ->
                        def fileContent = readFile(file.path)
                        echo "Contenu du fichier ${file.name} :"
                        echo fileContent
                    }
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
