package pedepet.loginlogoff.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import pedepet.loginlogoff.dtos.SenhaEntradaRequest
import pedepet.loginlogoff.dtos.UsuarioRequest
import pedepet.loginlogoff.models.Usuario
import pedepet.loginlogoff.repositories.AnuncioPetRepository
import pedepet.loginlogoff.repositories.UsuarioRepository
import javax.validation.Valid

@RestController
@RequestMapping("/usuarios")
class UsuarioController(
    val usuarioRepository: UsuarioRepository,
    val anuncioPetRepository: AnuncioPetRepository
) {
    val usuarios = mutableListOf<Usuario>()

    @PostMapping("/cadastrar")
    fun postCadastrar(@RequestBody @Valid novo: Usuario):ResponseEntity<UsuarioRequest>{
        val usuarioExistente = usuarios.firstOrNull{ it.email == novo.email}

        if(usuarioExistente != null){
            throw ResponseStatusException(409,"Esse email ${novo.email} já existe no sistema",null)
        }
        usuarios.add(novo)
        val novoUsuarioDto = UsuarioRequest(novo)
        return ResponseEntity.status(201).body(novoUsuarioDto)
    }

    @GetMapping
    fun getUsuario():ResponseEntity<List<UsuarioRequest>>{
        val listaUsuario = usuarios.map { UsuarioRequest(it) }
        if(listaUsuario.isNotEmpty()){
            return ResponseEntity.status(200).body(listaUsuario)
        }
        return ResponseEntity.status(204).build()
    }

    @PatchMapping("/alterarSenha/{email}")
    fun patchAlterarSenha(@PathVariable email:String, @RequestBody novaSenha: SenhaEntradaRequest):ResponseEntity<Usuario>{
        val encontrado = usuarios.firstOrNull{ it.email == email}

        if (encontrado == null){
            throw ResponseStatusException(401,"Usuário não encontrado",null)
        }else {
            encontrado.senha = novaSenha.senha
            return ResponseEntity.status(200).body(usuarioRepository.save(encontrado))
        }
    }

    @DeleteMapping("/deletar/{email}")
    fun deletarUsuario(@PathVariable email:String):ResponseEntity<Void>{
        val encontrado = usuarios.firstOrNull{ it.email == email}
        if (encontrado == null){
            throw ResponseStatusException(404,"Esse email não está registrado no sistema",null)
        } else{
            return ResponseEntity.status(200).build()
        }
    }
}