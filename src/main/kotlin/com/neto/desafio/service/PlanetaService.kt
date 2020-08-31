package com.neto.desafio.service

import com.neto.desafio.exception.PlanetaNotFoundException
import com.neto.desafio.model.Planeta
import com.neto.desafio.repository.IPlanetaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Component

@Component
class PlanetaService(val planetaRepository: IPlanetaRepository) : IPlanetaService {

    @Cacheable("planetas")
    override fun list(): List<Planeta> {
        return this.planetaRepository.findAll().toList();
    }

    @Cacheable("planetas")
    override fun getById(id: Long): Planeta? {

        return this.planetaRepository.findById(id).orElse(null)
                ?: throw PlanetaNotFoundException("Planeta de id ${id} não encontrado");
    }

    @CacheEvict("planetas", allEntries = true)
    override fun save(planeta: Planeta) {
        this.planetaRepository.save(planeta);
    }

    @CacheEvict("planetas", allEntries = true)
    override fun delete(id: Long) {

        if (this.planetaRepository.findById(id) == null)
        {
            throw PlanetaNotFoundException("Planeta de id ${id} não encontrado");
        }

        this.planetaRepository.deleteById(id)

    }

    @CacheEvict("planetas", allEntries = true)
    override fun update(id: Long, planeta: Planeta) {

        this.planetaRepository.save(planeta);

    }

    override fun count(): Long {
        return this.planetaRepository.count();
    }
}