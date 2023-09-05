package pedepet.apiRest.dto

import pedepet.apiRest.models.Comprador
import pedepet.apiRest.models.Endereco
import pedepet.apiRest.models.Formulario
import pedepet.apiRest.models.Usuario

data class CompradorRequest(
    val usuario: Comprador,
    val endereco: Endereco,
    val formulario: Formulario,
    var tipoUsuario:Int? = null,
)
