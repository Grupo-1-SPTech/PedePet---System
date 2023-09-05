package pedepet.apiRest.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import pedepet.apiRest.Service.UsuarioService
import pedepet.apiRest.dto.Cadastros.CadFormularioRequest
import pedepet.apiRest.dto.Cadastros.CadUserRequest
import pedepet.apiRest.dto.Cadastros.CadAnuncioRequest
import pedepet.apiRest.dto.Cadastros.CadEnderecoRequest

@RestController
@RequestMapping("cadastros")
@CrossOrigin("http://localhost:3000")
class CadastroController(
    val usuarioService: UsuarioService
) {

    @PostMapping("/usuario")
    fun cadUser(@RequestBody cadastroUser: CadUserRequest): ResponseEntity<Int> {
        return usuarioService.cadUsuario(cadastroUser)
    }

    @PutMapping("/endereco/{id}")
    fun cadEndereco(@PathVariable id:Int, @RequestBody cadEnderecoRequest: CadEnderecoRequest): ResponseEntity<String> {
        return usuarioService.cadEndereco(id, cadEnderecoRequest)
    }

    @PutMapping("/formulario/{id}")
    fun cadFormulario(@PathVariable id:Int, @RequestBody cadastroFormulario: CadFormularioRequest): ResponseEntity<String> {
        return usuarioService.cadFormulario(id, cadastroFormulario)
    }

    @PutMapping("/anuncio/{id}")
    fun cadAnuncio(@PathVariable id:Int, @RequestBody cadAnuncioRequest: CadAnuncioRequest): ResponseEntity<String> {
        return usuarioService.cadAnuncio(id, cadAnuncioRequest)
    }

}