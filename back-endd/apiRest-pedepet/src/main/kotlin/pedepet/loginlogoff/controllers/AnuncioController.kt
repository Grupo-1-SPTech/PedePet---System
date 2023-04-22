package pedepet.loginlogoff.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
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
        val anuncioExistente = anuncios.firstOrNull{ it.}

        return ResponseEntity.status(200).build()
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