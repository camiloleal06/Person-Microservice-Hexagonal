pipeline {
    agent any
    
    tools {
        maven 'M3'
    }
      
          stage("SonarQube analysis") {
            agent any
            steps {
              withSonarQubeEnv('sonar') {
                sh 'mvn sonar:sonar'
              }
            }
          }
     }
