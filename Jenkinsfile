pipeline {
    agent any
    
    tools {
        maven 'M3'
    }
    
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Sonar Scanner') {
             def sonarqubeScannerHome = tool name: 'sonar', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
             withCredentials([string(credentialsId: 'sonar', variable: 'sonarLogin')]) {
             sh "${sonarqubeScannerHome}/bin/sonar-scanner -e -Dsonar.host.url=http://sysredcartagena.duckdns.org:9000 -Dsonar.login=${sonarLogin} -Dsonar.projectVersion=${env.BUILD_NUMBER} -Dsonar.projectKey=GS -Dsonar.sources=complete/src/main/ -Dsonar.tests=complete/src/test/ -Dsonar.language=java -Dsonar.java.binaries=."
      }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
     
     }
}
