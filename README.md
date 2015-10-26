GAE - Java
==================

Working Java project boilerpates for Google App Engine, Cloud Endpoints, and Cloud SQL.
The samples as of writing are all for SQL databases because they are harder to configure
compared to Datastore which practically needs no configuration.

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