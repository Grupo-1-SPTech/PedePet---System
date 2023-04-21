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
data class Usuario(

        // PARTE 1 CADASTRO
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


        @field:NotBlank @field:Size(min = 8, max = 25)
        var senha:String,


        @field:NotBlank
        val tipoUsuario:Int, // COMPRADOR = 1, VENDEDOR = 2


        // PARTE 2 CADASTRO
        @field:NotBlank
        val interesse:Int, // COMPRAR PET = 1, VENDER UM PET = 2


        @field:NotBlank
        val preferenciaRaca:Int, // SIM = 1, NÃO = 2


        @field:NotBlank
        val pretendeEsperar:Int, // QTD DE MESES QUE A PESSOA PRETENDE ESPERAR PARA TER UM FILHOTE


        // PARTE 3 CADASTRO
        @field:NotBlank
        val moradia:String, // SOBRE A MORADIA DA PESSOA, APTO, CASA ETC


        @field:NotBlank
        val qtdComodos:Int, // QTD DE COMODOS NA CASA


        @field:NotBlank
        val qtdPessoas:Int, // QTD PESSOAS NA CASA


        @field:NotBlank
        val qtdHoras:Int, // QTD HORAS QUE PASSA EM CASA


        @field:NotBlank
        val tevePet:Int, // SIM = 1, NÃO = 2

) {
}