package pedepet.apiRest.dto.Cadastros

import pedepet.apiRest.models.Filhote

data class CadAnuncioRequest(

    val racaMae:Int,// RACA DO MA
    val idadeMae:Int, // IDADE MAE
    val porteMae:String, // TAMANHO MAE (GRANDE, MEDIO, PEQUENO)
    val pedigreeMae:Int, // SIM = 1, NÃO = 0
    val vacinadoMae:Int, // SIM = 1, NÃO = 0
    val racaPai:Int, // RACA DO PAI
    val idadePai:Int, // IDADE PAI
    val portePai:String, // TAMANHO PAI (GRANDE, MEDIO, PEQUENO)
    val pedigreePai:Int, // SIM = 1, NÃO =
    val vacinadoPai:Int, // SIM = 1, NÃO = 0
    var fotoPet:String,
    var visualizacoes: Int,
    var qtdFilhotes:Int,
    var descricao:String?,
    var filhote: Filhote
) {
}