package pedepet.loginlogoff.dtos

import pedepet.loginlogoff.models.AnuncioPet
import pedepet.loginlogoff.models.Usuario

data class AnuncioRequest(
    val id:Int,
   // val fkVendedorUsuario: Usuario,
    val racaMae:String,
    val racaPai:String,
    var qtdFilhotes:Int,
    val valorUnitarioFilhotes:Double,
    var tempoNascer:Int,
    var descricao:String,
) {
    constructor(anuncio: AnuncioPet): this (
        anuncio.id,
       // anuncio.fkVendedorUsuario,
        anuncio.racaMae,
        anuncio.racaPai,
        anuncio.qtdFilhotes,
        anuncio.valorUnitarioFilhotes,
        anuncio.tempoNascer,
        anuncio.descricao,
            )
}