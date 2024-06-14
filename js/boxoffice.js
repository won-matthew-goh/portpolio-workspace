let accCt = document.getElementById('accChart');
let weekCt = document.getElementById('weekChart');

let accChart = new Chart(accCt, {
  type: 'bar',
  data: {
    labels: ['원더랜드', '퓨리오사: 매드맥스 사가', '그녀가 죽었다', '범죄도시4', '설계자'],
    datasets: [
      {
        label: '누적 관객 수',
        data: [468801, 1418622, 1134094, 11421632, 501892],
      },
    ],
  },
});

let weekChart = new Chart(weekCt, {
  type: 'bar',
  data: {
    labels: ['원더랜드', '퓨리오사: 매드맥스 사가', '그녀가 죽었다', '범죄도시4', '설계자'],
    datasets: [
      {
        label: '관객수 증감',
        data: [460191, -118731, -61083, -79408, -240543],
      },
    ],
  },
});
