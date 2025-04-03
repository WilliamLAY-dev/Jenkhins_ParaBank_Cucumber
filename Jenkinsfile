pipeline {
    agent any
    environment {
        GITHUB_CREDENTIALS = credentials('Username_GitHub') // Utilisation des credentials stockés
    }
    stages {
        stage('Checkout') {
            steps {
                script {
                    git branch: 'main',
                        credentialsId: 'Username_GitHub',
                        url: "https://github.com/WilliamLAY-dev/Jenkhins_ParaBank_Cucumber.git"
                }
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }

        post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
		}

		stage('Publish Cucumber Reports') {

		steps {cucumber fileIncludePattern: 'target/cucumber.json'}
		}
    }

}