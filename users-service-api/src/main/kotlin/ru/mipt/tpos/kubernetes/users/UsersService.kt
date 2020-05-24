package ru.mipt.tpos.kubernetes.users

import mu.KotlinLogging
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

private val log = KotlinLogging.logger { }

@Service
class UsersService(
    private val usersRepository: UsersRepository
) {
    fun getUserById(id: Long): User? {
        log.info { "Trying to get user by id $id" }
        val user = usersRepository.findByIdOrNull(id)
        log.info { "User with id $id is $user" }
        return user
    }

    fun addUser(name: String, age: Int): Long {
        log.info { "Adding user with name $name and age $age" }
        val user = User(name, age)
        val savedUser = usersRepository.save(user)
        log.info { "User with name $name and age $age successfully added: $savedUser" }
        return savedUser.id
    }

    fun getAllUsers(): List<User> {
        log.info { "Getting all users" }
        val users = usersRepository.findAll()
        log.info { "Found users:\n$users" }
        return users.toList()
    }

    fun deleteUser(id: Long) {
        log.info { "Deleting user with id $id" }
        try {
            usersRepository.deleteById(id)
        } catch (e: EmptyResultDataAccessException) {
            val msg = "Failed to delete user with id $id: such user doesn't exist"
            log.info { msg }
            throw NoSuchUserException(msg)
        }
        log.info { "User with id $id deleted successfully" }
    }
}