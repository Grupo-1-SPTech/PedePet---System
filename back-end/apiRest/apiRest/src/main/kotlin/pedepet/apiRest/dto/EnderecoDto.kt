package pedepet.apiRest.dto

import pedepet.apiRest.models.Endereco
import pedepet.apiRest.models.Usuario

class EnderecoDto (
    val usuario: Usuario,
    val endereco: Endereco?
){

}