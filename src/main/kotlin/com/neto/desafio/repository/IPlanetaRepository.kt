package com.neto.desafio.repository

import com.neto.desafio.model.Planeta
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface IPlanetaRepository:CrudRepository<Planeta, Long>  {
}