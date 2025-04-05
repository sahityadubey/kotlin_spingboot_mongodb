package com.sahitya.ksm.kotlin_springboot_mongodb.database.model

import jakarta.validation.constraints.Email
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("users")
data class User(
    val email: String,
    val hashedPassword: String,
    @Id val id: ObjectId = ObjectId()
)
