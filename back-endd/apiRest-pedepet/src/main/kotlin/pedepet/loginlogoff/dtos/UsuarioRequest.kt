package pedepet.loginlogoff.dtos

import pedepet.loginlogoff.models.Usuario

class UsuarioRequest (
    val email:String,
    val nome:String,
    val tipoUsuario:Int,
) {
    constructor(usuario: Usuario): this(
        usuario.email,
        usuario.nome,
        usuario.tipoUsuario
    )
}