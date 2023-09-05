package pedepet.apiRest.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.data.rest.core.annotation.RestResource
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.CrossOrigin
import pedepet.apiRest.models.Filhote
import pedepet.apiRest.models.Usuario
import java.util.*

@Repository
@CrossOrigin("http://localhost:3000")
@RepositoryRestResource(path = "usuarios")
interface UsuarioRepository: JpaRepository<Usuario, Int> {

    @Query("""
    select u from Usuario u where u.email = :email
    """)
    @RestResource(exported = true)
    fun findByEmailAndTipoUsuario(email: String?): Optional<Usuario>


    fun findByEmail(email: String?): Optional<Usuario>

    @Query("""
        SELECT COUNT(u) FROM Usuario u WHERE TYPE(u) = Vendedor
    """)
    @RestResource(exported = true)
    fun buscarQtdVendedores():Long

    @Query("""
        SELECT COUNT(u) FROM Usuario u
    """)
    @RestResource(exported = true)
    fun buscarTotalUsuarios():Long


    @RestResource(exported = true)
    fun findByEmailContainsAndAutenticadoTrue(email: String?):Usuario?




}