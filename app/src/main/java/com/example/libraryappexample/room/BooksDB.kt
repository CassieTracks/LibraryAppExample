package com.example.libraryappexample.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [BookEntity::class], version = 1,
    exportSchema = false) //specify multiple tables if needed tables
abstract class BooksDB : RoomDatabase(){

    abstract fun bookDao(): BookDao

    // companion object - class level variables and methods
    companion object{

        @Volatile
        private var INSTANCE: BooksDB? = null //changes made by one thread will update all threads simultaneously

        //will only allow one instance of the database
        fun getInstance(context: Context): BooksDB{
            synchronized(this){
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        BooksDB::class.java,
                        "books_db"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}