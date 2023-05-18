function controller() {
    fetch("http://localhost:8080/usuarios/controller/demo", {
        method: "GET"
    })
    .then(res => res.text())
    .then((res) => {
        console.log(res)
    })
}

function usuarios() {
    fetch("http://localhost:8080/usuarios", {
        method: "GET"
    })
    .then(res => res.json())
    .then((res) => {
        for (let i = 0; i < res._embedded.usuarios.length; i++) {
            console.log(res._embedded.usuarios[i])
        }
    })
}

function cadastro() {
    fetch("http://localhost:8080/usuarios", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            nome: document.getElementById("nome").value,
            email: document.getElementById("email").value,
            senha: document.getElementById("senha").value
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