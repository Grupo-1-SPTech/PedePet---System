function cadastrarPet3() {
    fetch("http://localhost:3000/usuarios/cadastrar/vendedor", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            // id: document.getElementById("1"),
            qtdFilhotes: document.getElementById("input_quant").value,
            preco: document.getElementById("input_preco").value,
            nascimento: document.getElementById("select_semanac").value,
            foto: document.getElementById("span_foto").value,
            observacao: document.getElementById("span_observacao").value
        })
    })
    .then(res => res.json())
    .then((res) => {
        console.log(res)
        window.location = "./index.html"
    })
    .catch((err) => {
        console.log(err)
    })
    }