# micronaut-consuming-spring-config-server
Micronaut project as a Config Client for Spring Cloud Config Server


## spring-config-server

A simple Spring Cloud Config Server running on port 8888 with the
client config file in classpath.

## micronaut-config-client

A simple Micronaut application with `io.micronaut:micronaut-discovery-client`
running on port 8080 consuming configurations from spring-config-server

To compile the application correctly to native code, was necessary to add the code above.

```
@TypeHint(value = [
	io.micronaut.discovery.spring.config.client.ConfigServerPropertySource::class,
	io.micronaut.discovery.spring.config.client.ConfigServerResponse::class
],
	accessType = [
		TypeHint.AccessType.ALL_DECLARED_CONSTRUCTORS,
		TypeHint.AccessType.ALL_DECLARED_FIELDS,
		TypeHint.AccessType.ALL_DECLARED_METHODS,
		TypeHint.AccessType.ALL_PUBLIC,
		TypeHint.AccessType.ALL_PUBLIC_METHODS
	])
object Application
```