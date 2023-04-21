package pedepet.loginlogoff.models

import org.hibernate.validator.constraints.br.CPF
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

@Entity
data class Pipefy(

    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int,

    @field:NotBlank @field:Size(min = 3, max = 45)
    val nome:String,

    @field:Email @field:Size(min = 10, max = 100)
    val email:String,

    @field:CPF
    val cpf:String,

    @field:Pattern(
        regexp = "(\\(?\\d{2}\\)?\\s)?(\\d{4,5}\\-\\d{4})",
        message = "Envie um telefone válido"
    ) val telefone: String,

    @field:NotBlank
    val tipoUsuario:Int, // COMPRADOR = 1, VENDEDOR = 2

    @field:NotBlank
    val comprouAntes:Int, // SIM = 1, NAO = 2

    @field:NotBlank
    val preferenciaRaca:String,

    @field:NotBlank
    val planejaEntrarFila:Int, // PLANEJA ENRTAR FILA PARA ESPERAR FILHOTE NOS PROX 2 MESES SIM = 1, NAO = 2

    @field:NotBlank
    val possuiCasal:Int, // TEM CASAL PARA ANUNCIAR SIM = 1, NAO = 2

) {
}