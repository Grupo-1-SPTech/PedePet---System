package pedepet.apiRest.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.data.rest.core.annotation.RestResource
import org.springframework.web.bind.annotation.CrossOrigin
import pedepet.apiRest.models.Filhote

@CrossOrigin("http://localhost:3000")
@RepositoryRestResource(path = "filhotes")
interface FilhoteRepository: JpaRepository<Filhote, Int> {

    @Query("""
        SELECT COUNT(f) FROM Filhote f WHERE f.disponivel = FALSE
    """)
    @RestResource(exported = true)
    fun countFilhotesAdquiridos():Long


}