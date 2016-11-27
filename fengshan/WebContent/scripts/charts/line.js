			
			
			function parseAmountDate(dateStat){
				var arr = new Array();
				if (dateStat){
					for (var index in dateStat){
						arr.push([dateStat[index].statisticsDate,dateStat[index].amount]);
					}
				}
				return arr;
			}
			
			
			
			$(document).ready(function() {
				var chart;
				var stat;
				var options = {
					chart: {
						renderTo: 'container',
						defaultSeriesType: 'line'
					},
					title: {
						text: '',
						x: -10 //center
					},
					subtitle: {
						text: '',
						x: -10
					},
					xAxis: {
						categories: ['1', '2', '3', '4', '5', '6', '7']
					},
					yAxis: {
						title: {
							text: '数量'
						},
						plotLines: [{
							value: 0,
							width: 1,
							color: '#808080'
						}]
					},
					tooltip: {
						formatter: function() {
				                return '<b>'+ this.series.name +'</b><br/>'+
								this.point.name +' 共'+ this.y+"笔";
						}
					},
					legend: {
						layout: 'vertical',
						align: 'center',
						verticalAlign: 'top',
						x: 0,
						y: 0,
						borderWidth: 0
					},
					exporting: {
						enabled: false
					},
					series: [{
						name: '挂牌笔数'
					},
					{
						name: '成交数'
					}]
				};
				$.ajaxSetup({
					  async : false
					});
				$.getJSON(statisAjaxUrl, function(data){
					  stat = data;
			    });
			     
			     options.series[0].data = parseAmountDate(stat["project"]);
				 options.series[1].data = parseAmountDate(stat["order"]);
			     chart = new Highcharts.Chart(options);
			});