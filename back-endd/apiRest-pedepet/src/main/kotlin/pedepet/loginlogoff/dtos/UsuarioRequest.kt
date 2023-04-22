package pedepet.loginlogoff.dtos

import pedepet.loginlogoff.models.Usuario

data class UsuarioRequest (
    val id:Int,
    val email:String,
    val nome:String,
    var senha:String,
    val tipoUsuario:Int,
    var autenticado:Boolean,
) {
    constructor(usuario: Usuario): this(
        usuario.id,
        usuario.email,
        usuario.nome,
        usuario.senha,
        usuario.tipoUsuario,
        usuario.autenticado
    )
}