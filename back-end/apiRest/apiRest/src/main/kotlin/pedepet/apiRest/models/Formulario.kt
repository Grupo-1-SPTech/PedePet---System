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
    val qtdComodos:Int? = null, // QTD DE COMODOS NA CASA

    @Column(name = "qtd_moradores")
    val qtdMoradores:Int? = null, // QTD PESSOAS NA CASA

    @Column(name = "qtd_horas_casa")
    val qtdHorasCasa:Int? = null, // QTD HORAS QUE PASSA EM CASA

    @Column(name = "possui_pet")
    val possuiPet:Int? = null, // SIM = 1, NÃO = 0

    @OneToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id")
    var usuario: Usuario? = null,
) {
}