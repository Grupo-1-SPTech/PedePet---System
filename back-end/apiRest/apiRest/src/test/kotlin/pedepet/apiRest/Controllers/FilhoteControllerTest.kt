package pedepet.apiRest.Controllers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.web.bind.annotation.*
import pedepet.apiRest.controllers.FilhoteController
import pedepet.apiRest.controllers.HistoricoVendasController
import pedepet.apiRest.controllers.UsuarioController
import kotlin.reflect.full.hasAnnotation

class FilhoteControllerTest{


    @Test
    fun `classe deve estar anotada com @RestController`() {
        val classe = FilhoteController::class.java
        val result = assertTrue(classe.isAnnotationPresent(RestController::class.java))
        print("O parametro está presente? $result")
    }

    @Test
    fun `classe deve estar anotada com @RequestMapping('-filhotes')`() {
        val classe = FilhoteController::class.java
        val anotacao = classe.getAnnotation(RequestMapping::class.java)

        assertNotNull(anotacao)

        val result = assertEquals("/filhotes", anotacao.value[0])
        print("O parametro está presente? $result")
    }

    @Test
    fun `class deve estar annotada com @CrossOrigin(http---localhost-3000')`() {
        val classe = FilhoteController::class.java
        val anotacao = classe.getAnnotation(CrossOrigin::class.java)

        assertNotNull(anotacao)

        val result = assertEquals("http://localhost:3000", anotacao.value[0])
        print("O parametro está presente? $result")
    }

    // GET PEGAR FILHOTES POR ID

    @Test
    fun `buscarFilhotePorId() deve estar anotado com @GetMapping('-{id}')`() {

        val metodo = FilhoteController::buscarFilhotePorId
        val anotacao = metodo.annotations[0] as GetMapping

        val resultMetodo = assertNotNull(anotacao)
        val result = assertEquals("/{id}", anotacao.value[0])

        print("O método está: $resultMetodo e dentro tem o caminho? $result")
    }

    @Test
    fun `Os parâmetros de buscarFilhotePorId() devem estar anotados com @PathVariable`() {
        val metodo = FilhoteController::buscarFilhotePorId

        val resultPath = (metodo.parameters[1].hasAnnotation<PathVariable>())

        print("O parametro está presente @PathVariable? $resultPath")
    }

    // GET TOTAL FILHOTES ADQUIRIDOS

    @Test
    fun `buscarFilhotesAdquiridos() deve estar anotado com @GetMapping('-adquiridos')`() {

        val metodo = FilhoteController::buscarFilhotesAdquiridos
        val anotacao = metodo.annotations[0] as GetMapping

        val resultMetodo = assertNotNull(anotacao)
        val result = assertEquals("/adquiridos", anotacao.value[0])

        print("O método está: $resultMetodo e dentro tem o caminho? $result")
    }

}