package pedepet.apiRest.Models

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import pedepet.apiRest.models.AnuncioPet
import pedepet.apiRest.models.DadosPagamento
import javax.persistence.Entity
import javax.persistence.Table
import kotlin.reflect.full.findAnnotation

class DadosPagamentoTest {



    @Test
    fun `classe deve estar anotada com @Entity`() {
        val classe = DadosPagamento::class.java
        // Entity do pacote javax.persistence
        assertTrue(
            classe.isAnnotationPresent(Entity::class.java))
    }

    @Test
    fun `classe deve estar anotada com @Table(name = 'dados-pagamento')`() {
        val classe = DadosPagamento::class.java
        // Entity do pacote javax.persistence

        val anotacao = DadosPagamento::class.findAnnotation<Table>()

        assertNotNull(anotacao)
        assertEquals("dados-pagamento", anotacao?.name)
        // assertTrue(
        //    classe.isAnnotationPresent(Table::class.java))
    }
}


