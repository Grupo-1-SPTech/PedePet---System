package pedepet.apiRest.dto

import pedepet.apiRest.models.AnuncioPet
import pedepet.apiRest.models.Filhote

data class AddAnuncioRequest(
    val filhote: Filhote
)