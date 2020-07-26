package com.app.app.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "person")
data class Person(val dni: Long = 0, val name: String = "",
                  val lastname: String = "", val birtdayName: Date? = null) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
}
