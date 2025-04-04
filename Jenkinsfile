pipeline {
    agent any  // This defines that the pipeline can run on any available agent

    environment {
        // Declare environment variables to store important values
        GIT_REPO_URL = "https://github.com/WilliamLAY-dev/Jenkhins_ParaBank_Cucumber" // Git repository URL
        GIT_BRANCH = "main" // Branch of the Git repository to use
        XRAY_CLIENT_ID = "6205FBA04AB4417D8B960E99E55FCC35" // Xray client ID for authentication
        XRAY_CLIENT_SECRET = "5b9b5ac70c2a150b07417e1c18d30e8222aa5c744e842805ceef46fe33f7a210" // Xray client secret for authentication
        XRAY_TOKEN = "" // Declare the environment variable to store the Xray token (initially empty)
    }

    stages {
        // Stage for generating the Xray token
        stage('Generate Xray Token') {
            steps {
                script {
                    // Send a POST request to the Xray API to get the authentication token
                    def response = bat(
                        script: """curl -s -H "Content-Type: application/json" -X POST --data "{\\"client_id\\": \\"%XRAY_CLIENT_ID%\\", \\"client_secret\\": \\"%XRAY_CLIENT_SECRET%\\"}" https://xray.cloud.getxray.app/api/v2/authenticate""",
                        returnStdout: true  // Capture the output of the command
                    ).trim()  // Remove any extra spaces or newlines from the response

                    // Debugging: Log the token response to the console for debugging
                    echo "Token Response: '${response}'"  // Wrapped in single quotes for visibility

                    // Check if the response is correctly captured
                    if (response) {
                        // If the response is not null, clean the token string (remove quotes, etc.)
                        env.XRAY_TOKEN = response.replaceAll('"', '') // Removes the quotes around the token
                    } else {
                        // If the response is null, print an error message
                        error("Failed to retrieve Xray token")
                    }
                }
            }
        }

        // Stage to demonstrate usage of the Xray token in subsequent steps
        stage('Use Xray Token') {
            steps {
                script {
                    // Debugging: Log the value of the Xray token to ensure it was captured correctly
                    echo "Using Xray Token: '${env.XRAY_TOKEN}'" // This will print the token for verification
                }
            }
        }
    }

    post {
        always {
            // This block will always run after all stages finish
            junit '**/target/surefire-reports/*.xml'  // This collects the JUnit test reports
        }
    }
}
