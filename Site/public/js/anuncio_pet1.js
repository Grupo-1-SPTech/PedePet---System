const neutralValue = 50; // Valor neutro (pode ser variado)
const actualValue = 65; // Valor atual (pode ser variado)

const urlParams = new URLSearchParams(window.location.search);
const idAnuncio = urlParams.get('id');

function anuncioInfos(){
fetch(`http://localhost:8080/anuncios/${idAnuncio}`, {  
  method: "GET"
})
    .then((resposta) => resposta.json())
    .then((anuncio) => {

      

        const anuncioInfo = anuncio;
        console.log(anuncioInfo);
        const racaMae = anuncio.racaMae;
        const fotoPet = anuncio.fotoPet;
        const usuarioNome = anuncio.usuario.nome;
        const descricao = anuncio.descricao;
        const primeiroFilhote = anuncio.filhotes[0];
        const tamanhoFila = anuncio.filhotes.length;
        const tempoEsperaPrimeiroCaractere = primeiroFilhote.tempoEspera.charAt(0);
        const precoPrimeiroFilhote = primeiroFilhote.preco.toLocaleString('pt-BR', { minimumFractionDigits: 2 });

        let filhotesIndisponiveis = 0;

    
        for (const filhote of anuncio.filhotes) {
          if (!filhote.disponivel) {
            filhotesIndisponiveis++;
          }
        }
        

        let inObservacao = document.getElementById("observacao");
        let inPrecoFilhote = document.getElementById("filhotes_preco");
        let inImagem = document.getElementById("imagem");
        let inCardTempo = document.getElementById("cardTempo");
        let inQtdFilhotes = document.getElementById("qtdFilhotes");
        let inRaca = document.getElementById("raca");
        let inNomeVendedor = document.getElementById("nomeVendedor");
        let inTitulo = document.getElementById("titulo");
        const elementoImagem = document.querySelector('.imagem');

            elementoImagem.style.backgroundImage = `url('${fotoPet}')`;
            inRaca.innerHTML = racaMae;     
            inNomeVendedor.innerHTML = usuarioNome;
            inPrecoFilhote.innerHTML = 'R$'+ precoPrimeiroFilhote;  
            inTitulo.innerHTML = racaMae; 
            inObservacao.innerHTML = anuncio.titulo + "<br>" + descricao;
            inCardTempo.innerHTML = tempoEsperaPrimeiroCaractere;
            inQtdFilhotes.innerHTML = tamanhoFila - filhotesIndisponiveis; 
         

          

            const fillerBar = document.getElementById("filler-bar");
            const fillPercentage = (filhotesIndisponiveis / tamanhoFila) * 100;
            const percentageText = document.getElementById("percentage-text");
            const qtdFilhotes = document.getElementById("qtdFilhotes");
                
            fillerBar.style.width = fillPercentage + "%";
            percentageText.textContent =  + Math.round(fillPercentage) +  "%";
            qtdFilhotes.textContent = maxCapacity 
    })
    .catch((err) => {
        console.error(err);
    });
}





function entrar() {
  window.location.href = "./login.html"
}



function buscarDados() {
  anuncioInfos();
}