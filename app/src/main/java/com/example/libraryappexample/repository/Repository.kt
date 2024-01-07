package com.example.libraryappexample.repository

import com.example.libraryappexample.room.BookEntity
import com.example.libraryappexample.room.BooksDB

//acts as decision making part of the app to determine where
class Repository (val booksDB:BooksDB){

    suspend fun addBookToRoom(bookEntity: BookEntity){
        booksDB.bookDao().addBook(bookEntity)

    }

    fun getAllBooks() = booksDB.bookDao().getAllBooks()

    suspend fun deleteBookFromRoom(bookEntity: BookEntity){
        booksDB.bookDao().deleteBook(bookEntity)
    }

    suspend fun updateBookFromRoom(bookEntity: BookEntity){
        booksDB.bookDao().updateBook(bookEntity)
    }

}