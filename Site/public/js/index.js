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
}


