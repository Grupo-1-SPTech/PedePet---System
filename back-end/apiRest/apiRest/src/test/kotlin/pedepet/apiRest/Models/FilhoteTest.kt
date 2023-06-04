package pedepet.apiRest.Models

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import pedepet.apiRest.models.Endereco
import pedepet.apiRest.models.Filhote
import javax.persistence.Entity
import javax.persistence.Table
import kotlin.reflect.full.findAnnotation

class FilhoteTest {

    @Test
    fun `classe deve estar anotada com @Entity`() {
        val classe = Filhote::class.java
        // Entity do pacote javax.persistence
        assertTrue(
            classe.isAnnotationPresent(Entity::class.java))
    }

    @Test
    fun `classe deve estar anotada com @Table(name = 'filhote')`() {
        val classe = Filhote::class.java
        // Entity do pacote javax.persistence

        val anotacao = Filhote::class.findAnnotation<Table>()

        assertNotNull(anotacao)
        assertEquals("filhote", anotacao?.name)
        // assertTrue(
        //    classe.isAnnotationPresent(Table::class.java))
    }

}