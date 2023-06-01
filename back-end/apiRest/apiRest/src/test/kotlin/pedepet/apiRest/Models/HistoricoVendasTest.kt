package pedepet.apiRest.Models

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import pedepet.apiRest.models.Endereco
import pedepet.apiRest.models.HistoricoVendas
import javax.persistence.Entity
import javax.persistence.Table
import kotlin.reflect.full.findAnnotation

class HistoricoVendasTest{



    @Test
    fun `classe deve estar anotada com @Entity`() {
        val classe = HistoricoVendas::class.java
        // Entity do pacote javax.persistence
        assertTrue(
            classe.isAnnotationPresent(Entity::class.java))
    }

    @Test
    fun `classe deve estar anotada com @Table(name = 'historico-vendas')`() {
        val classe = HistoricoVendas::class.java
        // Entity do pacote javax.persistence

        val anotacao = HistoricoVendas::class.findAnnotation<Table>()

        assertNotNull(anotacao)
        assertEquals("historico-vendas", anotacao?.name)
        // assertTrue(
        //    classe.isAnnotationPresent(Table::class.java))
    }
}