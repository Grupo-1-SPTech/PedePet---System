package pedepet.apiRest.Models

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import pedepet.apiRest.models.Endereco
import pedepet.apiRest.models.Usuario
import javax.persistence.Entity
import javax.persistence.Table
import kotlin.reflect.full.findAnnotation

class UsuarioTest {


    @Test
    fun `classe deve estar anotada com @Entity`() {
        val classe = Usuario::class.java
        // Entity do pacote javax.persistence
        assertTrue(
            classe.isAnnotationPresent(Entity::class.java))
    }

    @Test
    fun `classe deve estar anotada com @Table(name = 'usuario')`() {
        val classe = Usuario::class.java
        // Entity do pacote javax.persistence

        val anotacao = Usuario::class.findAnnotation<Table>()

        assertNotNull(anotacao)
        assertEquals("usuario", anotacao?.name)
        // assertTrue(
        //    classe.isAnnotationPresent(Table::class.java))
    }
}