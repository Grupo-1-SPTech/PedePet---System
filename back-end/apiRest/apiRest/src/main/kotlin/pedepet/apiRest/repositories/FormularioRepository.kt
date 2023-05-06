package pedepet.apiRest.repositories

import org.springframework.data.jpa.repository.JpaRepository
import pedepet.apiRest.models.Formulario

interface FormularioRepository: JpaRepository<Formulario, Int> {
}