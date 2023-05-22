package pedepet.apiRest.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.web.bind.annotation.CrossOrigin
import pedepet.apiRest.models.HistoricoVendas
import java.util.Date

@CrossOrigin("http://localhost:3000")
@RepositoryRestResource(path = "historico_vendas")
interface HistoricoVendasRepository: JpaRepository<HistoricoVendas, Int> {

/*
    // buscas ultima venda
    @Query("""
        SELECT
        v FROM historico_venda v ORDER BY v.dataVenda DESC
    """)
    @RestResource(exported = false)
    fun buscasVendaMaisRecente():HistoricoVendas?
*/



}