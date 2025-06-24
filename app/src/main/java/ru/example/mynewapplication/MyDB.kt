package ru.example.mynewapplication

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Users::class], version = 1)
abstract class MyDB : RoomDatabase() {
    abstract fun getUserDao() : DAO
}