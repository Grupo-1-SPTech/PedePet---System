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
        @field:NotBlank @field:Size(min = 8, max = 25) var senha:String,
        @field:NotBlank var tipoUsuario:Int = 1, // COMPRADOR = 1, VENDEDOR = 2
        //var ativo:Boolean = true,
        //var autenticado:Boolean = false

        // PARTE 2 CADASTRO
        @field:NotBlank val interesse:Int = 1, // COMPRAR PET = 1, VENDER UM PET = 2
        @field:NotBlank val preferenciaRaca:Int = 1, // SIM = 1, NÃO = 2
        @field:NotBlank val pretendeEsperar:Int, // QTD DE MESES QUE A PESSOA PRETENDE ESPERAR PARA TER UM FILHOTE

        // PARTE 3 CADASTRO
        @field:NotBlank val moradia:String, // SOBRE A MORADIA DA PESSOA, APTO, CASA ETC
        @field:NotBlank val qtdComodos:Int, // QTD DE COMODOS NA CASA
        @field:NotBlank val qtdPessoas:Int, // QTD PESSOAS NA CASA
        @field:NotBlank val qtdHoras:Int, // QTD HORAS QUE PASSA EM CASA
        @field:NotBlank val tevePet:Int = 1, // SIM = 1, NÃO = 2

) {
}