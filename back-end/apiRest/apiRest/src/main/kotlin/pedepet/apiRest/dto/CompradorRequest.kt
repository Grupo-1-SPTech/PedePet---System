package pedepet.apiRest.dto

import pedepet.apiRest.models.Endereco
import pedepet.apiRest.models.Formulario
import pedepet.apiRest.models.Usuario

data class CompradorRequest(
    val usuario: Usuario,
    val endereco: Endereco,
    val formulario: Formulario
)
