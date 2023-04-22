package pedepet.loginlogoff.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import pedepet.loginlogoff.dtos.AnuncioRequest
import pedepet.loginlogoff.dtos.UsuarioRequest
import pedepet.loginlogoff.models.AnuncioPet
import pedepet.loginlogoff.repositories.AnuncioPetRepository
import pedepet.loginlogoff.repositories.UsuarioRepository
import javax.validation.Valid

@RestController
@RequestMapping("/anuncios")
class AnuncioController(
    val usuarioRepository: UsuarioRepository,
    val anuncioPetRepository: AnuncioPetRepository
) {

    val anuncios = mutableListOf<AnuncioPet>()

    @PostMapping("/cadastrar")
    fun postCadastrarA(@RequestBody @Valid novoAnuncio:AnuncioPet):ResponseEntity<AnuncioRequest>{
        val anuncioExistente = anuncios.firstOrNull{it.fkVendedorUsuario == novoAnuncio.fkVendedorUsuario && it.racaMae == novoAnuncio.racaMae && it.racaPai == novoAnuncio.racaPai}

        if(anuncioExistente != null){
            throw ResponseStatusException(409,"Esse anúncio já existe no sistema",null)
        }
        anuncios.add(novoAnuncio)
        val novoAnuncioDto = AnuncioRequest(novoAnuncio)
        return ResponseEntity.status(201).body(novoAnuncioDto)
    }

    @GetMapping
    fun getAnuncio():ResponseEntity<List<AnuncioRequest>>{
        val listaAnuncio = anuncios.map { AnuncioRequest(it) }
        if(listaAnuncio.isNotEmpty()){
            return ResponseEntity.status(200).body(listaAnuncio)
        }
        return ResponseEntity.status(204).build()
    }

}