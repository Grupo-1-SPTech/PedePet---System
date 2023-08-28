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

    // LISTAR TODOS OS ANÚNCIOS
    @GetMapping("/todos")
    fun listarTodosAnuncios(): ResponseEntity<List<AnuncioPet>> {
        val anuncios = anuncioRepository.findAll()
        return ResponseEntity.status(200).body(anuncios)
    }

    // CADASTRAR UM NOVO ANÚNCIO
    @PostMapping("/cadastrar")
    fun cadastrarAnuncio(@RequestBody novoAnuncio: AnuncioPet): ResponseEntity<AnuncioPet> {
        val anuncioSalvo = anuncioRepository.save(novoAnuncio)
        return ResponseEntity.status(201).body(anuncioSalvo)
    }

    // EXCLUIR UM ANÚNCIO PELO ID
    @DeleteMapping("/excluir/{id}")
    fun excluirAnuncio(@PathVariable id: Int): ResponseEntity<Unit> {
        if (anuncioRepository.existsById(id)) {
            anuncioRepository.deleteById(id)
            return ResponseEntity.noContent().build()
        }
        return ResponseEntity.notFound().build()
    }

}