package pedepet.apiRest.models

import java.time.LocalDateTime
import java.util.Date
import javax.persistence.*

@Entity
@Table(name = "filhote")
data class Filhote(

    //@Column(name = "idFilhote")
    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int,

    @Column(name = "tempo_espera")
    var tempoEspera: Date?,

    @Column(name = "preco")
    val preco:Double?,

    @Column(name = "data_criacao")
    val dataCriacao:LocalDateTime?,
) {
}