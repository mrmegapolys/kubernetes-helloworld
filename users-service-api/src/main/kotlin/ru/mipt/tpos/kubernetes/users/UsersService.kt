package ru.mipt.tpos.kubernetes.users

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UsersService(
    private val usersRepository: UsersRepository
) {
    fun getUserById(id: Long): User? =
        usersRepository.findByIdOrNull(id)

    fun addUser(name: String, age: Int): Long {
        val user = User(name, age)
        return usersRepository.save(user).id
    }
}