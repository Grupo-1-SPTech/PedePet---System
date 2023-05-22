package pedepet.apiRest.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.data.rest.core.annotation.RestResource
import org.springframework.web.bind.annotation.CrossOrigin
import pedepet.apiRest.models.AnuncioPet

@CrossOrigin("http://localhost:3000")
@RepositoryRestResource(path = "ninhadas")
interface AnuncioRepository: JpaRepository<AnuncioPet, Int> {

    fun findByIdAndQtdFilhotes(id:Int, qtdFilhotes:Int):AnuncioPet?

    @Query("""
        SELECT 
        COUNT(DISTINCT c.racaMae) FROM AnuncioPet c
    """)
    @RestResource(exported = true)
    fun findAllDistinctRacas():List<AnuncioPet>

    @Query("""
        SELECT c FROM AnuncioPet c WHERE c.racaMae = :racaMae
    """)
    @RestResource(exported = true)
    fun findByRacaMae():List<AnuncioPet?>
}