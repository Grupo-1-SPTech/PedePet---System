package pedepet.apiRest.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import pedepet.apiRest.dto.AltDescricaoRequest
import pedepet.apiRest.models.AnuncioPet
import pedepet.apiRest.repositories.AnuncioRepository
import pedepet.apiRest.repositories.UsuarioRepository


@RestController
@RequestMapping("/anuncios")
class AnuncioController(
    val anuncioRepository: AnuncioRepository,
    val usuarioRepository: UsuarioRepository
) {

    @PatchMapping("/alterarDescri/{id}")
    fun atualizarDescricao(@RequestBody alterarDescricao: AltDescricaoRequest): ResponseEntity<AnuncioPet?> {

        val anuncio: AnuncioPet =
            anuncioRepository.findById(alterarDescricao.id).get()
        anuncio.descricao = alterarDescricao.descricao
        return ResponseEntity.status(200).body(anuncioRepository.save(anuncio))
    }

}