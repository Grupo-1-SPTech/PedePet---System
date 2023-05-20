package pedepet.apiRest.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import pedepet.apiRest.models.Endereco
import pedepet.apiRest.repositories.EnderecoRepository

@RestController
@RequestMapping("/endereco")
class EnderecoController(
    val enderecoRepository: EnderecoRepository
) {

    @GetMapping("{id}")
    fun buscarEnderecoPorId(@PathVariable id:Int): Endereco? {
        return enderecoRepository.findById(id).get()
    }
}