package com.kitaplik.bookservice.dto

import com.kitaplik.bookservice.model.Book


//@JvmOverloads kotlinin reflect kütüphanesinden gelen anastasyondur.
//@JvmOverloads ile contructor oluşturulduğunda bize bu sınıfa ait birden fazla consructor sunar
//@JvmOverloads bana l id: BookIdDto? = null bi alan için bir constructor
//@JvmOverloads  val title: String, val cikisTarihi: Int,    val yazar: String,
// val basinAdi: String field leri için başka bir consruvtor açar

//@JvmOverloads lombooktan daha gelişmiştir. null olan fieldlara göre consructor oluşturur.


//data class içinde equls hash code tostring gibi özellikler mevcuttur
data class BookDto @JvmOverloads constructor(
    val id: BookIdDto? = null,
    val title: String,
    val cikisTarihi: Int,
    val yazar: String,
    val basinAdi: String,
    val konu: String
) {
    companion object {
        @JvmStatic
        fun convert(from: Book): BookDto {
            return BookDto(
                from.id?.let { BookIdDto.convert(it, from.isbn) },
                from.title,
                from.cikisTarihi,
                from.yazar,
                from.basinAdi,
                from.konu
            )
        }
    }
}
