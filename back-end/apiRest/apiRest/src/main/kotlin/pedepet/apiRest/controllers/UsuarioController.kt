package pedepet.apiRest.controllers

import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import pedepet.apiRest.dtos.LoginRequest
import pedepet.apiRest.dtos.SenhaEntradaRequest
import pedepet.apiRest.dtos.UsuarioRequest
import pedepet.apiRest.models.Usuario
import pedepet.apiRest.repositories.UsuarioRepository
import javax.validation.Valid

@RestController
@RequestMapping("/usuarios")
class UsuarioController(
    val repository: UsuarioRepository
) {
    /*@PostMapping("/cadastrarTeste")
    fun cad(@RequestBody usuarioNovo: UsuarioRequest): ResponseEntity<Void> {
        val usuarioCad: Usuario = repository.save(usuarioNovo.usuario)
        return ResponseEntity.status(200).build()
    }*/

    @PatchMapping("/alterarSenha/{id}")
    fun alterarSenha(@RequestBody novaSenha: SenhaEntradaRequest):ResponseEntity<Usuario>{
        val usuario: Usuario =
            repository.findById(novaSenha.id).get()
        usuario.senha = novaSenha.senha
        return ResponseEntity.status(200).body(repository.save(usuario))

    }

    @PostMapping("/login")
    fun logar(@RequestBody usuarioLogin: LoginRequest, id:Int): ResponseEntity<Usuario> {
        if(repository.existsById(id)){
            val usuarioLogin = repository.findById(id).get()
            usuarioLogin.autenticado = true
            repository.save(usuarioLogin)
            return ResponseEntity.status(200).build()
        } else{
            throw ResponseStatusException(404,"Credênciais incorretas ou usuario não cadastrado no sistema",null)
        }
    }

    @DeleteMapping("/logoff/{email}")
    fun deslogar(@RequestBody id: Int, @PathVariable email:String):ResponseEntity<Usuario> {
        if (repository.existsById(id)) {
            val usuarioLogin = repository.findById(id).get()
            usuarioLogin.autenticado = false
            repository.save(usuarioLogin)
            return ResponseEntity.status(200).build()
        } else {
            return ResponseEntity.status(404).build()
        }
    }
}