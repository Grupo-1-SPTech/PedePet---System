package pedepet.apiRest.dto

import pedepet.apiRest.models.AnuncioPet
import pedepet.apiRest.models.Endereco
import pedepet.apiRest.models.Usuario

data class VendedorRequest (
    val usuario: Usuario,
    val endereco: Endereco,
    val anuncioPet: AnuncioPet,
)
