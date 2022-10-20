timeout(300) {
    node('docker') {
        stage('Checkout') {
            checkout scm
        }
        stage('Running tests') {
            sh "mvn test -Dbase.url=${BASE_URL} -Dbrowser=${BROWSER_NAME} -DincludeTags=${TAGS} -Dwebdriver.remote.url=${REMOTE_URL}"
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
