pipeline {
    agent any

    environment {
        GIT_REPO_URL = "https://github.com/WilliamLAY-dev/Jenkhins_ParaBank_Cucumber" // Git repository URL
        GIT_BRANCH = "main" // Git branch to use
        XRAY_CLIENT_ID = "6205FBA04AB4417D8B960E99E55FCC35" // Xray client ID
        XRAY_CLIENT_SECRET = "5b9b5ac70c2a150b07417e1c18d30e8222aa5c744e842805ceef46fe33f7a210" // Xray client secret
        XRAY_TOKEN = "" // To store the token
    }

    stages {
        stage('Generate Xray Token') {
            steps {
                script {
                    // Send the POST request to get the Xray token
                    def response = bat(
                        script: """curl -s -H "Content-Type: application/json" -X POST --data "{\\"client_id\\": \\"%XRAY_CLIENT_ID%\\", \\"client_secret\\": \\"%XRAY_CLIENT_SECRET%\\"}" https://xray.cloud.getxray.app/api/v2/authenticate""",
                        returnStdout: true
                    ).trim() // Ensure there's no extra space or newline

                    // Debugging: log the response
                    echo "Token Response: '${response}'"

                    // Try to extract the token using Groovy's JSON parsing capabilities
                    def jsonResponse = readJSON text: response
                    env.XRAY_TOKEN = jsonResponse.token // Assuming the token is inside the 'token' key

                    // Debugging: Check if the token was set correctly
                    echo "Extracted Xray Token: ${env.XRAY_TOKEN}"
                }
            }
        }

        stage('Use Xray Token') {
            steps {
                script {
                    // Log the token to verify it's correctly set
                    echo "Using Xray Token: '${env.XRAY_TOKEN}'"
                }
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
