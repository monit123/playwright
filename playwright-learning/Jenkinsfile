pipeline {
    agent any

    tools {
        jdk 'JDK25'
        maven 'Maven'
    }

    stages {

        stage('Environment Check') {
            steps {
                bat 'java -version'
                bat 'mvn -version'
                bat 'git --version'
            }
        }
    }
}