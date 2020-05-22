package ru.mipt.tpos.kubernetes.users

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class UsersController(
    private val usersService: UsersService
) {
    @PostMapping("users/add")
    fun addUser(
        @RequestParam name: String,
        @RequestParam age: Int
    ): Long = usersService.addUser(name, age)

    @GetMapping("/users/get")
    fun getUserById(@RequestParam id: Long): User? =
        usersService.getUserById(id)
}