package pedepet.apiRest.models

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*
import javax.validation.constraints.Max
import javax.validation.constraints.Min

@Entity
@Table(name = "historico_vendas")
data class HistoricoVendas(

    @Column(name = "id")
    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int,

    @Column(name = "nota")
    @Min(value = 1, message = "A nota mínima é 1")
    @Max(value = 5, message = "A nota máxima é 5")
    var nota:Int? = null,

    @Column(name = "data_venda")
    var dataVenda: LocalDateTime? = null,

    @Column(name = "preco")
    var preco:Double? = null,

    @Column(name = "tipo_pagamento")
    var tipoPagamento:String? = null,

    @OneToOne
    @JoinColumn(name = "fk_comprador", referencedColumnName = "id")
    var comprador: Usuario? = null,

    @OneToOne
    @JoinColumn(name = "fk_vendedor", referencedColumnName = "id")
    var vendedor: Usuario? = null,

    @OneToOne
    @JoinColumn(name = "fk_filhote", referencedColumnName = "id")
    var filhote: Filhote? = null,

    @OneToOne
    @JoinColumn(name = "fk_dados_pagamento", referencedColumnName = "id")
    var dadosPagamento: DadosPagamento? = null,
) {
    init {
        dataVenda = LocalDateTime.now()
    }
}