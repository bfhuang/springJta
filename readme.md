# this is a project to learn springBoot

# how to run this project
* clone this project and cd to the project directory
* run command: gradle idea(this is to generate the Intellij idea project file, so that you can open this project in Inttelij idea)
* run command: gradle  bootRun -Dspring.profiles.active=dev (to start up this project)

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