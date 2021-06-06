pipeline {
  
  agent any
  
  stages {
    
    stage('clone') {
      
      steps {
        
          bat "git clone https://github.com/Lotfiayoub1/SuperMarioGame.git"
        
      }
    }
  
  
    stage('build') {
      
      steps {
        
          bat "cd SuperMarioGame/src/com/TETOSOFT/test && javac StartMenu.java"
        
      }
    }
    stage('run') {
      
      steps {
        
          bat "cd SuperMarioGame/src/com/TETOSOFT/test && java StartMenu"
        
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
