package pedepet.apiRest.dto.cadastros

import pedepet.apiRest.models.Filhote

data class CadAnuncioRequest(

    val titulo:String,
    val racaMae:String,// RACA DO MA
    val idadeMae:Int, // IDADE MAE
    val porteMae:String, // TAMANHO MAE (GRANDE, MEDIO, PEQUENO)
    val pedigreeMae:Int, // SIM = 1, NÃO = 0
    val vacinadoMae:Int, // SIM = 1, NÃO = 0
    val racaPai:String, // RACA DO PAI
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