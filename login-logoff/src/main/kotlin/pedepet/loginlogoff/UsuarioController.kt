package pedepet.loginlogoff

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/usuariospedepet")
class UsuarioController {
    val usuarios = mutableListOf<Usuario>()

    @PostMapping
    fun post(@RequestBody novo: Usuario):String{
        if (usuarios.count {it.login == novo.login} > 0){
            return "O login ${novo.login} já existe no sistema."
        } else {
            usuarios.add(novo)
            return "Usuário ${novo.login} (${novo.nome}) cadastrado com sucesso."
        }
    }

    @DeleteMapping("/{login}")
    fun delete(@PathVariable login:String):String{
        val encontrado = usuarios.firstOrNull{ it.login == login}
                if (encontrado == null){
                    return "Usuário $login não encontrado."
                } else{
                    encontrado.autenticado = false
                    encontrado.ativo = false
                    return "Usuário $login desativado."
                }
        }

    @GetMapping
    fun get():List<UsuarioResponse>{
        val listaUsuario = usuarios.map { UsuarioResponse(it) }
        return listaUsuario
    }

    @PostMapping("/autenticacao")
    fun postAutenticacao(@RequestBody login: AutenticacaoEntradaRequest):String{
        val encontrado = usuarios.firstOrNull{ it.login == login.login && it.senha == login.senha}

        if (encontrado == null){
            return "Usuário ${login.login} não encontrado."
        } else if (!encontrado.ativo){
            return "Usuário ${login.login} não está ativo."
        } else{
            encontrado.autenticado = true
            return "Usuário ${login.login} autenticado com sucesso."
        }
    }

    @DeleteMapping("/autenticacao/{login}")
    fun deleteAutenticacao(@PathVariable login:String):String{
        val encontrado = usuarios.firstOrNull{ it.login == login}

        if (encontrado == null){
            return "Usuário $login não encontrado."
        } else{
            encontrado.autenticado = false
            return "Usuário $login fez logoff com sucesso."
        }
    }

    @PatchMapping("/senha/{login}")
    fun patch(@PathVariable login:String, @RequestBody novaSenha: SenhaEntradaRequest):String{
        val encontrado = usuarios.firstOrNull{ it.login == login}

        if (encontrado == null){
            return "Usuário $login não encontrado."
        }else {
            encontrado.senha = novaSenha.senha
            return "Senha do usuário $login alterada com sucesso."
        }
    }
}