// validação caso estiver logado
// Recuperando o email do usuario no localStorageconst emailArmazenado = localStorage.getItem("email");

const emailArmazenado = sessionStorage.getItem("email");
console.log(emailArmazenado);

// Função para verificar o estado de login
function validaLogin() {
    // Recuperando o email do usuário no localStorage ou sessionStorage, conforme necessário
    const emailArmazenado = localStorage.getItem("email") || sessionStorage.getItem("email");

    if (emailArmazenado != null) {
        const url = `http://localhost:8080/usuarios/autenticado/${emailArmazenado}`;

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
                    console.log("aaaaaa", url)
                    profileDropdown.style.display = 'block';
                    btnLogin.style.display = 'none'; // Esconda o botão de login
                } else {
                    // O usuário não está logado, mostrar o botão de login
                    console.log("bbbb", url)
                    btnLogin.style.display = 'block';
                    profileDropdown.style.display = 'none'; // Esconda a div do perfil
                }
            })
            .catch(error => {
                console.error("Erro ao fazer a solicitação:", error);
            });
    }
}

// função select ASSUNTO 
const optionMenu = document.querySelector('.select-menu');
selectBtn = optionMenu.querySelector('.select-btn');
options = optionMenu.querySelectorAll('.option');
sBtn_text = optionMenu.querySelector('.sBtn-text');

selectBtn.addEventListener('click', () => optionMenu.classList.toggle('active'))

options.forEach(option => {
    option.addEventListener('click', () => {
        let selectedOption = option.querySelector(".option-text").innerText;
        sBtn_text.innerText = selectedOption;
        console.log(selectedOption); // valor selecionado pelo usuário

        optionMenu.classList.remove('active')
    })
});


// função select ESTADOS
const optionMenu2 = document.querySelector('.select-menu2');
selectBtn2 = optionMenu2.querySelector('.select-btn2');
options2 = optionMenu2.querySelectorAll('.option2');
sBtn_text2 = optionMenu2.querySelector('.sBtn-text2');

selectBtn2.addEventListener('click', () => optionMenu2.classList.toggle('active2'))

options2.forEach(option2 => {
    option2.addEventListener('click', () => {
        let selectedOption2 = option2.querySelector(".option-text2").innerText;
        sBtn_text2.innerText = selectedOption2;
        console.log(selectedOption2); // valor selecionado pelo usuário

        optionMenu2.classList.remove('active2')
    })
});


function entrar() {
    window.location.href = "./login.html"
}


function entrarComprador() {
    window.location = "./register_user1.html"
}

function entrarVendedor() {
    window.location = "./register_user1.html"
}

function getFilhotesAdquiridos() {
    fetch("http://localhost:8080/filhotes/adquiridos", {
        method: "GET"
    })
        .then(res => res.json())
        .then((data) => {
            filhotes_adquiridos.innerHTML = data
        }).catch((err) => {
            console.error(err);
        })
}

function getTotalVendedores() {
    fetch("http://localhost:8080/usuarios/vendedor/total", {
        method: "GET"
    })
        .then(res => res.json())
        .then((data) => {
            profissionais_cad.innerHTML = data
        }).catch((err) => {
            console.error(err);
        })
}

function getRacasDisponiveis() {
    fetch("http://localhost:8080/anuncios/racasDiponiveis", {
        method: "GET"
    })
        .then(res => res.json())
        .then((data) => {
            racas_disp.innerHTML = data
        }).catch((err) => {
            console.error(err);
        })
}

function getUsuariosTotal() {
    fetch("http://localhost:8080/usuarios/total", {
        method: "GET"
    })
        .then(res => res.json())
        .then((data) => {
            users_registrados.innerHTML = data
        }).catch((err) => {
            console.error(err);
        })
}

function buscarDados() {
    getFilhotesAdquiridos()
    getRacasDisponiveis()
    getTotalVendedores()
    getUsuariosTotal()
    validaLogin()
}

$(document).ready(function(){
    // Add smooth scrolling to all links
    $("a").on('click', function(event) {
  
      // Make sure this.hash has a value before overriding default behavior
      if (this.hash !== "") {
        // Prevent default anchor click behavior
        event.preventDefault();
  
        // Store hash
        var hash = this.hash;
  
        // Using jQuery's animate() method to add smooth page scroll
        // The optional number (800) specifies the number of milliseconds it takes to scroll to the specified area
        $('html, body').animate({
          scrollTop: $(hash).offset().top
        }, 900, function(){
  
          // Add hash (#) to URL when done scrolling (default click behavior)
          window.location.hash = hash;
        });
      } // End if
    });
  });