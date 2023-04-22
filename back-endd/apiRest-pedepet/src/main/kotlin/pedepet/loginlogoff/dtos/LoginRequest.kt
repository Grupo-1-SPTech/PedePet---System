package pedepet.loginlogoff.dtos

import javax.validation.constraints.NotBlank

data class LoginRequest(
    @field:NotBlank val email:String,
    @field:NotBlank var senha:String,
) {

}