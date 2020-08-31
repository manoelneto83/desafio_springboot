package com.neto.desafio.service

import com.neto.desafio.model.Planeta

interface IPlanetaService {
    fun list(): List<Planeta>
    fun getById(id: Long): Planeta?
    fun save(planeta: Planeta)
    fun delete(id: Long)
    fun update(id: Long, planeta: Planeta)
    fun count(): Long
}