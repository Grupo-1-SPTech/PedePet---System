package pedepet.loginlogoff.dtos

import pedepet.loginlogoff.models.Usuario

data class SenhaEntradaRequest(
    var senha:String,
) {
    constructor(usuario: Usuario): this(
        usuario.senha,
    )
}