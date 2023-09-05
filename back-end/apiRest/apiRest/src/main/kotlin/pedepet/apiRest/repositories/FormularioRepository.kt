package pedepet.apiRest.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.web.bind.annotation.CrossOrigin
import pedepet.apiRest.models.Endereco
import pedepet.apiRest.models.Formulario
import java.util.Optional

@CrossOrigin("http://localhost:3000")
@RepositoryRestResource(path = "formularios")
interface FormularioRepository: JpaRepository<Formulario, Int> {

    fun findByUsuarioId(id: Int): Formulario?
}