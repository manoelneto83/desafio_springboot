package com.neto.desafio

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
class DesafioApplication

fun main(args: Array<String>) {
	runApplication<DesafioApplication>(*args)
}
