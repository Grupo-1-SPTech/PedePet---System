package pedepet.apiRest.models

import java.util.Date
import javax.persistence.*
import javax.validation.constraints.NotBlank
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
    var validade:Date? = null,

    @Column(name = "cvv", length = 3)
    var cvv:Int? = null,

    @OneToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id")
    var usuario: Usuario? = null,
) {
}