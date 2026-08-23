pipeline {
    agent any
    parameters{
		choice(
			name: 'TEST_SUITE'
			choices: ['SMOKE','SANITY','REGRESSION']
			description: 'Select the test group to execute'
		)
		choice(
			name : 'BROWSER'
			choices: ['Chrome','Edge']
			description: 'Select the browser'
		)
	}

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
        stage('Build and Test'){
			steps{
				bat "mvn clean test -DtestSuite=${params.TEST_SUITE} -Dbrowser=${params.BROWSER}"
			}
		}
    }
}