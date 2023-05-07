package pedepet.apiRest.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pedepet.apiRest.models.Usuario
import java.util.*

@Repository
interface UsuarioRepository: JpaRepository<Usuario, Int> {

    fun findByEmailAndTipoUsuario(email: String?, tipoUsuario:Int? = 1): Usuario?

    fun findByEmailContainsAndAutenticadoTrue(email: String): List<Usuario>
    
    fun findByEmail(email: String?): Optional<Usuario>




}