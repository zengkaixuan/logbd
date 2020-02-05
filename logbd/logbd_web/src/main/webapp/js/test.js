$(function() {

	function rgb() {// rgb颜色随机
		var r = Math.floor(Math.random() * 256);
		var g = Math.floor(Math.random() * 256);
		var b = Math.floor(Math.random() * 256);
		var rgb = '(' + r + ',' + g + ',' + b + ')';
		return rgb;
	}
	function color16() {// 十六进制颜色随机
		var r = Math.floor(Math.random() * 256);
		var g = Math.floor(Math.random() * 256);
		var b = Math.floor(Math.random() * 256);
		var color = '#' + r.toString(16) + g.toString(16) + b.toString(16);
		return color;
	}
	var colors = [ '#ff4343', '#f69846', '#f6d54a', '#45dbf7', '#44aff0',
			'#4777f5', '#5045f6', '#ad46f3', '#f845f1' ];
	function random_rbg() {// 颜色随机
		var i = Math.floor(Math.random() * 10);
		var color = colors[i];
		return color;
	}

	echart_1();
	// echart_1湖南货物收入
	function echart_1() {
		var echart1_data = [ [] ];
		var citys = [];
		$.ajax({
			async : false,
			type : "GET",
			url : "ajax_index",
			dataType : "JSON",
			success : function(data) {
				data[1].forEach(function(item) {
					echart1_data[0].push({
						id : item.id,
						city : item.city,
						income : item.income
					})
				})
				echart1_data[0] = echart1_data[0].sort(function(a, b) { // 自定义函数排序
					var a1 = a.income;
					var b1 = b.income;
					if (a1 < b1) {
						return -1;
					} else if (a1 > b1) {
						return 1;
					}
					return 0;
				});
				echart1_data[0].forEach(function(item) {
					citys.push(item.city)
				})
				citys.reverse();
			},
			error : function() {
				alert("ajax错误");
			}
		});
		// 创建一个option对象的data属性类数组
		var arr = [];
		echart1_data[0].forEach(function(item) {
			arr.push({
				value : item.income,
				name : item.city,
				itemStyle : {
					normal : {
						color : random_rbg()
					}
				}
			})
		});
		echart1_data[0].forEach(function(item) {
			arr.push({
				value : 0,
				name : "",
				itemStyle : {
					normal : {
						color : 'transparent'
					}
				},
				label : {
					show : false
				},
				labelLine : {
					show : false
				}
			})
		});

		// 基于准备好的dom，初始化echarts实例
		var myChart = echarts.init(document.getElementById('chart_1'));
		option = {
			tooltip : {
				trigger : 'item',
				formatter : "{a} <br/>{b} : {c}万元"
			},
			legend : {
				x : 'center',
				y : '15%',
				data : citys,
				icon : 'circle',
				textStyle : {
					color : '#fff',
				}
			},
			calculable : true,
			series : [ {
				name : '',
				type : 'pie',
				// 起始角度，支持范围[0, 360]
				startAngle : 0,
				// 饼图的半径，数组的第一项是内半径，第二项是外半径
				radius : [ 41, 100.75 ],
				// 支持设置成百分比，设置成百分比时第一项是相对于容器宽度，第二项是相对于容器高度
				center : [ '50%', '40%' ],
				// 是否展示成南丁格尔图，通过半径区分数据大小。可选择两种模式：
				// 'radius' 面积展现数据的百分比，半径展现数据的大小。
				// 'area' 所有扇区面积相同，仅通过半径展现数据大小
				roseType : 'area',
				// 是否启用防止标签重叠策略，默认开启，圆环图这个例子中需要强制所有标签放在中心位置，可以将该值设为 false。
				avoidLabelOverlap : false,
				label : {
					normal : {
						show : true,
						formatter : '{c}万元'
					},
					emphasis : {
						show : true
					}
				},
				labelLine : {
					normal : {
						show : true,
						length2 : 1,
					},
					emphasis : {
						show : true
					}
				},
				data : arr
			} ]
		};
		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
		window.addEventListener("resize", function() {
			myChart.resize();
		});
	}

	echart_2();
	// echart_2湖南省地图
	function echart_2() {
		// 基于准备好的dom，初始化echarts实例
		var myChart = echarts.init(document.getElementById('chart_2'));
		function showProvince() {
			myChart.setOption(option = {
				// backgroundColor: '#ffffff',
				visualMap : {
					show : false,
					min : 0,
					max : 100,
					left : 'left',
					top : 'bottom',
					text : [ '高', '低' ], // 文本，默认为数值文本
					calculable : true,
					inRange : {
						color : [ 'yellow', 'lightskyblue', 'orangered' ]
					}
				},
				series : [ {
					type : 'map',
					mapType : 'hunan',
					roam : true,
					label : {
						normal : {
							show : true
						},
						emphasis : {
							textStyle : {
								color : '#fff'
							}
						}
					},
					itemStyle : {
						normal : {
							borderColor : '#389BB7',
							areaColor : '#fff',
						},
						emphasis : {
							areaColor : '#389BB7',
							borderWidth : 0
						}
					},
					animation : false,
					data : [ {
						name : '长沙市',
						value : 100
					}, {
						name : '株洲市',
						value : 96
					}, {
						name : '湘潭市',
						value : 98
					}, {
						name : '衡阳市',
						value : 80
					}, {
						name : '邵阳市',
						value : 88
					}, {
						name : '岳阳市',
						value : 79
					}, {
						name : '常德市',
						value : 77,
					}, {
						name : '张家界市',
						value : 33
					}, {
						name : '益阳市',
						value : 69,
					}, {
						name : '郴州市',
						value : 66
					}, {
						name : '永州市',
						value : 22
					}, {
						name : '娄底市',
						value : 51
					}, {
						name : '湘西土家族苗族自治州',
						value : 44
					}, {
						name : '怀化市',
						value : 9
					} ]
				} ]
			});
		}

		var currentIdx = 0;
		showProvince();
		// 使用刚指定的配置项和数据显示图表。
		window.addEventListener("resize", function() {
			myChart.resize();
		});
	}

	echart_map();
	// echart_map中国地图
	function echart_map() {
		// 基于准备好的dom，初始化echarts实例
		var myChart = echarts.init(document.getElementById('chart_map'));

		var mapName = 'china'
		var data = []
		var toolTipData = [];

		/* 获取地图数据 */
		myChart.showLoading();
		var mapFeatures = echarts.getMap(mapName).geoJson.features;
		myChart.hideLoading();
		var geoCoordMap = {
			'福州' : [ 119.4543, 25.9222 ],
			'长春' : [ 125.8154, 44.2584 ],
			'重庆' : [ 107.7539, 30.1904 ],
			'西安' : [ 109.1162, 34.2004 ],
			'成都' : [ 103.9526, 30.7617 ],
			'常州' : [ 119.4543, 31.5582 ],
			'北京' : [ 116.4551, 40.2539 ],
			'北海' : [ 109.314, 21.6211 ],
			'海口' : [ 110.3893, 19.8516 ],
			'长沙' : [ 113.019455, 28.200103 ],
			'上海' : [ 121.40, 31.73 ],
			'内蒙古' : [ 106.82, 39.67 ]
		};

		var GZData = [ [ {
			name : '长沙'
		}, {
			name : '福州',
			value : 95
		} ], [ {
			name : '长沙'
		}, {
			name : '长春',
			value : 80
		} ], [ {
			name : '长沙'
		}, {
			name : '重庆',
			value : 70
		} ], [ {
			name : '长沙'
		}, {
			name : '西安',
			value : 60
		} ], [ {
			name : '长沙'
		}, {
			name : '成都',
			value : 50
		} ], [ {
			name : '长沙'
		}, {
			name : '常州',
			value : 40
		} ], [ {
			name : '长沙'
		}, {
			name : '北京',
			value : 30
		} ], [ {
			name : '长沙'
		}, {
			name : '北海',
			value : 20
		} ], [ {
			name : '长沙'
		}, {
			name : '海口',
			value : 10
		} ], [ {
			name : '长沙'
		}, {
			name : '上海',
			value : 80
		} ], [ {
			name : '长沙'
		}, {
			name : '内蒙古',
			value : 80
		} ] ];

		var convertData = function(data) {
			var res = [];
			for (var i = 0; i < data.length; i++) {
				var dataItem = data[i];
				var fromCoord = geoCoordMap[dataItem[0].name];
				var toCoord = geoCoordMap[dataItem[1].name];
				if (fromCoord && toCoord) {
					res.push({
						fromName : dataItem[0].name,
						toName : dataItem[1].name,
						coords : [ fromCoord, toCoord ]
					});
				}
			}
			return res;
		};

		var color = [ '#c5f80e' ];
		var series = [];
		[ [ '石家庄', GZData ] ].forEach(function(item, i) {
			series.push({
				name : item[0],
				type : 'lines',
				zlevel : 2,
				symbol : [ 'none', 'arrow' ],
				symbolSize : 10,
				effect : {
					show : true,
					period : 6,
					trailLength : 0,
					symbol : 'arrow',
					symbolSize : 5
				},
				lineStyle : {
					normal : {
						color : color[i],
						width : 1,
						opacity : 0.6,
						curveness : 0.2
					}
				},
				data : convertData(item[1])
			}, {
				name : item[0],
				type : 'effectScatter',
				coordinateSystem : 'geo',
				zlevel : 2,
				rippleEffect : {
					brushType : 'stroke'
				},
				label : {
					normal : {
						show : true,
						position : 'right',
						formatter : '{b}'
					}
				},
				symbolSize : function(val) {
					return val[2] / 8;
				},
				itemStyle : {
					normal : {
						color : color[i]
					}
				},
				data : item[1].map(function(dataItem) {
					return {
						name : dataItem[1].name,
						value : geoCoordMap[dataItem[1].name]
								.concat([ dataItem[1].value ])
					};
				})
			});
		});

		option = {
			tooltip : {
				trigger : 'item'
			},
			geo : {
				map : 'china',
				label : {
					emphasis : {
						show : false
					}
				},
				roam : true,
				itemStyle : {
					normal : {
						borderColor : 'rgba(147, 235, 248, 1)',
						borderWidth : 1,
						areaColor : {
							type : 'radial',
							x : 0.5,
							y : 0.5,
							r : 0.8,
							colorStops : [ {
								offset : 0,
								color : 'rgba(175,238,238, 0)' // 0% 处的颜色
							}, {
								offset : 1,
								color : 'rgba(47,79,79, .1)' // 100% 处的颜色
							} ],
							globalCoord : false
						// 缺省为 false
						},
						shadowColor : 'rgba(128, 217, 248, 1)',
						// shadowColor: 'rgba(255, 255, 255, 1)',
						shadowOffsetX : -2,
						shadowOffsetY : 2,
						shadowBlur : 10
					},
					emphasis : {
						areaColor : '#389BB7',
						borderWidth : 0
					}
				}
			},
			series : series
		};

		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
		window.addEventListener("resize", function() {
			myChart.resize();
		});

	}

	echart_3();
	// echart_3货物周转量
	function echart_3() {
		// 基于准备好的dom，初始化echarts实例
		var myChart = echarts.init(document.getElementById('chart_3'));
		myChart.clear();
		var echart3_data = [];
		$.ajax({
			async : false,
			type : "GET",
			url : "ajax_index",
			dataType : "JSON",
			success : function(data) {
				data[2].forEach(function(item) {
					echart3_data.push({
						years : item.years,
						total_railway : item.total_railway,
						national_railway : item.national_railway,
						local_railway : item.local_railway,
						joint_venture_railway : item.joint_venture_railway,
						highway : item.highway,
						waterway : item.waterway
					})
				})
				echart3_data = echart3_data.sort(function(a, b) { // 自定义函数排序
					var a1 = a.years;
					var b1 = b.years;
					if (a1 < b1) {
						return -1;
					} else if (a1 > b1) {
						return 1;
					}
					return 0;
				});
			},
			error : function() {
				alert("ajax错误");
			}
		});

		// 年份
		var years = [];
		echart3_data.forEach(function(i) {
			years.push(i.years);
		})

		// 铁路货物
		var total_railways = []
		echart3_data.forEach(function(i) {
			total_railways.push(i.total_railway);
		})

		// 国家铁路货物
		var national_railways = []
		echart3_data.forEach(function(i) {
			national_railways.push(i.national_railway);
		})

		// 地方铁路货物
		var local_railways = []
		echart3_data.forEach(function(i) {
			local_railways.push(i.local_railway);
		})

		// 合资铁路货物
		var joint_venture_railways = []
		echart3_data.forEach(function(i) {
			joint_venture_railways.push(i.joint_venture_railway);
		})

		// 公路货物
		var highways = []
		echart3_data.forEach(function(i) {
			highways.push(i.highway);
		})

		// 水路货物
		var waterways = []
		echart3_data.forEach(function(i) {
			waterways.push(i.waterway);
		})

		option = {
			title : {
				text : ''
			},
			tooltip : {
				trigger : 'axis'
			},
			legend : {
				data : [ '铁路货物', '国家铁路货物', '地方铁路货物', '合资铁路货物', '公路货物', '水运货物' ],
				textStyle : {
					color : '#fff'
				},
				top : '8%'
			},
			grid : {
				top : '40%',
				left : '3%',
				right : '4%',
				bottom : '3%',
				containLabel : true
			},
			color : [ '#FF4949', '#FFA74D', '#FFEA51', '#4BF0FF', '#44AFF0',
					'#4E82FF', '#584BFF', '#BE4DFF', '#F845F1' ],
			xAxis : {
				type : 'category',
				boundaryGap : false,
				data : years,
				splitLine : {
					show : false
				},
				axisLine : {
					lineStyle : {
						color : '#fff'
					}
				}
			},
			yAxis : {
				name : '亿吨公里',
				type : 'value',
				splitLine : {
					show : false
				},
				axisLine : {
					lineStyle : {
						color : '#fff'
					}
				}
			},
			series : [ {
				name : '铁路货物',
				type : 'line',
				data : total_railways
			}, {
				name : '国家铁路货物',
				type : 'line',
				data : national_railways
			}, {
				name : '地方铁路货物',
				type : 'line',
				data : local_railways
			}, {
				name : '合资铁路货物',
				type : 'line',
				data : joint_venture_railways
			}, {
				name : '公路货物',
				type : 'line',
				data : highways
			}, {
				name : '水运货物',
				type : 'line',
				data : waterways
			} ]
		};
		myChart.setOption(option);
	}

	echart_4();
	// 湖南高速公路
	function echart_4() {
		// 基于准备好的dom，初始化echarts实例
		var myChart = echarts.init(document.getElementById('chart_4'));

		myChart.setOption({
			series : [ {
				type : 'map',
				mapType : 'hunan'
			} ]
		});

		var geoCoordMap = {
			'怀化' : [ 109.999867, 27.518949 ],
			'吉首' : [ 109.741528, 28.332629 ],
			'张家界' : [ 110.491722, 29.112001 ],
			'常德' : [ 111.701486, 29.076683 ],
			'益阳' : [ 112.348741, 28.544124 ],
			'岳阳' : [ 113.126486, 29.382401 ],
			'长沙' : [ 113.019455, 28.200103 ],
			'株洲' : [ 113.163141, 27.8418 ],
			'湘潭' : [ 112.91977, 27.882141 ],
			'邵阳' : [ 111.467859, 27.21915 ],
			'娄底' : [ 112.012438, 27.745506 ],
			'衡阳' : [ 112.63809, 26.895225 ],
			'永州' : [ 111.577632, 26.460144 ],
			'郴州' : [ 113.039396, 25.81497 ]
		};

		var goData = [ [ {
			name : '张家界'

		}, {
			id : 1,
			name : '常德',
			value : 86
		} ], [ {
			name : '吉首'

		}, {
			id : 1,
			name : '常德',
			value : 86
		} ], [ {
			name : '常德'

		}, {
			id : 1,
			name : '益阳',
			value : 70
		} ], [ {
			name : '益阳'

		}, {
			id : 1,
			name : '长沙',
			value : 95
		} ], [ {
			name : '长沙'

		}, {
			id : 1,
			name : '岳阳',
			value : 70
		} ], [ {
			name : '长沙'

		}, {
			id : 1,
			name : '湘潭',
			value : 80
		} ], [ {
			name : '长沙'

		}, {
			id : 1,
			name : '株洲',
			value : 80
		} ], [ {
			name : '长沙'

		}, {
			id : 1,
			name : '衡阳',
			value : 80
		} ], [ {
			name : '衡阳'

		}, {
			id : 1,
			name : '郴州',
			value : 70
		} ], [ {
			name : '衡阳'

		}, {
			id : 1,
			name : '永州',
			value : 70
		} ], [ {
			name : '湘潭'

		}, {
			id : 1,
			name : '娄底',
			value : 60
		} ], [ {
			name : '娄底'

		}, {
			id : 1,
			name : '邵阳',
			value : 75
		} ], [ {
			name : '邵阳'

		}, {
			id : 1,
			name : '怀化',
			value : 75
		} ], ];
		// 值控制圆点大小
		var backData = [ [ {
			name : '常德'

		}, {
			id : 1,
			name : '张家界',
			value : 80
		} ], [ {
			name : '常德'

		}, {
			id : 1,
			name : '吉首',
			value : 66
		} ], [ {
			name : '益阳'

		}, {
			id : 1,
			name : '常德',
			value : 86
		} ], [ {
			name : '长沙'

		}, {
			id : 1,
			name : '益阳',
			value : 70
		} ], [ {
			name : '岳阳'

		}, {
			id : 1,
			name : '长沙',
			value : 95
		} ], [ {
			name : '湘潭'

		}, {
			id : 1,
			name : '长沙',
			value : 95
		} ], [ {
			name : '株洲'

		}, {
			id : 1,
			name : '长沙',
			value : 95
		} ], [ {
			name : '衡阳'

		}, {
			id : 1,
			name : '长沙',
			value : 95
		} ], [ {
			name : '郴州'

		}, {
			id : 1,
			name : '衡阳',
			value : 80
		} ], [ {
			name : '永州'

		}, {
			id : 1,
			name : '衡阳',
			value : 80
		} ], [ {
			name : '娄底'

		}, {
			id : 1,
			name : '湘潭',
			value : 80
		} ], [ {
			name : '邵阳'

		}, {
			id : 1,
			name : '娄底',
			value : 60
		} ], [ {
			name : '怀化'

		}, {
			id : 1,
			name : '邵阳',
			value : 75
		} ], ];

		var planePath = 'path://M1705.06,1318.313v-89.254l-319.9-221.799l0.073-208.063c0.521-84.662-26.629-121.796-63.961-121.491c-37.332-0.305-64.482,36.829-63.961,121.491l0.073,208.063l-319.9,221.799v89.254l330.343-157.288l12.238,241.308l-134.449,92.931l0.531,42.034l175.125-42.917l175.125,42.917l0.531-42.034l-134.449-92.931l12.238-241.308L1705.06,1318.313z';
		var arcAngle = function(data) {
			var j, k;
			for (var i = 0; i < data.length; i++) {
				var dataItem = data[i];
				if (dataItem[1].id == 1) {
					j = 0.2;
					return j;
				} else if (dataItem[1].id == 2) {
					k = -0.2;
					return k;
				}
			}
		}

		var convertData = function(data) {
			var res = [];
			for (var i = 0; i < data.length; i++) {
				var dataItem = data[i];
				var fromCoord = geoCoordMap[dataItem[0].name];
				var toCoord = geoCoordMap[dataItem[1].name];
				if (dataItem[1].id == 1) {
					if (fromCoord && toCoord) {
						res.push([ {
							coord : fromCoord,
						}, {
							coord : toCoord,
							value : dataItem[1].value
						// 线条颜色

						} ]);
					}
				} else if (dataItem[1].id == 2) {
					if (fromCoord && toCoord) {
						res.push([ {
							coord : fromCoord,
						}, {
							coord : toCoord
						} ]);
					}
				}
			}
			return res;
		};

		var color = [ '#fff', '#FF1493', '#0000FF' ];
		var series = [];
		[ [ '1', goData ], [ '2', backData ] ].forEach(function(item, i) {
			series.push({
				name : item[0],
				type : 'lines',
				zlevel : 2,
				symbol : [ 'arrow', 'arrow' ],
				// 线特效配置
				effect : {
					show : true,
					period : 6,
					trailLength : 0.1,
					symbol : 'arrow', // 标记类型
					symbolSize : 5
				},
				lineStyle : {
					normal : {
						width : 1,
						opacity : 0.4,
						curveness : arcAngle(item[1]), // 弧线角度
						color : '#fff'
					}
				},
				edgeLabel : {
					normal : {
						show : true,
						textStyle : {
							fontSize : 14
						},
						formatter : function(params) {
							var txt = '';
							if (params.data.speed !== undefined) {
								txt = params.data.speed;
							}
							return txt;
						},
					}
				},
				data : convertData(item[1])
			}, {
				type : 'effectScatter',
				coordinateSystem : 'geo',
				zlevel : 2,
				// 波纹效果
				rippleEffect : {
					period : 2,
					brushType : 'stroke',
					scale : 3
				},
				label : {
					normal : {
						show : true,
						color : '#fff',
						position : 'right',
						formatter : '{b}'
					}
				},
				// 终点形象
				symbol : 'circle',
				// 圆点大小
				symbolSize : function(val) {
					return val[2] / 8;
				},
				itemStyle : {
					normal : {
						show : true
					}
				},
				data : item[1].map(function(dataItem) {
					return {
						name : dataItem[1].name,
						value : geoCoordMap[dataItem[1].name]
								.concat([ dataItem[1].value ])
					};
				})

			});

		});

		option = {
			title : {
				text : '',
				subtext : '',
				left : 'center',
				textStyle : {
					color : '#fff'
				}
			},
			tooltip : {
				trigger : 'item',
				formatter : '{b}'
			},
			// 线颜色及飞行轨道颜色
			visualMap : {
				show : false,
				min : 0,
				max : 100,
				color : [ '#31A031', '#31A031' ]
			},
			// 地图相关设置
			geo : {
				map : 'hunan',
				// 视角缩放比例
				zoom : 1,
				// 显示文本样式
				label : {
					normal : {
						show : false,
						textStyle : {
							color : '#fff'
						}
					},
					emphasis : {
						textStyle : {
							color : '#fff'
						}
					}
				},
				// 鼠标缩放和平移
				roam : true,
				itemStyle : {
					normal : {
						// color: '#ddd',
						borderColor : 'rgba(147, 235, 248, 1)',
						borderWidth : 1,
						areaColor : {
							type : 'radial',
							x : 0.5,
							y : 0.5,
							r : 0.8,
							colorStops : [ {
								offset : 0,
								color : 'rgba(175,238,238, 0)' // 0% 处的颜色
							}, {
								offset : 1,
								color : 'rgba(	47,79,79, .2)' // 100% 处的颜色
							} ],
							globalCoord : false
						// 缺省为 false
						},
						shadowColor : 'rgba(128, 217, 248, 1)',
						// shadowColor: 'rgba(255, 255, 255, 1)',
						shadowOffsetX : -2,
						shadowOffsetY : 2,
						shadowBlur : 10
					},
					emphasis : {
						areaColor : '#389BB7',
						borderWidth : 0
					}
				}
			},
			series : series
		};
		myChart.setOption(option);
	}

	echart_5();
	// 湖南省飞机场
	function echart_5() {
		// 基于准备好的dom，初始化echarts实例
		var myChart = echarts.init(document.getElementById('chart_5'));

		function showProvince() {
			var geoCoordMap = {
				'长沙黄花国际机场' : [ 113.226512, 28.192929 ],
				'张家界荷花机场' : [ 110.454598, 29.107223 ],
				'常德桃花源机场' : [ 111.651508, 28.921516 ],
				'永州零陵机场' : [ 111.622869, 26.340994 ],
				'怀化芷江机场' : [ 109.714784, 27.44615 ],
			};
			var data = [ {
				name : '长沙黄花国际机场',
				value : 100
			}, {
				name : '张家界荷花机场',
				value : 100
			}, {
				name : '常德桃花源机场',
				value : 100
			}, {
				name : '永州零陵机场',
				value : 100
			}, {
				name : '怀化芷江机场',
				value : 100
			} ];
			var max = 480, min = 9; // todo
			var maxSize4Pin = 100, minSize4Pin = 20;
			var convertData = function(data) {
				var res = [];
				for (var i = 0; i < data.length; i++) {
					var geoCoord = geoCoordMap[data[i].name];
					if (geoCoord) {
						res.push({
							name : data[i].name,
							value : geoCoord.concat(data[i].value)
						});
					}
				}
				return res;
			};

			myChart.setOption(option = {
				title : {
					top : 20,
					text : '',
					subtext : '',
					x : 'center',
					textStyle : {
						color : '#ccc'
					}
				},
				legend : {
					orient : 'vertical',
					y : 'bottom',
					x : 'right',
					data : [ 'pm2.5' ],
					textStyle : {
						color : '#fff'
					}
				},
				visualMap : {
					show : false,
					min : 0,
					max : 500,
					left : 'left',
					top : 'bottom',
					text : [ '高', '低' ], // 文本，默认为数值文本
					calculable : true,
					seriesIndex : [ 1 ],
					inRange : {}
				},
				geo : {
					show : true,
					map : 'hunan',
					mapType : 'hunan',
					label : {
						normal : {},
						// 鼠标移入后查看效果
						emphasis : {
							textStyle : {
								color : '#fff'
							}
						}
					},
					// 鼠标缩放和平移
					roam : true,
					itemStyle : {
						normal : {
							// color: '#ddd',
							borderColor : 'rgba(147, 235, 248, 1)',
							borderWidth : 1,
							areaColor : {
								type : 'radial',
								x : 0.5,
								y : 0.5,
								r : 0.8,
								colorStops : [ {
									offset : 0,
									color : 'rgba(175,238,238, 0)' // 0% 处的颜色
								}, {
									offset : 1,
									color : 'rgba(	47,79,79, .2)' // 100% 处的颜色
								} ],
								globalCoord : false
							// 缺省为 false
							},
							shadowColor : 'rgba(128, 217, 248, 1)',
							shadowOffsetX : -2,
							shadowOffsetY : 2,
							shadowBlur : 10
						},
						emphasis : {
							areaColor : '#389BB7',
							borderWidth : 0
						}
					}
				},
				series : [ {
					name : 'light',
					type : 'map',
					coordinateSystem : 'geo',
					data : convertData(data),
					itemStyle : {
						normal : {
							color : '#F4E925'
						}
					}
				}, {
					name : '点',
					type : 'scatter',
					coordinateSystem : 'geo',
					symbol : 'pin',
					symbolSize : function(val) {
						var a = (maxSize4Pin - minSize4Pin) / (max - min);
						var b = minSize4Pin - a * min;
						b = maxSize4Pin - a * max;
						return a * val[2] + b;
					},
					label : {
						normal : {
						// show: true,
						// textStyle: {
						// color: '#fff',
						// fontSize: 9,
						// }
						}
					},
					itemStyle : {
						normal : {
							color : '#F62157', // 标志颜色
						}
					},
					zlevel : 6,
					data : convertData(data),
				}, {
					name : 'light',
					type : 'map',
					mapType : 'hunan',
					geoIndex : 0,
					aspectScale : 0.75, // 长宽比
					showLegendSymbol : false, // 存在legend时显示
					label : {
						normal : {
							show : false
						},
						emphasis : {
							show : false,
							textStyle : {
								color : '#fff'
							}
						}
					},
					roam : true,
					itemStyle : {
						normal : {
							areaColor : '#031525',
							borderColor : '#FFFFFF',
						},
						emphasis : {
							areaColor : '#2B91B7'
						}
					},
					animation : false,
					data : data
				}, {
					name : ' ',
					type : 'effectScatter',
					coordinateSystem : 'geo',
					data : convertData(data.sort(function(a, b) {
						return b.value - a.value;
					}).slice(0, 5)),
					symbolSize : function(val) {
						return val[2] / 10;
					},
					showEffectOn : 'render',
					rippleEffect : {
						brushType : 'stroke'
					},
					hoverAnimation : true,
					label : {
						normal : {
							formatter : '{b}',
							position : 'right',
							show : true
						}
					},
					itemStyle : {
						normal : {
							color : '#05C3F9',
							shadowBlur : 10,
							shadowColor : '#05C3F9'
						}
					},
					zlevel : 1
				},

				]
			});
		}
		showProvince();
		// 使用刚指定的配置项和数据显示图表。
		// myChart.setOption(option);
		window.addEventListener("resize", function() {
			myChart.resize();
		});
	}

	// 点击跳转
	$('#chart_map').click(function() {
		window.location.href = "detail?id=1";
	});
	$('.t_btn2').click(function() {
		window.location.href = "detail?id=2";
	});
	$('.t_btn3').click(function() {
		window.location.href = "detail?id=3";
	});
	$('.t_btn4').click(function() {
		window.location.href = "detail?id=4";
	});
	$('.t_btn5').click(function() {
		window.location.href = "detail?id=5";
	});
	$('.t_btn6').click(function() {
		window.location.href = "detail?id=6";
	});
	$('.t_btn7').click(function() {
		window.location.href = "detail?id=7";
	});
	$('.t_btn8').click(function() {
		window.location.href = "detail?id=8";
	});
	$('.t_btn9').click(function() {
		window.location.href = "detail?id=9";
	});
});