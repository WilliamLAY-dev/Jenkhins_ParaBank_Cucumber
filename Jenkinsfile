pipeline{
    agent any
    stages{
        stage('Checkout'){
            steps{
                git branch: 'main',
                url: 'https://github.com/WilliamLAY-dev/Jenkhins_ParaBank_Cucumber'
            }
        }
        stage('Build'){
            steps{
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
    }
}