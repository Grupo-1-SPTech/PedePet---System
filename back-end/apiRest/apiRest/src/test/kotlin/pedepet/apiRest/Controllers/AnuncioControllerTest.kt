package pedepet.apiRest.Controllers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import pedepet.apiRest.controllers.AnuncioController
import pedepet.apiRest.controllers.FormularioController
import pedepet.apiRest.controllers.UsuarioController
import pedepet.apiRest.dto.AltDescricaoRequest
import pedepet.apiRest.models.AnuncioPet
import kotlin.reflect.full.hasAnnotation

class AnuncioControllerTest{

    @Test
    fun `classe deve estar anotada com @RestController`() {
        val classe = AnuncioController::class.java
        val result = assertTrue(classe.isAnnotationPresent(RestController::class.java))
        print("O parametro está presente? $result")
    }

    @Test
    fun `classe deve estar anotada com @RequestMapping('anuncios')`() {
        val classe = AnuncioController::class.java
        val anotacao = classe.getAnnotation(RequestMapping::class.java)

        assertNotNull(anotacao)

        val result = assertEquals("/anuncios", anotacao.value[0])
        print("O parametro está presente? $result")
    }

    @Test
    fun `class deve estar annotada com @CrossOrigin(http---localhost-3000')`() {
        val classe = AnuncioController::class.java
        val anotacao = classe.getAnnotation(CrossOrigin::class.java)

        assertNotNull(anotacao)

        val result = assertEquals("http://localhost:3000", anotacao.value[0])
        print("O parametro está presente? $result")
    }


    // PEGAR ANUNCIO POR ID
    @Test
    fun `buscarAnuncioPorId() deve estar anotado com @GetMapping('-{id}')`() {

        val metodo = AnuncioController::buscarAnuncioPorId
        val anotacao = metodo.annotations[0] as GetMapping

        val resultMetodo = assertNotNull(anotacao)
        val result = assertEquals("/{id}", anotacao.value[0])

        print("O método está: $resultMetodo e dentro tem o caminho? $result")
    }

    @Test
    fun `Os parâmetros de buscarAnuncioPorId() devem estar anotados com @PathVariable`() {
        val metodo = AnuncioController::buscarAnuncioPorId

        val resultPath = (metodo.parameters[1].hasAnnotation<PathVariable>())

        print("O parametro está presente @PathVariable? $resultPath")
    }

    // ALTERAR DESCRICAO
    @Test
    fun `atualizarDescricao() deve estar anotado com @PatchMapping('-alterarDescri-{id}')`() {

        val metodo = AnuncioController::atualizarDescricao
        val anotacao = metodo.annotations[0] as PatchMapping

        val resultMetodo = assertNotNull(anotacao)
        val result = assertEquals("/alterarDescri/{id}", anotacao.value[0])

        print("O método está: $resultMetodo e dentro tem o caminho? $result")
    }

    @Test
    fun `Os parâmetros de atualizarDescricao() devem estar anotados com @RequestBody`() {
        val metodo = AnuncioController::atualizarDescricao

        val result = (metodo.parameters[1].hasAnnotation<RequestBody>())
        print("O parametro está presente? $result")
    }


    // RACAS DISPONIVEIS

    @Test
    fun `buscarRacasDisponiveis() deve estar anotado com @GetMapping('-racasDiponiveis')`() {

        val metodo = AnuncioController::buscarRacasDisponiveis
        val anotacao = metodo.annotations[0] as GetMapping

        val resultMetodo = assertNotNull(anotacao)
        val result = assertEquals("/racasDiponiveis", anotacao.value[0])

        print("O método está: $resultMetodo e dentro tem o caminho? $result")
    }

    // FILTRO RAÇA

    @Test
    fun `buscarCachorroPorRaca() deve estar anotado com @GetMapping('-filtro-raca')`() {

        val metodo = AnuncioController::buscarCachorroPorRaca
        val anotacao = metodo.annotations[0] as GetMapping

        val resultMetodo = assertNotNull(anotacao)
        val result = assertEquals("/filtro/raca", anotacao.value[0])

        print("O método está: $resultMetodo e dentro tem o caminho? $result")
    }


}