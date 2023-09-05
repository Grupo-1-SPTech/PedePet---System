package pedepet.apiRest.dto.Cadastros

data class CadastrarFormulario(
    val tipoMoradia:String,
    val qtdComodos:String,
    val qtdMoradores:String,
    val qtdHorasCasa:String,
    val possuiPet:Int,
    val statusForms:Int?,
) {
}