package pedepet.apiRest.dto

import pedepet.apiRest.models.*

data class VendedorRequest (
    val usuario: Vendedor,
    val endereco: Endereco,
    val anuncioPet: AnuncioPet,
    var filhote: Filhote,
    var tipoUsuario:Int? = null,
)
