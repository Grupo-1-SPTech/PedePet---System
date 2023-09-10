package pedepet.apiRest.dto.Cadastros

data class CadFormularioRequest(
    val tipoMoradia:String,
    val qtdComodos:String,
    val qtdMoradores:String,
    val qtdHorasCasa:String,
    val possuiPet:Boolean,
    val statusForms:Int?,
) {
}