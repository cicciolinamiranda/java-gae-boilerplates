GAE - Java
==================

Working Java project boilerpates for Google App Engine, Cloud Endpoints, and Cloud SQL.
The samples as of writing are all for SQL databases because they are harder to configure
compared to Datastore which practically needs no configuration.

### How do I choose?
* Want sure compatibility with GAE? **Guice**
* Want a lightweight application? **Guice**
* Want faster development for the persistence layer? **Spring ([spring-data](http://projects.spring.io/spring-data/))[1]**
* Want to implement custom authentication? **Spring ([spring-security](http://projects.spring.io/spring-security/))[1]**

[1] Using Spring in GAE may not be as smooth as it could be due to JVM restrictions. Spring is best used for deployment to native JVM environments (GCE, Amazon EC2).

### Why Google Guice?
Google Guice is made by, well, Google. Hence, it's not surprising that it has nearly seamless compatibility with the Google Cloud Platform. It's lightweight compared to Spring that it can support the faster startup required in GAE instances.

### Spring Boot vs Traditional Spring?
Spring Boot is made to help developers get applications up and running as fast as possible. It makes opinionated configurations based on common use-cases. These configurations can be overridden. However, due to this, Spring Boot may be slower at starting up compared to Traditional Spring.

Traditional Spring on the other hand makes no assumptions and lets the developer configure everything that is needed. Read more [here](http://projects.spring.io/spring-boot/).

### Note
All Spring boilerplates use Spring 4


## Modules
*	`boot-dataJPA-sql`
			(Spring Boot + Spring Data JPA with default auto-configuration)
*   `guice-hibernate-sql`
 		(Google Guice + Hibernate)
*	`spring-dataJPA-sql`
			(Spring + Spring Data JPA with traditional annotation based configuration)
*	`spring-gae-compatibility`
	(contains classes customized to make Spring and GAE features work together)

## How to run
For Eclipse users:

	$ mvn clean eclipse:eclipse install
	$ cd {module}
	$ mvn appengine:devserver -Dappengine.port=#### 
	
For non-Eclipse users:

	$ mvn clean install
	$ cd {module}
	$ mvn appengine:devserver -Dappengine.port=####