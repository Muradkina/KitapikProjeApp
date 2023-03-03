package com.kitaplik.libraryservice.model

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
data class Library  @JvmOverloads constructor(
    @Id
    @Column(name = "library_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String? = "",



    @ElementCollection
    //userBook book serviceden gelen Book nesnesi değildir.
    //Neden değildir -->> eğer ki bookservicede ki boook nesnesini olduğu gibi
    // klibrarySErvice yüklersem library service db boş yere şişer
    //bookservicede daha sonra bir işlem yapmaya kalkarsam bu değişiklilklerden library service etkilenir
    //Yapılan herhangi bir serviceden başka bir servis etkilenıyorsa bu microservice değildir
    //yapmam gerken ID payşlaşımı bu ne anlama gelir --->>> yanı bookservicede ki book nesnesinin id sini
    // library servicedeki db ye kaydedilir
    //peki bookservice de ki diğer tedaylara iytiyaç duyduk ne yapmam gerek?
    //-->>bookservici cağırım dto üzerinden  teslim alacağım.
    val userBook: List<String> = ArrayList()
)
