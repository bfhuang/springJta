# this is a project to learn springBoot

# how to run this project
* clone this project and cd to the project directory
* run command: ./gradlew idea(this is to generate the Intellij idea project file, so that you can open this project in Inttelij idea)
* run command: ./gradlew  bootRun -Dspring.profiles.active=dev (to start up this project), or ./gradlew bootRun -Dspring.profiles.active=dev --debug-jvm to start and debug the project

## profile example
here I have dev and prod profiles
## property configuration example
property configurations, please see FooProperties.java
## logging example
by default, springboot use logback, the default level is info, and default formart is
```
2017-06-28 14:46:56.084  INFO 12142 --- [Thread-3] o.s.c.support.DefaultLifecycleProcessor  : Stopping beans in phase 0
2017-06-28 14:46:56.086  INFO 12142 --- [Thread-3] o.s.j.e.a.AnnotationMBeanExporter        : Unregistering JMX-exposed beans on shutdown
```
* Date and Time — Millisecond precision and easily sortable.
* Log Level — ERROR, WARN, INFO, DEBUG or TRACE.
* Process ID.
* A --- separator to distinguish the start of actual log messages.
* Thread name — Enclosed in square brackets (may be truncated for console output).
* Logger name — This is usually the source class name (often abbreviated).
* The log message.

logging.file | logging.path | Example | Description
------------ | ------------ | ------- | -----------
(none) | (none) | | Console only logging.
Specific file | (none) | my.log | Writes to the specified log file. Names can be an exact location or relative to the current directory.
(none) | Specific directory | /var/log | Writes spring.log to the specified directory. Names can be an exact location or relative to the current directory.


for some special package, you can set specific log level for them like this:
```
logging.level.root=WARN
logging.level.org.springframework.web=DEBUG
logging.level.org.hibernate=ERROR
```
refer log config in prod profile and in dev profile.
## static content
you can access index page by adding index.html at the end of the context url
* By default Spring Boot will serve static content from a directory called /static (or /public or /resources or /META-INF/resources) in the classpath or from the root of the ServletContext
* By default, resources are mapped on /** but you can tune that via spring.mvc.static-path-pattern, for instance
```
spring.mvc.static-path-pattern=/resources/**
```
## Controller advice example
HelloController /exception path will throw Some exception and this exception will be handled by GlobalAdvice and
 convert it to CustomerErrorType
## spring data jpa
* crudRepository and pageableSortableRepository and also different profile use different database, all files are under com.jpa directory
* the repository [name convension and sql convension](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)
* [one-to-many and many-to-many relationships](https://gigsterous.github.io/engineering/2016/09/25/spring-boot-2.html)
## activemq example
* you have to start up activemq first by running: activemq
* [queue to queue](https://javainsider.wordpress.com/tag/jms-with-activemq-sample-example/)
* [Topic](https://www.codenotfound.com/2014/11/jms-publish-subscribe-messaging-example-activemq-maven.html)
## resttemplate example
* json serialization ignore null value(@JsonInclude(JsonInclude.Include.NON_NULL))
* resttempalte get a list of product (Customer[].class)
* [the guide to resttemplate](http://www.baeldung.com/rest-template)