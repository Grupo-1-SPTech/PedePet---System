package pedepet.loginlogoff.dtos

import pedepet.loginlogoff.models.AnuncioPet

data class DescriAnuncioRequest (
    val id:Int,
    var descricao:String,
)