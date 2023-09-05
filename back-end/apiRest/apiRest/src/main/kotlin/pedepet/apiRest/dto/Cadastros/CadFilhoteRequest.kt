package pedepet.apiRest.dto.Cadastros

import java.time.LocalDateTime

data class CadFilhoteRequest(
    var tempoEspera: Int?,
    var preco:Double?,
    var dataCriacao: LocalDateTime?,
    var disponivel:Boolean?,
    var vacinaFilhote:Int?,
) {
}