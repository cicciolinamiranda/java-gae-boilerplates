GAE - Java
==================

Working Java project boilerpates for Google App Engine, Cloud Endpoints, and Cloud SQL.
The samples as of writing are all for SQL databases because they are harder to configure
compared to Datastore which practically needs no configuration.

### How do I choose?
* Want sure compatibility with GAE? **Guice**
* Want a lightweight application? **Guice**
* Want faster development for the persistence layer? **Spring (spring-data)[1]**
* Want to implement custom authentication? **Spring (spring-security)[1]**

[1] Using Spring in GAE may not be as smooth as it could be due to JVM restrictions. Spring is best used for deployment to native JVM environments (GCE, Amazon EC2).


### Note
All Spring boilerplates use Spring 4


## Modules
*	boot-dataJPA-sql			(Spring Boot + Spring Data JPA with default auto-configuration)
*   guice-hibernate-sql 		(Google Guice + Hibernate)
*	spring-dataJPA-sql			(Spring + Spring Data JPA with traditional annotation based configuration)
*	spring-gae-compatibility	(contains classes customized to make Spring and GAE features work together)

## How to run
For Eclipse users:

	$ mvn clean eclipse:eclipse install
	$ cd {module}
	$ mvn appengine:devserver -Dappengine.port=#### 
	
For non-Eclipse users:

	$ mvn clean install
	$ cd {module}
	$ mvn appengine:devserver -Dappengine.port=####