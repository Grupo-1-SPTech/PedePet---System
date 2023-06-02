document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("btn-entrar").addEventListener("click", entrar);
});

function entrar() {
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
            console.log(res);
            // Faça algo com a resposta do servidor, como redirecionar para outra página
            // ou exibir uma mensagem de sucesso.
        })
        .catch((err) => {
            console.log(err);
            // Trate o erro, por exemplo, exibindo uma mensagem de erro para o usuário.
        });
}