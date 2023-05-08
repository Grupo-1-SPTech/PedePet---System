package pedepet.apiRest.models

import javax.persistence.*

@Entity
@Table(name = "formulario")
data class Formulario(

    //@Column(name = "idFormulario")
    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int,

    //@Column(name = "id")
    val tipoMoradia:String?, // SOBRE A MORADIA DA PESSOA, APTO, CASA ETC

    //@Column(name = "qtd_comodos")
    val qtdComodos:Int?, // QTD DE COMODOS NA CASA

    //@Column(name = "qtd_moradores")
    val qtdMoradores:Int?, // QTD PESSOAS NA CASA

    //@Column(name = "qtd_horas_casa")
    val qtdHorasCasa:Int?, // QTD HORAS QUE PASSA EM CASA

    //@Column(name = "possui_pet")
    val possuiPet:Int?, // SIM = 1, NÃO = 2

    //@Column(name = "fkUsuario")
    @OneToOne
    val usuario: Usuario,
) {
}