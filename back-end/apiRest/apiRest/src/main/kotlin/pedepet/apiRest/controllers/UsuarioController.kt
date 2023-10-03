package pedepet.apiRest.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import pedepet.apiRest.dto.*
import pedepet.apiRest.models.*
import pedepet.apiRest.repositories.*
import java.util.*
import javax.validation.constraints.Email

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("http://localhost:3000")
class UsuarioController(
    val repository: UsuarioRepository,
    val anuncioRepository: AnuncioRepository,
    val formularioRepository: FormularioRepository,
    val enderecoRepository: EnderecoRepository,
    val filhoteRepository: FilhoteRepository
) {

 // ALTERAR SENHA
 @PatchMapping("/alterarSenha/{email}")
 fun alterarSenha(@RequestBody novaSenha: SenhaEntradaRequest):ResponseEntity<Usuario>{
     val usuario: Usuario =
         repository.findByEmail(novaSenha.email).get()
     usuario.senha = novaSenha.senha
     return ResponseEntity.status(200).body(repository.save(usuario))
 }

 // LOGIN
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

 // DESLOGAR
 @DeleteMapping("/logoff/{id}")
 fun deslogar(@PathVariable id: Int):ResponseEntity<Usuario> {
     if (repository.existsById(id)) {
         val usuarioLogin = repository.findById(id).get()
         usuarioLogin.autenticado = false
         repository.save(usuarioLogin)
         return ResponseEntity.status(200).build()
     } else {
         return ResponseEntity.status(404).build()
     }
 }

 // TOTAL DE VENDEDORES CADASTRADOS
 @GetMapping("/vendedor/total")
 fun buscarQtdVendedores():ResponseEntity<Long>{
     val vendedores = repository.buscarQtdVendedores()
     return ResponseEntity.status(200).body(vendedores)
 }

 // TOTAL DE USUARIOS CADASTRADOS
 @GetMapping("/total")
 fun buscarTotalUsuario():ResponseEntity<Long>{
     val usuarios = repository.buscarTotalUsuarios()
     return ResponseEntity.status(200).body(usuarios)
 }

 // VALIDA SE USUARIO ESTA AUTENTICADO
 @GetMapping("/autenticado/{email}")
 fun buscaUsuarioAutenticado(@PathVariable email: String): ResponseEntity<Boolean>{
     val autenticado = repository.findByEmailAndAutenticadoTrue(email)
     if(autenticado != null) {
         return ResponseEntity.ok().body(autenticado.autenticado)
     } else{
         return ResponseEntity.status(404).build()

     }
 }
    @GetMapping("/existente/{email}")
    fun buscarEmailExistente (@PathVariable email: String): ResponseEntity<Boolean> {
        val emailExistente = repository.findByEmail(email)
        if (emailExistente.isEmpty) {
            return ResponseEntity.status(404).build()
        } else {
            return ResponseEntity.ok().build()
        }
    }
    @GetMapping("/info/{email}")
    fun buscarInfoUser (@PathVariable email: String): ResponseEntity<EnderecoDto> {
        val infoUser: Usuario = repository.findByEmail(email).get()

        val enderecoUser: Endereco? = enderecoRepository.findByUsuarioId(infoUser.id)
        val retorno = EnderecoDto(usuario = infoUser, endereco = enderecoUser)

        return ResponseEntity.status(200).body(retorno)
    }

    @GetMapping("/alterar/{email}")
    fun alterarEmail (@PathVariable infoAlt: AltEmailRequest): ResponseEntity<Usuario> {
        val infoUser: Usuario = repository.findByEmail(infoAlt.email).get()

        if (infoUser.senha == infoAlt.senha) {
            infoUser.email = infoAlt.emailNovo
            return ResponseEntity.status(200).body(repository.save(infoUser))
        } else {
            return ResponseEntity.status(404).build()
        }
    }


    
}