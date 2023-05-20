package pedepet.apiRest.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import pedepet.apiRest.models.Formulario
import pedepet.apiRest.repositories.FormularioRepository


@RestController
@RequestMapping("/formularios")
class FormularioController(
    val formularioRepository: FormularioRepository
) {
    @GetMapping("{id}")
    fun buscarFormularioPorId(@PathVariable id:Int): Formulario? {
        return formularioRepository.findById(id).get()
    }
}