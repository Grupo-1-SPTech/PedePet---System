package pedepet.loginlogoff.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pedepet.loginlogoff.models.Pipefy

@Repository
interface PipefyRepository: JpaRepository<Pipefy, Int> {
}