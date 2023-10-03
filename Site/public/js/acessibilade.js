// botao perfil
let profileDropdownList = document.querySelector('.profile-dropdown-list');
let btn = document.querySelector('.profile-dropdown-btn');
let modoBtn = document.querySelector('dark-mode');
let daltonismoBtn = document.querySelector('daltonismo');
let configBtn = document.querySelector('config');
let sairBtn = document.querySelector('logout');

const toggle = () => profileDropdownList.classList.toggle('active');

window.addEventListener('click', function(e){
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


