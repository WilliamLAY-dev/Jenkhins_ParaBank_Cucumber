pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                bat 'mvn clean'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test -Dcucumber.filter.tags="@ConnxionReussieParaBank"'
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