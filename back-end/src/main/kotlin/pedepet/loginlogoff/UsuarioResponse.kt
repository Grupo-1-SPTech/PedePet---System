package pedepet.loginlogoff

import pedepet.loginlogoff.Usuario

data class UsuarioResponse(
    val login:String,
    val nome:String,
    val autenticado:Boolean = false
) {
    constructor(usuario: Usuario): this(
        usuario.login,
        usuario.nome,
        usuario.autenticado
    )
}