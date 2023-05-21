package pedepet.apiRest.controllers

import org.springframework.web.bind.annotation.*
import pedepet.apiRest.models.Filhote
import pedepet.apiRest.repositories.FilhoteRepository

@RestController
@RequestMapping("/filhotes")
@CrossOrigin("http://localhost:3000")
class Filhote(
    val filhoteRepository: FilhoteRepository
) {

    @GetMapping("{id}")
    fun buscarFilhotePorId(@PathVariable id:Int): Filhote? {
        return filhoteRepository.findById(id).get()
    }

}