# Backend Tigo Accrued Automation
###### Version 1.0

Servicios REST para Tigo Accrued Automation.

## Configuration
- Spring Boot 2.6.0-SNAPSHOT
- Java 1.8 
- Maven 3.6.3

## Dependencies
- JPA
- Web
- AOP

## Usage
#### Clone repository
```
git clone https://gitlab-bsd.tigo.com.gt/BSD-APPS/Ventas/AccruedAutomationApp/src.git 
```
#### Project information
```
    <groupId>gt.com.tigo</groupId>
    <artifactId>accrued-automation-api</artifactId>
    <version>1.0</version>
    <packaging>war</packaging>
    <name>accrued-automation-api</name>
    <description>Tigo Accrued Automation API</description>
```
#### Base package
```
    gt.com.tigo.accruedautomation
```
#### Main class
```
    public class AccruedAutomationApplication extends SpringBootServletInitializer implements WebApplicationInitializer {
        ...
    }
```
#### Main class path
```
    <project-path>/src/main/java/gt/com/tigo/accruedautomation/AccruedAutomationApplication.java
```
#### Weblogic configuration
```
    <wls:context-root>/accrued-automation-api</wls:context-root>
```
#### Build
```
mvn package
```
#### API Documentation
```
N/A
```