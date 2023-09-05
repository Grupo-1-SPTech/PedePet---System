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
import pedepet.apiRest.dto.Cadastros.CadastrarFormulario
import pedepet.apiRest.dto.Cadastros.CadastrarUserRequest
import pedepet.apiRest.dto.Cadastros.CadastroAnuncio
import pedepet.apiRest.dto.Cadastros.CadastroEndereco

@RestController
@RequestMapping("cadastros")
@CrossOrigin("http://localhost:3000")
class CadastroController(
    val usuarioService: UsuarioService
) {

    @PostMapping("/usuario")
    fun cadUser(@RequestBody cadastroUser: CadastrarUserRequest): ResponseEntity<Int> {
        return usuarioService.cadUsuario(cadastroUser)
    }

    @PutMapping("/endereco/{id}")
    fun cadEndereco(@PathVariable id:Int, @RequestBody cadastroEndereco: CadastroEndereco): ResponseEntity<String> {
        return usuarioService.cadEndereco(id, cadastroEndereco)
    }

    @PutMapping("/formulario/{id}")
    fun cadFormulario(@PathVariable id:Int, @RequestBody cadastroFormulario: CadastrarFormulario): ResponseEntity<String> {
        return usuarioService.cadFormulario(id, cadastroFormulario)
    }

    @PutMapping("/anuncio/{id}")
    fun cadAnuncio(@PathVariable id:Int, @RequestBody cadastroAnuncio: CadastroAnuncio): ResponseEntity<String> {
        return usuarioService.cadAnuncio(id, cadastroAnuncio)
    }

}