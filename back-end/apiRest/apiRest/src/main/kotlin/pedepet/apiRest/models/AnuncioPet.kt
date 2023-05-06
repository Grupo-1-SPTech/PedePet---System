package pedepet.apiRest.models

import javax.persistence.*
import javax.validation.constraints.Size

@Entity
data class AnuncioPet(

    // PARTE 1 CAD ANUNCIO
    //@Column(name = "id")
    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Int?,

    //@Column(name = "titulo")
    val titulo:String?,

    //@Column(name = "raca_mae")
    val racaMae:String?, // RACA DO MAE

    //@Column(name = "idade_mae")
    val idadeMae:Int?, // IDADE MAE

    //@Column(name = "porte_mae")
    val porteMae:String?, // TAMANHO MAE (GRANDE, MEDIO, PEQUENO)

    //@Column(name = "pedigree_mae")
    val pedigreeMae:Int?, // SIM = 1, NÃO = 2

    //@Column(name = "vacinado_mae")
    val vacinadoMae:Int?, // SIM = 1, NÃO = 2


    // PARTE 2 CAD ANUNCIO
    //@Column(name = "raca_pai")
    val racaPai:String?, // RACA DO PAI

    //@Column(name = "idade_pai")
    val idadePai:Int?, // IDADE PAI

    //@Column(name = "porte_pai")
    val portePai:String?, // TAMANHO PAI (GRANDE, MEDIO, PEQUENO)

    //@Column(name = "pedigree_pai")
    val pedigreePai:Int?, // SIM = 1, NÃO = 2

    //@Column(name = "vacinado_pai")
    val vacinadoPai:Int?, // SIM = 1, NÃO = 2


    // PARTE 3 CAD ANUNCIO
    //@Column(name = "qtd_filhotes")
    var qtdFilhotes:Int?,

    //@Column(name = "valor_filhote")
    val valorFilhote:Double?,

    //@Column(name = "tempo_nascer")
    var tempoNascer:Int?,

    //@Column(name = "foto_casal")
    var fotosCasal:String?,

    //@Column(name = "descricao")
    @field:Size(min = 0, max= 240)
    var descricao:String?,

    @ManyToOne
    val usuario: Usuario?,
) {
}