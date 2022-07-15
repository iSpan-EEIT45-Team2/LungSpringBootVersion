// window.onload = function() {
    /*--------------------START後台首頁chart的USER性別統計-------------------*/
    let xhr = new XMLHttpRequest();
    let countFemale;  //統計全部女性會員
    let countMale;  //統計全部男性會員
    let countSecret;  //統計全部不公開性別會員
    xhr.onreadystatechange = function () {
        // alert(xhr.responseText + ", readyState=" + xhr.readyState);
        if (xhr.readyState === 4 && xhr.status === 200) {
            let result = JSON.parse(xhr.responseText);
            countFemale = parseInt(result.countFemale);
            countMale = parseInt(result.countMale);
            countSecret = parseInt(result.countSecret);
            console.log("取得會員性別統計: ");
            console.log("result.countFemale: " +countFemale);
            console.log("result.countMale: " +countMale);
            console.log("result.countSecret: " +countSecret);
        }

        if ($("#memberdoughnutChart").length) {
            var doughnutChartCanvas = $("#memberdoughnutChart").get(0).getContext("2d");
            var doughnutPieData = {
                datasets: [{
                    data: [countFemale, countMale, countSecret],
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.5)',
                        'rgba(255, 206, 86, 0.5)',
                        'rgba(54, 162, 235, 0.5)',
                        'rgba(75, 192, 192, 0.5)',
                        'rgba(153, 102, 255, 0.5)',
                        'rgba(255, 159, 64, 0.5)'
                    ],
                    borderColor: [
                        'rgba(255,99,132,1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(153, 102, 255, 1)',
                        'rgba(255, 159, 64, 1)'
                    ],
                }],

                // These labels appear in the legend and in the tooltips when hovering different arcs
                labels: [
                    '女',
                    '男',
                    '不公開',
                ]
            };
            var doughnutPieOptions = {
                cutoutPercentage: 50,
                animationEasing: "easeOutBounce",
                animateRotate: true,
                animateScale: false,
                responsive: true,
                maintainAspectRatio: true,
                showScale: true,
                legend: false,
                legendCallback: function (chart) {
                    var text = [];
                    text.push('<div class="chartjs-legend"><ul class="justify-content-center">');
                    for (var i = 0; i < chart.data.datasets[0].data.length; i++) {
                        text.push('<li><span style="background-color:' + chart.data.datasets[0].backgroundColor[i] + '">');
                        text.push('</span>');
                        if (chart.data.labels[i]) {
                            text.push(chart.data.labels[i]);
                        }
                        text.push('</li>');
                    }
                    text.push('</div></ul>');
                    return text.join("");
                },

                layout: {
                    padding: {
                        left: 0,
                        right: 0,
                        top: 0,
                        bottom: 0
                    }
                },
                tooltips: {
                    callbacks: {
                        title: function(tooltipItem, data) {
                            return data['labels'][tooltipItem[0]['index']];
                        },
                        label: function(tooltipItem, data) {
                            return data['datasets'][0]['data'][tooltipItem['index']];
                        }
                    },

                    backgroundColor: '#fff',
                    titleFontSize: 16,
                    titleFontColor: '#0B0F32',
                    bodyFontColor: '#737F8B',
                    bodyFontSize: 14,
                    displayColors: false
                }
            };
            var doughnutChart = new Chart(doughnutChartCanvas, {
                type: 'doughnut',
                data: doughnutPieData,
                options: doughnutPieOptions
            });
            document.getElementById('member-doughnut-chart-legend').innerHTML = doughnutChart.generateLegend();
        }

    }
    xhr.open("GET", "/Lung/StatisticMember/CountAllGender", true);
    xhr.send();

    /*--------------------END後台首頁chart的USER性別統計-------------------*/
// }











