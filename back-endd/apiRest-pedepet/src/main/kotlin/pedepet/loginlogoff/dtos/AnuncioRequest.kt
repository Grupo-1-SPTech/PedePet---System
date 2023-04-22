package pedepet.loginlogoff.dtos

import pedepet.loginlogoff.models.AnuncioPet
import pedepet.loginlogoff.models.Usuario

class AnuncioRequest(
    val anuncioPet: AnuncioPet,
    val usuario: Usuario
) {
}