// regex de verificações (verifica os caracteres de uma variavel)
const regexEmail = /^[\w.-]+@[a-zA-Z]+\.[a-zA-Z]{2,}$/;

// aviso de algum erro nas validações
function showSnackBar(message) {
  var x = document.getElementById("snackbar");
  x.innerHTML = message;
  x.className = "show";
  setTimeout(function () { x.className = x.className.replace("show", ""); }, 3000);
}

// função de validação do e-mail e redefinição de senha
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

  // Enviar e-mail de redefinição de senha usando o Firebase Authentication
  firebase.auth().sendPasswordResetEmail(in_email)
    .then(function() {
      // E-mail de redefinição de senha enviado com sucesso
      alert("Um e-mail de redefinição de senha foi enviado para o seu endereço de e-mail.");
      
      // Redirecionar para a página de login (login.html)
      window.location.href = './login.html';
    })
    .catch(function(error) {
      // Lidar com erros, por exemplo, se o e-mail não estiver registrado
      showSnackBar("Ocorreu um erro ao enviar o e-mail de redefinição de senha: " + error.message);
    });
}