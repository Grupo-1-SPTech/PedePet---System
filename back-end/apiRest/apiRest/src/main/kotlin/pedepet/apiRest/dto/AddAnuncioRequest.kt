package pedepet.apiRest.dto

import pedepet.apiRest.models.AnuncioPet
import pedepet.apiRest.models.Usuario
import javax.persistence.Id

data class AddAnuncioRequest(
    val anuncioPet: AnuncioPet
)