// aviso de algum erro nas validações
function showSnackBar() {
    var x = document.getElementById("snackbar");
    x.className = "show";
    setTimeout(function () { x.className = x.className.replace("show", ""); }, 3000);
}

// regex de verificações (verifica os caracteres de uma variavel)
const regexNumero = /^[0-9]+$/;

// objeto que recebe valores do cadastro de pet pt. 1
class formCadPet1 {
    constructor(racaMae, idadeMae, porteMae, pedigreeMae, pedigreeNaoMae, vacinaMae, vacinaNaoMae) {
        this.racaMae = racaMae;
        this.idadeMae = idadeMae;
        this.porteMae = porteMae;
        this.pedigreeMae = pedigreeMae;
        this.pedigreeNaoMae = pedigreeNaoMae;
        this.vacinaMae = vacinaMae;
        this.vacinaNaoMae = vacinaNaoMae;
    }
}

// objeto que recebe valores do cadastro de pet pt. 2
class formCadPet2 {
    constructor(racaPai, idadePai, portePai, pedigreePai, pedigreeNaoPai, vacinaPai, vacinaNaoPai) {
        this.racaPai = racaPai;
        this.idadePai = idadePai;
        this.portePai = portePai;
        this.pedigreePai = pedigreePai;
        this.pedigreeNaoPai = pedigreeNaoPai;
        this.vacinaPai = vacinaPai;
        this.vacinaNaoPai = vacinaNaoPai
    }
}

// objeto que recebe valores do cadastro de pet pt. 3
class formCadPet3 {
    constructor(quant, preco, nasc, foto, descric) {
        this.quant = quant;
        this.preco = preco;
        this.nasc = nasc;
        this.foto = foto;
        this.descric = descric;
    }
}

// instanciando os objetos
const cadastroPetOBJT = new formCadPet1();
const cadastroPetOBJT2 = new formCadPet2();
const cadastroPetOBJT3 = new formCadPet3();

// função de validação dos campos do cadastro pet pt. 1
function validarCampoCad1() {

    //declarando variaveis que recebem o valor dos inputs
    const racaMae = document.getElementById('select_raca').value;
    const idadeMae = document.getElementById('input_idade').value;
    const porteMae = document.getElementById('select_porte').value;
    const pedigreeMae = document.querySelector('.radioCertificado');
    const pedigreeNaoMae = document.querySelector('.radioCertificadoNao');
    const vacinaMae = document.querySelector('.radioVacinado');
    const vacinaNaoMae = document.querySelector('.radioVacinadoNao');

    if (racaMae == "" || idadeMae == "" || porteMae == "" || pedigreeMae == "" || pedigreeNaoMae == "" || vacinaMae == "" || vacinaNaoMae == "") {
        snackbar.innerHTML = "É necessário preencher todos os campos!";
        showSnackBar();
        //snackbar é o elemento que recebe uma mensagem a ser exibida ao usuário
        return
    }

    if (cadastroPetOBJT.racaMae == "") {
        snackbar.innerHTML = "É necessário escolher a raça da mãe!";
        showSnackBar();
        return
    } else {
        cadastroPetOBJT.racaMae = idadeMae
    }

    if (regexNumero.test(idadeMae) && idadeMae.length == 1 || idadeMae.length == 2) {
        cadastroPetOBJT.idadeMae = idadeMae;
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
        cadastroPetOBJT.porteMae = porteMae
    }

    if (cadastroPetOBJT.pedigreeMae == "" && cadastroPetOBJT.pedigreeNaoMae == "") {
        snackbar.innerHTML = "É necessário assinalar se a mãe possui pedigree!";
        showSnackBar();
        return
    } else {
        cadastroPetOBJT.pedigreeMae = pedigreeMae
    }

    if (cadastroPetOBJT.vacinaMae == "" && cadastroPetOBJT.vacinaNaoMae == "") {
        snackbar.innerHTML = "É necessário escolher se a mãe é vacinada ou não!";
        showSnackBar();
        return
    } else {
        cadastroPetOBJT.vacinaMae = vacinaMae
    }

    localStorage.setItem('cadastroPetOBJT', JSON.stringify(cadastroPetOBJT));
    window.location.href = "./register_pet2.html";
}

// função de validação dos campos do cadastro pet pt. 2
function validarCampoCad2() {

    const cadastroPetOBJT = JSON.parse(localStorage.getItem('cadastroPetOBJT'));

    //declarando variaveis que recebem o valor dos inputs
    const racaPai = document.getElementById('select_raca').value;
    const idadePai = document.getElementById('input_idade').value;
    const portePai = document.getElementById('select_porte').value;
    const pedigreePai = document.querySelector('.radioCertificado');
    const pedigreeNaoPai = document.querySelector('.radioCertificadoNao');
    const vacinaPai = document.querySelector('.radioVacinado');
    const vacinaNaoPai = document.querySelector('.radioVacinadoNao');

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
        cadastroPetOBJT2.racaPai = racaPai
    }

    if (regexNumero.test(idadePai) && idadePai.length == 1 || idadePai.length == 2) {
        cadastroPetOBJT2.idadePai = idadePai;
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
        cadastroPetOBJT2.portePai = portePai
    }

    if (cadastroPetOBJT2.pedigreePai == "" && cadastroPetOBJT2.pedigreeNaoPai == "") {
        snackbar.innerHTML = "É necessário assinalar se o pai possui pedigree!";
        showSnackBar();
        return
    } else {
        cadastroPetOBJT2.pedigreePai = pedigreePai
    }

    if (cadastroPetOBJT.vacinaPai == "" && cadastroPetOBJT.vacinaNaoPai == "") {
        snackbar.innerHTML = "É necessário escolher se o pai é vacinado ou não!";
        showSnackBar();
        return
    } else {
        cadastroPetOBJT2.vacinaPai = vacinaPai
    }

    localStorage.setItem('cadastroPetOBJT', JSON.stringify(cadastroPetOBJT));
    localStorage.setItem('cadastroPetOBJT2', JSON.stringify(cadastroPetOBJT2));
    window.location.href = "./register_pet3.html";
}

// função de validação dos campos do cadastro pet pt. 3
function validarCampoCad3() {

    const cadastroPetOBJT = JSON.parse(localStorage.getItem('cadastroPetOBJT'));
    const cadastroPetOBJT2 = JSON.parse(localStorage.getItem('cadastroPetOBJT2'));

    //declarando variaveis que recebem o valor dos inputs
    const quant = document.getElementById('input_quant').value;
    const preco = document.getElementById('input_preco').value;
    const nasc = document.getElementById('select_semana').value;
    const foto = document.getElementById('input_imagem').value;
    const desc = document.getElementById('span_observacao').value;

    if (quant == "" || preco == "" || nasc == "" || foto == "" || desc == "") {
        snackbar.innerHTML = "É necessário preencher todos os campos!";
        showSnackBar();
        //snackbar é o elemento que recebe uma mensagem a ser exibida ao usuário
        return
    }

    if (!regexNumero.test(quant)) {
        snackbar.innerHTML = "O campo 'Quantidade de filhotes' deve conter apenas números!";
        showSnackBar();
        return;
    } else {
        cadastroPetOBJT3.quant = quant
    }

    if (!regexNumero.test(preco)) {
        snackbar.innerHTML = "O campo 'Preço unitário' deve conter apenas números!";
        showSnackBar();
        return;
    } else {
        cadastroPetOBJT3.preco = preco
    }


    cadastroVendedor(cadastroPetOBJT, cadastroPetOBJT2, cadastroPetOBJT3);
    console.log(cadastroPetOBJT)
    console.log(cadastroPetOBJT2)
    console.log(cadastroPetOBJT3)
    window.location.href = "./puppys_ad.html";
}

function cadastroVendedor(cadastroPetOBJT, cadastroPetOBJT2, cadastroPetOBJT3) {

    const cadastroUserOBJT = JSON.parse(localStorage.getItem('cadastroUserOBJT'));
    const cadastroUserOBJT2 = JSON.parse(localStorage.getItem('cadastroUserOBJT2'));
    console.log(cadastroUserOBJT2);
    console.log(cadastroUserOBJT);

    // Cadastro de usuario (vendedor)
    fetch("http://localhost:8080/usuarios/cadastrar/vendedor", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(
            {
                "usuario": {
                    "nome": cadastroUserOBJT.nome,
                    "email": cadastroUserOBJT.email,
                    "cpf": cadastroUserOBJT.cpf,
                    "telefone": cadastroUserOBJT.telefone,
                    "senha": cadastroUserOBJT.senha,
                    "tipoUsuario": 2,
                    "autenticado": true
                },
                "endereco": {
                    "cep": cadastroUserOBJT2.cep,
                    "rua": cadastroUserOBJT2.endereco,
                    "numero": cadastroUserOBJT2.numero,
                    "complemento": cadastroUserOBJT2.complemento,
                    "bairro": cadastroUserOBJT2.bairro,
                    "cidade": cadastroUserOBJT2.cidade,
                    "estado": cadastroUserOBJT2.uf
                },
                "anuncioPet": {
                    "racaMae": cadastroPetOBJT.racaMae,
                    "idadeMae": cadastroPetOBJT.idadeMae,
                    "porteMae": cadastroPetOBJT.porteMae,
                    "vacinaMae": cadastroPetOBJT.vacinaMae,
                    "pedigreeMae": 1,
                    "racaPai": cadastroPetOBJT2.racaPai,
                    "idadePai": cadastroPetOBJT2.idadePai,
                    "portePai": cadastroPetOBJT2.portePai,
                    "vacinadoPai": cadastroPetOBJT2.vacinaPai,
                    "pedigreePai": 1,
                    "qtdFilhotes": cadastroPetOBJT3.quant,
                    "fotoPet": cadastroPetOBJT3.foto,
                    "descricao": cadastroPetOBJT3.descric
                },
                "filhote": {
                    "tempoEspera": cadastroPetOBJT3.nasc,
                    "preco": cadastroPetOBJT3.preco
                }
            }
        )
    })
        .then(res => res.json())
        .then((res) => {
            console.log(res);
        })
        .catch((err) => {
            console.log(err);
        });
}

function entrar() {
    window.location.href = "./login.html"
}