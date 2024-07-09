let weekCt = document.getElementById('weekChart');

let weekChart = new Chart(weekCt, {
    type: 'bar',
    data: {
        axis: 'y',
        labels: movieArray.slice(0, 5).map(movie => `${movie.movieNm} / ${movie.titleEn} / ${movie.titleJa}`),
        datasets: [
            {
                label: '관객수 증감 / Audience Change / 観客数の変化',
                data: movieArray.slice(0, 5).map(movie => movie.audiInten),
                backgroundColor: ['rgba(255, 99, 132, 0.2)', 'rgba(255, 159, 64, 0.2)', 'rgba(255, 205, 86, 0.2)', 'rgba(75, 192, 192, 0.2)', 'rgba(54, 162, 235, 0.2)'],
                borderColor: ['rgb(255, 99, 132)', 'rgb(255, 159, 64)', 'rgb(255, 205, 86)', 'rgb(75, 192, 192)', 'rgb(54, 162, 235)'],
                borderWidth: 1,
            },
        ],
    },
    options: {
        indexAxis: 'y',
        plugins: {
            tooltip: {
                callbacks: {
                    label: function(context) {
                        let label = context.dataset.label || '';
                        if (label) {
                            label += ': ';
                        }
                        if (context.parsed.x !== null) {
                            label += context.parsed.x;
                        }
                        return label;
                    },
                    title: function(tooltipItems) {
                        return movieArray[tooltipItems[0].dataIndex].movieNm + ' / ' + 
                               movieArray[tooltipItems[0].dataIndex].titleEn + ' / ' + 
                               movieArray[tooltipItems[0].dataIndex].titleJa;
                    }
                }
            }
        }
    },
});