const neutralValue = 50; // Valor neutro (pode ser variado)
const actualValue = 65; // Valor atual (pode ser variado)

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

function buscarDados() {

  carregarValores();
}