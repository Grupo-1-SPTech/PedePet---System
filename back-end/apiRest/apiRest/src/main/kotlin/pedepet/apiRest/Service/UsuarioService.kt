package pedepet.apiRest.Service

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import pedepet.apiRest.dto.Cadastros.CadastrarFormulario
import pedepet.apiRest.dto.Cadastros.CadastrarUserRequest
import pedepet.apiRest.dto.Cadastros.CadastroAnuncio
import pedepet.apiRest.dto.Cadastros.CadastroEndereco
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
    fun cadUsuario(cadastroUser: CadastrarUserRequest): ResponseEntity<Int> {

        val tipoUsuario = when (cadastroUser.tipoUsuario) {
            1 -> Comprador::class.java
            2 -> Vendedor::class.java
            else -> Comprador::class.java
        }
        val selectUser = usuarioRepository.findByEmailAndTipoUsuario(cadastroUser.email)
        if (selectUser.isPresent){
            return ResponseEntity.status(404).build()
        } else {

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
                val vendedor = Vendedor()
                vendedor.nome = cadastroUser.nome
                vendedor.email = cadastroUser.email
                vendedor.cpf = cadastroUser.cpf
                vendedor.telefone = cadastroUser.telefone
                vendedor.senha = cadastroUser.senha
                vendedor.autenticado = cadastroUser.autenticado
                usuarioRepository.save(vendedor).id
            }
            return ResponseEntity.status(201).body(usuario)
        }
    }

    // CADASTRO ENDERECO
    fun cadEndereco(id:Int, cadastroEndereco: CadastroEndereco): ResponseEntity<String> {

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
            endereco.cep = cadastroEndereco.cep
            endereco.rua = cadastroEndereco.rua
            endereco.numero = cadastroEndereco.numero
            endereco.complemento = cadastroEndereco.complemento
            endereco.bairro = cadastroEndereco.bairro
            endereco.cidade = cadastroEndereco.cidade
            endereco.estado = cadastroEndereco.estado
            enderecoRepository.save(endereco)
            ResponseEntity.status(201).body(cadEndereco)
        }
    }

    // CADASTRO FORMS
    fun cadFormulario(id: Int, cadastrarFormulario: CadastrarFormulario): ResponseEntity<String> {

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
            form.tipoMoradia = cadastrarFormulario.tipoMoradia
            form.qtdComodos = cadastrarFormulario.qtdComodos
            form.qtdMoradores = cadastrarFormulario.qtdMoradores
            form.qtdHorasCasa = cadastrarFormulario.qtdHorasCasa
            form.possuiPet = cadastrarFormulario.possuiPet
            form.statusForms = cadastrarFormulario.statusForms
            formularioRepository.save(form)
            return ResponseEntity.status(201).body("Formulario Cadastrado")
        }
    }

    fun cadAnuncio(id:Int, cadastrarAnuncio: CadastroAnuncio): ResponseEntity<String> {

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