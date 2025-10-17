package com.example

import io.ktor.server.application.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import com.example.di.mainModule
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        module() // chama o módulo abaixo
    }.start(wait = true)
}

fun Application.module() {
    install(Koin) {
        slf4jLogger()
        modules(mainModule) // seu módulo definido em MainModule.kt
    }

    configureSockets()
    configureMonitoring()
    configureSerialization()
    configureSecurity()
    configureRouting()
}