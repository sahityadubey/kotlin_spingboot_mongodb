package com.sahitya.ksm.kotlin_springboot_mongodb.database.repository

import com.sahitya.ksm.kotlin_springboot_mongodb.database.model.User
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository: MongoRepository<User, ObjectId> {
    fun findByEmail(email: String): User?
}