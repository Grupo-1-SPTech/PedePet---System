package pedepet.apiRest.models

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "filhote")
data class Filhote(

    @Column(name = "id")
    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int?,

    @Column(name = "tempo_espera")
    var tempoEspera: Int? = null,

    @Column(name = "preco")
    val preco:Double? = null,

    @Column(name = "data_criacao")
    var dataCriacao:LocalDateTime? = null,

    @Column(name = "disponivel")
    var disponivel:Boolean? = true,

    @Column(name = "vacina_filhote")
    var vacinaFilhote:Int? = null, // SIM = 1, NÃO = 0

    @ManyToOne
    @JoinColumn(name = "fk_ninhada", referencedColumnName = "id")
    var anuncioPet: AnuncioPet? = null,

) {
    init {
        dataCriacao = LocalDateTime.now()
    }
}