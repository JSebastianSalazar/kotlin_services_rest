package com.app.app.controller

import com.app.app.exception.BusinessException
import com.app.app.model.Person
import com.app.app.service.PersonService
import com.app.app.utils.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(Constants.URL_BASE)
class PersonServiceController {
    @Autowired
    val personService: PersonService? = null

    @GetMapping()
    fun list(): ResponseEntity<List<Person>> {
        return try {
            ResponseEntity(personService!!.list(), HttpStatus.OK)
        } catch (ex: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable(value = "id", required = true) id: Long): ResponseEntity<Person> {
        return try {
            ResponseEntity(personService!!.findById(id), HttpStatus.OK)
        } catch (ex: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PostMapping()
    fun save(person: Person) {
        try {
            ResponseEntity(personService!!.save(person), HttpStatus.OK)
        } catch (ex: Exception) {
            throw BusinessException("")
        }
    }

    @DeleteMapping()
    fun delete(id: Long) {
        try {
            ResponseEntity(personService!!.delete(id), HttpStatus.OK)
        } catch (ex: Exception) {
            throw BusinessException("")
        }
    }

}