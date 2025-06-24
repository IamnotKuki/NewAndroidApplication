package ru.example.mynewapplication

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity()
data class Users (
    val username: String,
    @PrimaryKey(autoGenerate = true)
    val id: Long = undefined_id
) {
    companion object{
        private const val undefined_id: Long = 0
    }
}
