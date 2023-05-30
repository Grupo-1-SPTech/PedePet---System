function cadastrarComprador3() {
fetch("http://localhost:3000/usuarios/cadastrar/comprador", {
    method: "POST",
    headers: {
        "Content-Type": "application/json"
    },
    body: JSON.stringify({
        // id: document.getElementById("1"),
        moradia: document.getElementById("select_moradia").value,
        comodos: document.getElementById("select_comodos").value,
        residentes: document.getElementById("select_residentes").value,
        horasCasa: document.getElementById("select_horas").value,
        tevePet: document.getElementById("span_pedigree").value
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
