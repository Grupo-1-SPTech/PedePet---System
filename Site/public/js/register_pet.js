// aviso de algum erro nas validações
function showSnackBar() {
    var x = document.getElementById("snackbar");
    x.className = "show";
    setTimeout(function () { x.className = x.className.replace("show", ""); }, 3000);
}

function entrar() {
    window.location.href = "./login.html"
}


// regex de verificações (verifica os caracteres de uma variavel)
const regexNumero = /^[0-9]+$/;

class formCadUser {
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

// objeto que recebe valores do cadastro de pet pt. 1
class formCadPet1 {
    constructor(titulo, racaMae, idadeMae, porteMae, pedigreeMae, vacinaMae) {
        this.titulo = titulo;
        this.racaMae = racaMae;
        this.idadeMae = idadeMae;
        this.porteMae = porteMae;
        this.pedigreeMae = pedigreeMae;
        this.vacinaMae = vacinaMae;
    }
}

// objeto que recebe valores do cadastro de pet pt. 2
class formCadPet2 {
    constructor(racaPai, idadePai, portePai, pedigreePai, vacinaPai) {
        this.racaPai = racaPai;
        this.idadePai = idadePai;
        this.portePai = portePai;
        this.pedigreePai = pedigreePai;
        this.vacinaPai = vacinaPai;
    }
}

// objeto que recebe valores do cadastro de pet pt. 3
class formCadPet3 {
    constructor(qtd, preco, dtNasc, vacinado, foto, desc) {
        this.qtd = qtd;
        this.preco = preco;
        this.dtNasc = dtNasc;
        this.vacinado = vacinado;
        this.foto = foto;
        this.desc = desc;
    }
}

// instanciando os objetos
const cadastroPetOBJT = new formCadPet1();
const cadastroPetOBJT2 = new formCadPet2();
const cadastroPetOBJT3 = new formCadPet3();
let cadastroUserOBJT = new formCadUser();



// função de validação dos campos do cadastro pet pt. 1
function validarCampoCad1() {

    cadastroUserOBJT = JSON.parse(localStorage.getItem('cadastroUserOBJT'));
    //declarando variaveis que recebem o valor dos inputs
    const titulo = document.getElementById('input_titulo').value;
    const racaMae = document.getElementById('select_raca').value;
    const idadeMae = document.getElementById('input_idade').value;
    const porteMae = document.getElementById('select_porte').value;
    const pedigreeMae = document.querySelector('.radioCertificado');
    const pedigreeNaoMae = document.querySelector('.radioCertificadoNao');
    const vacinaMae = document.querySelector('.radioVacinado');
    const vacinaNaoMae = document.querySelector('.radioVacinadoNao');

    if (titulo == "", racaMae == "" || idadeMae == "" || porteMae == "" || pedigreeMae == "" || pedigreeNaoMae == "" || vacinaMae == "" || vacinaNaoMae == "") {
        snackbar.innerHTML = "É necessário preencher todos os campos!";
        showSnackBar();
        //snackbar é o elemento que recebe uma mensagem a ser exibida ao usuário
        return
    }

    cadastroPetOBJT.titulo = titulo;

    if (cadastroPetOBJT.racaMae == "") {
        snackbar.innerHTML = "É necessário escolher a raça da mãe!";
        showSnackBar();
        return
    } else {
        cadastroPetOBJT.racaMae = racaMae;
    }

    if (regexNumero.test(idadeMae) && idadeMae.length <= 2) {
        cadastroPetOBJT.idadeMae = idadeMae;
    } else if (idadeMae > 20) {
        snackbar.innerHTML = "Idade alta demais!";
        showSnackBar();
        return
    } else {
        snackbar.innerHTML = "Idade da mãe inválida!";
        showSnackBar();
        return
    }

    if (cadastroPetOBJT.porteMae == "") {
        snackbar.innerHTML = "É necessário escolher o porte da mãe!";
        showSnackBar();
        return
    } else {
        cadastroPetOBJT.porteMae = porteMae;
    }

    if (pedigreeMae.checked) {
        cadastroPetOBJT.pedigreeMae = 1;
    } else if (pedigreeNaoMae.checked) {
        cadastroPetOBJT.pedigreeMae = 0;
    } else {
        snackbar.innerHTML = "Vacina imcompleto";
        showSnackBar();
        return
    }


    if (vacinaMae.checked) {
        cadastroPetOBJT.vacinaMae = 1;
    } else if (vacinaNaoMae.checked) {
        cadastroPetOBJT.vacinaMae = 0;
    } else {
        snackbar.innerHTML = "É necessário escolher se a mãe é vacinada ou não!";
        showSnackBar();
        return
    }

    localStorage.setItem('cadastroPetOBJT', JSON.stringify(cadastroPetOBJT));
    localStorage.setItem('cadastroUserOBJT', JSON.stringify(cadastroUserOBJT));
    console.log(cadastroPetOBJT);
    console.log(cadastroUserOBJT);
    window.location.href = "./register_pet2.html";
}


// função de validação dos campos do cadastro pet pt. 2
function validarCampoCad2() {

    const cadastroPetOBJT = JSON.parse(localStorage.getItem('cadastroPetOBJT'));
    const cadastroUserOBJT = JSON.parse(localStorage.getItem('cadastroUserOBJT'));
    console.log("recuperado");
    console.log(cadastroPetOBJT);
    console.log(cadastroPetOBJT);

    //declarando variaveis que recebem o valor dos inputs
    const racaPai = document.getElementById('select_raca').value;
    const idadePai = document.getElementById('input_idade').value;
    const portePai = document.getElementById('select_porte').value;
    const pedigreePai = document.querySelector('.radioCertificado2');
    const pedigreeNaoPai = document.querySelector('.radioCertificadoNao2');
    const vacinaPai = document.querySelector('.radioVacinado2');
    const vacinaNaoPai = document.querySelector('.radioVacinadoNao2');

    if (racaPai == "" || idadePai == "" || portePai == "" || pedigreePai == "" || pedigreeNaoPai == "" || vacinaPai == "" || vacinaNaoPai == "") {
        snackbar.innerHTML = "É necessário preencher todos os campos!";
        showSnackBar();
        //snackbar é o elemento que recebe uma mensagem a ser exibida ao usuário
        return
    }

    if (cadastroPetOBJT2.racaPai == "") {
        snackbar.innerHTML = "É necessário escolher a raça do pai!";
        showSnackBar();
        return
    } else {
        cadastroPetOBJT2.racaPai = racaPai;
    }

    if (regexNumero.test(idadePai) && idadePai.length <= 2) {
        cadastroPetOBJT2.idadePai = idadePai;
    } else if (idadePai > 20) {
        snackbar.innerHTML = "Idade muito alta!";
        showSnackBar();
        return
    } else {
        snackbar.innerHTML = "Idade do pai inválida!";
        showSnackBar();
        return
    }

    if (cadastroPetOBJT2.portePai == "") {
        snackbar.innerHTML = "É necessário escolher o porte do pai!";
        showSnackBar();
        return
    } else {
        cadastroPetOBJT2.portePai = portePai;
    }

    if (pedigreePai.checked) {
        cadastroPetOBJT2.pedigreePai = 1;
    } else if (pedigreeNaoPai.checked) {
        cadastroPetOBJT2.pedigreePai = 0;
    } else {
        snackbar.innerHTML = "Vacina imcompleto";
        showSnackBar();
        return
    }

    if (vacinaPai.checked) {
        cadastroPetOBJT2.vacinaMae = 1;
    } else if (vacinaNaoPai.checked) {
        cadastroPetOBJT2.vacinaMae = 0;
    } else {
        snackbar.innerHTML = "É necessário escolher se o pai é vacinado ou não!";
        showSnackBar();
        return
    }

    localStorage.setItem('cadastroPetOBJT', JSON.stringify(cadastroPetOBJT));
    localStorage.setItem('cadastroPetOBJT2', JSON.stringify(cadastroPetOBJT2));
    localStorage.setItem('cadastroUserOBJT', JSON.stringify(cadastroUserOBJT));
    window.location.href = "./register_pet3.html";
}


function formatCurrency(input) {
    const cleanedValue = input.value.replace(/[^\d]/g, '');

    const formattedValue = parseFloat(cleanedValue) / 100;

    input.value = formattedValue.toFixed(2);

    return formattedValue;
}


const inputPreco = document.getElementById("input_preco");

inputPreco.addEventListener("input", function () {
    const floatValue = formatCurrency(inputPreco);
});


// função de validação dos campos do cadastro pet pt. 3
function validarCampoCad3() {

    const cadastroPetOBJT = JSON.parse(localStorage.getItem('cadastroPetOBJT'));
    const cadastroPetOBJT2 = JSON.parse(localStorage.getItem('cadastroPetOBJT2'));
    const cadastroUserOBJT = JSON.parse(localStorage.getItem('cadastroUserOBJT'));

    console.log(cadastroPetOBJT);
    console.log(cadastroPetOBJT2);
    console.log(cadastroUserOBJT);

    //declarando variaveis que recebem o valor dos inputs
    const qtd = document.getElementById('input_quant').value;
    const preco = document.getElementById('input_preco').value;
    const dtNasc = document.getElementById('select_semana').value;
    const foto = document.getElementById('input_imagem').value;
    const desc = document.getElementById('txt_desc').value;
    const vacPuppy = document.getElementById('radioVacinado');
    const vacNotPuppy = document.getElementById('radioVacinadoNao');

    if (qtd == "" || preco == "" || dtNasc == "" || foto == "" || desc == "" || vacPuppy == "" || vacNotPuppy == "") {
        snackbar.innerHTML = "É necessário preencher todos os campos!";
        showSnackBar();
        return
    }

    if (!regexNumero.test(qtd)) {
        snackbar.innerHTML = "O campo 'Quantidade de filhotes' deve conter apenas números!";
        showSnackBar();
        return;
    } else {
        cadastroPetOBJT3.qtd = qtd
    }

    if (preco == "") {
        snackbar.innerHTML = "O campo 'Preço unitário' deve ser preenchido!";
        showSnackBar();
        return;
    } else {
        cadastroPetOBJT3.preco = preco
    }

    if (dtNasc == "") {
        snackbar.innerHTML = "É necessário preencher o prazo de nascimento!";
        showSnackBar();
        return;
    } else {
        cadastroPetOBJT3.dtNasc = dtNasc;
    }

    if (vacPuppy.checked) {
        cadastroPetOBJT3.vacinado = 1;
    } else if (vacNotPuppy.checked) {
        cadastroPetOBJT3.vacinado = 0;
    } else {
        snackbar.innerHTML = "É necessário escolher se os filhotes serão vacinados!";
        showSnackBar();
        return
    }

    if (foto == "") {
        snackbar.innerHTML = "Insira o URL da foto!";
        showSnackBar();
        return;
    } else {
        cadastroPetOBJT3.foto = foto;
    }

    if (desc == "") {
        snackbar.innerHTML = "Insira uma descrição do anuncio!";
        showSnackBar();
        return;
    } else {
        cadastroPetOBJT3.desc = desc;
    }

    cadastroAnuncio(cadastroUserOBJT, cadastroPetOBJT, cadastroPetOBJT2, cadastroPetOBJT3);

}

function cadastroAnuncio(cadastroUserOBJT, cadastroPetOBJT, cadastroPetOBJT2, cadastroPetOBJT3) {

    console.log(cadastroUserOBJT);

    fetch(`http://localhost:8080/cadastros/anuncio/${cadastroUserOBJT.idUsuario}`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            "titulo": cadastroPetOBJT.titulo,
            "racaMae": cadastroPetOBJT.racaMae,
            "idadeMae": cadastroPetOBJT.idadeMae,
            "porteMae": cadastroPetOBJT.porteMae,
            "pedigreeMae": cadastroPetOBJT.pedigreeMae,
            "vacinadoMae": cadastroPetOBJT.vacinaMae,
            "racaPai": cadastroPetOBJT2.racaPai,
            "idadePai": cadastroPetOBJT2.idadePai,
            "portePai": cadastroPetOBJT2.portePai,
            "pedigreePai": cadastroPetOBJT2.pedigreePai,
            "vacinadoPai": cadastroPetOBJT2.vacinaPai,
            "fotoPet": cadastroPetOBJT3.foto,
            "visualizacoes": 0,
            "qtdFilhotes": cadastroPetOBJT3.qtd,
            "descricao": cadastroPetOBJT3.desc,
            "filhote": {
                "tempoEspera": cadastroPetOBJT3.dtNasc,
                "preco": cadastroPetOBJT3.preco,
                "disponivel": true,
                "vacinaFilhote": cadastroPetOBJT3.vacinado,
                "filhotes": [
                    "string"
                ]
            }
        })
    })
        .then(res => res.json())
        .then((response) => {
            // window.location.href = "./puppys_ad.html";
            console.log(cadastroUserOBJT);
            console.log(cadastroPetOBJT);
            console.log(cadastroPetOBJT2);
            console.log(cadastroPetOBJT3);
            console.log(response);
            console.log("cadAnuncio feito");
        })
        .catch((err) => {
            console.log(cadastroUserOBJT);
            console.log(cadastroPetOBJT);
            console.log(cadastroPetOBJT2);
            console.log(cadastroPetOBJT3);
            console.log(err);
            console.log("CdAnuncio deu erro");
        })
}
