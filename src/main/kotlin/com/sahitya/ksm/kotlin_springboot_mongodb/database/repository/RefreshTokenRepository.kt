package com.sahitya.ksm.kotlin_springboot_mongodb.database.repository

import com.sahitya.ksm.kotlin_springboot_mongodb.database.model.RefreshToken
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface RefreshTokenRepository: MongoRepository<RefreshToken, ObjectId> {

    fun findByUserIdAndHashedToken(userId: ObjectId, hashedToken: String): RefreshToken?

    fun deleteByUserIdAndHashedToken(userId: ObjectId, hashedToken: String)
}