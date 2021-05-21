package com.johnowl

import io.micronaut.context.annotation.ConfigurationProperties
import io.micronaut.core.annotation.Introspected
import io.micronaut.core.annotation.TypeHint
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.runtime.Micronaut.*

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

fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("com.johnowl")
		.start()
}

@Introspected
@ConfigurationProperties("my-config")
class MyConfig(
	var message: String? = null
)

@Controller
class HelloController(
	private val config: MyConfig
) {

	@Get("/")
	fun sayIt(): String? {
		return config.message
	}
}