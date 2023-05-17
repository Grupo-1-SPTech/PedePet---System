package pedepet.apiRest.models

import java.time.LocalDateTime
import java.util.Date
import javax.persistence.*

@Entity
//@Table(name = "filhote")
data class Filhote(

    //@Column(name = "idFilhote")
    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int,

    //@Column(name = "tempo_espera")
    var tempoEspera: Int? = null,

    //@Column(name = "preco")
    val preco:Double? = null,

    //@Column(name = "data_criacao")
    val dataCriacao:String? = null,

    //@Column(name = "disponivel")
    var disponivel:Boolean? = true,

    @ManyToOne
    @JoinColumn(name = "fkAnuncio", referencedColumnName = "id")
    var anuncioPet: AnuncioPet? = null,

) {
}