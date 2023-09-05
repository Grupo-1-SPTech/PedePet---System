package pedepet.apiRest.models

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("2")
class Vendedor(
    id:Int,
    nome:String?,
    email:String?,
    cpf:String?,
    telefone: String?,
    senha:String?,
    autenticado:Boolean? = true,
): Usuario(id, nome, email, cpf, telefone, senha, autenticado){
    constructor() : this(0, null, null, null, null, null, true)
}