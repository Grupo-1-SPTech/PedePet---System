package pedepet.apiRest.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import pedepet.apiRest.models.DadosPagamento
import pedepet.apiRest.models.Endereco
import pedepet.apiRest.repositories.DadosPagamentoRepository

@RestController
@RequestMapping("/dados_pagamento")
@CrossOrigin("http://localhost:3000")
class DadosPagamentoController(
    val dadosPagamentoRepository: DadosPagamentoRepository
) {

    // teste
    @GetMapping("{id}")
    fun buscarDadosPagamentoPorId(@PathVariable id:Int): DadosPagamento? {
        if (dadosPagamentoRepository.existsById(id)){
            return dadosPagamentoRepository.findById(id).get()
        }
        throw ResponseStatusException(
            HttpStatus.NOT_FOUND, "Id não encontrado")
    }
}