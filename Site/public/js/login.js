function entrar(){
    fetch("http://localhost:3000/usuarios/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            email: document.getElementById("input_email").value,
            senha: document.getElementById("input_senha").value
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
