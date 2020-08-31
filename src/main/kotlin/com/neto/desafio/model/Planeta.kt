package com.neto.desafio.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Planeta (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 1,
    val nome: String = "",
    val clima: String = "",
    val terreno: String = ""
)