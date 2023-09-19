const email = localStorage.getItem("email");

function inAlterarEmail() {
    
}

function buscaInfoUser() {
    const email = localStorage.getItem("email");

    fetch(`http://localhost:8080/usuarios/info/${email}`, {
        method: "GET"
    })
    .then(res => res.json())
    .then((data) => {
        const userInfo = data;
        console.log(userInfo);

        let inNome = document.getElementById("nomeUser");
        let inEmail = document.getElementById("emailUser");
        let inTelefone = document.getElementById("telUser");
        let inRua = document.getElementById("ruaUser");
        let inNumero = document.getElementById("nmrUser");
        let inBairro = document.getElementById("bairroUser");
        let inCidade = document.getElementById("cidUser");
        let inEstado = document.getElementById("estadoUser");

        inAlterarEmail = document.getElementById("emailProfile");

        inNome.innerHTML = userInfo.usuario.nome;
        inEmail.innerHTML = userInfo.usuario.email;
        inTelefone.innerHTML = userInfo.usuario.telefone;
        inRua.innerHTML = userInfo.endereco.rua
        inNumero.innerHTML = userInfo.endereco.numero;
        inBairro.innerHTML = userInfo.endereco.bairro;
        inCidade.innerHTML = userInfo.endereco.cidade;
        inEstado.innerHTML = userInfo.endereco.estado;

        inAlterarEmail.placeholder = userInfo.usuario.email;

    })
    .catch((err) => {
        console.error(err);
    });
}
