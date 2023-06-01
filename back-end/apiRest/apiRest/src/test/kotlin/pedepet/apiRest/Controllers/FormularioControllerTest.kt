package pedepet.apiRest.Controllers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.web.bind.annotation.*
import pedepet.apiRest.controllers.FormularioController
import pedepet.apiRest.controllers.HistoricoVendasController
import pedepet.apiRest.controllers.UsuarioController
import kotlin.reflect.full.hasAnnotation

class FormularioControllerTest{

    @Test
    fun `classe deve estar anotada com @RestController`() {
        val classe = FormularioController::class.java
        val result = assertTrue(classe.isAnnotationPresent(RestController::class.java))
        print("O parametro está presente? $result")
    }

    @Test
    fun `classe deve estar anotada com @RequestMapping('formularios')`() {
        val classe = FormularioController::class.java
        val anotacao = classe.getAnnotation(RequestMapping::class.java)

        assertNotNull(anotacao)

        val result = assertEquals("/formularios", anotacao.value[0])
        print("O parametro está presente? $result")
    }

    @Test
    fun `class deve estar annotada com @CrossOrigin(http---localhost-3000')`() {
        val classe = FormularioController::class.java
        val anotacao = classe.getAnnotation(CrossOrigin::class.java)

        assertNotNull(anotacao)

        val result = assertEquals("http://localhost:3000", anotacao.value[0])
        print("O parametro está presente? $result")
    }

//GET BUSCAR FORMULARIO POR ID

    @Test
    fun `buscarFormularioPorId() deve estar anotado com @GetMapping('-{id}')`() {

        val metodo = FormularioController::buscarFormularioPorId
        val anotacao = metodo.annotations[0] as GetMapping

        val resultMetodo = assertNotNull(anotacao)
        val result = assertEquals("/{id}", anotacao.value[0])

        print("O método está: $resultMetodo e dentro tem o caminho? $result")
    }

    @Test
    fun `Os parâmetros de buscarFormularioPorId() devem estar anotados com @PathVariable`() {
        val metodo = FormularioController::buscarFormularioPorId

        val resultPath = (metodo.parameters[1].hasAnnotation<PathVariable>())

        print("O parametro está presente @PathVariable? $resultPath")
    }

}