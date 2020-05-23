package ru.mipt.tpos.kubernetes.users

import org.springframework.data.jpa.repository.JpaRepository

interface UsersRepository: JpaRepository<User, Long>