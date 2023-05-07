package pedepet.apiRest.models

import javax.persistence.*

@Entity
@Table(name = "endereco")
data class Endereco(

    //@Column(name = "idEndereco")
    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int,

    //@Column(name = "cep", length = 8)
    val cep:String?,

    //@Column(name = "rua")
    val rua:String?,

    //@Column(name = "numero")
    val numero:Int?,

    //@Column(name = "complemento")
    val complemento:String?,

    //@Column(name = "bairro")
    val bairro:String?,

    //@Column(name = "cidade")
    val cidade:String?,

    //@Column(name = "estado")
    val estado:String?,

    //@Column(name = "fkUsuario")
    @OneToOne
    val usuario: Usuario? = null,
) {
}