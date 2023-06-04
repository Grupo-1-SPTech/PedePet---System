package pedepet.apiRest.Models

import org.hibernate.mapping.Formula
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import pedepet.apiRest.models.Endereco
import pedepet.apiRest.models.Formulario
import javax.persistence.Entity
import javax.persistence.Table
import kotlin.reflect.full.findAnnotation

class FormularioTest{


    @Test
    fun `classe deve estar anotada com @Entity`() {
        val classe = Formulario::class.java
        // Entity do pacote javax.persistence
        assertTrue(
            classe.isAnnotationPresent(Entity::class.java))
    }

    @Test
    fun `classe deve estar anotada com @Table(name = 'formulario')`() {
        val classe = Formulario::class.java
        // Entity do pacote javax.persistence

        val anotacao = Formulario::class.findAnnotation<Table>()

        assertNotNull(anotacao)
        assertEquals("formulario", anotacao?.name)
        // assertTrue(
        //    classe.isAnnotationPresent(Table::class.java))
    }
}