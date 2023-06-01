package pedepet.apiRest.Controllers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.web.bind.annotation.*
import pedepet.apiRest.controllers.DadosPagamentoController
import pedepet.apiRest.controllers.EnderecoController
import kotlin.reflect.full.hasAnnotation

class DadosPagamentoControllerTest{


    @Test
    fun `classe deve estar anotada com @RestController`() {
        val classe = DadosPagamentoController::class.java
        val result = assertTrue(classe.isAnnotationPresent(RestController::class.java))
        print("O parametro está presente? $result")
    }

    @Test
    fun `classe deve estar anotada com @RequestMapping('-dados_pagamento')`() {
        val classe = DadosPagamentoController::class.java
        val anotacao = classe.getAnnotation(RequestMapping::class.java)

        assertNotNull(anotacao)

        val result = assertEquals("/dados_pagamento", anotacao.value[0])
        print("O parametro está presente? $result")
    }

    @Test
    fun `class deve estar annotada com @CrossOrigin(http---localhost-3000')`() {
        val classe =    DadosPagamentoController::class.java
        val anotacao = classe.getAnnotation(CrossOrigin::class.java)

        assertNotNull(anotacao)

        val result = assertEquals("http://localhost:3000", anotacao.value[0])
        print("O parametro está presente? $result")
    }

    // GET BUSCAR PAGAMENTO POR ID

    @Test
    fun `buscarDadosPagamentoPorId() deve estar anotado com @GetMapping('-{id}')`() {

        val metodo =DadosPagamentoController::buscarDadosPagamentoPorId
        val anotacao = metodo.annotations[0] as GetMapping

        val resultMetodo = assertNotNull(anotacao)
        val result = assertEquals("/{id}", anotacao.value[0])

        print("O método está: $resultMetodo e dentro tem o caminho? $result")
    }

    @Test
    fun `Os parâmetros de buscarDadosPagamentoPorId() devem estar anotados com @PathVariable`() {
        val metodo = DadosPagamentoController::buscarDadosPagamentoPorId

        val resultPath = (metodo.parameters[1].hasAnnotation<PathVariable>())

        print("O parametro está presente @PathVariable? $resultPath")



    }

}