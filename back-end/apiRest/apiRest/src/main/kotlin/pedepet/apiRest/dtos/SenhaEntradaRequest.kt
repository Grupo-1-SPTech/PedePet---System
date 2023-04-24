package pedepet.apiRest.dtos

import pedepet.apiRest.models.Usuario

data class SenhaEntradaRequest(
    val id:Int,
    var senha:String,
) {
    constructor(usuario: Usuario): this(
        usuario.id,
        usuario.senha,
    )
}