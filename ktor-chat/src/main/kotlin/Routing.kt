package com.example

import com.example.room.RoomController
import com.example.routes.chatSocket

import io.ktor.server.application.*

import io.ktor.server.routing.*

import org.koin.ktor.ext.inject


fun Application.configureRouting() {
    val roomController by inject<RoomController>()
    routing {
        chatSocket(roomController)
    }

}
