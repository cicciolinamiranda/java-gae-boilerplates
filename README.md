GAE - Java
==================

Working Java project boilerpates for Google App Engine, Cloud Endpoints, and Cloud SQL.
The samples as of writing are all for SQL databases because they are harder to configure
compared to Datastore which practically needs no configuration.

All of the modules implement the same behavior. A simple "To-Do Application" that requires a Google login. Users can place To-do items and specify its due date.

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

## Liquibase
You may notice that all the modules have a dependency to [Liquibase](http://www.liquibase.org/). Liquibase is a nifty tool for dealing with tracking of database changes, particularly in the schema. It also helps a new developer to setup a database when joining a project.

To update the database schema, run `mvn liquibase:update`. To drop everything run `mvn liquibase:dropAll`.

## Modules
*	`boot-dataJPA-sql`
			(Spring Boot + Spring Data JPA with default auto-configuration)
*   `guice-hibernate-sql`
 		(Google Guice + Hibernate)
*	`spring-dataJPA-sql`
			(Spring + Spring Data JPA with traditional annotation based configuration)
*	`spring-gae-compatibility`
	(contains classes customized to make Spring and GAE features work together)

## Folder Structure
### Under `src/main`
* `java` contains Java source codes
* `resource` contains classpath resources. These are usually property files, configuration XML (e.g. persistence.xml), view templates (e.g. Thymeleaf, Mustache, JSP).
* `webapp` contains files needed by the application container (e.g. Tomcat, Glassfish, GAE).

### Under `src/main/java`
* `com.cloudsherpas.java.api` contains the classes that represent the REST API that will be exposed.
    * `endpoint` - API Endpoint Classes (e.g. Cloud Endpoints, Jersey Endpoints, Spring REST Controllers, etc.).
    * `resource` - Classes that are serialized to the JSON payload.

* `com.cloudsherpas.java.config` contains classes that configure the application such as wiring/declaring dependencies.

* `com.cloudsherpas.java.data` contains classes that interact or represent the data layer.
    * `domain` - domain data models for the ORM. (i.e. classes that represent the DB tables).
    * `repository` - classes that abstract the DAO as repositories. These classes represent results as collections of entities. Hence the name 'repository'.

* `com.cloudsherpas.java.service` contains classes that implement business logic in the application.

* `com.cloudsherpas.java.util` contains utility classes for that application (e.g. mapping domain models to resources).

* `Application.class` (Spring Boot only) Entry point of the Spring Boot application.

## How to run
For Eclipse users:

	$ mvn clean eclipse:eclipse install
	$ cd {module}
	$ mvn appengine:devserver -Dappengine.port=#### 
	
For non-Eclipse users:

	$ mvn clean install
	$ cd {module}
	$ mvn appengine:devserver -Dappengine.port=####