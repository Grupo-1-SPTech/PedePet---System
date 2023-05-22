package pedepet.apiRest.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import pedepet.apiRest.models.Filhote
import pedepet.apiRest.repositories.FilhoteRepository

@RestController
@RequestMapping("/filhotes")
@CrossOrigin("http://localhost:3000")
class Filhote(
    val filhoteRepository: FilhoteRepository
) {

    // PEGAR FILHOTES POR ID
    @GetMapping("{id}")
    fun buscarFilhotePorId(@PathVariable id:Int): Filhote? {
        return filhoteRepository.findById(id).get()
    }

    // TOTAL FILHOTES ADQUIRIDOS
    @GetMapping("adquiridos")
    fun buscarFilhotesAdquiridos():ResponseEntity<List<Filhote?>> {
        val filhotes = filhoteRepository.buscarFilhotesAdiquiridos()

        if(filhotes.isNotEmpty()){
            return ResponseEntity.status(200).body(filhotes)
        }
        return ResponseEntity.status(204).build()
    }


}