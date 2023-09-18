// Importe o Firebase
// import firebase from "firebase/app";
// import "firebase/auth";

// const firebaseConfig = {
//   apiKey: "AIzaSyCZzk3i4ltw3RCjkXWK1jcB26gjV9kgJSA",
//   authDomain: "pedepet-7e1d7.firebaseapp.com",
//   projectId: "pedepet-7e1d7",
//   storageBucket: "pedepet-7e1d7.appspot.com",
//   messagingSenderId: "1030631391810",
//   appId: "1:1030631391810:web:4758e52101c3dff61da3db",
//   measurementId: "G-7L4545M83R"
// };

// firebase.initializeApp(firebaseConfig);

// Adicionar evento de clique no botão de login
document.getElementById('btn-entrar').addEventListener('click', validarLogin);

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
function validarLogin() {
  // declarando variaveis que recebem o valor dos inputs
  const in_email = document.getElementById('input_email').value;
  const in_senha = document.getElementById('input_senha').value;

  if (in_email === "" || in_senha === "") {
    showSnackBar("É necessário preencher todos os campos");
    return; // Retorna aqui para interromper a execução
  }

  if (!regexEmail.test(in_email)) {
    showSnackBar("Email inválido!");
    return; // Retorna aqui para interromper a execução
  }

  fazerLogin(in_email, in_senha);
}

// Função para fazer a requisição de login
function fazerLogin(email, senha) {
  fetch('http://localhost:8080/usuarios/login', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify({
      email: email,
      senha: senha,
    }),
  })
    .then(response => {
      if (response.ok) {
        // Login bem-sucedido, redirecionar para a próxima página
        // guardando email logado em local storage 
        sessionStorage.setItem("email", email);
        window.location.href = './puppys_ad.html'
      } else if (response.status === 204 || response.status === 404) {
        // E-mail não encontrado ou senha incorreta
        showSnackBar("Senha ou e-mail inválido!");
      } else {
        // Outro erro
        showSnackBar("Ocorreu um erro durante o login!");
      }
    })
    .catch(error => {
      console.error('Erro ao fazer login:', error);
    });
}

// // Função para fazer login usando o Firebase Authentication
// function fazerLogin(email, senha) {
//   firebase.auth().signInWithEmailAndPassword(email, senha)
//     .then(function() {
//       // Login bem-sucedido
//       sessionStorage.setItem("email", email);
//       window.location.href = './puppys_ad.html';
//     })
//     .catch(function(error) {
//       // Lidar com erros, por exemplo, se as credenciais estiverem incorretas
//       showSnackBar("Erro ao fazer login: " + error.message);
//     });
// }

function entrar() {
  window.location.href = "./login.html"
}