// aviso de algum erro nas validações
function showSnackBar() {
    var x = document.getElementById("snackbar");
    x.className = "show";
    setTimeout(function () { x.className = x.className.replace("show", ""); }, 3000);
}

// regex de verificações (verifica os caracteres de uma variavel)
const regexNumero = /^[0-9]+$/;
const regexImagem = /\.(jpg|jpeg|png|gif)$/i;

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

    if (racaMae == "" || idadeMae == "" || porteMae == "" || pedigreeMae == "" || pedigreeNaoMae == "" || vacinaMae == ""|| vacinaNaoMae == "") {
        snackbar.innerHTML = "É necessário preencher todos os campos!";
        showSnackBar();
        //snackbar é o elemento que recebe uma mensagem a ser exibida ao usuário
        return
    }

    if (cadastroPetOBJT.racaMae == "") {
        snackbar.innerHTML = "É necessário escolher a raça da mãe!";
        showSnackBar();
        return
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
    }

    if (cadastroPetOBJT.pedigreeMae == "" && cadastroPetOBJT.pedigreeNaoMae == "") {
        snackbar.innerHTML = "É necessário assinalar se a mãe possui pedigree!";
        showSnackBar();
        return
    }

    if (cadastroPetOBJT.vacinaMae == "" && cadastroPetOBJT.vacinaNaoMae == "") {
        snackbar.innerHTML = "É necessário escolher se a mãe é vacinada ou não!";
        showSnackBar();
        return
    }

    localStorage.setItem('cadastroPetOBJT', JSON.stringify(cadastroPetOBJT));
    window.location.href = "./register_pet2.html";
}

// função de validação dos campos do cadastro pet pt. 2
function validarCampoCad2() {

    //declarando variaveis que recebem o valor dos inputs
    const racaPai = document.getElementById('select_raca').value;
    const idadePai = document.getElementById('input_idade').value;
    const portePai = document.getElementById('select_porte').value;
    const pedigreePai = document.querySelector('.radioCertificado');
    const pedigreeNaoPai = document.querySelector('.radioCertificadoNao');
    const vacinaPai = document.querySelector('.radioVacinado');
    const vacinaNaoPai = document.querySelector('.radioVacinadoNao');

    if (racaPai == "" || idadePai == "" || portePai == "" || pedigreePai == "" || pedigreeNaoPai == "" || vacinaPai == ""|| vacinaNaoPai == "") {
        snackbar.innerHTML = "É necessário preencher todos os campos!";
        showSnackBar();
        //snackbar é o elemento que recebe uma mensagem a ser exibida ao usuário
        return
    }

    if (cadastroPetOBJT.racaPai == "") {
        snackbar.innerHTML = "É necessário escolher a raça do pai!";
        showSnackBar();
        return
    }

    if (regexNumero.test(idadePai) && idadePai.length == 1 || idadePai.length == 2) {
        cadastroPetOBJT.idadePai = idadePai;
    } else {
        snackbar.innerHTML = "Idade do pai inválida!";
        showSnackBar();
        return
    }

    if (cadastroPetOBJT.portePai == "") {
        snackbar.innerHTML = "É necessário escolher o porte do pai!";
        showSnackBar();
        return
    }

    if (cadastroPetOBJT.pedigreePai == "" && cadastroPetOBJT.pedigreeNaoPai == "") {
        snackbar.innerHTML = "É necessário assinalar se o pai possui pedigree!";
        showSnackBar();
        return
    }

    if (cadastroPetOBJT.vacinaPai == "" && cadastroPetOBJT.vacinaNaoPai == "") {
        snackbar.innerHTML = "É necessário escolher se o pai é vacinado ou não!";
        showSnackBar();
        return
    }

    localStorage.setItem('cadastroPetOBJT2', JSON.stringify(cadastroPetOBJT2));
    window.location.href = "./register_pet3.html";
}

// função de validação dos campos do cadastro pet pt. 3
function validarCampoCad3() {

    //declarando variaveis que recebem o valor dos inputs
    const quant = document.getElementById('input_quant').value;
    const preco = document.getElementById('input_preco').value;
    const nasc = document.getElementById('select_semana').value;
    const foto = document.querySelector('.input_imagem');
    const desc = document.querySelector('.span_observacao');

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
    }

    if (!regexNumero.test(preco)) {
        snackbar.innerHTML = "O campo 'Preço unitário' deve conter apenas números!";
        showSnackBar();
        return;
    }

    if (!regexImagem.test(foto)) {
        snackbar.innerHTML = "O campo 'Foto' deve conter um arquivo de imagem (jpg, jpeg, png ou gif)!";
        showSnackBar();
        return;
    }

    localStorage.setItem('cadastroPetOBJT3', JSON.stringify(cadastroPetOBJT3));
    window.location.href = "./anuncios_pets.html";
}

function cadastroVendedor(cadastroUserOBJT, cadastroUserOBJT2) {
   
    // Cadastro de usuario (vendedor)
    fetch("http://localhost:8080/usuarios/cadastrar/vendedor", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
                "ninhada": {
                  "raca_mae": cadastroPetOBJT.racaMae,
                  "idade_mae": cadastroPetOBJT.idadeMae,
                  "porte_mae": cadastroPetOBJT.porteMae,
                  "vacina_mae": cadastroPetOBJT.vacinaMae,
                  "pedigree_mae": cadastroPetOBJT.pedigreeMae,
                  "raca_pai": cadastroPetOBJT2.racaPai,
                  "idade_pai": cadastroPetOBJT2.idadePai,
                  "porte_pai": cadastroPetOBJT2.portePai,
                  "vacina_pai": cadastroPetOBJT2.vacinaPai,
                  "pedigree_pai": cadastroPetOBJT2.pedigreePai,
                  "qtd_filhotes": cadastroPetOBJT3.quant,
                  "foto_casal": cadastroPetOBJT3.foto,
                  "descricao": cadastroPetOBJT3.descric
                },
                "filhote": {
                  "tempo_espera": cadastroPetOBJT3.nasc,
                  "preco": cadastroPetOBJT3.preco
                }
        })
    })
        .then(res => res.json())
        .then((res) => {
            console.log(res)
        })
        .catch((err) => {
            console.log(err)
        })
}