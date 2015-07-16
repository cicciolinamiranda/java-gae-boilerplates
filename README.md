GAE - Spring Framework Integration - SQL POC
==================

POC (proof of concept) application using GAE and Spring Framework based on existing [work](https://bitbucket.org/lloal/spring-cloud-endpoint-poc) by Jordan and Alvin. 

This is not a demonstration of behavior. Rather, this should serve as a template on configuring the frameworks.

The goal of this project is to demonstrate the following:

*   GAE and Spring Framework configuration to take advantage of Spring's IoC Container (a.k.a. dependency injection)
*   GAE and Spring Boot integration to take advantage of Spring Boot's auto-configurations
*	Use of Spring Data to interface with MySQL and ultimately Cloud SQL
*	Demonstrate profile based configuration (dev vs prod)
*	Demonstrate Maven's multi-module capabilities
*	(future) Demonstrate GAE Modules
*	(future) Demonstrate Task Queue usage

## Modules
*	spring-boot-gae-sql	(GAE + Spring Boot + Spring Data Auto Configuration)
*	spring-gae-sql	(GAE + Spring + Spring Data)
*	spring-gae-compatibility (contains classes customized to merge Spring and GAE features)

## How to run
For Eclipse users:

	.../spring-gae-poc$ mvn clean eclipse:eclipse install
	.../spring-gae-poc$ cd {module}
	.../spring-gae-poc/{module}$ mvn appengine:devserver -Dappengine.port=#### 
	
For non-Eclipse users:

	.../spring-gae-poc$ mvn clean install
	.../spring-gae-poc$ cd {module}
	.../spring-gae-poc/{module}$ mvn appengine:devserver -Dappengine.port=#### 
	
Running `mvn clean install` on the root folder of the multi-module project will compile and install all the modules inside.


## Authors

Reynald Pader <reynald.pader@cloudsherpas.com>

Alvin Llobrera <alvin.llobrera@cloudsherpas.com> (Original work)

Jordan Duabe <jordan.duabe@cloudsherpas.com> (Original work)

