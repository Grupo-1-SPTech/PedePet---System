package pedepet.apiRest.dto.cadastros

data class CadEnderecoRequest(
    val cep:String,
    val rua:String,
    val numero:Int,
    val complemento:String?,
    val bairro:String,
    val cidade:String,
    val estado:String,
)