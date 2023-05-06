package pedepet.apiRest.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import pedepet.apiRest.dto.LoginRequest
import pedepet.apiRest.dto.SenhaEntradaRequest
import pedepet.apiRest.models.Usuario
import pedepet.apiRest.repositories.AnuncioRepository
import pedepet.apiRest.repositories.FormularioRepository
import pedepet.apiRest.repositories.UsuarioRepository

@RestController
@RequestMapping("/usuarios")
class UsuarioController(
    val repository: UsuarioRepository,
    val anuncioRepository: AnuncioRepository,
    val formularioRepository: FormularioRepository,
    val enderecoRepository: AnuncioRepository

) {

    @PostMapping("/cadastrar")



    @PatchMapping("/alterarSenha/{emal}")
    fun alterarSenha(@RequestBody novaSenha: SenhaEntradaRequest):ResponseEntity<Usuario>{
        val usuario: Usuario =
            repository.findByEmail(novaSenha.email).get()
        usuario.senha = novaSenha.senha
        return ResponseEntity.status(200).body(repository.save(usuario))

    }

    @PostMapping("/login")
    fun logar(@RequestBody usuarioLogin: LoginRequest): ResponseEntity<Usuario> {

        val usuarioEncontrado = repository.findByEmail(usuarioLogin.email)

        if(usuarioEncontrado.isEmpty){
            return ResponseEntity.status(204).build()
        } else {
            if(usuarioEncontrado.get().senha == usuarioLogin.senha){
                val usuarioLogado: Usuario = usuarioEncontrado.get()
                usuarioLogado.autenticado = true
                return ResponseEntity.status(200).body(repository.save(usuarioLogado))
            } else {
                return ResponseEntity.status(404).build()
            }
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


    /*@PostMapping("/login")
    fun logar(@RequestBody usuarioLogin: LoginRequest, id:Int): ResponseEntity<Usuario> {
        if(repository.existsById(id)){
            val usuarioLogin = repository.findById(id).get()
            usuarioLogin.autenticado = true
            repository.save(usuarioLogin)
            return ResponseEntity.status(200).build()
        } else{
            throw ResponseStatusException(HttpStatus.NOT_FOUND,"Credênciais incorretas ou usuario não cadastrado no sistema")
        }
    }
    */
}