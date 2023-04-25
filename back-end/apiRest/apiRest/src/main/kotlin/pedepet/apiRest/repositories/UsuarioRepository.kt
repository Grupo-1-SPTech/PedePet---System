package pedepet.apiRest.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pedepet.apiRest.models.Usuario

@Repository
interface UsuarioRepository: JpaRepository<Usuario, Int> {

    fun findByTipoUsuario(tipoUsuario:Int): List<Usuario>

    // fun findByInteresse(interesse:Int): List<Usuario>

    //fun findByEmailIgnoreCaseContains(email: String):List<Usuario>

    fun findByEmailContainsAndAutenticadoTrue(email: String): List<Usuario>

    fun findByPreferenciaRaca(preferenciaRaca:Int): List<Usuario>

    fun findByPretendeEsperar(pretendeEsperar:Int): List<Usuario>

    fun findByQtdComodosGreaterThanOrderByNome(QtdComodos: Int): List<Usuario>

    //fun deleteByEmail(email:String): List<Usuario>

    //fun existsByEmail(email: String): List<Usuario>

    //fun findByEmail(email: String): List<Usuario>


}