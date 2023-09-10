package pedepet.apiRest.Service

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import pedepet.apiRest.dto.Cadastros.CadFormularioRequest
import pedepet.apiRest.dto.Cadastros.CadUserRequest
import pedepet.apiRest.dto.Cadastros.CadAnuncioRequest
import pedepet.apiRest.dto.Cadastros.CadEnderecoRequest
import pedepet.apiRest.models.*
import pedepet.apiRest.repositories.*

@Service
class UsuarioService(
    val usuarioRepository: UsuarioRepository,
    val enderecoRepository: EnderecoRepository,
    val formularioRepository: FormularioRepository,
    val anuncioRepository: AnuncioRepository,
    val filhoteRepository: FilhoteRepository,
) {

    // CADASTR USUARIO
    fun cadUsuario(cadastroUser: CadUserRequest): ResponseEntity<Int> {
        println("1")
        val tipoUsuario = when (cadastroUser.tipoUsuario) {
            1 -> Comprador::class.java
            2 -> Vendedor::class.java
            else -> Comprador::class.java
        }

        val selectUser = usuarioRepository.findByEmailAndTipoUsuario(cadastroUser.email)
        if (selectUser.isPresent){
            println("Usuário já existe")
            return ResponseEntity.status(404).build()
        } else {
            println("2")
            val usuario = if (cadastroUser.tipoUsuario == 1){
                val comprador = Comprador()
                comprador.nome = cadastroUser.nome
                comprador.email = cadastroUser.email
                comprador.cpf = cadastroUser.cpf
                comprador.telefone = cadastroUser.telefone
                comprador.senha = cadastroUser.senha
                comprador.autenticado = cadastroUser.autenticado
                usuarioRepository.save(comprador).id
            } else {
                println("3")
                val vendedor = Vendedor()
                vendedor.nome = cadastroUser.nome
                vendedor.email = cadastroUser.email
                vendedor.cpf = cadastroUser.cpf
                vendedor.telefone = cadastroUser.telefone
                vendedor.senha = cadastroUser.senha
                vendedor.autenticado = cadastroUser.autenticado
                usuarioRepository.save(vendedor).id
            }
            println("4")
            return ResponseEntity.status(201).body(usuario)
        }
    }

    // CADASTRO ENDERECO
    fun cadEndereco(id:Int, cadEnderecoRequest: CadEnderecoRequest): ResponseEntity<String> {

        val user = usuarioRepository.findById(id)
        if (user.isEmpty) {
            return ResponseEntity.status(404).build()
        }
        val cadEndereco = enderecoRepository.findByUsuarioId(id)
        return if(cadEndereco != null) {
            ResponseEntity.status(404).build()
        } else {
            val endereco = Endereco()
            endereco.usuario = user.get()
            endereco.cep = cadEnderecoRequest.cep
            endereco.rua = cadEnderecoRequest.rua
            endereco.numero = cadEnderecoRequest.numero
            endereco.complemento = cadEnderecoRequest.complemento
            endereco.bairro = cadEnderecoRequest.bairro
            endereco.cidade = cadEnderecoRequest.cidade
            endereco.estado = cadEnderecoRequest.estado
            enderecoRepository.save(endereco)
            ResponseEntity.status(201).body(cadEndereco)
        }
    }

    // CADASTRO FORMS
    fun cadFormulario(id: Int, cadFormulario: CadFormularioRequest): ResponseEntity<String> {

        val user = usuarioRepository.findById(id)
        if (user.isEmpty) {
            return ResponseEntity.status(404).build()
        }
        val selectForm = formularioRepository.findByUsuarioId(id)
        if(selectForm != null) {
            ResponseEntity.status(404).body("Formulario exisente")
        }
        val comprador = user.get()
        if(comprador is Vendedor){
            return ResponseEntity.status(404).build()
        } else {
            val form = Formulario()
            form.usuario = user.get()
            form.tipoMoradia = cadFormulario.tipoMoradia
            form.qtdComodos = cadFormulario.qtdComodos
            form.qtdMoradores = cadFormulario.qtdMoradores
            form.qtdHorasCasa = cadFormulario.qtdHorasCasa
            form.possuiPet = cadFormulario.possuiPet
            form.statusForms = cadFormulario.statusForms
            formularioRepository.save(form)
            return ResponseEntity.status(201).body("Formulario Cadastrado")
        }
    }

    fun cadAnuncio(id:Int, cadastrarAnuncio: CadAnuncioRequest): ResponseEntity<String> {

        val user = usuarioRepository.findById(id)
        if (user.isEmpty) {
            return ResponseEntity.status(404).build()
        }
        val selectAnuncio = anuncioRepository.findByUsuarioId(id)
        if (selectAnuncio != null){
            ResponseEntity.status(404).body("Anuncio ja existente")
        }
        val vendedor = user.get()
        if(vendedor is Comprador){
            return ResponseEntity.status(404).build()
        } else {
            val anuncio = AnuncioPet()
            anuncio.usuario = user.get()
            anuncio.racaMae = cadastrarAnuncio.racaMae
            anuncio.idadeMae = cadastrarAnuncio.idadeMae
            anuncio.porteMae = cadastrarAnuncio.porteMae
            anuncio.pedigreeMae = cadastrarAnuncio.pedigreeMae
            anuncio.vacinadoMae = cadastrarAnuncio.vacinadoMae
            anuncio.racaPai = cadastrarAnuncio.racaPai
            anuncio.idadePai = cadastrarAnuncio.idadePai
            anuncio.portePai = cadastrarAnuncio.portePai
            anuncio.pedigreePai = cadastrarAnuncio.pedigreePai
            anuncio.vacinadoPai = cadastrarAnuncio.vacinadoPai
            anuncio.fotoPet = cadastrarAnuncio.fotoPet
            anuncio.visualizacoes = cadastrarAnuncio.visualizacoes
            anuncio.descricao = cadastrarAnuncio.descricao
            anuncio.qtdFilhotes = cadastrarAnuncio.qtdFilhotes
            val saveAnuncio: AnuncioPet = anuncioRepository.save(anuncio)
            cadastrarAnuncio.filhote.anuncioPet = anuncioRepository.findById(saveAnuncio.id).get()
            val qtdFilhote = saveAnuncio.qtdFilhotes
            for (i in 1..qtdFilhote){
                val dog = cadastrarAnuncio.filhote
                filhoteRepository.save(dog).also {
                    cadastrarAnuncio.filhote = cadastrarAnuncio.filhote.copy(id = null)
                }
            }
            return ResponseEntity.status(201).body("Anuncio cadastrado")
        }
    }
}