package ru.mipt.tpos.kubernetes.users

class NoSuchUserException(message: String):
    IllegalArgumentException(message)