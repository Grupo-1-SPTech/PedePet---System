package pedepet.apiRest.controllers

import net.bytebuddy.matcher.ElementMatchers.any
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.HttpStatus
import org.springframework.test.web.servlet.MockMvc
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.HttpStatusCodeException
import pedepet.apiRest.dto.CompradorRequest
import pedepet.apiRest.models.Usuario
import pedepet.apiRest.repositories.*
import kotlin.reflect.full.hasAnnotation
import org.junit.jupiter.api.Test as Test1


class UsuarioControllerTest {


    @Test1
    fun `classe deve estar anotada com @RestController`() {
        val classe = UsuarioController::class.java
        val result = assertTrue(classe.isAnnotationPresent(RestController::class.java))
        print("O parametro está presente? $result")
    }

    @Test1
    fun `classe deve estar anotada com @RequestMapping('usuarios')`() {
        val classe = UsuarioController::class.java

        val anotacao = classe.getAnnotation(RequestMapping::class.java)

        assertNotNull(anotacao)

        val result = assertEquals("/usuarios", anotacao.value[0])
        print("O parametro está presente? $result")
    }


    /*POST CADASTRAR COMPRADOR */

    @Test1
    fun `cadComprador() deve estar anotado com @PostMapping('cadastrar-comprador')`() {

        val metodo = UsuarioController::cadComprador

        val anotacao = metodo.annotations[0] as PostMapping

        val resultMetodo = assertNotNull(anotacao)

        val result = assertEquals("cadastrar/comprador", anotacao.value[0])

        print("O método está: $resultMetodo e dentro tem o caminho? $result")
    }

    @Test1
    fun `Os parâmetros de cadComprador() devem estar anotados com @RequestBody`() {
        val metodo = UsuarioController::cadComprador

        val result = (metodo.parameters[1].hasAnnotation<RequestBody>())
        print("O parametro está presente? $result")
    }




    /* POST CADASTRAR VENDEDOR */


    @Test1
    fun `Os parâmetros de cadVendedor() devem estar anotados com @RequestBody`() {
        val metodo = UsuarioController::cadVendedor

        val result = (metodo.parameters[1].hasAnnotation<RequestBody>())
        print("O parametro está presente? $result")
    }

    @Test
    fun `cadVendedor() deve estar anotado com @PostMapping('cadastrar-vendedor')`() {

        val metodo = UsuarioController::cadVendedor

        val anotacao = metodo.annotations[0] as PostMapping

        val resultMetodo = assertNotNull(anotacao)

        val result = assertEquals("cadastrar/vendedor", anotacao.value[0])

        print("O método está: $resultMetodo e dentro tem o caminho? $result")
    }


    /*PATCH ALTERAR SENHA*/

    @Test

    fun `alterarsenha() deve estar anotado com @PatchMapping('-alterarSenha-{email}')`() {

        val metodo = UsuarioController::alterarSenha

        val anotacao = metodo.annotations[0] as PatchMapping

        val resultMetodo = assertNotNull(anotacao)

        val result = assertEquals("/alterarSenha/{email}", anotacao.value[0])

        print("O método está: $resultMetodo e dentro tem o caminho? $result")
    }

    @Test1
    fun `Os parâmetros de alterarsenha() devem estar anotados com @RequestBody`() {
        val metodo = UsuarioController::cadComprador

        val result = (metodo.parameters[1].hasAnnotation<RequestBody>())
        print("O parametro está presente? $result")
    }


    /*POST LOGIN*/

    @Test

    fun `logar() deve estar anotado com @PostMapping('-login')`() {

        val metodo = UsuarioController::logar

        val anotacao = metodo.annotations[0] as PostMapping

        val resultMetodo = assertNotNull(anotacao)

        val result = assertEquals("/login", anotacao.value[0])

        print("O método está: $resultMetodo e dentro tem o caminho? $result")
    }

    @Test1
    fun `Os parâmetros de logar() devem estar anotados com @RequestBody`() {
        val metodo = UsuarioController::logar

        val result = (metodo.parameters[1].hasAnnotation<RequestBody>())
        print("O parametro está presente? $result")
    }


    /*POST LOGOFF*/

    @Test
    fun `deslogar() deve estar anotado com @DeleteMapping('-logoff-{id}')`() {

        val metodo = UsuarioController::deslogar

        val anotacao = metodo.annotations[0] as DeleteMapping

        val resultMetodo = assertNotNull(anotacao)

        val result = assertEquals("/logoff/{id}", anotacao.value[0])

        print("O método está: $resultMetodo e dentro tem o caminho? $result")
    }

    @Test1
    fun `Os parâmetros de deslogar() devem estar anotados com @PathVariable`() {
        val metodo = UsuarioController::deslogar

        val resultPath = (metodo.parameters[1].hasAnnotation<PathVariable>())

        print("O parametro está presente @PathVariable? $resultPath")
    }
}
