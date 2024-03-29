package pedepet.apiRest.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import pedepet.apiRest.dto.AddAnuncioRequest
import pedepet.apiRest.dto.AltDescricaoRequest
import pedepet.apiRest.models.AnuncioPet
import pedepet.apiRest.models.Filhote
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
    @GetMapping("/{id}")
    fun buscarAnuncioPorId(@PathVariable id:Int): AnuncioPet? {
        return anuncioRepository.findById(id).get()
    }

    @GetMapping("/total")
    fun getTotalAnuncios():ResponseEntity<List<AnuncioPet>>{
        val anuncioPet = anuncioRepository.getTodosAnuncios()
        return if (anuncioPet.isNotEmpty()) {
            ResponseEntity.status(200).body(anuncioPet)
        } else {
            ResponseEntity.status(404).build()
        }
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
    fun buscarRacasDisponiveis():ResponseEntity<Long>{
        val qtdRacas = anuncioRepository.countDistinctRacas()
        return ResponseEntity.status(200).body(qtdRacas)
    }

    // FILTRO RAÇA
    @GetMapping("/filtro/raca")
    fun buscarCachorroPorRaca():ResponseEntity<List<AnuncioPet?>>{
        val racas = anuncioRepository.findByRacaMae()

        if(racas.isNotEmpty()){
            return ResponseEntity.status(200).body(racas)
        }
        return ResponseEntity.status(204).build()
    }

    // FILTRO PORTE
    @GetMapping("filtro/porte")
    fun buscarCachorroPorPorte():ResponseEntity<List<AnuncioPet?>>{
        val portes = anuncioRepository.findByPorte()

        if(portes.isNotEmpty()) {
            return ResponseEntity.status(200).body(portes)
        }
        return ResponseEntity.status(204).build()
    }

    // VALOR POR ID
    @GetMapping("/{id}/valor")
    fun buscarValorAnuncioPorId(@PathVariable id: Int): ResponseEntity<Double?> {
        val valor = anuncioRepository.findValorById(id)
        return ResponseEntity.ok(valor)
    }

    // TEMPO PARA NASCER POR ID
    @GetMapping("/{id}/tempo")
    fun buscarTempoAnuncioPorId(@PathVariable id: Int): ResponseEntity<Int?> {
        val tempo = anuncioRepository.findTempoById(id)
        return ResponseEntity.ok(tempo)
    }

    // DESCRICAO POR ID
    @GetMapping("/{id}/descricao")
    fun buscarDescricaoAnuncioPorId(@PathVariable id: Int): ResponseEntity<String?> {
        val descricao = anuncioRepository.findDescricaoById(id)
        return ResponseEntity.ok(descricao)
    }

    // RAÇA POR ID
    @GetMapping("/{racaMae}/raca-mae")
    fun buscarRacaMae(@PathVariable racaMae: String): ResponseEntity<String?> {
        val racaMae = anuncioRepository.findRacaMae(racaMae)
        return ResponseEntity.ok(racaMae?.firstOrNull())
    }

    // QUANT FILHOTES DISPONÍVEIS POR ID
  @GetMapping("/{id}/quantidade-filhotes-disponiveis")
    fun buscarQuantidadeFilhotesDisponiveisPorId(@PathVariable id: Int): ResponseEntity<Long> {
        val quantidade = anuncioRepository.findQuantidadeFilhotesDisponiveisById(id)
        return ResponseEntity.ok(quantidade)
    }



}