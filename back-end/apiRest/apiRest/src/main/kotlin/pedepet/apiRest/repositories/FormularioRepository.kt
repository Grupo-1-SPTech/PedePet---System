package pedepet.apiRest.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.web.bind.annotation.CrossOrigin
import pedepet.apiRest.models.Formulario

@CrossOrigin("http://localhost:3000")
interface FormularioRepository: JpaRepository<Formulario, Int> {
}