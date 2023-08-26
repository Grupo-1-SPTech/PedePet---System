// regex de verificações (verifica os caracteres de uma variavel)
const regexEmail = /^[\w.-]+@[a-zA-Z]+\.[a-zA-Z]{2,}$/;

// aviso de algum erro nas validações
function showSnackBar(message) {
  var x = document.getElementById("snackbar");
  x.innerHTML = message;
  x.className = "show";
  setTimeout(function () { x.className = x.className.replace("show", ""); }, 3000);
}

// função de validação dos campos de login
function validarEmail() {
    // declarando variaveis que recebem o valor dos inputs
    const in_email = document.getElementById('input_email').value;
  
    if (in_email === "") {
      showSnackBar("É necessário preencher todos os campos");
      return; // Retorna aqui para interromper a execução
    }
  
    if (!regexEmail.test(in_email)) {
      showSnackBar("Email inválido!");
      return; // Retorna aqui para interromper a execução
    }
    else {
        window.location.href='./forgotpass_2.html'
    }
  
    // Prosseguir(in_email);
  }