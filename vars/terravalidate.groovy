def call() {
    pipeline {
        agent {
            label 'mycustomtf'
        }

        stages {
            stage('Terraform Test') {
                steps {
                    container('mycustomtf-sidecar') {
                        sh '''
                            terraform version
                            terraform init
                            terraform validate
                        '''
                    }
                }
            }
        }
    }
}