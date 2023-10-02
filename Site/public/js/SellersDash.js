// validação caso estiver logado
// Recuperando o email do usuario no localStorageconst emailArmazenado = localStorage.getItem("email");


const emailArmazenado = localStorage.getItem("email");
console.log(emailArmazenado);

// Função para verificar o estado de login
function validaLogin() {
    // Recuperando o email do usuário no localStorage ou sessionStorage, conforme necessário
    const emailArmazenado = localStorage.getItem("email");
    const profileDropdown = document.querySelector('.profile-dropdown-btn');
    const btnLogin = document.querySelector('.btn-login');

    if (emailArmazenado != null) {
        const url = `http://localhost:8080/usuarios/autenticado/${emailArmazenado}`;
        console.log(url)

        fetch(url, {
            method: "GET",
            headers: {
                "Content-Type": "application/json"
            },
            timeout: 5000,
        })
            .then(response => {
                if (response.ok) {
                    console.log("foi")
                    return response.json(); // Converte a resposta para JSON
                } else {
                    throw new Error("Erro na solicitação");
                }
            })
            .then(data => {
                // O objeto 'data' contém os dados retornados da API como um objeto JavaScript
                console.log("Dados retornados:", data);

                // Adicione esta parte para mostrar o botão de login ou a div do perfil com base no estado de login
                const profileDropdown = document.querySelector('.profile-dropdown');
                const btnLogin = document.querySelector('.btn-login');

                if (emailArmazenado !== null) {
                    // O usuário está logado, mostrar a div do perfil
                    console.log("Mostrando botão de perfil", url)
                    profileDropdown.style.display = 'block';
                    btnLogin.style.display = 'none'; // Esconda o botão de login
                } else {
                    // O usuário não está logado, mostrar o botão de login
                    console.log("Mostrando botão de entrar", url)
                    btnLogin.style.display = 'block';
                    profileDropdown.style.display = 'none'; // Esconda a div do perfil
                }
            })
            .catch(error => {
                console.error("Erro ao fazer a solicitação:", error);
            });
    }

    if (emailArmazenado != null) {
        // O usuário está logado, mostrar o botão do perfil
        profileDropdown.style.display = 'block';
        btnLogin.style.display = 'none'; // Esconder o botão de login
    } else {
        // O usuário não está logado, mostrar o botão de login
        btnLogin.style.display = 'block';
        profileDropdown.style.display = 'none'; // Esconder o botão do perfil
    }
}

function logoff(Id) {
    // Limpar o email armazenado no localStorage
    localStorage.removeItem("email");

    // Fazer uma solicitação ao servidor para efetuar o logoff (se necessário)
    // Você pode fazer uma solicitação DELETE para um endpoint de logoff no servidor
    const url = `http://localhost:8080/logoff/${Id}`;

    fetch(url, {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json"
        }
    })
    .then(response => {
        if (response.ok) {
            // O logoff foi bem-sucedido
            // Redirecionar o usuário para a página de login ou outra página apropriada
            window.location.href = "./login.html";
        } else {
            console.error("Erro ao efetuar o logoff no servidor.");
        }
    })
    .catch(error => {
        console.error("Erro ao fazer a solicitação de logoff:", error);
    });
}

//insert de anuncios pet
async function buscarAnuncios(){
    const resposta = await fetch("http://localhost:8080/anuncios/total");

    const getResposta = await resposta.json();
    console.log(getResposta);

    const boxAnuncio = document.getElementById('box_anuncio');

    boxAnuncio.innerHTML = getResposta.map(function(anuncio){
        const precoFilhote = anuncio.filhotes[0].preco.toLocaleString('pt-BR', { minimumFractionDigits: 2 });
        const tempoEsperaFilhote = anuncio.filhotes[0].tempoEspera;

        return `<div class="ex-card">
                    <div class="img-pet"><img class="img-puppy" src="${anuncio.fotoPet}" alt=""></div>
                    <div class="content-card">
                        <h3>${anuncio.racaMae}</h3>
                        <p id="mes">${tempoEsperaFilhote}</p>
                        <p id="preco">R$ ${precoFilhote}</p>
                        <div class="fila-local">
                            <p id="fila">${anuncio.qtdFilhotes}/${anuncio.qtdFilhotes} Fila de espera</p>
                            <p id="local">SP</p>
                        </div>
                    </div>
                    <div class="btn-fila">
                    <button onclick="entrarFila('${anuncio.id}')" class="entrar-fila" id="entrar-fila">Entrar na fila</button>
                    </div>
                </div>`
    }).join('');
}

// //insert de anuncios pet
// async function buscarAnuncios(email){
//     var email = localStorage.getItem("email");
//     const resposta = await fetch("http://localhost:8080/info/${email}");

//     const getResposta = await resposta.json();
//     console.log(getResposta);

//     const boxAnuncio = document.getElementById('box_anuncio');

//     boxAnuncio.innerHTML = getResposta.map(function(anuncio){
//         const precoFilhote = anuncio.filhotes[0].preco.toLocaleString('pt-BR', { minimumFractionDigits: 2 });
//         const tempoEsperaFilhote = anuncio.filhotes[0].tempoEspera;

//         return `<div class="ex-card">
//                     <div class="img-pet"><img class="img-puppy" src="${anuncio.fotoPet}" alt=""></div>
//                     <div class="content-card">
//                         <h3>${anuncio.racaMae}</h3>
//                         <p id="mes">${tempoEsperaFilhote}</p>
//                         <p id="preco">R$ ${precoFilhote}</p>
//                         <div class="fila-local">
//                             <p id="fila">${anuncio.qtdFilhotes}/${anuncio.qtdFilhotes} Fila de espera</p>
//                             <p id="local">SP</p>
//                         </div>
//                     </div>
//                     <div class="btn-fila">
//                     <button onclick="entrarFila('${anuncio.id}')" class="entrar-fila" id="entrar-fila">Entrar na fila</button>
//                     </div>
//                 </div>`
//     }).join('');
// }

// function entrarFila(idAnuncio) {
//     window.location.href = `./anuncio_pet1.html?id=${idAnuncio}`;
//     console.log(idAnuncio);
// }

// function buscarDados() {
//     buscarAnuncios();
// }