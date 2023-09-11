package pedepet.apiRest.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.data.rest.core.annotation.RestResource
import org.springframework.web.bind.annotation.CrossOrigin
import pedepet.apiRest.models.AnuncioPet
import pedepet.apiRest.models.Endereco

@CrossOrigin("http://localhost:3000")
@RepositoryRestResource(path = "ninhadas")
interface AnuncioRepository: JpaRepository<AnuncioPet, Int> {

    fun findByUsuarioId(id: Int): AnuncioPet?

    fun findByIdAndQtdFilhotes(id:Int, qtdFilhotes:Int):AnuncioPet?

    // Função para contar quantas raças distintas estão cadastradas
    @Query("""
        SELECT 
        COUNT(DISTINCT c.racaMae) FROM AnuncioPet c
    """)
    @RestResource(exported = true)
    fun countDistinctRacas():Long

    // Função para buscar anúncios pela raça
    @Query("""
        SELECT c FROM AnuncioPet c WHERE c.racaMae = :racaMae
    """)
    @RestResource(exported = true)
    fun findByRacaMae():List<AnuncioPet?>

    // Função para buscar anúncios pelo porte
    @Query("""
        SELECT c FROM AnuncioPet c WHERE c.porteMae = :porteMae
    """)
    @RestResource(exported = true)
    fun findByPorte():List<AnuncioPet?>

    // Função para buscar o valor do anúncio por ID
    @Query("SELECT AVG(filhote.preco) FROM AnuncioPet anuncio JOIN anuncio.filhotes filhote WHERE anuncio.id = :id")
    @RestResource(exported = true)
    fun findValorById(@Param("id") id: Int): Double?

    // Função para buscar o tempo do anúncio por ID
    @Query("SELECT filhote.tempoEspera FROM AnuncioPet anuncio JOIN anuncio.filhotes filhote WHERE anuncio.id = :id")
    @RestResource(exported = true)
    fun findTempoById(@Param("id") id: Int): Int?

    // Função para buscar a descrição do anúncio por ID
    @Query("SELECT anuncio.descricao FROM AnuncioPet anuncio WHERE anuncio.id = :id")
    @RestResource(exported = true)
    fun findDescricaoById(@Param("id") id: Int): String?

    // Função para buscar o nome do vendedor por ID do anúncio
    @Query("SELECT usuario.nome FROM AnuncioPet anuncio JOIN anuncio.usuario usuario WHERE anuncio.id = :id")
    @RestResource(exported = true)
    fun findNomeVendedorById(@Param("id") id: Int): String?

    // Função para buscar o nome da raça da mãe pelo nome da raça da mãe
    @Query("SELECT ap.racaMae FROM AnuncioPet ap WHERE ap.racaMae = :racaMae")
    @RestResource(exported = true)
    fun findRacaMae(@Param("racaMae") racaMae: String): List<String>


    // Função para buscar a quantidade de filhotes disponíveis por ID do anúncio
    @Query("SELECT COUNT(filhote) FROM AnuncioPet anuncio JOIN anuncio.filhotes filhote WHERE anuncio.id = :id AND filhote.disponivel = true")
    @RestResource(exported = true)
    fun findQuantidadeFilhotesDisponiveisById(@Param("id") id: Int): Long

    // Função pegar todos anuncios
    @Query("""
        SELECT DISTINCT a FROM AnuncioPet a LEFT JOIN FETCH a.filhotes
    """)
    @RestResource(exported = true)
    fun getTodosAnuncios():List<AnuncioPet>

}