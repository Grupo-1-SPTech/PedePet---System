var email = localStorage.getItem("email");
const regexEmail = /^[\w.-]+@[a-zA-Z]+\.[a-zA-Z]{2,}$/;

function fecharModal() {
    let modal = document.getElementById("modal");
    let backModal = document.getElementById("backModal");
    modal.style.display = "none";
    backModal.style.display = "none";

    document.body.classList.remove("modal-open");

    var novoEmail = document.getElementById("novoEmail");
    var senha = document.getElementById("senhaUser");
    novoEmail.value = "";
    senha.value = "";
}


function abrirModal() {
    let modal = document.getElementById("modal");
    let backModal = document.getElementById("backModal");

    backModal.style.display = "flex";
    modal.style.display = "flex";

    document.body.classList.add("modal-open");
}


function alterarEmail(email) {
    const novoEmail = document.getElementById("novoEmail").value;
    const senha = document.getElementById("senhaUser").value;

    if (!regexEmail.test(email) || email == "") {
        showSnackBar("Email inválido!");
    } else if (senha == "") {
        showSnackBar("senha inválida!");
    }

    fetch(`http://localhost:8080/usuarios/alterar/${email}?emailNovo=${novoEmail}&senha=${senha}`, {
        method: "GET"
    })
        .then(response => {
            if (response.status === 200) {
                console.log("Email alterado com sucesso!");
                fetch(`http://localhost:8080/usuarios/info/${email}`, {
                    method: "GET"
                })
                    .then(res => res.json())
                    .then((data) => {
                        const userInfo = data;
                        email = userInfo.usuario.email;
                        const inAlterarEmail = document.getElementById("emailProfile");
                        inAlterarEmail.placeholder = email;
                        localStorage.setItem("email", email);
                    })
                    .catch((err) => {
                        console.error(err);
                    });
            } else {
                showSnackBar("Senha inválida!");
            }
        })
        .catch(error => {
            console.error("Erro ao enviar solicitação: ", error);
        });
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


function showSnackBar(message) {
    var x = document.getElementById("snackbar");
    x.innerHTML = message;
    x.className = "show";
    setTimeout(function () { x.className = x.className.replace("show", ""); }, 3000);
}