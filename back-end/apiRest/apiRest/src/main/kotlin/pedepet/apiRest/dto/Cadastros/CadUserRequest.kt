package pedepet.apiRest.dto.Cadastros

import io.swagger.v3.oas.annotations.media.Schema
import org.hibernate.validator.constraints.br.CPF
import javax.validation.constraints.Email
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.Size

data class CadUserRequest(

    //@field:NotBlank
    val nome:String,

    //@field:NotBlank
    @field:Email
    val email:String,

    @field:CPF
    val cpf:String,

    //@field:NotBlank
    val telefone:String,

    //@field:NotBlank
    @field:Size(min = 8, max = 24)
    val senha:String,

    //@field:NotNull
    @Schema(example = "1")
    @field:Min(1)
    @field:Max(2)
    val tipoUsuario:Int,

    val autenticado:Boolean
) {
}