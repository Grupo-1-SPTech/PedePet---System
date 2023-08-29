const neutralValue = 50; // Valor neutro (pode ser variado)
const actualValue = 65; // Valor atual (pode ser variado)

let profileDropdownList = document.querySelector('.profile-dropdown-list');
let btn = document.querySelector('.profile-dropdown-btn');
let modoBtn = document.querySelector('modo');
let daltonismoBtn = document.querySelector('daltonismo');

const toggle = () => profileDropdownList.classList.toggle('active');

window.addEventListener('click', function(e){
    if(!btn.contains(e.target)) profileDropdownList.classList.remove('active');
});

//progress bar da fila 
const maxCapacity = 7;
const currentPersons = 3;

const fillerBar = document.getElementById("filler-bar");
const fillPercentage = (currentPersons / maxCapacity) * 100;
const percentageText = document.getElementById("percentage-text");
const qtdFilhotes = document.getElementById("qtdFilhotes");

function carregarValores(){
fillerBar.style.width = fillPercentage + "%";
percentageText.textContent =  + Math.round(fillPercentage) +  "%";
qtdFilhotes.textContent = maxCapacity 
}

function entrar() {
  window.location.href = "./login.html"
}

//tema dark
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

function buscarDados() {

  carregarValores();
}