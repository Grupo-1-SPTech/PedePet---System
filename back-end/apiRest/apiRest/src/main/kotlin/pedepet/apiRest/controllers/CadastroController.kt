package pedepet.apiRest.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import pedepet.apiRest.dto.cadastros.CadAnuncioRequest
import pedepet.apiRest.dto.cadastros.CadEnderecoRequest
import pedepet.apiRest.dto.cadastros.CadFormularioRequest
import pedepet.apiRest.dto.cadastros.CadUserRequest
import pedepet.apiRest.service.UsuarioService


@RestController
@RequestMapping("cadastros")
@CrossOrigin("http://localhost:3000")
class CadastroController(
    val usuarioService: UsuarioService
) {

    @PostMapping("/usuario")
    fun cadUser(@RequestBody cadastroUser: CadUserRequest): ResponseEntity<Int> {
        println("no endpoint")
        return usuarioService.cadUsuario(cadastroUser)
    }

    @PostMapping("/endereco/{id}")
    fun cadEndereco(@PathVariable id:Int, @RequestBody cadEnderecoRequest: CadEnderecoRequest): ResponseEntity<String> {
        return usuarioService.cadEndereco(id, cadEnderecoRequest)
    }

    @PostMapping("/formulario/{id}")
    fun cadFormulario(@PathVariable id:Int, @RequestBody cadastroFormulario: CadFormularioRequest): ResponseEntity<String> {
        return usuarioService.cadFormulario(id, cadastroFormulario)
    }

    @PutMapping("/anuncio/{id}")
    fun cadAnuncio(@PathVariable id:Int, @RequestBody cadAnuncioRequest: CadAnuncioRequest): ResponseEntity<String> {
        return usuarioService.cadAnuncio(id, cadAnuncioRequest)
    }

}