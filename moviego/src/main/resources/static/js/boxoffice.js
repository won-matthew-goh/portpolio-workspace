let weekCt = document.getElementById('weekChart');

let weekChart = new Chart(weekCt, {
  	  type: 'bar',
  	  data: {
  	    axis: 'y',
  	    labels: [movieArray[0].movieNm, movieArray[1].movieNm, movieArray[2].movieNm, movieArray[3].movieNm, movieArray[4].movieNm],
  	    datasets: [
  	      {
  	        label: '관객수 증감',
  	        data: [movieArray[0].audiInten, movieArray[1].audiInten, movieArray[2].audiInten, movieArray[3].audiInten, movieArray[4].audiInten],
  	        backgroundColor: ['rgba(255, 99, 132, 0.2)', 'rgba(255, 159, 64, 0.2)', 'rgba(255, 205, 86, 0.2)', 'rgba(75, 192, 192, 0.2)', 'rgba(54, 162, 235, 0.2)'],
  	        borderColor: ['rgb(255, 99, 132)', 'rgb(255, 159, 64)', 'rgb(255, 205, 86)', 'rgb(75, 192, 192)', 'rgb(54, 162, 235)'],
  	        borderWidth: 1,
  	      },
  	    ],
  	  },
  	  options: {
  	    indexAxis: 'y',
  	  },
  	});
