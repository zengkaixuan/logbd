$(function(){
	var echart_data;
	// 请求数据库所有
	$.ajax({
		async : false,
		type : "GET",
		url : "ajax_index",
		dataType : "JSON",
		success : function(data) {
			echart_data = data;
		},
		error : function() {
			alert("ajax错误");
		}
	});
	console.log(echart_data);
	
	//湖南省交通
	var table1=$("#table1");
	var t1_body=table1.append("<tbody></tbody>");
	var t1_data=echart_data[4];
	t1_data.forEach(function(i){
		t1_body.append("<tr><td>"+ i.years+"</td><td>"+ i.total_operations_num+"</td><td>"+ i.total_transline_length+"</td><td>"+ i.total_passengers+"</td></tr>")
	});
	
	//湖南省业务量
	var table2=$("#table2");
	var t2_body=table2.append("<tbody></tbody>");
	var t2_data=echart_data[0];
	t2_data.forEach(function(i){
		t2_body.append("<tr><td>"+ i.years+"</td><td>"+ i.province+"</td><td>"+ i.other_provinces+"</td><td>"+ i.international+"</td><td>"+ i.total_volume+"</td></tr>");
	});
	
	//湖南省汽车
	var table3=$("#table3");
	var t3_body=table3.append("<tbody></tbody>");
	var t3_data=echart_data[7];
	t3_data.forEach(function(i){
		t3_body.append("<tr><td>"+ i.years+"</td><td>"+ i.operating_passenger_capacity+"</td><td>"+ i.operating_cargo_capacity+"</td><td>"+ i.total_vehicles+"</td></tr>")
	});
});