package ru.mipt.tpos.kubernetes.users

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.IDENTITY
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "users")
data class User(
    val name: String,
    val age: Int,
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long = 0
)