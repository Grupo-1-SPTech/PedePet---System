package pedepet.loginlogoff.controllers

import pedepet.loginlogoff.models.Usuario

data class UsuarioResponse(
    val email:String,
    val nome:String,
) {
    constructor(usuario: Usuario): this(
        usuario.email,
        usuario.nome,
    )
}