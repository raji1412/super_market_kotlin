package com.example

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.http.ContentType.Text.Html

fun main() {
   //setting a port
    embeddedServer(Netty, port = 9090, host = "localhost") {

        //setting the routes
        routing {

            get("/prices"){
                call.respondText(
                    this::class.java.classLoader.getResource("price.html")!!.readText(),
                    Html
                )
            }
            get("/"){
                call.respondText(
                    this::class.java.classLoader.getResource("index.html")!!.readText(),
                    Html
                )
            }

        }
    }.start(wait = true)
}
