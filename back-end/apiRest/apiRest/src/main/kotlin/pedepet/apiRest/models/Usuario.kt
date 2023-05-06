package pedepet.apiRest.models

import org.hibernate.validator.constraints.br.CPF
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

@Entity
@Table(name = "usuario")
data class Usuario(

    //@Column(name = "id")
    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int,

    //@Column(name = "nome")
    @field:NotBlank @field:Size(min = 3, max = 45)
    val nome:String? = null,

    //@Column(name = "email")
    @field:Email @field:NotBlank @field:Size(min = 10, max = 100)
    var email:String? = null,

    //@Column(name = "cpf", unique = true)
    @field:CPF
    val cpf:String? = null,

    //@Column(name = "telefone")
    @field:Pattern(
        regexp = "(\\(?\\d{2}\\)?\\s)?(\\d{4,5}\\-\\d{4})",
        message = "Envie um telefone válido"
    ) val telefone: String? = null,

    //@Column(name = "senha")
    @field:NotBlank @field:Size(min = 8, max = 25)
    var senha:String? = null,

    //@Column(name = "tipo_usuario")
    val tipoUsuario:Int?, // COMPRADOR = 1, VENDEDOR = 2

    //@Column(name = "autenticado")
    var autenticado:Boolean? = false,
    ) {
}