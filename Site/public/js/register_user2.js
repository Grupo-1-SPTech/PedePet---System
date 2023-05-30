function selecionarUsuario2() {
    var tipoSelecionado = document.getElementById("tipoUser").value;

    if (tipoSelecionado == "1") {
      cadastrarComprador2();
      window.location.href = "../register_user3.html"
    } else if (tipoSelecionado == "2") {
      cadastrarVendedor2();
      window.location.href = "../register_pet1.html"
    }
}


function cadastrarComprador2() {
fetch("http://localhost:3000/usuarios/cadastrar/comprador", {
    method: "POST",
    headers: {
        "Content-Type": "application/json"
    },
    body: JSON.stringify({
        // id: document.getElementById("1"),
        cep: document.getElementById("input_cep").value,
        endereco: document.getElementById("input_end").value,
        num: document.getElementById("input_cpf").value,
        uf: document.getElementById("input_numero").value,
        cidade: document.getElementById("input_cidade").value,
        bairro: document.getElementById("input_bairro").value,
        complemento: document.getElementById("input_comp").value
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

function cadastrarVendedor2() {
fetch("http://localhost:3000/usuarios/cadastrar/vendedor", {
    method: "POST",
    headers: {
        "Content-Type": "application/json"
    },
    body: JSON.stringify({
        // id: document.getElementById("2"),
        cep: document.getElementById("input_cep").value,
        endereco: document.getElementById("input_end").value,
        num: document.getElementById("input_cpf").value,
        uf: document.getElementById("input_numero").value,
        cidade: document.getElementById("input_cidade").value,
        bairro: document.getElementById("input_bairro").value,
        complemento: document.getElementById("input_comp").value
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
