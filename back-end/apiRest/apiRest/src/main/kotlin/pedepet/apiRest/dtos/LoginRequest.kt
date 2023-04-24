package pedepet.apiRest.dtos

import javax.validation.constraints.NotBlank

data class LoginRequest(
    //val id:Int,
    val email:String,
    var senha:String,
    //var autenticado:Boolean,
) {

}