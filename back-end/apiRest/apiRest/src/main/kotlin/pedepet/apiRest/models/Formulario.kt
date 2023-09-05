package pedepet.apiRest.models

import javax.persistence.*

@Entity
@Table(name = "formulario")
class Formulario{

    @Column(name = "id")
    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int = 0

    @Column(name = "tipo_moradia")
    var tipoMoradia:String? = null // SOBRE A MORADIA DA PESSOA, APTO, CASA ETC

    @Column(name = "qtd_comodos")
    var qtdComodos:String? = null // QTD DE COMODOS NA CASA

    @Column(name = "qtd_moradores")
    var qtdMoradores:String? = null // QTD PESSOAS NA CASA

    @Column(name = "qtd_horas_casa")
    var qtdHorasCasa:String? = null // QTD HORAS QUE PASSA EM CASA

    @Column(name = "possui_pet")
    var possuiPet:Int? = null // SIM = 1, NÃO = 0

    @Column(name = "status_forms")  //  não aprovado = 0, aprovado = 1, pendente = 2
    var statusForms:Int? = null

    @OneToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id")
    var usuario: Usuario? = null
}