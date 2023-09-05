package pedepet.apiRest.models

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("1")
class Comprador(
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
