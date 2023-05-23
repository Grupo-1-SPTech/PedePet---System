package pedepet.apiRest.models

import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import java.util.Date
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

@Entity
@Table(name = "dados_pagamento")
data class DadosPagamento(

    @Column(name = "id")
    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int,

    @Column(name = "nome")
    @field:NotBlank @field:Size(min = 3, max = 45)
    var nome:String? = null,

    @Column(name = "numero_cartao", length = 16)
    var numeroCartao:Int? = null,

    @Column(name = "validade")
    @field:Pattern(
        regexp = "^(0[1-9]|1[0-2])/(y{2})\$",
        message = "Envie uma validade no formato MM-yy"
    ) var validade:String? = null,

    @Column(name = "cvv", length = 3)
    var cvv:Int? = null,

    @OneToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id")
    var usuario: Usuario? = null,
) {
    init {
        validade = YearMonth.now().format(DateTimeFormatter.ofPattern("MM-yy"))
    }
}