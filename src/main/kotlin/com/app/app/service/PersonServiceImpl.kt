package com.app.app.service

import com.app.app.exception.BusinessException
import com.app.app.exception.NotFoundException
import com.app.app.model.Person
import com.app.app.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonServiceImpl : PersonService {

    @Autowired
    val personRepository: PersonRepository? = null

    @Throws(BusinessException::class)
    override fun list(): List<Person> {
        try {
            return personRepository!!.findAll()
        } catch (ex: Exception) {
            throw BusinessException(ex.message)
        }
    }

    @Throws(BusinessException::class)
    override fun findById(id: Long): Person {
        val person: Optional<Person>
        try {
            person = personRepository!!.findById(id)
        } catch (ex: Exception) {
            throw BusinessException(ex.message)
        }
        if (!person.isPresent) {
            throw BusinessException("Not found person with id $id")
        }
        return person.get()
    }

    @Throws(BusinessException::class)
    override fun save(person: Person) {
        try {
            personRepository!!.save(person)
        } catch (ex: Exception) {
            throw BusinessException(ex.message)
        }
    }

    @Throws(BusinessException::class)
    override fun delete(id: Long) {
        try {
            personRepository!!.deleteById(id)
        } catch (ex: Exception) {
            throw BusinessException(ex.message)
        }
    }

}