pipeline {
  
  agent any
  
  stages {
    
    stage('clone') {
      
      steps {
        
          sh "rm -rf"
          sh "git clone https://github.com/Lotfiayoub1/SuperMarioGame.git"
        
      }
    }
  
  
    stage('build') {
      
      steps {
        
          sh "cd SuperMarioGame/src/com/TETOSOFT/test/ && javac StartMenu.java"
        
      }
    }
    stage('run') {
      
      steps {
        
          sh "cd SuperMarioGame/src/com/TETOSOFT/test/ && java StartMenu"
        
      }
    }
  
    stage('test') {
      
      steps {
        
          echo 'Testing the app...'
        
      }
    }
    
    stage('deploy') {
      
      steps {
        
          echo 'Deploying the app...'
        
      }
    }
  }
}
