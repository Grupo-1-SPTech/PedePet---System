package pedepet.loginlogoff.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import pedepet.loginlogoff.dtos.AnuncioRequest
import pedepet.loginlogoff.dtos.DescriAnuncioRequest
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
    fun cadastrarAnuncio(@RequestBody @Valid novoAnuncio:AnuncioPet):ResponseEntity<AnuncioRequest>{
        val anuncioExistente = anuncios.firstOrNull{it.racaMae == novoAnuncio.racaMae && it.racaPai == novoAnuncio.racaPai}

        if(anuncioExistente != null){
            throw ResponseStatusException(409,"Esse anúncio já existe no sistema",null)
        }
        anuncios.add(novoAnuncio)
        val novoAnuncioDto = AnuncioRequest(novoAnuncio)
        return ResponseEntity.status(201).body(novoAnuncioDto)
    }
/*
CADASTRO COM FK
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
*/
    @GetMapping
    fun getAnuncio():ResponseEntity<List<AnuncioRequest>>{
        val listaAnuncio = anuncios.map { AnuncioRequest(it) }
        if(listaAnuncio.isNotEmpty()){
            return ResponseEntity.status(200).body(listaAnuncio)
        }
        return ResponseEntity.status(204).build()
    }

    @PatchMapping("alterarDescri/{id}")
    fun alterarDescri(@PathVariable id:Int, @RequestBody novaDescri:DescriAnuncioRequest):ResponseEntity<Void>{
        val encontrado = anuncios.firstOrNull { it.id == id }

        if(encontrado == null){
           throw ResponseStatusException(404,"Anuncio não existe",null)
        }else {
            encontrado.descricao = novaDescri.descricao
            return ResponseEntity.status(200).build()
        }
    }

    @DeleteMapping("/deletar/{id}")
    fun deletarAnuncio (@PathVariable id:Int):ResponseEntity<Void>{
        val encontrado = anuncios.firstOrNull { it.id == id }
        if(encontrado != null) {
            anuncioPetRepository.deleteById(id)
            return ResponseEntity.status(200).build()
        } else {
            throw ResponseStatusException(400,"Esse anuncio não esta registrado",null)
        }
    }


}