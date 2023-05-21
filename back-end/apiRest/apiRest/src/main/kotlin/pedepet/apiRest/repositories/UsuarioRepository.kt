package pedepet.apiRest.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.CrossOrigin
import pedepet.apiRest.models.Usuario
import java.util.*

@Repository
@CrossOrigin("http://localhost:3000")
interface UsuarioRepository: JpaRepository<Usuario, Int> {

    fun findByEmailAndTipoUsuario(email: String?, tipoUsuario:Int? = 1): Usuario?

    fun findByEmailContainsAndAutenticadoTrue(email: String): List<Usuario>
    
    fun findByEmail(email: String?): Optional<Usuario>




}