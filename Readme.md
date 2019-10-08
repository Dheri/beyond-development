# Beyond Spring Boot development

[![forthebadge](https://forthebadge.com/images/badges/check-it-out.svg)](https://forthebadge.com)
>I finished my Spring Boot application development, what next?

Lets see.
## Topics covered 
- External Configurations (spring boot)
- YML files (general)
- Multiple profiles (spring boot)
- Loging (java)
- Packaging (maven)

Reference used: https://github.com/Dheri/beyond-development

### External Configurations and YML
Try to keep config data out of `.java` files
Use `appliation.yml` 
``` yml
spring:
  application:
    name: Adv Java Final Project
``` 
Usage in code `(HomeController)`:
``` java
@Value("${spring.application.name}")
private String appName;
```


### Monitoring
>I want to keep track of errors and exceptions thrown by the application, and make them persistance on file system. What can i do?

Use Loging.


#### Log4J2
Loggers are used to log (print) error messages on consle or file. Used in this project, log4J2 is [upgraded version](https://stackoverflow.com/a/30021470/7283740) of Log4J.
> Logging will require me to write more code, more imports and more dependencies, which I am too lazy to do.
And `System.out.println("I screwed-up here!")` works fine as well.

##### It's not that hard.
1. Add the dependency (see reference)
2. Declare `Logger` in class
     * `private static final Logger log = LogManager.getLogger(HomeController.class);`
3. log you messages
     * `log.warn("buggy code running");`

 
easy as 1. 2 3.

#### Packaging and deployment
`mvn package` to create a jar file in target directory.
`java -jar target/fileName.jar` to run your application.

##### Excercise:
Use https://github.com/Dheri/beyond-development as reference, create a spring boot rest application that:
- Return back spring.application.name property defined in application.yml file.
- Log a message of info ,debug, warn and error type on a file.

Please use log4j2.yml file, as well as dependency list from pom.xml from  reference provided.
