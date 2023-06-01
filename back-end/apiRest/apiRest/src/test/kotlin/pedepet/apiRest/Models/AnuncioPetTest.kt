package pedepet.apiRest.Models

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import pedepet.apiRest.models.AnuncioPet
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import kotlin.reflect.full.findAnnotation

class AnuncioPetTest{

    @Test
    fun `classe deve estar anotada com @Entity`() {
        val classe = AnuncioPet::class.java
        // Entity do pacote javax.persistence
        assertTrue(
            classe.isAnnotationPresent(Entity::class.java))
    }

    @Test
    fun `classe deve estar anotada com @Table(name = 'ninhada')`() {
        val classe = AnuncioPet::class.java
        // Entity do pacote javax.persistence

        val anotacao = AnuncioPet::class.findAnnotation<Table>()

        assertNotNull(anotacao)
        assertEquals("ninhada", anotacao?.name)
       // assertTrue(
        //    classe.isAnnotationPresent(Table::class.java))
    }


     
    }

