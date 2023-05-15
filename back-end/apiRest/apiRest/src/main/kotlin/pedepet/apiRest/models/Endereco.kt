package pedepet.apiRest.models

import javax.persistence.*

@Entity
//@Table(name = "endereco")
data class Endereco(

    //@Column(name = "idEndereco")
    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int,

    //@Column(name = "cep", length = 8)
    val cep:String? = null,

    //@Column(name = "rua")
    val rua:String? = null,

    //@Column(name = "numero")
    val numero:Int? = null,

    //@Column(name = "complemento")
    val complemento:String? = null,

    //@Column(name = "bairro")
    val bairro:String? = null,

    //@Column(name = "cidade")
    val cidade:String? = null,

    //@Column(name = "estado")
    val estado:String? = null,

    //@Column(name = "fkUsuario")
    @OneToOne
    var usuario: Usuario,
) {
}