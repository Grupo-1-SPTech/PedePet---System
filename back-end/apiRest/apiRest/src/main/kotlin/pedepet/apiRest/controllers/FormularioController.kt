package pedepet.apiRest.controllers

import org.springframework.web.bind.annotation.*
import pedepet.apiRest.models.Formulario
import pedepet.apiRest.repositories.FormularioRepository


@RestController
@RequestMapping("/formularios")
@CrossOrigin("http://localhost:3000")
class FormularioController(
    val formularioRepository: FormularioRepository
) {
    @GetMapping("/{id}")
    fun buscarFormularioPorId(@PathVariable id:Int): Formulario? {
        return formularioRepository.findById(id).get()
    }
}