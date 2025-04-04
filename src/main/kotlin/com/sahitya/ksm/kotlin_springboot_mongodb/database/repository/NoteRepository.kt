package com.sahitya.ksm.kotlin_springboot_mongodb.database.repository

import com.sahitya.ksm.kotlin_springboot_mongodb.database.model.Note
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface NoteRepository: MongoRepository<Note, ObjectId> {
    fun findByOwnerId(ownerId: ObjectId): List<Note>
}