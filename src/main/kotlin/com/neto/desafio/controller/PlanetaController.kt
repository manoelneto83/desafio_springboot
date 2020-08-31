package com.neto.desafio.controller

import com.neto.desafio.exception.PlanetaNotFoundException
import com.neto.desafio.model.Planeta
import com.neto.desafio.service.IPlanetaService
import com.neto.desafio.service.PlanetaService
import org.apache.coyote.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.RequestEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/planetas"])
class PlanetaController {

    @Autowired
    lateinit var planetaService:IPlanetaService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    fun index():List<Planeta> {
        return planetaService.list();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun show(@PathVariable id:Long):Planeta? {
        return planetaService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    fun store(@RequestBody planeta: Planeta) {
        planetaService.save(planeta);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun update(@PathVariable id: Long, @RequestBody planeta: Planeta) {
        planetaService.update(id, planeta);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun delete(@PathVariable id:Long) {
        planetaService.delete(id);
    }

    @GetMapping("/count")
    @ResponseStatus(HttpStatus.OK)
    fun count(): Map<String, Long> {
        return mapOf("count" to planetaService.count());
    }



}