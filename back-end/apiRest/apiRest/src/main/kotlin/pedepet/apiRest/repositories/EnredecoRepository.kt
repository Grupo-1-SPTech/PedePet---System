package pedepet.apiRest.repositories

import org.springframework.data.jpa.repository.JpaRepository
import pedepet.apiRest.models.Endereco

interface EnredecoRepository: JpaRepository<Endereco, Int> {
}