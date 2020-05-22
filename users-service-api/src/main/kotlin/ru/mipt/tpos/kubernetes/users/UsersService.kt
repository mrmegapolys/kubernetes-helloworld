package ru.mipt.tpos.kubernetes.users

import org.springframework.stereotype.Service

@Service
class UsersService {
    fun getUserById(id: Long) =
        User(12345, "fullName", 30)

    fun addUser(name: String, age: Int): Long = 12345
}