package ru.mipt.tpos.kubernetes.users

import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.noContent
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class UsersController(
    private val usersService: UsersService
) {
    @PostMapping("/users/add")
    fun addUser(
        @RequestParam name: String,
        @RequestParam age: Int
    ): Long = usersService.addUser(name, age)

    @GetMapping("/users/get")
    fun getUserById(@RequestParam id: Long): User? =
        usersService.getUserById(id)

    @GetMapping("/users/get/all")
    fun getAllUsers(): List<User> =
        usersService.getAllUsers()

    @DeleteMapping("/users/delete")
    fun deleteUser(@RequestParam id: Long): ResponseEntity<String> {
        usersService.deleteUser(id)
        return noContent().build()
    }

    @ExceptionHandler(NoSuchUserException::class)
    fun noSuchUser(e: NoSuchUserException) = ok(checkNotNull(e.message))

    @GetMapping("/")
    fun healthcheck() = ok().build<String>()
}