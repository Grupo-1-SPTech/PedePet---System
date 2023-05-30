function selecionarUsuario() {
    var tipoSelecionado = document.getElementById("tipoUser").value;

    if (tipoSelecionado == "1") {
      cadastrarComprador();
      window.location.href = "../register_user2.html"
    } else if (tipoSelecionado == "2") {
      cadastrarVendedor();
      window.location.href = "../register_user2.html"
    }
}

function cadastrarComprador() {
fetch("http://localhost:3000/usuarios/cadastrar/comprador", {
    method: "POST",
    headers: {
        "Content-Type": "application/json"
    },
    body: JSON.stringify({
        // id: document.getElementById("1"),
        nome: document.getElementById("input_nome").value,
        email: document.getElementById("input_email").value,
        cpf: document.getElementById("input_cpf").value,
        numero: document.getElementById("input_numero").value,
        senha: document.getElementById("input_senha").value,
        // confSenha: document.getElementById("input_confSenha").value,
        select: document.getElementById("select_user").value
    })
})
.then(res => res.json())
.then((res) => {
    console.log(res)
})
.catch((err) => {
    console.log(err)
})
}

function cadastrarVendedor() {
fetch("http://localhost:3000/usuarios/cadastrar/vendedor", {
    method: "POST",
    headers: {
        "Content-Type": "application/json"
    },
    body: JSON.stringify({
        // id: document.getElementById("2"),
        nome: document.getElementById("input_nome").value,
        email: document.getElementById("input_email").value,
        cpf: document.getElementById("input_cpf").value,
        numero: document.getElementById("input_numero").value,
        senha: document.getElementById("input_senha").value,
        // confSenha: document.getElementById("input_confSenha").value,
        select: document.getElementById("select_user").value
    })
})
.then(res => res.json())
.then((res) => {
    console.log(res)
})
.catch((err) => {
    console.log(err)
})
}

function cadastro() {
fetch("http://localhost:3000/usuarios", {
    method: "GET"
})
.then(res => res.json())
.then((res) => {
    for (let i = 0; i < res._embedded.usuarios.length; i++) {
        console.log(res._embedded.usuarios[i])
    }
})
}
