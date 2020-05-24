package ru.mipt.tpos.kubernetes.users

import org.springframework.data.repository.CrudRepository

interface UsersRepository: CrudRepository<User, Long>