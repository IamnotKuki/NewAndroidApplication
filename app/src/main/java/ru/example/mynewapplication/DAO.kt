package ru.example.mynewapplication

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DAO {
    @Insert
    suspend fun addUser(users: Users)

    @Delete
    suspend fun deleteUser(users: Users)

    @Query("SELECT * FROM Users")
    suspend fun getAllUsers() : List<Users>

    @Query("SELECT * FROM Users WHERE id=:id")
    suspend fun getUsersById(id: Long) : Users

}