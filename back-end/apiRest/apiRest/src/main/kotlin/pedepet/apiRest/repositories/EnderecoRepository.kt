package pedepet.apiRest.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.web.bind.annotation.CrossOrigin
import pedepet.apiRest.models.Endereco

@CrossOrigin("http://localhost:3000")
@RepositoryRestResource(path = "enderecos")
interface EnderecoRepository: JpaRepository<Endereco, Int> {
}