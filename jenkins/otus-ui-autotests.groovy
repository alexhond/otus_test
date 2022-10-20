timeout(300) {
    node('docker') {
        wrap([$class: 'BuildUser']) {
            summary = """<b>Owner:</b> ${env.BUILD_USER}"""
        }
        stage('Checkout') {
            checkout scm
        }
        stage('Running tests') {
            sh "mvn test -Dbase.url=${BASE_URL} -Dbrowser=${BROWSER_NAME} -Dbrowser.version=${BROWSER_VERSION} -DincludeTags=${TAGS}"
        }
        stage('Publisher allure') {
            allure([
                    includeProperties: false,
                    jdk              : '',
                    properties       : [],
                    reportBuildPolicy: 'ALWAYS',
                    results          : [[path: 'target/allure-results']]
            ])
        }
    }
}
