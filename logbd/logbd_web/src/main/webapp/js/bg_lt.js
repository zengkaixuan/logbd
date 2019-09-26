function pageClick(k) {
	$(k).parent().find("div").removeClass("active");
	$(k).addClass("active");
	$("#flTitle").text($(k).text());
}
$(function(){
		//user表数据
		$(".active").click(function() {
	         $.ajax({
				  type : 'GET',
				  url : '/logbd_web/ajax/div1',
				  dataType : 'JSON',
				  success : function(data) {
					   //刷新页面前清除数据
					   $(".tables tr").remove();
					   $(".xiaLaXuan select").remove();
					  
					  //获取后台数据
					  var arrs = data;
					  //生成表头
					  var $th = $("<tr><th>" + '编号'
									+ "</th><th>"
									+ '用户名'
									+ "</th><th>"
									+ '用户密码'
									+ "</th><th>" + '操作'
									+ "</th></tr>");
						//添加表头
						$(".tables").append($th);
						//生成下拉选头部
						var $select = $("<select  class='op1'><option>"+'请选择用户编号'+"</option></select>");
						//添加下拉选头部
						$(".xiaLaXuan").append($select);
						for (var i = 0; i < arrs.length; i++) {
								var arr = arrs[i];
								//下拉选内容
								var $option = $("<option value='"+(i+1)+"'>"+arr.id+"</option>");
								//创建一个tr元素，用来生成表格内容
								var $tr = $("<tr ><td>"
										+ arr.id
										+ "</td><td>"
										+ arr.userName
										+ "</td><td>"
										+ arr.password
										+ "</td>"
										+ "<td><a href='javascript:del(\""
										+ arr.id
										+ "\");'>删除</a><a href='#'>修改</a></td></tr>");
									    $(".tables").append($tr);
									    //添加下拉选内容
									    $(".xiaLaXuan select").append($option);
											}
						
						$(".xiaLaXuan select").change(function(){
							var i = $(this).val();
							if(isNaN(i)){
								$(".tables tr").show();
								return;
							}
							$(".tables tr:eq("+i+")").show();
							$(".tables tr:not(:eq("+i+"))").hide();
							$(".tables tr:eq(0)").show();
							
						});
		
					},
					error : function(er) {
							alert("er");
					}
			});

	});
		//第二张表
		$(".div2").click(function() {
			 
			  $.ajax({
					type : 'GET',
					url : '/logbd_web/ajax/div2',
					dataType : 'JSON',
					success : function(data) {
						  console.log(data);
						      //每次刷新前清除页面数据
                              $(".tables tr").remove();
                              $(".xiaLaXuan select").remove();
                              
						      var arrs = data;
								//生成下拉选头部
								var $select = $("<select><option>"+'请选择年份'+"</option></select>");
								//添加下拉选头部
								$(".xiaLaXuan").append($select);
							  var $th = $("<tr ><th>" + '年份'
											+ "</th><th>" + '省内(万件)'
											+ "</th><th>" + '省外(万件)'
											+ "</th><th>" + '国际(万件)'
											+ "</th><th>" + '总业务量(万件)'
											+ "</th><th>" + '操作'
											+ "</th></tr>");
							  $(".tables").append($th);
									for (var i = 0; i < arrs.length; i++) {
										 var arr = arrs[i];
										//下拉选内容
											var $option = $("<option value='"+(i+1)+"'>"+arr.years+"</option>");
										 //创建一个tr元素
										 var $tr = $("<tr><td>" + arr.years
												+ "</td><td>" + arr.total_volume
												+ "</td><td>" + arr.other_provinces
												+ "</td><td>" + arr.province
												+ "</td><td>" + arr.international
												+ "</td><td><a href='javascript:del(\""
												+ arr.years
												+ "\");'>删除</a><a href='#'>修改</a></td></tr>");
										$(".tables").append($tr);
										 //添加下拉选内容
									    $(".xiaLaXuan select").append($option);
									    
									    
									    
											
									}
									
									$(".xiaLaXuan select").change(function(){
										 //console.log($(this).val());
										var i = $(this).val();
										if(isNaN(i)){
											$(".tables tr").show();
											return;
										}
										$(".tables tr:eq("+i+")").show();
										$(".tables tr:not(:eq("+i+"))").hide();
										$(".tables tr:eq(0)").show();
										
									});
								},
					error : function(er) {
						    if(er.responseText=="NO_LOGIN"){
						    	alert("请先登陆");
						    }
						    
							
					}
			});

		}); 
//第三表
		$(".div3").click(function() {
			  $.ajax({
					type : 'GET',
					url : '/logbd_web/ajax/div3',
					dataType : 'JSON',
					success : function(data) {
                            $(".tables tr").remove();
                            $(".xiaLaXuan select").remove();
						      var arrs = data;
						    //生成下拉选头部
								var $select = $("<select><option>"+'请选择id'+"</option></select>");
								//添加下拉选头部
								$(".xiaLaXuan").append($select);
							  var $th = $("<tr><th>" + '城市'
											+ "</th><th>" + '货运收入'
											+ "</th><th>" + '操作'
											+ "</th></tr>");
							  $(".tables").append($th);
									for (var i = 0; i < arrs.length; i++) {
										 var arr = arrs[i];
										//下拉选内容
											var $option = $("<option  value='"+(i+1)+"'>"+arr.id+"</option>");
										 //创建一个tr元素
										 var $tr = $("<tr><td>" + arr.city
												+ "</td><td>" + arr.income
												+ "</td><td><a href='javascript:del(\""
												+ arr.years
												+ "\");'>删除</a><a href='#'>修改</a></td></tr>");
										$(".tables").append($tr);
										 //添加下拉选内容
									    $(".xiaLaXuan select").append($option);
											
									}
									
									$(".xiaLaXuan select").change(function(){
										 //console.log($(this).val());
										var i = $(this).val();
										if(isNaN(i)){
											$(".tables tr").show();
											return;
										}
										$(".tables tr:eq("+i+")").show();
										$(".tables tr:not(:eq("+i+"))").hide();
										$(".tables tr:eq(0)").show();
										
									});
									
									
									
								},
					error : function(er) {
							alert("er");
					}
			});

		});
		//第四张表
		$(".div4").click(function() {
			  $.ajax({
					type : 'GET',
					url : '/logbd_web/ajax/div4',
					dataType : 'JSON',
					success : function(data) {
                            $(".tables tr").remove();
                            $(".xiaLaXuan select").remove();
						      var arrs = data;
						    //生成下拉选头部
								var $select = $("<select><option>"+'请选择年份'+"</option></select>");
								//添加下拉选头部
								$(".xiaLaXuan").append($select);
							  var $th = $("<tr><th>" + '年份'
											+ "</th><th>" + '铁路货物'
											+ "</th><th>" + '国家铁路货物'
											+ "</th><th>" + '当地铁路货物'
											+ "</th><th>" + '合资铁路货物'
											+ "</th><th>" + '公路货物'
											+ "</th><th>" + '水运货物'
											+ "</th><th>" + '操作'
											+ "</th></tr>");
							  $(".tables").append($th);
									for (var i = 0; i < arrs.length; i++) {
										 var arr = arrs[i];
										//下拉选内容
											var $option = $("<option  value='"+(i+1)+"'>"+arr.years+"</option>");
										 //创建一个tr元素
										 var $tr = $("<tr><td>" + arr.years
												+ "</td><td>" + arr.total_railway
												+ "</td><td>" + arr.national_railway
												+ "</td><td>" + arr.local_railway
												+ "</td><td>" + arr.joint_venture_railway
												+ "</td><td>" + arr.highway
												+ "</td><td>" + arr.waterway
												+ "</td><td><a href='javascript:del(\""
												+ arr.years
												+ "\");'>删除</a><a href='#'>修改</a></td></tr>");
										$(".tables").append($tr);
										 //添加下拉选内容
									    $(".xiaLaXuan select").append($option);
											
									}
									
									$(".xiaLaXuan select").change(function(){
										 //console.log($(this).val());
										var i = $(this).val();
										if(isNaN(i)){
											$(".tables tr").show();
											return;
										}
										$(".tables tr:eq("+i+")").show();
										$(".tables tr:not(:eq("+i+"))").hide();
										$(".tables tr:eq(0)").show();
										
									});
									
									
								},
					error : function(er) {
							alert("er");
					}
			});

		});
		//第五张表
		$(".div5").click(function() {
			  $.ajax({
					type : 'GET',
					url : '/logbd_web/ajax/div5',
					dataType : 'JSON',
					success : function(data) {
                            $(".tables tr").remove();
                            $(".xiaLaXuan select").remove();
						      var arrs = data;
						    //生成下拉选头部
								var $select = $("<select><option>"+'请选择年份'+"</option></select>");
								//添加下拉选头部
								$(".xiaLaXuan").append($select);
							  var $th = $("<tr><th>" + '年份'
											+ "</th><th>" + '总计'
											+ "</th><th>" + '铁路货物'
											+ "</th><th>" + '国家铁路货物'
											+ "</th><th>" + '地方铁路货物'
											+ "</th><th>" + '合资铁路货物'
											+ "</th><th>" + '公路货物'
											+ "</th><th>" + '水运货物'
											+ "</th><th>" + '操作'
											+ "</th></tr>");
							  $(".tables").append($th);
									for (var i = 0; i < arrs.length; i++) {
										 var arr = arrs[i];
										//下拉选内容
											var $option = $("<option value='"+(i+1)+"'>"+arr.years+"</option>");
										 //创建一个tr元素
										 var $tr = $("<tr><td>" + arr.years
												+ "</td><td>" + arr.total
												+ "</td><td>" + arr.total_railway
												+ "</td><td>" + arr.national_railway
												+ "</td><td>" + arr.local_railway
												+ "</td><td>" + arr.joint_venture_railway
												+ "</td><td>" + arr.highway
												+ "</td><td>" + arr.waterway
												+ "</td><td><a href='javascript:del(\""
												+ arr.years
												+ "\");'>删除</a><a href='#'>修改</a></td></tr>");
										$(".tables").append($tr);
										 //添加下拉选内容
									    $(".xiaLaXuan select").append($option);
											
									}
									
									$(".xiaLaXuan select").change(function(){
										 //console.log($(this).val());
										var i = $(this).val();
										if(isNaN(i)){
											$(".tables tr").show();
											return;
										}
										$(".tables tr:eq("+i+")").show();
										$(".tables tr:not(:eq("+i+"))").hide();
										$(".tables tr:eq(0)").show();
										
									});
									
									
									
								},
					error : function(er) {
							alert("er");
					}
			});

		});
	
		 //第六张表
		$(".div6").click(function() {
			  $.ajax({
					type : 'GET',
					url : '/logbd_web/ajax/div6',
					dataType : 'JSON',
					success : function(data) {
                            $(".tables tr").remove();
                            $(".xiaLaXuan select").remove();
						      var arrs = data;
						    //生成下拉选头部
								var $select = $("<select><option>"+'请选择年份'+"</option></select>");
								//添加下拉选头部
								$(".xiaLaXuan").append($select);
							  var $th = $("<tr><th>" + '年份'
											+ "</th><th>" + '运营数(辆)'
											+ "</th><th>" + '线路总长度(公里)'
											+ "</th><th>" + '客运总量(万人次)'
											+ "</th><th>" + '操作'
											+ "</th></tr>");
							  $(".tables").append($th);
									for (var i = 0; i < arrs.length; i++) {
										 var arr = arrs[i];
										//下拉选内容
											var $option = $("<option  value='"+(i+1)+"'>"+arr.years+"</option>");
										 //创建一个tr元素
										 var $tr = $("<tr><td>" + arr.years
												+ "</td><td>" + arr.total_operations_num
												+ "</td><td>" + arr.total_transline_length
												+ "</td><td>" + arr.total_passengers
												+ "</td><td><a href='javascript:del(\""
												+ arr.years
												+ "\");'>删除</a><a href='#'>修改</a></td></tr>");
										$(".tables").append($tr);
										 //添加下拉选内容
									    $(".xiaLaXuan select").append($option);
											
									}
									

									$(".xiaLaXuan select").change(function(){
										 //console.log($(this).val());
										var i = $(this).val();
										if(isNaN(i)){
											$(".tables tr").show();
											return;
										}
										$(".tables tr:eq("+i+")").show();
										$(".tables tr:not(:eq("+i+"))").hide();
										$(".tables tr:eq(0)").show();
										
									});
									
									
								},
					error : function(er) {
							alert("er");
					}
			});

		});
		//第七张表
		$(".div7").click(function() {
			  $.ajax({
					type : 'GET',
					url : '/logbd_web/ajax/div7',
					dataType : 'JSON',
					success : function(data) {
                            $(".tables tr").remove();
                            $(".xiaLaXuan select").remove();
						      var arrs = data;
						    //生成下拉选头部
								var $select = $("<select><option>"+'请选择年份'+"</option></select>");
								//添加下拉选头部
								$(".xiaLaXuan").append($select);
							  var $th = $("<tr><th>" + '年份'
											+ "</th><th>" + '铁路运输业'
											+ "</th><th>" + '公路运输业'
											+ "</th><th>" + '水路交通业'
											+ "</th><th>" + '航空运输业'
											+ "</th><th>" + '管道运输业'
											+ "</th><th>" + '其它运输服务业'
											+ "</th><th>" + '操作'
											+ "</th></tr>");
							  $(".tables").append($th);
									for (var i = 0; i < arrs.length; i++) {
										 var arr = arrs[i];
										//下拉选内容
											var $option = $("<option value='"+(i+1)+"'>"+arr.years+"</option>");
										 //创建一个tr元素
										 var $tr = $("<tr><td>" + arr.years
												+ "</td><td>" + arr.railway_transportation
												+ "</td><td>" + arr.highway_transportation
												+ "</td><td>" + arr.waterway_transportation
												+ "</td><td>" + arr.air_transportation
												+ "</td><td>" + arr.pipage_transportation
												+ "</td><td>" + arr.others
												+ "</td><td><a href='javascript:del(\""
												+ arr.years
												+ "\");'>删除</a><a href='#'>修改</a></td></tr>");
										$(".tables").append($tr);
										 //添加下拉选内容
									    $(".xiaLaXuan select").append($option);
											
									}
									
									$(".xiaLaXuan select").change(function(){
										 //console.log($(this).val());
										var i = $(this).val();
										if(isNaN(i)){
											$(".tables tr").show();
											return;
										}
										$(".tables tr:eq("+i+")").show();
										$(".tables tr:not(:eq("+i+"))").hide();
										$(".tables tr:eq(0)").show();
										
									});
								},
					error : function(er) {
							alert("er");
					}
			});

		});
		//第八张表
		$(".div8").click(function() {
			  $.ajax({
					type : 'GET',
					url : '/logbd_web/ajax/div8',
					dataType : 'JSON',
					success : function(data) {
                            $(".tables tr").remove();
                            $(".xiaLaXuan select").remove();
						      var arrs = data;
						    //生成下拉选头部
								var $select = $("<select><option>"+'请选择年份'+"</option></select>");
								//添加下拉选头部
								$(".xiaLaXuan").append($select);
							  var $th = $("<tr><th>" + '年份'
											+ "</th><th>" + '铁路营业里程'
											+ "</th><th>" + '公路通车里程'
											+ "</th><th>" + '等级公路里程'
											+ "</th><th>" + '高速等级公路里程'
											+ "</th><th>" + '一级等级公路里程'
											+ "</th><th>" + '二级等级公路里程'
											+ "</th><th>" + '等外公路公路里程'
											+ "</th><th>" + '操作'
											+ "</th></tr>");
							  $(".tables").append($th);
									for (var i = 0; i < arrs.length; i++) {
										 var arr = arrs[i];
										//下拉选内容
											var $option = $("<option value='"+(i+1)+"'>"+arr.years+"</option>");
										 //创建一个tr元素
										 var $tr = $("<tr><td>" + arr.years
												+ "</td><td>" + arr.railway_mileage
												+ "</td><td>" + arr.highway_mileage
												+ "</td><td>" + arr.classified_highway
												+ "</td><td>" + arr.highway
												+ "</td><td>" + arr.primary_road
												+ "</td><td>" + arr.secondary_road
												+ "</td><td>" + arr.other_road
												+ "</td><td><a href='javascript:del(\""
												+ arr.years
												+ "\");'>删除</a><a href='#'>修改</a></td></tr>");
										$(".tables").append($tr);
										 //添加下拉选内容
									    $(".xiaLaXuan select").append($option);
											
									}
									$(".xiaLaXuan select").change(function(){
										 //console.log($(this).val());
										var i = $(this).val();
										if(isNaN(i)){
											$(".tables tr").show();
											return;
										}
										$(".tables tr:eq("+i+")").show();
										$(".tables tr:not(:eq("+i+"))").hide();
										$(".tables tr:eq(0)").show();
										
									});
								},
					error : function(er) {
							alert("er");
					}
			});

		});
		//第九张表
		$(".div9").click(function() {
			  $.ajax({
					type : 'GET',
					url : '/logbd_web/ajax/div9',
					dataType : 'JSON',
					success : function(data) {
                            $(".tables tr").remove();
                            $(".xiaLaXuan select").remove();
						      var arrs = data;
						    //生成下拉选头部
								var $select = $("<select><option>"+'请选择年份'+"</option></select>");
								//添加下拉选头部
								$(".xiaLaXuan").append($select);
							  var $th = $("<tr><th>" + '年份'
											+ "</th><th>" + '运营线路总长度'
											+ "</th><th>" + '公共交通客运总量'
											+ "</th><th>" + '公共交通运营数'
											+ "</th><th>" + '操作'
											+ "</th></tr>");
							  $(".tables").append($th);
									for (var i = 0; i < arrs.length; i++) {
										 var arr = arrs[i];
										//下拉选内容
											var $option = $("<option value='"+(i+1)+"'>"+arr.years+"</option>");
										 //创建一个tr元素
										 var $tr = $("<tr><td>" + arr.years
												+ "</td><td>" + arr.total_vehicles
												+ "</td><td>" + arr.operating_passenger_capacity
												+ "</td><td>" + arr.operating_cargo_capacity
												+ "</td><td><a href='javascript:del(\""
												+ arr.years
												+ "\");'>删除</a><a href='#'>修改</a></td></tr>");
										$(".tables").append($tr);
										 //添加下拉选内容
									    $(".xiaLaXuan select").append($option);
											
									}
									
									$(".xiaLaXuan select").change(function(){
										 //console.log($(this).val());
										var i = $(this).val();
										if(isNaN(i)){
											$(".tables tr").show();
											return;
										}
										$(".tables tr:eq("+i+")").show();
										$(".tables tr:not(:eq("+i+"))").hide();
										$(".tables tr:eq(0)").show();
										
									});
								},
					error : function(er) {
							alert("er");
					}
			});
		});	
});
function del(years){
	   var url = document.delForm.action;
	   document.delForm.action = url+"/"+years;
	   //提交表单
	   document.delForm.submit();
	   
}