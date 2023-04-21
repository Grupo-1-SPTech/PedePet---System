package pedepet.loginlogoff.models

import net.bytebuddy.dynamic.loading.InjectionClassLoader.Strategy
import java.awt.Image
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.validation.constraints.NotBlank

@Entity
data class AnuncioPet(

    @ManyToOne
    val fkVendedorUsuario: Usuario,

    // PARTE 1 CAD ANUNCIO
    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Int,


    @field:NotBlank
    val racaMae:String, // RACA DO MAE


    @field:NotBlank
    val idadeMae:Int, // IDADE MAE


    @field:NotBlank
    val porteMae:String, // TAMANHO MAE (GRANDE, MEDIO, PEQUENO)


    @field:NotBlank
    val pedigreeMae:Int, // SIM = 1, NÃO = 2


    @field:NotBlank
    val vacinadoMae:Int, // SIM = 1, NÃO = 2


    // PARTE 2 CAD ANUNCIO
    @field:NotBlank
    val racaPai:String, // RACA DO PAI


    @field:NotBlank
    val idadePai:Int, // IDADE PAI


    @field:NotBlank
    val portePai:String, // TAMANHO PAI (GRANDE, MEDIO, PEQUENO)


    @field:NotBlank
    val pedigreePai:Int, // SIM = 1, NÃO = 2


    @field:NotBlank
    val vacinadoPai:Int, // SIM = 1, NÃO = 2


    // PARTE 3 CAD ANUNCIO
    @field:NotBlank
    var qtdFilhotes:Int,


    @field:NotBlank
    var valorUnitarioFilhotes:Double,


    @field:NotBlank
    var tempoNascer:Int,


    @field:NotBlank
    var fotosCasal:Int,

    var descricao:String,

) {


}