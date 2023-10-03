function isElementInViewport(el) {
    const rect = el.getBoundingClientRect();
    return (
        rect.top >= 0 &&
        rect.left >= 0 &&
        rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) &&
        rect.right <= (window.innerWidth || document.documentElement.clientWidth)
    );
}

function startCounterWhenVisible(element, endValue, duration) {
    let startValue = 0;
    let interval = duration / endValue;

    function updateCounter() {
        element.textContent = startValue;
        startValue++;
        if (startValue <= endValue) {
            requestAnimationFrame(updateCounter);
            setTimeout(() => {
            }, duration);
        }
    }

    requestAnimationFrame(updateCounter);
}

const countedElements = new Set();

function checkElementVisibility() {
    const elements = document.querySelectorAll(".value_metrica");

    elements.forEach((element) => {
        if (isElementInViewport(element) && !countedElements.has(element)) {
            const endValue = parseInt(element.getAttribute("data-val"), 10);
            const duration = Math.min(5000, endValue * 1000); // Limita a duração a 5000ms ou ao valor máximo necessário
            startCounterWhenVisible(element, endValue, duration);
            countedElements.add(element);
        }
    });
}

window.addEventListener("scroll", checkElementVisibility);

checkElementVisibility();

// botao perfil
let profileDropdownList = document.querySelector('.profile-dropdown-list');
let btn = document.querySelector('.profile-dropdown-btn');
let modoBtn = document.querySelector('dark-mode');
let daltonismoBtn = document.querySelector('daltonismo');
let configBtn = document.querySelector('config');
let sairBtn = document.querySelector('logout');

const toggle = () => profileDropdownList.classList.toggle('active');

window.addEventListener('click', function (e) {
    if (!btn.contains(e.target) && !profileDropdownList.contains(e.target)) {
        profileDropdownList.classList.remove('active');
    }
});

// troca de temar dark mode
const btnDarkMode = document.getElementById('btn-dark-mode-toggle')
const themeSystem = localStorage.getItem("themeSystem") || "light"

btnDarkMode.addEventListener('click', () => {
    let oldTheme = localStorage.getItem("themeSystem") || "light"
    let newTheme = oldTheme === "light" ? "dark" : "light"

    localStorage.setItem("themeSystem", newTheme)
    defineCurrentTheme(newTheme)
})

function defineCurrentTheme(theme) {
    document.documentElement.setAttribute("data-theme", theme)
    if(theme == "light")
    {

    }
}

function entrar() {
    window.location.href = "./login.html"
}

// tema ficar no localStorage
const colorThemes = document.querySelectorAll('[name="theme"]');

//store theme
const storeTheme = function(theme) {
    localStorage.setItem("theme", theme);
}

const setTheme = function() {
    const activeTheme = localStorage.getItem("theme");
    colorThemes.forEach((themeOption) => {
        if(themeOption.id === activeTheme){
            themeOption.checked = true;
        }
    });
    document.documentElement.className = theme;
};

colorThemes.forEach(themeOption => {
    themeOption.addEventListener('click', () => {
        storeTheme(themeOption.id);    
    });
});

document.onload = setTheme();


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
            const filhotes_adquiridos = document.getElementById("filhotes_adquiridos");
            filhotes_adquiridos.setAttribute("data-val", data); // Define o atributo "data-val"
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
            const profissionais_cad = document.getElementById("profissionais_cad");
            profissionais_cad.setAttribute("data-val", data); // Define o atributo "data-val"
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
            const racas_disp = document.getElementById("racas_disp");
            racas_disp.setAttribute("data-val", data); // Define o atributo "data-val"
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
            const users_registrados = document.getElementById("users_registrados");
            users_registrados.setAttribute("data-val", data); // Define o atributo "data-val"
        }).catch((err) => {
            console.error(err);
        })
}

$(document).ready(function () {
    // Add smooth scrolling to all links
    $("a").on('click', function (event) {

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
            }, 900, function () {

                // Add hash (#) to URL when done scrolling (default click behavior)
                window.location.hash = hash;
            });
        } // End if
    });
});

function buscarDados() {
    getFilhotesAdquiridos()
    getRacasDisponiveis()
    getTotalVendedores()
    getUsuariosTotal()
    validaLogin()
}

$(document).ready(function () {
    // Add smooth scrolling to all links
    $("a").on('click', function (event) {

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
            }, 900, function () {

                // Add hash (#) to URL when done scrolling (default click behavior)
                window.location.hash = hash;
            });
        } // End if
    });
});