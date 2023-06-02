// Função para fazer a requisição de login
async function fazerLogin() {
    const email = document.getElementById('input_email').value;
    const senha = document.getElementById('input_senha').value;
  
    const response = await fetch('http://localhost:8080/usuarios/login', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        email: email,
        senha: senha,
      }),
    });
  
    if (response.status === 200) {
      // Login bem-sucedido, redirecionar para a próxima página
      window.location.href = './index.html';
    } else if (response.status === 204) {
      // Email inválido.
      alert('Email inválido.');
    } else if (response.status === 404) {
      // Senha incorreta
      alert('Senha incorreta.');
    } else {
      // Outro erro
      alert('Ocorreu um erro durante o login.');
    }
  }
  
  // Adicionar evento de clique no botão de login
  document.getElementById('btn-entrar').addEventListener('click', fazerLogin);