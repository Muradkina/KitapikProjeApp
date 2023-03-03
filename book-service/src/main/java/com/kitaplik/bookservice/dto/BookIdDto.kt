package com.kitaplik.bookservice.dto

//BookIdDto bana sadece 2 tane tekil olan id ve isbn dönecek
data class BookIdDto @JvmOverloads constructor(
    val id: String? = "",
    val isbn: String
) {
    companion object{
        @JvmStatic
        fun convert(id:String,isbn: String):BookIdDto{
            return BookIdDto(id, isbn)
        }
    }
}
