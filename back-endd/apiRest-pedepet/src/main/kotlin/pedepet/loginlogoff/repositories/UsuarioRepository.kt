package pedepet.loginlogoff.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pedepet.loginlogoff.models.Usuario

@Repository
interface UsuarioRepository: JpaRepository<Usuario, Int> {

    fun findByTipoUsuario(tipoUsuario:Int): List<Usuario>

    fun findByInteresse(interesse:Int): List<Usuario>

    fun findByPreferenciaRaca(preferenciaRaca:Int): List<Usuario>

    fun findByPretendeEsperar(pretendeEsperar:Int): List<Usuario>

    fun findByQtdComodosGreaterThanOrderByNome(tipoUsuario:Int): List<Usuario>

    fun deleteByEmail(email:String): List<Usuario>

}