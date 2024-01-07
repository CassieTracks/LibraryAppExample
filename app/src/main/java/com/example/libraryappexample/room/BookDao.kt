package com.example.libraryappexample.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {

    @Insert
    suspend fun addBook(bookEntity: BookEntity)

    @Query("SELECT * FROM BookEntity")  //Query function * = all
    fun getAllBooks(): Flow<List<BookEntity>>

    @Delete
    suspend fun deleteBook(bookEntity: BookEntity)

    @Update
    suspend fun updateBook(bookEntity: BookEntity)

}