// função select raça
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

window.addEventListener('click', function(e){
    if(!selectBtn.contains(e.target)) optionMenu.classList.remove('active'); 
});

// função select tamanho
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

window.addEventListener('click', function(e){
    if(!selectBtn2.contains(e.target)) optionMenu2.classList.remove('active2'); 
});


// limpar filtros

const racaSelect = document.getElementById('select-raca')
const tamanhoSelect = document.getElementById('select-tamanho')
const vacinaSimSelect = document.getElementById('vacina-sim')
const vacinaNaoSelect = document.getElementById('vacina-nao')
const limparFilter = document.getElementById('limpar-filter')

function limparFiltros() {

    document.getElementById("select-raca").querySelector(".sBtn-text").textContent = "Escolha uma raça";

    document.getElementById("select-tamanho").querySelector(".sBtn-text2").textContent = "Escolha um tamanho";

    document.querySelector(".radioVacinado").checked = false;

    document.querySelector(".radioVacinadoNao").checked = false;
}
limparFilter.addEventListener('click', limparFiltros);

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

//insert de anuncios pet
// async function buscarAnuncios(){
//     const resposta = await fetch("endpoint");

//     const getResposta = await resposta.json();
//     console.log(getResposta);

//     const boxAnuncio = document.getElementById('box_anuncio');

//     boxAnuncio.innerHTML = getResposta.map(function(anuncio){

//         return `<div class="ex-card" id="box_anuncio">
//                     <div class="img-pet"><img class="img-puppy" src="./css/images/spitz-filhote.jpg" alt=""></div>
//                     <div class="content-card">
//                         <h3>${anuncio.nomePet}</h3>
//                         <p id="mes">${anuncio.diaNascimento} dias</p>
//                         <p id="preco">R$ ${anuncio.precoPet}</p>
//                         <div class="fila-local">
//                             <p id="fila">6/10 Fila de espera</p>
//                             <p id="local">${anuncio.estadoLocal}</p>
//                         </div>
//                     </div>
//                     <div class="btn-fila">
//                         <button onclick="entrarFila()" class="entrar-fila" id="entrar-fila">Entrar na fila</button>
//                     </div>
//                 </div>`;
//     })
// }

// buscarAnuncios();
