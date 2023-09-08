package pedepet.apiRest.controllers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.web.bind.annotation.*
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

    @Test1
    fun `class deve estar annotada com @CrossOrigin(http---localhost-3000')`() {
        val classe = UsuarioController::class.java
        val anotacao = classe.getAnnotation(CrossOrigin::class.java)

        assertNotNull(anotacao)

        val result = assertEquals("http://localhost:3000", anotacao.value[0])
        print("O parametro está presente? $result")
    }

    /*POST CADASTRAR COMPRADOR */

    @Test1
    fun `cadComprador() deve estar anotado com @PostMapping('cadastrar-comprador')`() {

        val metodo = CadastroController::cadUser
        val anotacao = metodo.annotations[0] as PostMapping

        val resultMetodo = assertNotNull(anotacao)
        val result = assertEquals("/cadastrar/comprador", anotacao.value[0])

        print("O método está: $resultMetodo e dentro tem o caminho? $result")
    }

    @Test1
    fun `Os parâmetros de cadComprador() devem estar anotados com @RequestBody`() {
        val metodo = CadastroController::cadUser

        val result = (metodo.parameters[1].hasAnnotation<RequestBody>())
        print("O parametro está presente? $result")
    }


    /* POST CADASTRAR VENDEDOR */


    @Test1
    fun `Os parâmetros de cadVendedor() devem estar anotados com @RequestBody`() {
        val metodo = CadastroController::cadUser

        val result = (metodo.parameters[1].hasAnnotation<RequestBody>())
        print("O parametro está presente? $result")
    }

    @Test
    fun `cadVendedor() deve estar anotado com @PostMapping('cadastrar-vendedor')`() {

        val metodo = CadastroController::cadUser
        val anotacao = metodo.annotations[0] as PostMapping

        val resultMetodo = assertNotNull(anotacao)
        val result = assertEquals("/cadastrar/vendedor", anotacao.value[0])

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
        val metodo = CadastroController::cadUser

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

   //GET TOTAL VENDEDORES

    @Test
    fun `buscarQtdVendedores() deve estar anotado com @GetMapping('-vendedor-total')`() {

        val metodo = UsuarioController::buscarQtdVendedores
        val anotacao = metodo.annotations[0] as GetMapping

        val resultMetodo = assertNotNull(anotacao)
        val result = assertEquals("/vendedor/total", anotacao.value[0])

        print("O método está: $resultMetodo e dentro tem o caminho? $result")
    }

   //GET TOTAL COMPRADORES
   @Test
   fun `buscarTotalUsuario() deve estar anotado com @GetMapping('-total')`() {

       val metodo = UsuarioController::buscarTotalUsuario
       val anotacao = metodo.annotations[0] as GetMapping

       val resultMetodo = assertNotNull(anotacao)
       val result = assertEquals("/total", anotacao.value[0])

       print("O método está: $resultMetodo e dentro tem o caminho? $result")
   }

}
