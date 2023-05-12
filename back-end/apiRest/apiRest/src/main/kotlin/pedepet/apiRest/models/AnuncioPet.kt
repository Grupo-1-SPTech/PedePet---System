package pedepet.apiRest.models

import javax.persistence.*
import javax.validation.constraints.Size

@Entity
//@Table(name = "ninhada")
data class AnuncioPet(

    // PARTE 1 CAD ANUNCIO
    //@Column(name = "idNinhada")
    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Int?,

    //@Column(name = "titulo")
    val titulo:String? = null,

    //@Column(name = "raca_mae")
    val racaMae:String? = null, // RACA DO MAE

    //@Column(name = "idade_mae")
    val idadeMae:Int? = null, // IDADE MAE

    //@Column(name = "porte_mae")
    val porteMae:String? = null, // TAMANHO MAE (GRANDE, MEDIO, PEQUENO)

    //@Column(name = "pedigree_mae")
    val pedigreeMae:Int? = null, // SIM = 1, NÃO = 2

    //@Column(name = "vacinado_mae")
    val vacinadoMae:Int? = null, // SIM = 1, NÃO = 2


    // PARTE 2 CAD ANUNCIO
    //@Column(name = "raca_pai")
    val racaPai:String? = null, // RACA DO PAI

    //@Column(name = "idade_pai")
    val idadePai:Int? = null, // IDADE PAI

    //@Column(name = "porte_pai")
    val portePai:String? = null, // TAMANHO PAI (GRANDE, MEDIO, PEQUENO)

    //@Column(name = "pedigree_pai")
    val pedigreePai:Int? = null, // SIM = 1, NÃO = 2

    //@Column(name = "vacinado_pai")
    val vacinadoPai:Int? = null, // SIM = 1, NÃO = 2

    //@Column(name = "foto_casal")
    var fotosCasal:String? = null,

    //@Column(name = "visualizacoes")
    var visualizacoes: Int? = null,

    // PARTE 3 CAD ANUNCIO
    //@Column(name = "qtd_filhotes")
    var qtdFilhotes:Int? = null,

    //@Column(name = "descricao")
    @field:Size(min = 0, max= 240)
    var descricao:String? = null,

    //@Column(name = "fkUsuario")
    @ManyToOne
    var usuario: Int? = null,
) {
}