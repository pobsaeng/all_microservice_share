package com.gateway

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan
class GatewayApplication {

    @Bean
    fun run(): CommandLineRunner {
        return CommandLineRunner { args ->
            println("CommandLineRunner!")
        }
    }
}

fun main(args: Array<String>) {
    runApplication<GatewayApplication>(*args)
}
