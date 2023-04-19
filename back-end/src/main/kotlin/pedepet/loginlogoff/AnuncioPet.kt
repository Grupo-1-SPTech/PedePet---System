package pedepet.loginlogoff

import java.awt.Image
import javax.validation.constraints.NotBlank

data class AnuncioPet(
    // PARTE 1 CAD ANUNCIO
    @field:NotBlank var racaMae:String, // RACA DO MAE
    @field:NotBlank var idadeMae:Int, // IDADE MAE
    @field:NotBlank var porteMae:String, // TAMANHO MAE (GRANDE, MEDIO, PEQUENO)
    @field:NotBlank val pedigreeMae:Int, // SIM = 1, NÃO = 2
    @field:NotBlank val vacinadoMae:Int, // SIM = 1, NÃO = 2

    // PARTE 2 CAD ANUNCIO
    @field:NotBlank var racaPai:String, // RACA DO PAI
    @field:NotBlank var idadePai:Int, // IDADE PAI
    @field:NotBlank var portePai:String, // TAMANHO PAI (GRANDE, MEDIO, PEQUENO)
    @field:NotBlank val pedigreePai:Int, // SIM = 1, NÃO = 2
    @field:NotBlank val vacinadoPai:Int, // SIM = 1, NÃO = 2

    // PARTE 3 CAD ANUNCIO
    @field:NotBlank var qtdFilhotes:Int,
    @field:NotBlank var valorUnitarioFilhotes:Double = 0.00,
    @field:NotBlank var tempoNascer:Int,
    @field:NotBlank var fotosCasal:Int,
) {


}