package ru.example.mynewapplication

import android.content.Context
import androidx.room.Room


object Dap {

    lateinit var roomDB: MyDB

    fun init(context: Context){
        roomDB = Room.databaseBuilder(
            context,
            MyDB::class.java,
            "myDB"
        ).build()
    }
}