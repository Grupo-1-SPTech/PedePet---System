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


const emailArmazenado = sessionStorage.getItem("email");
console.log(emailArmazenado);

function validaLogin() {

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
                // Faça algo com os dados, como atualizar a interface do usuário
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