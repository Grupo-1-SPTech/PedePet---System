package pedepet.apiRest.controllers

import org.springframework.web.bind.annotation.*
import pedepet.apiRest.models.DadosPagamento
import pedepet.apiRest.models.Endereco
import pedepet.apiRest.repositories.DadosPagamentoRepository

@RestController
@RequestMapping("/dados_pagamento")
@CrossOrigin("http://localhost:3000")
class DadosPagamentoController(
    val dadosPagamentoRepository: DadosPagamentoRepository
) {

    @GetMapping("{id}")
    fun buscarDadosPagamentoPorId(@PathVariable id:Int): DadosPagamento? {
        return dadosPagamentoRepository.findById(id).get()
    }
}