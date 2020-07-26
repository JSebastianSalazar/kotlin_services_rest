package com.app.app.service

import com.app.app.model.Person

interface PersonService {
    fun list(): List<Person>
    fun findById(id: Long): Person
    fun save(person: Person)
    fun delete(id: Long)
}