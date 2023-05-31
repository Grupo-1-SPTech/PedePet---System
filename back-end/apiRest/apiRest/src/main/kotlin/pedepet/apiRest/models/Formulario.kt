package pedepet.apiRest.models

import javax.persistence.*

@Entity
@Table(name = "formulario")
data class Formulario(

    @Column(name = "id")
    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int,

    @Column(name = "tipo_moradia")
    val tipoMoradia:String? = null, // SOBRE A MORADIA DA PESSOA, APTO, CASA ETC

    @Column(name = "qtd_comodos")
    val qtdComodos:String? = null, // QTD DE COMODOS NA CASA

    @Column(name = "qtd_moradores")
    val qtdMoradores:String? = null, // QTD PESSOAS NA CASA

    @Column(name = "qtd_horas_casa")
    val qtdHorasCasa:String? = null, // QTD HORAS QUE PASSA EM CASA

    @Column(name = "possui_pet")
    val possuiPet:Int? = null, // SIM = 1, NÃO = 0

//    @Column(name = "status_forms")  // aprovado = 1, não aprovado = 0
//    val statusForms:Boolean? = false,

    @OneToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id")
    var usuario: Usuario? = null,
) {
}