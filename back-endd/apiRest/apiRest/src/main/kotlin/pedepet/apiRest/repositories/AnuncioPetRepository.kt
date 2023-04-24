package pedepet.apiRest.repositories

import org.springframework.data.jpa.repository.JpaRepository
import pedepet.apiRest.models.AnuncioPet

interface AnuncioPetRepository: JpaRepository<AnuncioPet, Int> {
}