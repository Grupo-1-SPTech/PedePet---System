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
import pedepet.loginlogoff.dtos.LoginRequest
import pedepet.loginlogoff.dtos.SenhaEntradaRequest
import pedepet.loginlogoff.dtos.UsuarioRequest
import pedepet.loginlogoff.models.Usuario
import pedepet.loginlogoff.repositories.AnuncioPetRepository
import pedepet.loginlogoff.repositories.UsuarioRepository
import javax.transaction.Transactional
import javax.validation.Valid

@RestController
@RequestMapping("/usuarios")
class UsuarioController(
    //val usuarioRepository: UsuarioRepository,
    val repository: UsuarioRepository
) {
    val usuarios = mutableListOf<Usuario>()

    @PostMapping("/cadastrar")
    fun cadastrar(@RequestBody @Valid novo: Usuario):ResponseEntity<UsuarioRequest>{
        val usuarioExistente = usuarios.firstOrNull{ it.email == novo.email}

        if(usuarioExistente != null){
            throw ResponseStatusException(409,"Esse email ${novo.email} já existe no sistema",null)
        }
        usuarios.add(novo)
        val novoUsuarioDto = UsuarioRequest(novo)
        return ResponseEntity.status(201).body(novoUsuarioDto)
    }

    /*
    @PostMapping("/cadastrarTeste")
    fun cad(@RequestBody usuarioNovo:UsuarioRequest):ResponseEntity<Void>{
        val usuarioCad:Usuario = repository.save(usuarioNovo.usuario)
        return ResponseEntity.status(200).build()
    }
    */


    @GetMapping
    fun getUsuario():ResponseEntity<List<UsuarioRequest>>{
        val listaUsuario = usuarios.map { UsuarioRequest(it) }
        if(listaUsuario.isNotEmpty()){
            return ResponseEntity.status(200).body(listaUsuario)
        }
        //throw ResponseStatusException(204,"Sem cadastros",null)
        return ResponseEntity.status(204).build()
    }

    /*@GetMapping
    fun getTeste(): ResponseEntity<List<Usuario>>{
        val resultado = repository.findByEmailIgnoreCaseContains()
        if(resultado.isNotEmpty()){
            return ResponseEntity.status(200).body(resultado)
        }
        return ResponseEntity.status(204).build()
    }
     */

    @PatchMapping("/alterarSenha/{email}")
    fun alterarSenha(@PathVariable email:String, @RequestBody novaSenha: SenhaEntradaRequest):ResponseEntity<Void>{
        val encontrado = usuarios.firstOrNull{ it.email == email}

        if (encontrado == null){
            throw ResponseStatusException(404,"Usuário não encontrado",null)
        }else {
            encontrado.senha = novaSenha.senha
            return ResponseEntity.status(200).build()
        }
    }

    @DeleteMapping("/deletar/{email}")
    fun deletarUsuario(@PathVariable email: String):ResponseEntity<Void>{
        val encontrado = usuarios.firstOrNull{ it.email == email}
        if (encontrado != null){
            repository.deleteByEmail(email)
            return ResponseEntity.status(200).build()
        } else{
            throw ResponseStatusException(404,"Esse email não esta registrado no sistema",null)
        }
    }


    @PostMapping("/login")
    fun logar(@RequestBody @Valid usuarioLogin: LoginRequest): ResponseEntity<UsuarioRequest> {
        val usuarioExistente = usuarios.firstOrNull { it.email == usuarioLogin.email && it.senha == usuarioLogin.senha }

        if(usuarioExistente != null){
            usuarioExistente.autenticado = true
            val LoginUsuarioDto = UsuarioRequest(usuarioExistente)
            return ResponseEntity.status(200).body(LoginUsuarioDto)
        }

        throw ResponseStatusException(404, "Usuário não existe ou credênciais errada",null)
    }

    @DeleteMapping("/login/{email}")
    fun deslogar(@PathVariable email:String):ResponseEntity<Void>{
        val usuarioExistente = usuarios.firstOrNull { it.email == email }

        if(usuarioExistente != null){
            usuarioExistente.autenticado = false
            return ResponseEntity.status(200).build()
        }

        throw ResponseStatusException(404, null,null)
    }

}