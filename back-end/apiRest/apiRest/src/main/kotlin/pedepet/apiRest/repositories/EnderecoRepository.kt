package pedepet.apiRest.repositories

import org.springframework.data.jpa.repository.JpaRepository
import pedepet.apiRest.models.Endereco

interface EnderecoRepository: JpaRepository<Endereco, Int> {
}