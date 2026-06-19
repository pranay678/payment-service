pipeline {
  agent any

  tools {
    maven 'Maven 3'
    jdk   'JDK 21'
  }

  options {
    timestamps()
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
        sh 'mvn -B clean compile -pl sample-projects/payment-service -am'
      }
    }

    stage('Test') {
      steps {
        sh 'mvn -B test -pl sample-projects/payment-service -am'
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
        sh 'mvn -B package -DskipTests -pl sample-projects/payment-service -am'
      }
    }
  }

  post {
    failure {
      echo 'Build FAILED — trigger diagnosis copilot'
    }
  }
}
