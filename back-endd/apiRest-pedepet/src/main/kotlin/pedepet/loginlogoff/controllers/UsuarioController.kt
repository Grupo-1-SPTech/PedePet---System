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
import pedepet.loginlogoff.models.Usuario
import pedepet.loginlogoff.repositories.AnuncioPetRepository
import pedepet.loginlogoff.repositories.UsuarioRepository

@RestController
@RequestMapping("/usuarios")
class UsuarioController(
    val usuarioRepository: UsuarioRepository,
    val anuncioPetRepository: AnuncioPetRepository
) {
    val usuarios = mutableListOf<Usuario>()

    @PostMapping("/cadastrar")
    fun postCadastro(@RequestBody novo: Usuario):String{
        if (usuarios.count {it.email == novo.email} > 0){
            return "O email ${novo.email} já existe no sistema."
        } else {
            usuarios.add(novo)
            return "Usuário ${novo.email} (${novo.nome}) cadastrado com sucesso."
        }
    }

    @DeleteMapping("/{email}")
    fun delete(@PathVariable email:String):String{
        val encontrado = usuarios.firstOrNull{ it.email == email}
                if (encontrado == null){
                    return "Usuário $email não encontrado."
                } else{
                    return "Usuário $email desativado."
                }
        }

    @GetMapping
    fun get():List<UsuarioResponse>{
        val listaUsuario = usuarios.map { UsuarioResponse(it) }
        return listaUsuario
    }

    @PatchMapping("/alterarSenha/{email}")
    fun patchAlterarSenha(@PathVariable email:String, @RequestBody novaSenha: SenhaEntradaRequest):ResponseEntity<Usuario>{
        val encontrado = usuarios.firstOrNull{ it.email == email}

        if (encontrado == null){
            throw ResponseStatusException(401,"Usuário não encontrado",null)
        }else {
            encontrado.senha = novaSenha.senha
            return ResponseEntity.status(200).build()
        }
    }
}