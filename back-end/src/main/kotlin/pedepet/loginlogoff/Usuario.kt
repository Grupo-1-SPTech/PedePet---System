package pedepet.loginlogoff

import org.hibernate.validator.constraints.br.CPF
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

data class Usuario(

        // PARTE 1 CADASTRO
        @field:NotBlank @field:Size(min = 3, max = 45) var nome:String,
        @field:Email var email:String,
        @field:CPF var cpf:String,
        @field:Pattern(
                regexp = "(\\(?\\d{2}\\)?\\s)?(\\d{4,5}\\-\\d{4})",
                message = "Envie um telefone válido"
        ) var telefone: String,
        @field:NotBlank var senha:String,
        @field:NotBlank var tipoUsuario:Int = 1, // COMPRADOR = 1, VENDEDOR = 2
        //var ativo:Boolean = true,
        //var autenticado:Boolean = false

        // PARTE 2 CADASTRO
        @field:NotBlank var interesse:Int = 1, // COMPRAR PET = 1, VENDER UM PET = 2
        @field:NotBlank var preferenciaRaca:Int = 1, // SIM = 1, NÃO = 2
        @field:NotBlank var pretendeEsperar:
) {
}