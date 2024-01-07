package com.example.libraryappexample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.libraryappexample.repository.Repository
import com.example.libraryappexample.room.BookEntity
import kotlinx.coroutines.launch

class BookViewModel(val repository: Repository): ViewModel() {

    fun addBook(book: BookEntity){
        viewModelScope.launch {
            repository.addBookToRoom(book)
        }
    }

    val books = repository.getAllBooks() //if not using a suspend function, above one uses a suspend function

    fun deleteBook(book: BookEntity){
        viewModelScope.launch {
            repository.deleteBookFromRoom(book)
        }
    }

    fun updateBook(book: BookEntity){
        viewModelScope.launch {
            repository.updateBookFromRoom(book)
        }
    }


}