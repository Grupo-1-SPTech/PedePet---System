package pedepet.loginlogoff.dtos

import pedepet.loginlogoff.models.Usuario

class UsuarioRequest (
    val id:Int,
    val email:String,
    val nome:String,
    val senha:String,
    val tipoUsuario:Int,
) {
    constructor(usuario: Usuario): this(
        usuario.id,
        usuario.email,
        usuario.nome,
        usuario.senha,
        usuario.tipoUsuario
    )
}