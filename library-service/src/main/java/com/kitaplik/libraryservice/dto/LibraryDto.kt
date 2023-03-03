package com.kitaplik.libraryservice.dto

class LibraryDto @JvmOverloads constructor(
    val id: String,
    val userBookList: List<BookDto>? = ArrayList()
) {
}