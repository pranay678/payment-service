pipeline {
  agent any

  options {
    timeout(time: 15, unit: 'MINUTES')
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Build') {
      steps {
        // FAILS: Jackson 2.13 + Hibernate Validator 6 conflict with Spring Boot 3.3.x
        sh 'mvn -B clean compile -f sample-projects/payment-service/pom.xml'
      }
    }

    stage('Test') {
      steps {
        sh 'mvn -B test -f sample-projects/payment-service/pom.xml'
      }
      post {
        always {
          junit allowEmptyResults: true,
                testResults: 'sample-projects/payment-service/target/surefire-reports/*.xml'
        }
      }
    }

    stage('Package') {
      steps {
        sh 'mvn -B package -DskipTests -f sample-projects/payment-service/pom.xml'
      }
    }
  }

  post {
    failure {
      echo 'Build FAILED — trigger diagnosis copilot'
    }
  }
}
