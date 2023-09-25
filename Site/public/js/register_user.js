// const { resp } = require("express");

// aviso de algum erro nas validações
function showSnackBar() {
    var x = document.getElementById("snackbar");
    x.className = "show";
    setTimeout(function () { x.className = x.className.replace("show", ""); }, 3000);
}

// regex de verificações (verifica os caracteres de uma variavel)
const regexLetra = /^[a-zA-Z]+(?:\s[a-zA-Z]+)*$/;
const regexNumero = /^[0-9]+$/;
const regexEmail = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
const regexSenha = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;

// objeto que recebe valores do Cadastro de usuário Pt1
class formCadPt1 {
    constructor(nome, email, cpf, telefone, senha, tipoUser, idUsuario) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.senha = senha;
        this.tipoUser = tipoUser;
        this.idUsuario = idUsuario;
    }
}

// objeto que recebe valores do Cadastro de usuário Pt2
class formCadPt2 {
    constructor(cep, endereco, numero, uf, cidade, bairro, complemento) {
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.uf = uf;
        this.cidade = cidade;
        this.bairro = bairro;
        this.complemento = complemento;
    }
}

// objeto que recebe valores do Cadastro de usuário Pt3
class formCadPt3 {
    constructor(moradia, comodos, residentes, horasCasa, tevePet) {
        this.moradia = moradia;
        this.comodos = comodos;
        this.residentes = residentes;
        this.horasCasa = horasCasa;
        this.tevePet = tevePet;
    }
}

// instanciando os objetos
const cadastroUserOBJT = new formCadPt1();
const cadastroUserOBJT2 = new formCadPt2();
const cadastroUserOBJT3 = new formCadPt3();

// função de validação dos campos do cadastro pt1
function validarCampoCad1() {

    //declarando variaveis que recebem o valor dos inputs
    const nome = document.getElementById('input_nome').value;
    const email = document.getElementById('input_email').value;
    const cpf = document.getElementById('input_cpf').value;
    const telefone = document.getElementById('input_telefone').value;
    const senha = document.getElementById('input_senha').value;
    const confSenha = document.getElementById('input_confSenha').value;

    if (nome == "" || email == "" || cpf == "" || telefone == "" || senha == "" || confSenha == "") {
        snackbar.innerHTML = "É necessário preencher todos os campos";
        showSnackBar();
        //snackbar é o elemento que recebe uma mensagem a ser exibida ao usuário
        return
    }

    if (regexLetra.test(nome) || nome != null) { // testando se o nome contem somente caracteres definido no regex
        cadastroUserOBJT.nome = nome;
    } else if (nome.length < 4) {
        snackbar.innerHTML = "Nome muito curto!";
        showSnackBar();
        return
    } else {
        snackbar.innerHTML = "Nome inválido!";
        showSnackBar();
        return
    }

    if (regexEmail.test(email)) {
        cadastroUserOBJT.email = email;
    } else {
        snackbar.innerHTML = "Email inválido!";
        console.log("erro aqui")
        showSnackBar();
        return
    }

    if (regexNumero.test(cpf) && cpf.length == 11) {
        cadastroUserOBJT.cpf = cpf;
    } else {
        snackbar.innerHTML = "CPF inválido!";
        showSnackBar();
        return
    }

    if (regexNumero.test(telefone) && telefone.length == 11) {
        cadastroUserOBJT.telefone = telefone;
    } else if (telefone.length == 9) {
        snackbar.innerHTML = "Favor inserir DDD";
        showSnackBar();
        return
    } else {
        snackbar.innerHTML = "Telefone inválido!";
        showSnackBar();
        return
    }

    if (senha.length < 8 || !regexSenha.test(senha)) {
        snackbar.innerHTML = "Senha inválida!";
        showSnackBar();

        var aviso = document.getElementById('span_dica');
        // exibe dica de senha
        aviso.style.display = 'block';
        return

    } else if (senha != confSenha || confSenha == "") {
        snackbar.innerHTML = "Senhas não correspondem";
        showSnackBar();
        return
    } else {
        cadastroUserOBJT.senha = senha;
    }

    if (cadastroUserOBJT.tipoUser == undefined) {
        snackbar.innerHTML = "É necessário escolher o usuário";
        showSnackBar();
        return
    }

    if (cadastroUserOBJT.tipoUser == 'Vendedor') {
        cadastroVendedor(cadastroUserOBJT);
    } else if (cadastroUserOBJT.tipoUser == 'Comprador') {
        cadastroComprador(cadastroUserOBJT);
    }
}


// função de validação dos campos do cadastro pt2
function validarCampoCad2() {

    const cadastroUserOBJT = JSON.parse(localStorage.getItem('cadastroUserOBJT'));
    console.log(cadastroUserOBJT);

    //declarando variaveis que recebem o valor dos inputs
    const cep = document.getElementById("input_cep").value;
    const endereco = document.getElementById("input_endereco").value;
    const numero = document.getElementById("input_numero").value;
    const cidade = document.getElementById("input_cidade").value;
    const bairro = document.getElementById("input_bairro").value;
    const complemento = document.getElementById("input_complemento").value

    if (cep == "" || endereco == "" || numero == "" || cidade == "" || bairro == "" || complemento == "") {
        snackbar.innerHTML = "É neessário preencher todos os campos";
        showSnackBar();
        //snackbar é o elemento que recebe uma mensagem a ser exibida ao usuário
        return
    }

    if (!regexNumero.test(cep) || cep.length < 8) { // lembrando que caso exista "!" no começo na condição do IF, significa que estou validando o oposto
        // nesse caso, valido: Caso cep NÃO estiver de acordo o regex OU for menor que 8, ele é invalido
        snackbar.innerHTML = "CEP inválido!";
        showSnackBar();
        return
    } else if (cep.length > 8) {
        snackbar.innerHTML = "Apenas números em CEP!";
        showSnackBar();
        return
    } else {
        cadastroUserOBJT2.cep = cep;
    }

    if (!regexLetra.test(endereco)) {
        snackbar.innerHTML = "Endereço inválido!";
        showSnackBar();
        return
    } else {
        cadastroUserOBJT2.endereco = endereco;
    }

    if (!/^[a-zA-Z0-9]+$/.test(numero)) { // testando se o numero não tem caracteres especias, pois pode haver um numero personalizado, como 1238A oi 1238B
        snackbar.innerHTML = "Número residencial inválido!"
        showSnackBar();
        return
    } else {
        cadastroUserOBJT2.numero = numero;
    }

    if (cadastroUserOBJT2.uf == null) {
        snackbar.innerHTML = "É necessário selecionar UF!"
        showSnackBar();
        return
    }

    if (/^[\p{L}\p{N}\s\p{M}]+$/.test(cidade)) {
        snackbar.innerHTML = "Cidade inválida!"
        showSnackBar();
        return
    } else {
        cadastroUserOBJT2.cidade = cidade;
    }

    if (/^[\p{L}\p{N}\s\p{M}]+$/.test(bairro)) {
        snackbar.innerHTML = "Bairro inválido!"
        showSnackBar();
        return
    } else {
        cadastroUserOBJT2.bairro = bairro;
    }

    if (complemento.length > 30) {
        snackbar.innerHTML = "Complemento deve ter menos de 30 caracteres"
        showSnackBar();
        return
    } else {
        cadastroUserOBJT2.complemento = complemento;
    }

    if (cadastroUserOBJT.idUsuario) {
        if (cadastroUserOBJT.tipoUser == "Vendedor") {

            console.log(cadastroUserOBJT);
            cadastroEndereco(cadastroUserOBJT, cadastroUserOBJT2);


        } else if (cadastroUserOBJT.tipoUser == "Comprador") {

            console.log(cadastroUserOBJT);
            cadastroEndereco(cadastroUserOBJT, cadastroUserOBJT2);
        }
    } else {
        console.log("não obteve id na primeira etapa");
        snackbar.innerHTML = "Houve um erro no cadastro"
    }
}


function validarCampoCad3() {

    const cadastroUserOBJT = JSON.parse(localStorage.getItem('cadastroUserOBJT'));

    console.log(cadastroUserOBJT);

    const radioTevePet = document.querySelector('.radioTevePet');
    const radioNaoTevePet = document.querySelector('.radioNaoTevePet');

    // Verificar qual radio button foi selecionado
    if (radioTevePet.checked) {
        // O usuário selecionou o radio button "Sim"
        cadastroUserOBJT3.tevePet = true;
        console.log("Opção selecionada: Sim");
    } else if (radioNaoTevePet.checked) {
        // O usuário selecionou o radio button "Não"
        cadastroUserOBJT3.tevePet = false;
        console.log("Opção selecionada: Não");
    }


    if (cadastroUserOBJT3.tevePet == undefined || cadastroUserOBJT3.moradia == undefined || cadastroUserOBJT3.comodos == undefined || cadastroUserOBJT3.residentes == undefined || cadastroUserOBJT3.horasCasa == undefined) {
        snackbar.innerHTML = "É necessário preencher todos os campos";
        showSnackBar();
        return
    } else {
        cadastroFormulario(cadastroUserOBJT, cadastroUserOBJT3);
    }
}

function cadastroVendedor(cadastroUserOBJT) {

    console.log(cadastroUserOBJT);

    // Cadastro de usuario (vendedor)
    fetch("http://localhost:8080/cadastros/usuario", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            "nome": cadastroUserOBJT.nome,
            "email": cadastroUserOBJT.email,
            "cpf": cadastroUserOBJT.cpf,
            "telefone": cadastroUserOBJT.telefone,
            "senha": cadastroUserOBJT.senha,
            "tipoUsuario": 2,
            "autenticado": true
        })
    })
        .then(res => res.json())
        .then((response) => {
            cadastroUserOBJT.idUsuario = response;
            console.log(cadastroUserOBJT.idUsuario);
            localStorage.setItem('cadastroUserOBJT', JSON.stringify(cadastroUserOBJT));
            window.location.href = "./register_user2.html";
        })
        .catch((err) => {
            console.log(err);
            console.log("email existe");
            snackbar.innerHTML = "Email existente! Redirecionando para login";
            showSnackBar();
            setTimeout(function () {
                window.location.href = "./login.html";
            }, 3500);
        })
}

function cadastroComprador(cadastroUserOBJT) {

    console.log(cadastroUserOBJT);
    // Cadastro de usuario (comprador)
    fetch("http://localhost:8080/cadastros/usuario", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            "nome": cadastroUserOBJT.nome,
            "email": cadastroUserOBJT.email,
            "cpf": cadastroUserOBJT.cpf,
            "telefone": cadastroUserOBJT.telefone,
            "senha": cadastroUserOBJT.senha,
            "tipoUsuario": 1,
            "autenticado": true
        })
    })
        .then(res => res.json())
        .then((response) => {
            cadastroUserOBJT.idUsuario = response;
            console.log(cadastroUserOBJT.idUsuario);
            localStorage.setItem('cadastroUserOBJT', JSON.stringify(cadastroUserOBJT));
            window.location.href = "./register_user2.html";
        })
        .catch((err) => {
            console.log(err);
            console.log("email existe");
            snackbar.innerHTML = "Email existente! Redirecionando para login";
            showSnackBar();
            setTimeout(function () {
                window.location.href = "./login.html";
            }, 3500);
        })
}

function cadastroEndereco(cadastroUserOBJT, cadastroUserOBJT2) {

    // cadastro usuario pt2 (endereço)
    fetch(`http://localhost:8080/cadastros/endereco/${cadastroUserOBJT.idUsuario}`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            "cep": cadastroUserOBJT2.cep,
            "rua": cadastroUserOBJT2.endereco,
            "numero": cadastroUserOBJT2.numero,
            "complemento": cadastroUserOBJT2.complemento,
            "bairro": cadastroUserOBJT2.bairro,
            "cidade": cadastroUserOBJT2.cidade,
            "estado": cadastroUserOBJT2.uf
        })
    })
        .then((res) => {
            console.log("id retornado", res);

            if (cadastroUserOBJT.tipoUser == "Vendedor") {
                window.location.href = "./register_pet1.html";

            } else if (cadastroUserOBJT.tipoUser == "Comprador") {
                window.location.href = "./register_user3.html";
            }
        })
        .catch((err) => {
            console.log(err)
            console.log("erro fetch pagina 2");
        })
}

function cadastroFormulario(cadastroUserOBJT, cadastroUserOBJT3) {

    console.log("estou no 3 func");
    console.log(cadastroUserOBJT);

    // cadastro usuario pt2 (endereço)
    fetch(`http://localhost:8080/cadastros/formulario/${cadastroUserOBJT.idUsuario}`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            "tipoMoradia": cadastroUserOBJT3.moradia,
            "qtdComodos": cadastroUserOBJT3.comodos,
            "qtdMoradores": cadastroUserOBJT3.residentes,
            "qtdHorasCasa": cadastroUserOBJT3.horasCasa,
            "possuiPet": cadastroUserOBJT3.tevePet,
            "statusForms": 0
        })
    })
        .then((res) => {
            window.location.href = "./puppys_ad.html";
        })
        .catch((err) => {
            console.log(err)
            console.log("erro fetch pagina 3");
        })
}

if (document.querySelector('.select-menu') != null) {
    const optionMenu = document.querySelector('.select-menu');
    selectBtn = optionMenu.querySelector('.select-btn');
    options = optionMenu.querySelectorAll('.option');
    sBtn_text = optionMenu.querySelector('.sBtn-text');

    selectBtn.addEventListener('click', () => optionMenu.classList.toggle('active'))

    options.forEach(option => {
        option.addEventListener('click', () => {
            let selectedOption = option.querySelector(".option-text").innerText;
            sBtn_text.innerText = selectedOption;
            optionMenu.classList.remove('active')
            cadastroUserOBJT.tipoUser = selectedOption; // "selectedOption" representa a variavel que recebe a opção que o usuário escolheu

            // nesse caso, a função é utilizada na pt1, e armazenada no objeto 1

            if (cadastroUserOBJT.tipoUser != null) { // aqui valido, se a função já foi usada na pt1, significa qu estamos na segunda
                cadastroUserOBJT2.uf = selectedOption; // sendo assim, inserimos oque foi selecionado na pt2 no objeto 2
            }
        })
    });
}

// as constantes e for each abaixo se destina aos dropdowns da pt3 respectivamente, é necessario duplicar uma função para cada por estarem na mesma pagina
// dropdown moradia
if (window.location.pathname === "/register_user3.html") {
    const optionMenu1 = document.querySelector('.select-menu1');
    selectBtn1 = optionMenu1.querySelector('.select-btn1');
    options1 = optionMenu1.querySelectorAll('.option1');
    sBtn_text1 = optionMenu1.querySelector('.sBtn-text1');

    selectBtn1.addEventListener('click', () => optionMenu1.classList.toggle('active1'))

    options1.forEach(option1 => {
        option1.addEventListener('click', () => {
            let selectedOption1 = option1.querySelector(".option-text1").innerText;
            sBtn_text1.innerText = selectedOption1;
            cadastroUserOBJT3.moradia = selectedOption1; // valor selecionado pelo usuário

            optionMenu1.classList.remove('active1')
        })
    });

    // dropdown comodos da casa
    const optionMenu2 = document.querySelector('.select-menu2');
    selectBtn2 = optionMenu2.querySelector('.select-btn2');
    options2 = optionMenu2.querySelectorAll('.option2');
    sBtn_text2 = optionMenu2.querySelector('.sBtn-text2');

    selectBtn2.addEventListener('click', () => optionMenu2.classList.toggle('active2'))

    options2.forEach(option2 => {
        option2.addEventListener('click', () => {
            let selectedOption2 = option2.querySelector(".option-text2").innerText;
            sBtn_text2.innerText = selectedOption2;
            cadastroUserOBJT3.comodos = selectedOption2; // valor selecionado pelo usuário

            optionMenu2.classList.remove('active2')
        })
    });

    // dropdown residentes
    const optionMenu3 = document.querySelector('.select-menu3');
    selectBtn3 = optionMenu3.querySelector('.select-btn3');
    options3 = optionMenu3.querySelectorAll('.option3');
    sBtn_text3 = optionMenu3.querySelector('.sBtn-text3');

    selectBtn3.addEventListener('click', () => optionMenu3.classList.toggle('active3'))

    options3.forEach(option3 => {
        option3.addEventListener('click', () => {
            let selectedOption3 = option3.querySelector(".option-text3").innerText;
            sBtn_text3.innerText = selectedOption3;
            cadastroUserOBJT3.residentes = selectedOption3; // valor selecionado pelo usuário

            optionMenu3.classList.remove('active3')
        })
    });

    // dropdown horas em casa
    const optionMenu4 = document.querySelector('.select-menu4');
    selectBtn4 = optionMenu4.querySelector('.select-btn4');
    options4 = optionMenu4.querySelectorAll('.option4');
    sBtn_text4 = optionMenu4.querySelector('.sBtn-text4');

    selectBtn4.addEventListener('click', () => optionMenu4.classList.toggle('active4'))

    options4.forEach(option4 => {
        option4.addEventListener('click', () => {
            let selectedOption4 = option4.querySelector(".option-text4").innerText;
            sBtn_text4.innerText = selectedOption4;
            cadastroUserOBJT3.horasCasa = selectedOption4; // valor selecionado pelo usuário

            optionMenu4.classList.remove('active4')
        })
    });

}

function entrar() {
    window.location.href = "./login.html"
}