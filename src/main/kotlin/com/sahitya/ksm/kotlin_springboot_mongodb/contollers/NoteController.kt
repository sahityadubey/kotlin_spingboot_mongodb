package com.sahitya.ksm.kotlin_springboot_mongodb.contollers

import com.sahitya.ksm.kotlin_springboot_mongodb.database.model.Note
import com.sahitya.ksm.kotlin_springboot_mongodb.database.repository.NoteRepository
import jakarta.validation.Valid
import jakarta.validation.constraints.NotBlank
import org.bson.types.ObjectId
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant

@RestController
@RequestMapping("/notes")
class NoteController(val noteRepository: NoteRepository) {

    data class NoteRequest(
        val id: String?,
        @field:NotBlank(message = "Title can't be black.")
        val title: String,
        val content: String,
        val color: Long
    )

    data class NoteResponse(
        val id: String,
        val title: String,
        val content: String,
        val color: Long,
        val createdAt: Instant
    )

    @PostMapping
    fun save(
         @Valid @RequestBody body: NoteRequest
    ): NoteResponse {
        val ownerId = SecurityContextHolder.getContext().authentication.principal as String
       return noteRepository.save(
            Note(
                id = body.id?.let{ ObjectId(it) } ?: ObjectId.get(),
                title = body.title,
                content = body.content,
                color = body.color,
                ownerId = ObjectId(ownerId),
                createdAt = Instant.now()
            )
        ).toResponse()
    }

    @GetMapping
    fun findByOwnerId(): List<NoteResponse> {
        val ownerId = SecurityContextHolder.getContext().authentication.principal as String
        return noteRepository.findByOwnerId(ObjectId(ownerId)).map {
            it.toResponse()
        }
    }

    @DeleteMapping(path = ["/{id}"])
    fun delete(
        @PathVariable id: String
    ) {
        val note = noteRepository.findById(ObjectId(id)).orElseThrow{
            IllegalArgumentException("Note not found")
        }
        val ownerId = SecurityContextHolder.getContext().authentication.principal as String
        if(note.ownerId.toHexString() == ownerId) {
            noteRepository.deleteById(ObjectId(ownerId))
        }
        noteRepository.deleteById(ObjectId(id))
    }

    private fun Note.toResponse(): NoteResponse {
        return NoteResponse(
            id = id.toHexString(),
            title = title,
            content = content,
            color = color,
            createdAt = createdAt
        )
    }
}