package com.example.data

import com.example.data.model.Message
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.descending
import org.litote.kmongo.coroutine.CoroutineCollection

class MessageDataSourceImpl(
    private val db: CoroutineDatabase
) : MessageDataSource {

    private val messages: CoroutineCollection<Message> = db.getCollection()

    override suspend fun getAllMessages(): List<Message> {
        // ordena por timestamp decrescente e converte para lista
        return messages.find()
            .sort(descending(Message::timestamp))
            .toList()
    }

    override suspend fun insertMessage(message: Message) {
        messages.insertOne(message)
    }
}