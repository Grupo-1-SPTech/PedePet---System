package pedepet.apiRest.models

import javax.persistence.*

@Entity
@Table(name = "endereco")
class Endereco {

    @Column(name = "id")
    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int = 0

    @Column(name = "cep", length = 8)
    var cep:String? = null

    @Column(name = "rua")
    var rua:String? = null

    @Column(name = "numero")
    var numero:Int? = null

    @Column(name = "complemento")
    var complemento:String? = null

    @Column(name = "bairro")
    var bairro:String? = null

    @Column(name = "cidade")
    var cidade:String? = null

    @Column(name = "estado")
    var estado:String? = null

    @OneToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id")
    var usuario: Usuario? = null

}