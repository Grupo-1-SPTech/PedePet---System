package pedepet.apiRest.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import pedepet.apiRest.dto.CompradorRequest
import pedepet.apiRest.dto.LoginRequest
import pedepet.apiRest.dto.SenhaEntradaRequest
import pedepet.apiRest.dto.VendedorRequest
import pedepet.apiRest.models.AnuncioPet
import pedepet.apiRest.models.Usuario
import pedepet.apiRest.repositories.*

@RestController
@RequestMapping("/usuarios")
class UsuarioController(
    val repository: UsuarioRepository,
    val anuncioRepository: AnuncioRepository,
    val formularioRepository: FormularioRepository,
    val enderecoRepository: EnderecoRepository,
    val filhoteRepository: FilhoteRepository

) {

    @PostMapping("/cadastrar")
    fun cad(@RequestBody cadVendedorRequest: VendedorRequest, cadCompradorRequest: CompradorRequest): ResponseEntity<Void> {

        //val selectVendedor = repository.findByEmailAndTipoUsuario(cadVendedorRequest.usuario.email, cadVendedorRequest.usuario.tipoUsuario)
        val selectComprador = repository.findByEmailAndTipoUsuario(cadCompradorRequest.usuario.email, cadCompradorRequest.usuario.tipoUsuario)

        if(selectComprador == null) {
            val usuarioComprador: Usuario = repository.save(cadCompradorRequest.usuario)
            cadCompradorRequest.endereco.usuario = usuarioComprador.id
            cadCompradorRequest.formulario.usuario = usuarioComprador.id
            enderecoRepository.save(cadCompradorRequest.endereco)
            formularioRepository.save(cadCompradorRequest.formulario)
            ResponseEntity.status(201).body(null)
        } else {
            val usuarioVendedor: Usuario = repository.save(cadVendedorRequest.usuario)
            cadVendedorRequest.endereco.usuario = usuarioVendedor.id
            cadVendedorRequest.anuncioPet.usuario = usuarioVendedor.id
            enderecoRepository.save(cadVendedorRequest.endereco)
            val saveAnuncio: AnuncioPet = anuncioRepository.save(cadVendedorRequest.anuncioPet)
            cadVendedorRequest.filhote.anuncioPet = saveAnuncio.id
            filhoteRepository.save(cadVendedorRequest.filhote)
            ResponseEntity.status(201).body(null)
        }
        return ResponseEntity.status(404).build()
    }



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