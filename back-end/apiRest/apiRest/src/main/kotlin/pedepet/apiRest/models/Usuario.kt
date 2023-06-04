package pedepet.apiRest.models

import org.hibernate.validator.constraints.br.CPF
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

@Entity
@Table(name = "usuario")
data class Usuario(

    @Column(name = "id")
    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int,

    @Column(name = "nome")
    @field:NotBlank @field:Size(min = 3, max = 45)
    var nome:String?,

    @Column(name = "email")
    @field:Email @field:NotBlank @field:Size(min = 10, max = 50)
    var email:String?,

    @Column(name = "cpf", unique = true)
    @field:CPF
    var cpf:String?,

    @Column(name = "telefone")
    @field:Pattern(
        regexp = "^[0-9]+\$",
        message = "Envie um telefone válido"
    ) var telefone: String?,

    @Column(name = "senha")
    @field:NotBlank @field:Size(min = 8, max = 30)
    var senha:String?,

    @Column(name = "tipo_usuario")
    var tipoUsuario:Int? = null, // COMPRADOR = 1, VENDEDOR = 2

    @Column(name = "autenticado")
    var autenticado:Boolean? = true,
    ) {
}