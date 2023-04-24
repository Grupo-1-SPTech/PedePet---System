package pedepet.apiRest.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.Size

@Entity
data class AnuncioPet(

    //@ManyToOne
    //val usuario: Usuario,

    // PARTE 1 CAD ANUNCIO
    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Int,

    val racaMae:String, // RACA DO MAE

    val idadeMae:Int, // IDADE MAE

    val porteMae:String, // TAMANHO MAE (GRANDE, MEDIO, PEQUENO)

    val pedigreeMae:Int, // SIM = 1, NÃO = 2

    val vacinadoMae:Int, // SIM = 1, NÃO = 2


    // PARTE 2 CAD ANUNCIO
    val racaPai:String, // RACA DO PAI

    val idadePai:Int, // IDADE PAI

    val portePai:String, // TAMANHO PAI (GRANDE, MEDIO, PEQUENO)

    val pedigreePai:Int, // SIM = 1, NÃO = 2

    val vacinadoPai:Int, // SIM = 1, NÃO = 2


    // PARTE 3 CAD ANUNCIO
    var qtdFilhotes:Int,

    val valorUnitarioFilhotes:Double,

    var tempoNascer:Int,

    var fotosCasal:Int,

    @field:Size(min = 0, max= 240)
    var descricao:String,

    ) {


}