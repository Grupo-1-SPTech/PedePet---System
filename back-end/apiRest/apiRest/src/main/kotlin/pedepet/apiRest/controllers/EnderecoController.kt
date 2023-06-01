package pedepet.apiRest.controllers

import org.springframework.web.bind.annotation.*
import pedepet.apiRest.models.Endereco
import pedepet.apiRest.repositories.EnderecoRepository

@RestController
@RequestMapping("/endereco")
@CrossOrigin("http://localhost:3000")
class EnderecoController(
    val enderecoRepository: EnderecoRepository
) {
// GET BUSCAR ENDEREÇO POR ID
    @GetMapping("/{id}")
    fun buscarEnderecoPorId(@PathVariable id:Int): Endereco? {
        return enderecoRepository.findById(id).get()
    }
}