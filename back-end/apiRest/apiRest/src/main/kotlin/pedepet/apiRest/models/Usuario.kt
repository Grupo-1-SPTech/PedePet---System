package pedepet.apiRest.models

import org.hibernate.validator.constraints.br.CPF
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_usuario", discriminatorType = DiscriminatorType.INTEGER)
@Table(name = "usuario")
abstract class Usuario(

    @Column(name = "id")
    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int,

    @Column(name = "nome")
    @field:NotBlank @field:Size(min = 3, max = 60)
    var nome:String?,

    @Column(name = "email")
    @field:Email @field:NotBlank @field:Size(min = 10, max = 60)
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

    @Column(name = "autenticado")
    var autenticado:Boolean? = true,

    ) {
}