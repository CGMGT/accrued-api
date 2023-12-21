// -------------------------------------------------------------------------------------------------------
// -- Mantenimiento: César Garcia - cgarciam@tigo.com.gt
//   -- Proyecto: Accrued Automation App
//   -- Recursos: Cesar Garcia, Josue Barillas
//   -- Empresa: CGM Soluciones
//   -- Arquitecto; Gabriela Rodas - mgrodasp@tigo.com.gt
//
// -- Características:
//                     -- Obtiene el código del repositorio git
//                     -- Compila y Construye con Maven
//                     -- Almacena el artefacto de despliegue en Artifactory 
// -------------------------------------------------------------------------------------------------------
//------
pipeline {
  agent any 
  tools {nodejs "NodeJS_14.4.0"}
  stages {
  
		stage('Git') {
		  steps {
			script {	  
			  echo 'Clonando Repositorio de AccruedAutomationApp ' + env.BRANCH_NAME
			   git(url: 'https://gitlab-bsd.tigo.com.gt/BSD-APPS/Ventas/AccruedAutomationApp/src.git', branch:  env.BRANCH_NAME, credentialsId: '47c6893c-a3cf-4190-9e9c-3eec2782d5d6')
			}
		  }
		}

		stage('Compilar') {
			steps {
				script {
					def mvnHome = tool 'MavenBSD'
					env.PATH = "${mvnHome}/bin:${env.PATH}"
					echo "var mvnHome='${mvnHome}'"
					echo "var env.PATH='${env.PATH}'"
					
					echo 'compilar frontend-src'
					
					dir('AccruedAutomation-frontend-src') {
						sh 'pwd'
						echo 'verificando npm'
						//sh 'apt update --assume-yes && apt upgrade --assume-yes'
						//sh 'apt-get --assume-yes --fix-missing install build-essential'
						sh 'npm -version'
						sh 'npm rebuild node-sass --force'
						sh 'npm install'
						sh 'npm run build'	
						sh 'ls -l ../AccruedAutomation-frontend/src/main/webapp'
						sh 'rm -rf ../AccruedAutomation-frontend/src/main/webapp/static'
						sh 'rm -f ../AccruedAutomation-frontend/src/main/webapp/*.json'
						sh 'rm -f ../AccruedAutomation-frontend/src/main/webapp/*.ico'
						sh 'rm -f ../AccruedAutomation-frontend/src/main/webapp/*.png'
						sh 'rm -f ../AccruedAutomation-frontend/src/main/webapp/*.html'
						sh 'rm -f ../AccruedAutomation-frontend/src/main/webapp/*.js'
						echo 'archivos eliminados'
						sh 'ls -l ../AccruedAutomation-frontend/src/main/webapp'
						sh 'cp build/*.* ../AccruedAutomation-frontend/src/main/webapp/'
						sh 'cp -R build/static ../AccruedAutomation-frontend/src/main/webapp/'
						echo 'archivos actualizados'
						sh 'ls -l ../AccruedAutomation-frontend/src/main/webapp'						
					}
					
					echo 'empaquetando AccruedAutomation-frontend...'
			
					dir('AccruedAutomation-frontend') {
						sh 'pwd'
						sh 'mvn package'				
					}
					
					echo 'empaquetando AccruedAutomation-api...'
					
					dir('AccruedAutomation-api') {
						sh 'pwd'
						sh 'mvn package'
						sh "ls target/"
					}
					
					echo 'empaquetando AccruedAutomation-job-scheduler...'
					
					dir('AccruedAutomation-job-scheduler') {
						sh 'pwd'
						sh 'mvn package'
						sh "ls target/"
					}
				}
			}
		}
		
		stage('SonarQube AccruedAutomation-frontend Analysis') {
			steps {
				script {
					// requires SonarQube Scanner 2.8+
				scannerHome = tool 'Sonar'
				}
				withSonarQubeEnv('SonarQube_BSD') {
					sh "${scannerHome}/bin/sonar-scanner \
					-Dsonar.projectKey=AccruedAutomationFrontend \
					-Dsonar.projectName=AccruedAutomationFrontend \
					-Dsonar.projectVersion=1.9 \
					-Dsonar.exclusions='AccruedAutomation-frontend-src/src/DemoPages/**.*, AccruedAutomation-frontend-src/src/assets/**.*, AccruedAutomation-frontend-src/src/Layout/**.*' \
					-Dsonar.sources=AccruedAutomation-frontend-src/src"
				}
			}
		}
		
		stage('SonarQube AccruedAutomation-api Analysis') {
			steps {
				script {
					// requires SonarQube Scanner 2.8+
					scannerHome = tool 'Sonar'
				}
				withSonarQubeEnv('SonarQube_BSD') {
				    sh "${scannerHome}/bin/sonar-scanner \
				    -Dsonar.projectKey=AccruedAutomationApi \
				    -Dsonar.projectName=AccruedAutomationApi \
				    -Dsonar.java.binaries=AccruedAutomation-api/target/classes \
				    -Dsonar.projectVersion=1.9 \
				    -Dsonar.sources=AccruedAutomation-api/"
				}
			}
		}		
		
		stage('SonarQube AccruedAutomation-job-scheduler Analysis') {
			steps {
				script {
					// requires SonarQube Scanner 2.8+
					scannerHome = tool 'Sonar'
				}
				withSonarQubeEnv('SonarQube_BSD') {
					sh "${scannerHome}/bin/sonar-scanner \
					-Dsonar.projectKey=AccruedAutomationJobScheduler \
					-Dsonar.projectName=AccruedAutomationJobScheduler \
					-Dsonar.java.binaries=AccruedAutomation-job-scheduler/target/classes \
					-Dsonar.projectVersion=1.5 \
					-Dsonar.sources=AccruedAutomation-job-scheduler/"
				}
			}
		}

		stage('Save Artifactory') {
			steps {
				script {
					def server = Artifactory.server 'ArtifactoryBSD'			
					
					if (env.BRANCH_NAME=='dev') {
						echo 'Almacenando el artefacto para despliegue de '+env.BRANCH_NAME
						
						def uploadFrontendSpec = """{
							"files": [
								{
									"pattern": "/var/jenkins_home/workspace/Ventas_AccruedAutomation_dev/AccruedAutomation-frontend/target/*.war",
									"target": "BSD-VENTAS/"
								}
							]
						}"""
						
						server.upload(uploadFrontendSpec)	
						
						def uploadBackendSpec = """{
							"files": [
								{
									"pattern": "/var/jenkins_home/workspace/Ventas_AccruedAutomation_dev/AccruedAutomation-api/target/*.war",
									"target": "BSD-VENTAS/"
								}
							]
						}"""
						
						server.upload(uploadBackendSpec)
						
						def uploadJobsSpec = """{
							"files": [
								{
									"pattern": "/var/jenkins_home/workspace/Ventas_AccruedAutomation_dev/AccruedAutomation-job-scheduler/target/*.war",
									"target": "BSD-VENTAS/"
								}
							]
						}"""
						
						server.upload(uploadJobsSpec)
					}
					if (env.BRANCH_NAME=='QA') {
						echo 'Almacenando el artefacto para despliegue de '+env.BRANCH_NAME
						
						def uploadFrontendSpec = """{
							"files": [
								{
									"pattern": "/var/jenkins_home/workspace/Ventas_AccruedAutomation_QA/AccruedAutomation-frontend/target/*.war",
									"target": "BSD-VENTAS/"
								}
							]
						}"""
						
						server.upload(uploadFrontendSpec)	
						
						def uploadBackendSpec = """{
							"files": [
								{
									"pattern": "/var/jenkins_home/workspace/Ventas_AccruedAutomation_QA/AccruedAutomation-api/target/*.war",
									"target": "BSD-VENTAS/"
								}
							]
						}"""
						
						server.upload(uploadBackendSpec)
						
						def uploadJobsSpec = """{
							"files": [
								{
									"pattern": "/var/jenkins_home/workspace/Ventas_AccruedAutomation_QA/AccruedAutomation-job-scheduler/target/*.war",
									"target": "BSD-VENTAS/"
								}
							]
						}"""
						
						server.upload(uploadJobsSpec)
					}
					if (env.BRANCH_NAME=='master') {
						echo 'Almacenando el artefacto para despliegue de '+env.BRANCH_NAME		   
						
						def uploadFrontendSpec = """{
							"files": [
								{
									"pattern": "/var/jenkins_home/workspace/Ventas_AccruedAutomation_dev/frontend/target/*.war",
									"target": "BSD-VENTAS/"
								}
							]
						}"""
						
						server.upload(uploadFrontendSpec)	
						
						def uploadBackendSpec = """{
							"files": [
								{
									"pattern": "/var/jenkins_home/workspace/Ventas_AccruedAutomation_dev/backend/target/*.war",
									"target": "BSD-VENTAS/"
								}
							]
						}"""
						
						server.upload(uploadBackendSpec)
						
						def uploadJobsSpec = """{
							"files": [
								{
									"pattern": "/var/jenkins_home/workspace/Ventas_AccruedAutomation_dev/AccruedAutomation-job-scheduler/target/*.war",
									"target": "BSD-VENTAS/"
								}
							]
						}"""
						
						server.upload(uploadJobsSpec)
					}			   
				}
			}
		}



  }
	post {
		success {
			echo 'Exitoso!'
			mail to: 'cgarciam@tigo.com.gt,mgrodasp@tigo.com.gt',
			subject: "Despliegue Exitoso: ${currentBuild.fullDisplayName}",
			body: "El despliegue en el ambiente de ${env.BRANCH_NAME} ha finalizado con éxito"			
		}
		unstable {
			echo 'I am unstable :/'
			mail to: 'cgarciam@tigo.com.gt,mgrodasp@tigo.com.gt',
			subject: "unstable Pipeline: ${currentBuild.fullDisplayName}",
			body: "El despliegue en el ambiente ${env.BRANCH_NAME} ha generado un error"			
		}
		failure {
			echo 'Despliegue fallido: ${currentBuild.fullDisplayName}'
			mail to: 'cgarciam@tigo.com.gt',
			subject: "failure Pipeline: ${currentBuild.fullDisplayName}",
			body: "El despliegue en el ambiente ${env.BRANCH_NAME} del proyecto AccruedAutomation ha generaro un error, favor repotarlo a cgarciam@tigo.com.gt o mgrodasp@tigo.com.gt"				
			//emailext body: 'Check console output at $BUILD_URL to view the results. \n\n ${CHANGES} \n\n -------------------------------------------------- \n${BUILD_LOG, maxLines=1000, escapeHtml=false}'
		}
	}  
}
