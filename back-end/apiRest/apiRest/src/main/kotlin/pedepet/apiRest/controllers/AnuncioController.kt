package pedepet.apiRest.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import pedepet.apiRest.dto.AddAnuncioRequest
import pedepet.apiRest.dto.AltDescricaoRequest
import pedepet.apiRest.models.AnuncioPet
import pedepet.apiRest.repositories.AnuncioRepository
import pedepet.apiRest.repositories.UsuarioRepository


@RestController
@RequestMapping("/anuncios")
@CrossOrigin("http://localhost:3000")
class AnuncioController(
    val anuncioRepository: AnuncioRepository,
    val usuarioRepository: UsuarioRepository
) {

    // PEGAR ANUNCIO POR ID
    @GetMapping("{id}")
    fun buscarAnuncioPorId(@PathVariable id:Int): AnuncioPet? {
        return anuncioRepository.findById(id).get()
    }

    // ALTERAR DESCRICAO
    @PatchMapping("/alterarDescri/{id}")
    fun atualizarDescricao(@RequestBody alterarDescricao: AltDescricaoRequest): ResponseEntity<AnuncioPet?> {

        val anuncio: AnuncioPet =
            anuncioRepository.findById(alterarDescricao.id).get()
        anuncio.descricao = alterarDescricao.descricao
        return ResponseEntity.status(200).body(anuncioRepository.save(anuncio))
    }

    // RACAS DISPONIVEIS
    @GetMapping("/racasDiponiveis")
    fun buscarRacasDisponiveis():ResponseEntity<List<AnuncioPet?>>{
        val racas = anuncioRepository.buscarRacas()

        if(racas.isNotEmpty()){
            return ResponseEntity.status(200).body(racas)
        }
        return ResponseEntity.status(204).build()
    }

}