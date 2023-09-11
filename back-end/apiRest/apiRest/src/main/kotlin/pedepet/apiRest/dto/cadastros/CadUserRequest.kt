package pedepet.apiRest.dto.cadastros

import io.swagger.v3.oas.annotations.media.Schema
import org.hibernate.validator.constraints.br.CPF
import javax.validation.constraints.Email
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.Size

data class CadUserRequest(

    val nome:String,

    @field:Email
    val email:String,

    @field:CPF
    val cpf:String,

    val telefone:String,

    @field:Size(min = 8, max = 24)
    val senha:String,

    val tipoUsuario:Int,

    val autenticado:Boolean = true
) {
}