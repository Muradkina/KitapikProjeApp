package com.kitaplik.libraryservice.dto

data class BookDto @JvmOverloads constructor(val id: BookIdDto? = null,
                                             val title: String? = "",
                                             val year: Int? = 0,
                                             val yazar: String? = "",
                                             val basinAdi: String? = "")
{

}




