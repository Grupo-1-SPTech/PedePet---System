function cadastrarPet1() {
fetch("http://localhost:3000/usuarios/cadastrar/vendedor", {
    method: "POST",
    headers: {
        "Content-Type": "application/json"
    },
    body: JSON.stringify({
        // id: document.getElementById("1"),
        raca: document.getElementById("select_raca").value,
        idade: document.getElementById("input_idade").value,
        porte: document.getElementById("select_porte").value,
        pedigree: document.getElementById("span_pedigree").value,
        vacina: document.getElementById("span_vacina").value
    })
})
.then(res => res.json())
.then((res) => {
    window.location = "./register_pet2.html"
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
