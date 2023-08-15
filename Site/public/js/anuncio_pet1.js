const neutralValue = 50; // Valor neutro (pode ser variado)
const actualValue = 65; // Valor atual (pode ser variado)

const ctx = document.getElementById('neutralLineChart').getContext('2d');
const neutralLineChart = new Chart(ctx, {
  type: 'line',
  data: {
    labels: ['Neutro', 'Atual'],
    datasets: [{
      data: [neutralValue, actualValue],
      borderColor: '#36A2EB', // Cor da linha
      borderWidth: 2, // Largura da linha
      fill: false, // Preenchimento desligado para uma linha
    }]
  },
  options: {
    scales: {
      y: {
        beginAtZero: true,
      }
    }
  }
});