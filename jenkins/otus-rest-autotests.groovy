timeout(300) {
    node('docker') {
        wrap([$class: 'BuildUser']) {
            summary = """<b>Owner:</b> ${env.BUILD_USER}"""
        }
        stage('Checkout') {
            checkout scm
        }
        stage('Running tests') {
            sh "mvn test -DincludeTags=${TAGS}"
        }
        stage('Publisher allure') {
            allure([
                    includeProperties: false,
                    jdk              : '',
                    properties       : [],
                    reportBuildPolicy: 'ALWAYS',
                    results          : [[path: 'allure-results']]
            ])
        }
    }
}
