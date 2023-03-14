package pedepet.loginlogoff

data class Usuario(
    val login:String,
    var senha:String,
    val nome:String,
    var ativo:Boolean = true,
    var autenticado:Boolean = false
) {
}