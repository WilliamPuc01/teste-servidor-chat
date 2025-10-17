package com.example.room

import io.ktor.server.websocket.WebSocketServerSession


data class Member(
    val username: String,
    val sessionId: String,
    val socket: WebSocketServerSession
)