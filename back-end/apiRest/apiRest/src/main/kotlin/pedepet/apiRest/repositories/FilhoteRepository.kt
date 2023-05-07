package pedepet.apiRest.repositories

import org.springframework.data.jpa.repository.JpaRepository
import pedepet.apiRest.models.Filhote

interface FilhoteRepository: JpaRepository<Filhote, Int> {
}