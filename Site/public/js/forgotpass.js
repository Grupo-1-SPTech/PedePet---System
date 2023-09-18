// Importe o Firebase
import firebase from "firebase/app";
import "firebase/auth";

const firebaseConfig = {
  apiKey: "AIzaSyCZzk3i4ltw3RCjkXWK1jcB26gjV9kgJSA",
  authDomain: "pedepet-7e1d7.firebaseapp.com",
  projectId: "pedepet-7e1d7",
  storageBucket: "pedepet-7e1d7.appspot.com",
  messagingSenderId: "1030631391810",
  appId: "1:1030631391810:web:4758e52101c3dff61da3db",
  measurementId: "G-7L4545M83R"
};

firebase.initializeApp(firebaseConfig);

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
      showSnackBar("Um e-mail de redefinição de senha foi enviado para o seu endereço de e-mail.");
    })
    .catch(function(error) {
      // Lidar com erros, por exemplo, se o e-mail não estiver registrado
      showSnackBar("Ocorreu um erro ao enviar o e-mail de redefinição de senha: " + error.message);
    });
}