package pedepet.apiRest.models

import javax.persistence.*
import javax.validation.constraints.Size

@Entity
@Table(name = "ninhada")
class AnuncioPet{

    // PARTE 1 CAD ANUNCIO
    @Column(name = "id")
    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int = 0

    @Column(name = "raca_mae")
    var racaMae:Int? = null // RACA DO MAE

    @Column(name = "idade_mae")
    var idadeMae:Int? = null// IDADE MAE

    @Column(name = "porte_mae")
    var porteMae:String? = null // TAMANHO MAE (GRANDE, MEDIO, PEQUENO)

    @Column(name = "pedigree_mae")
    var pedigreeMae:Int? = null // SIM = 1, NÃO = 0

    @Column(name = "vacina_mae")
    var vacinadoMae:Int? = null // SIM = 1, NÃO = 0


    // PARTE 2 CAD ANUNCIO
    @Column(name = "raca_pai")
    var racaPai:Int? = null // RACA DO PAI

    @Column(name = "idade_pai")
    var idadePai:Int? = null // IDADE PAI

    @Column(name = "porte_pai")
    var portePai:String? = null // TAMANHO PAI (GRANDE, MEDIO, PEQUENO)

    @Column(name = "pedigree_pai")
    var pedigreePai:Int? = null // SIM = 1, NÃO = 0

    @Column(name = "vacina_pai")
    var vacinadoPai:Int? = null // SIM = 1, NÃO = 0

    @Column(name = "foto_pet")
    var fotoPet:String? = null

    @Column(name = "visualizacoes")
    var visualizacoes: Int? = null

    // PARTE 3 CAD ANUNCIO
    @Column(name = "qtd_filhotes")
    var qtdFilhotes:Int = 0

    @Column(name = "descricao")
    @field:Size(min = 0, max= 240)
    var descricao:String? = null

    @ManyToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id")
    var usuario: Usuario? = null

    @OneToMany(mappedBy = "anuncioPet")
    var filhotes: MutableList<Filhote> = mutableListOf()
}