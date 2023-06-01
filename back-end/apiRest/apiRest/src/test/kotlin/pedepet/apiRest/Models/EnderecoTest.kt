package pedepet.apiRest.Models

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import pedepet.apiRest.models.DadosPagamento
import pedepet.apiRest.models.Endereco
import javax.persistence.Entity
import javax.persistence.Table
import kotlin.reflect.full.findAnnotation

class EnderecoTest{


    @Test
    fun `classe deve estar anotada com @Entity`() {
        val classe = Endereco::class.java
        // Entity do pacote javax.persistence
        assertTrue(
            classe.isAnnotationPresent(Entity::class.java))
    }

    @Test
    fun `classe deve estar anotada com @Table(name = 'endereco')`() {
        val classe = Endereco::class.java
        // Entity do pacote javax.persistence

        val anotacao = Endereco::class.findAnnotation<Table>()

        assertNotNull(anotacao)
        assertEquals("endereco", anotacao?.name)
        // assertTrue(
        //    classe.isAnnotationPresent(Table::class.java))
    }
}