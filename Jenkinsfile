pipeline {
  
  agent any
  
  stages {
    
    stage('build') {
      
      steps {
        
          withAnt(installation:'ant'){
                    bat 'ant compile'
                }
        
      }
    }
    
    stage('test') {
      
      steps {
        
          bat 'ant unit-tests'
        
      }
    }
    
    stage('packaging') {
      
      steps {
        
          bat 'ant package'
        
      }
    }
  }
}
