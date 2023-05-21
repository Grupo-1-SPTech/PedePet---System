package pedepet.apiRest.controllers

import org.springframework.web.bind.annotation.*
import pedepet.apiRest.models.DadosPagamento
import pedepet.apiRest.models.HistoricoVendas
import pedepet.apiRest.repositories.HistoricoVendasRepository

@RestController
@RequestMapping("/historico_vendas")
@CrossOrigin("http://localhost:3000")
class HistoricoVendasController(
    val historicoVendasRepository: HistoricoVendasRepository
) {

    @GetMapping("{id}")
    fun buscarHistoricoVendasPorId(@PathVariable id:Int): HistoricoVendas? {
        return historicoVendasRepository.findById(id).get()
    }

    /*
    @GetMapping
    fun ultimaVeda(): HistoricoVendas?{
        return historicoVendasRepository.buscasVendaMaisRecente()
    }
     */

}