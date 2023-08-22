package pedepet.apiRest.controllers

import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import pedepet.apiRest.dto.*
import pedepet.apiRest.models.AnuncioPet
import pedepet.apiRest.models.Filhote
import pedepet.apiRest.models.Usuario
import pedepet.apiRest.repositories.*

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


    // CADASTRAR COMPRADOR
    @PostMapping("/cadastrar/comprador")
    fun cadComprador(@RequestBody cadCompradorRequest: CompradorRequest): ResponseEntity<Usuario> {

        val selectComprador = repository.findByEmailAndTipoUsuario(cadCompradorRequest.usuario.email, cadCompradorRequest.usuario.tipoUsuario)

        if(selectComprador == null) {
            val usuarioComprador: Usuario = repository.save(cadCompradorRequest.usuario)
            cadCompradorRequest.endereco.usuario = repository.findById(usuarioComprador.id).get()
            cadCompradorRequest.formulario.usuario = repository.findById(usuarioComprador.id).get()
            enderecoRepository.save(cadCompradorRequest.endereco)
            formularioRepository.save(cadCompradorRequest.formulario)
            return ResponseEntity.status(201).body(usuarioComprador)
        }
        return ResponseEntity.status(404).build()
    }


    // CADASTRAR VENDEDOR
    @PostMapping("/cadastrar/vendedor")
    fun cadVendedor(@RequestBody cadVendedorRequest: VendedorRequest): ResponseEntity<Usuario> {

        val selectVendedor = repository.findByEmailAndTipoUsuario(cadVendedorRequest.usuario.email, tipoUsuario = 2)

        if(selectVendedor == null) {
            val usuarioVendedor: Usuario = repository.save(cadVendedorRequest.usuario)
            cadVendedorRequest.endereco.usuario = repository.findById(usuarioVendedor.id).get()
            cadVendedorRequest.anuncioPet.usuario = repository.findById(usuarioVendedor.id).get()
            enderecoRepository.save(cadVendedorRequest.endereco)
            val saveAnuncio: AnuncioPet = anuncioRepository.save(cadVendedorRequest.anuncioPet)
            cadVendedorRequest.filhote.anuncioPet = anuncioRepository.findById(saveAnuncio.id).get()
            val qtdFilhote = saveAnuncio.qtdFilhotes
            for (i in 1..qtdFilhote){
                val dog = cadVendedorRequest.filhote
                filhoteRepository.save(dog).also {
                    cadVendedorRequest.filhote = cadVendedorRequest.filhote.copy(id = null)
                }
            }
            return ResponseEntity.status(201).body(usuarioVendedor)
        }
        return ResponseEntity.status(404).build()
    }

    // CADASTRAR ANUNCIO DE VENDEDOR ESPECIFICO(VENDEDOR JÁ ERA CADASTRADO)
    @PostMapping("/cadastrar/vendedor/{id}/anuncio")
    fun cadAnuncio(@RequestBody novoAnuncio: AddAnuncioRequest, @PathVariable id: Int): ResponseEntity<AnuncioPet> {

        val selectVendedor = repository.findById(id).get()

        if(selectVendedor != null){
            val anuncio: AnuncioPet = anuncioRepository.save(novoAnuncio.anuncioPet)
            novoAnuncio.filhote.anuncioPet?.id = anuncio.id
            val qtdFilhote = anuncio.qtdFilhotes
            for (i in 1..qtdFilhote){
                val dog = novoAnuncio.filhote
                filhoteRepository.save(dog).also {
                    novoAnuncio.filhote = novoAnuncio.filhote.copy(id = null)
                }
            }
            return ResponseEntity.status(201).body(anuncio)
        }
        return ResponseEntity.status(404).build()
    }


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

}