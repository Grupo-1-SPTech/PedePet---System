package pedepet.apiRest.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import pedepet.apiRest.models.Filhote
import pedepet.apiRest.repositories.FilhoteRepository

@RestController
@RequestMapping("/filhotes")
class Filhote(
    val filhoteRepository: FilhoteRepository
) {

    @GetMapping("{id}")
    fun buscarFilhotePorId(@PathVariable id:Int): Filhote? {
        return filhoteRepository.findById(id).get()
    }
}