function pageClick(k) {
	$(k).parent().find("div").removeClass("active");
	$(k).addClass("active");
	$("#flTitle").text($(k).text());
}

/**
 * user表
 */
$(function() {
	// user表数据
	$(".div1").click(
	function clickLleft() {
		var condition=$(".conditionUserInput").val();
		if(typeof condition=="undefined"){
			condition="";
		}
		conditionSearch="?condition="+condition;
		$.ajax({
			async: false,
			type : 'GET',
			url : '/logbd_web/ajax/div1'+conditionSearch,
			dataType : 'JSON',
			success : function(data) {
				// 刷新页面前清除数据
				$(".tables tr").remove();
				$(".xiaLaXuan select,input,span")
						.remove();
				var pageBean=data;
				// 获取后台数据
				var arrs = pageBean.list;
				// 生成表头
				var $th = $("<tr><th>" + '编号'
						+ "</th><th>" + '用户名'
						+ "</th><th>" + '用户密码'
						+ "</th><th>" + '操作'
						+ "</th></tr>");
				// 添加表头
				$(".tables").append($th);
				for (var i = 0; i < arrs.length; i++) {
					var arr = arrs[i];
					// 创建一个tr元素，用来生成表格内容
					var $tr = $("<tr ><td>"
							+ arr.id
							+ "</td><td>"
							+ arr.userName
							+ "</td><td>"
							+ arr.password
							+ "</td>"
							+ "<td><span class=\"delBtn\" onclick=\"delUser(this)\">删除</span>&nbsp;<span class=\"updateBtn\" onclick=\"toUpdateUser(this)\">修改</span></td></tr>");
					$(".tables").append($tr);
				}
				//添加页码
				var $fenYeDiv=$(".fenYe");
				var $pageNum="";
				var lastNum;
				for(var i=0;i<pageBean.totalPages;i++){
					var str="";
					if(pageBean.pageNo==(i+1)){
						str="class='onPage'";
					}
					$pageNum=$pageNum+("<span "+str+" onclick=\"changeUserPage('"+(i+1)+"')\">"+(i+1)+"</span>");
					lastNum=i+1;
				}
				var $pages=$("<span onclick=\"changeUserPage('1')\">|<</span>"+$pageNum+"<span onclick=\"changeUserPage('"+lastNum+"')\">>|</span>");
				$fenYeDiv.append($pages);
				// 增加信息
				var $add = $("<span class=\"addBlock fr\" onclick=\"toAddUser()\" >+&nbsp;增加</span>");
				$(".xiaLaXuan").append($add);
				// 条件框
				var $condition = $("<input class=\"conditionUserInput conditionInput fl\" placeholder=\"用户名关键字\" value=\"\"/>");
				$(".xiaLaXuan").append($condition);
				$('.conditionUserInput').val('').focus().val(condition);
			},
			error : function(er) {
				alert("er");
			}
		});
		
		//条件框改变事件
		$('.conditionUserInput').bind('keyup', function() {
		    // 绑定键盘按下并松开。。。
		   var condition=$(this).val();
		   $(".div1").click();
		});
	});
});

//User添加增加输入框
function toAddUser() {
	$(".fenYe>span:last").click();
	var $addTr = $("<tr id=\"addTr\">"
			+ "<td>无需手动填写</td>"
			+ "<td><input class=\"nameInput\" /></td>"
			+ "<td><input class=\"passInput\" /></td>"
			+ "<td><span class=\"clickBtn\" onclick=\"addUser()\">确定</span>&nbsp;<span class=\"cancelBtn\" onclick=\"cancelUser()\">取消</span></td>"
			+ "</tr>");
	$(".tables").append($addTr);
};
//User取消按键
function cancelUser(){
	var pageNum=$(".onPage")[0];
	pageNum.click();
};

//User换页
function changeUserPage(e){
	var condition=$(".conditionUserInput").val();
	if(typeof condition=="undefined"){
		condition="";
	}
	conditionSearch="?condition="+condition;
	$.ajax({
		async: false,
		type : 'GET',
		url : '/logbd_web/ajax/div1'+conditionSearch+'&pageNo='+e,
		dataType : 'JSON',
		success : function(data) {
			// 刷新页面前清除数据
			$(".tables tr").remove();
			$(".xiaLaXuan select,input,span")
					.remove();
			var pageBean=data;
			// 获取后台数据
			var arrs = pageBean.list;
			// 生成表头
			var $th = $("<tr><th>" + '编号'
					+ "</th><th>" + '用户名'
					+ "</th><th>" + '用户密码'
					+ "</th><th>" + '操作'
					+ "</th></tr>");
			// 添加表头
			$(".tables").append($th);
			// 生成下拉选头部
			/*var $select = $("<select  class='op1 fl'><option>"
					+ '请选择用户编号'
					+ "</option></select>");
			// 添加下拉选头部
			$(".xiaLaXuan").append($select);*/
			for (var i = 0; i < arrs.length; i++) {
				var arr = arrs[i];
				// 创建一个tr元素，用来生成表格内容
				var $tr = $("<tr ><td>"
						+ arr.id
						+ "</td><td>"
						+ arr.userName
						+ "</td><td>"
						+ arr.password
						+ "</td>"
						+ "<td><span class=\"delBtn\" onclick=\"delUser(this)\">删除</span>&nbsp;<span class=\"updateBtn\" onclick=\"toUpdateUser(this)\">修改</span></td></tr>");
				$(".tables").append($tr);
			}
			//添加页码
			var $fenYeDiv=$(".fenYe");
			var $pageNum="";
			var lastNum;
			for(var i=0;i<pageBean.totalPages;i++){
				var str="";
				if(pageBean.pageNo==(i+1)){
					str="class='onPage'";
				}
				$pageNum=$pageNum+("<span "+str+" onclick=\"changeUserPage('"+(i+1)+"')\">"+(i+1)+"</span>");
				lastNum=i+1;
			}
			var $pages=$("<span onclick=\"changeUserPage('1')\">|<</span>"+$pageNum+"<span onclick=\"changeUserPage('"+lastNum+"')\">>|</span>");
			$fenYeDiv.append($pages);

			// 条件框
			var $condition = $("<input class=\"conditionUserInput conditionInput fl\" placeholder=\"用户名关键字\" value=\""+condition+"\"/>");
			$(".xiaLaXuan").append($condition);
			
			// 增加信息
			var $add = $("<span class=\"addBlock fr\" onclick=\"toAddUser()\" >+&nbsp;增加</span>");
			$(".xiaLaXuan").append($add);
		},
		error : function(er) {
			alert("er");
		}
	});
	//条件框改变事件
	$('.conditionUserInput').bind('keyup', function() {
	    // 绑定键盘按下并松开。。。
	   var condition=$(this).val();
	   $(".div1").click();
	});
}

//User添加User
function addUser() {
	var $name = $("#addTr>td:eq(1)>input").val();
	var $pass = $("#addTr>td:eq(2)>input").val();
	var retName=/^[a-zA-Z]\w{2,15}$/;
	var retPass=/^\w{3,16}$/;
	if ($name == "" || $pass == "") {
		alert("用户名或密码不能为空!");
		return false;
	}else if(!retName.test($name)){
		alert("用户名必须3到16位以英文字母开头的字母数字组合!");
		return false;
	}else if(!retPass.test($pass)){
		alert("密码必须3到16位字母数字组合!");
		return false;
	}
	var user = {
		"id" : "",
		"userName" : $name,
		"password" : $pass
	};

	$.ajax({
		url : "/logbd_web/ajax/addUser",
		async : false,
		type : "POST",
		contentType : 'application/json',
		dataType : "TEXT",
		data : JSON.stringify(user),
		success : function(data) {
			$(".active").trigger("click");
		},
		error : function() {
			alert("未知错误,请联系管理员");
			return false;
		}
	});
	$(".fenYe>span:last").click();
}
//User删除User
function delUser(e){
	var id=e.parentElement.parentElement.firstChild.innerHTML;
	var pageNum=$(".onPage")[0];
	$.ajax({
		url : "/logbd_web/ajax/delUser?id="+id,
		async : false,
		type : "POST",
		contentType : 'application/json',
		dataType : "TEXT",
		data : id.toString(),
		success : function(data) {
			$(".active").trigger("click");
		},
		error : function() {
			alert("未知错误,请联系管理员");
			return false;
		}
	});
	pageNum.click();
}

//User添加修改栏
function toUpdateUser(e){
	var $Tr=e.parentElement.parentElement;
	var $nameTd=$Tr.children[1];
	var $passTd=$Tr.children[2];
	var name=$nameTd.innerHTML;
	var pass=$passTd.innerHTML;
	$nameTd.innerHTML="";
	$nameInput=$("<input class=\"nameInput\" value="+name+" />");
	$($nameTd).append($nameInput);
	$passTd.innerHTML="";
	$passInput=$("<input class=\"passInput\" value="+pass+" />");
	$($passTd).append($passInput);
	
	var $opraTd=$Tr.children[3];
	$opraTd.innerHTML="";
	$btn=$("<span class=\"clickBtn\" onclick=\"updateUser(this)\">确定</span>&nbsp;<span class=\"cancelBtn\" onclick=\"cancelUser()\">取消</span>");
	$($opraTd).append($btn);
}
//User修改用户
function updateUser(e){
	var $Tr=e.parentElement.parentElement;
	var $id=$Tr.children[0].innerHTML;
	var $name = $($Tr).find("td:eq(1)>input").val();
	var $pass = $($Tr).find("td:eq(2)>input").val();
	var pageNum=$(".onPage")[0];
	var retName=/^[a-zA-Z]\w{2,15}$/;
	var retPass=/^\w{3,16}$/;
	if ($name == "" || $pass == "") {
		alert("用户名或密码不能为空!");
		return false;
	}else if(!retName.test($name)){
		alert("用户名必须3到16位以英文字母开头的字母数字组合!");
		return false;
	}else if(!retPass.test($pass)){
		alert("密码必须3到16位字母数字组合!");
		return false;
	}
	var user = {
		"id" : $id,
		"userName" : $name,
		"password" : $pass
	};
	
	$.ajax({
		url : "/logbd_web/ajax/updateUser",
		async : false,
		type : "POST",
		contentType : 'application/json',
		dataType : "TEXT",
		data : JSON.stringify(user),
		success : function(data) {
			$(".active").trigger("click");
		},
		error : function() {
			alert("未知错误,请联系管理员");
			return false;
		}
	});
	pageNum.click();
}

/**
 * 湖南省业务量
 */
$(function() {
	// Hunan_business_volume表数据
	$(".div2").click(
	function clickLleft() {
		var condition=$(".conditionHBVInput").val();
		var conditionSearch="?condition="+condition;
		if(typeof condition=="undefined"){
			conditionSearch="";
		}
		$.ajax({
			async: false,
			type : 'GET',
			url : '/logbd_web/ajax/div2'/*+conditionSearch*/,
			dataType : 'JSON',
			success : function(data) {
				// 刷新页面前清除数据
				$(".tables tr").remove();
				$(".xiaLaXuan select,input,span")
						.remove();
				var pageBean=data;
				// 获取后台数据
				var arrs = pageBean.list;
				// 生成表头
				var $th = $("<tr><th>" + '年份'
						+ "</th><th>" + '总业务量'
						+ "</th><th>" + '外省业务量'
						+ "</th><th>" + '省内业务量'
						+ "</th><th>" + '国际业务量'
						+ "</th><th>" + '操作'
						+ "</th></tr>");
				// 添加表头
				$(".tables").append($th);
				for (var i = 0; i < arrs.length; i++) {
					var arr = arrs[i];
					// 创建一个tr元素，用来生成表格内容
					var $tr = $("<tr ><td>"
							+ arr.years
							+ "</td><td>"
							+ arr.total_volume
							+ "</td><td>"
							+ arr.other_provinces
							+ "</td><td>"
							+ arr.province
							+ "</td><td>"
							+ arr.international
							+ "</td>"
							+ "<td><span class=\"delBtn\" onclick=\"delHBV(this)\">删除</span>&nbsp;<span class=\"updateBtn\" onclick=\"toUpdateHBV(this)\">修改</span></td></tr>");
					$(".tables").append($tr);
				}
				//添加页码
				var $fenYeDiv=$(".fenYe");
				var $pageNum="";
				var lastNum;
				for(var i=0;i<pageBean.totalPages;i++){
					var str="";
					if(pageBean.pageNo==(i+1)){
						str="class='onPage'";
					}
					$pageNum=$pageNum+("<span "+str+" onclick=\"changeHBVPage('"+(i+1)+"')\">"+(i+1)+"</span>");
					lastNum=i+1;
				}
				var $pages=$("<span onclick=\"changeHBVPage('1')\">|<</span>"+$pageNum+"<span onclick=\"changeHBVPage('"+lastNum+"')\">>|</span>");
				$fenYeDiv.append($pages);

				// 增加信息
				var $add = $("<span class=\"addBlock fr\" onclick=\"toAddHBV()\" >+&nbsp;增加</span>");
				$(".xiaLaXuan").append($add);
				/*// 条件框
				var $condition = $("<input class=\"conditionHBVInput conditionInput fl\" placeholder=\"年份关键字\" value=\"\"/>");
				$(".xiaLaXuan").append($condition);
				$('.conditionHBVInput').val('').focus().val(condition);*/
			},
			error : function(er) {
				alert("er");
			}
		});
		
		//条件框改变事件
		$('.conditionHBVInput').bind('keyup', function() {
		    // 绑定键盘按下并松开。。。
		   var condition=$(this).val();
		   $(".div2").click();
		});
	});
});

//湖南省业务量添加增加输入框
function toAddHBV() {
	$(".fenYe>span:last").click();
	var $addTr = $("<tr id=\"addTr\">"
			+ "<td><input class=\"yearsInput\" /></td>"
			+ "<td>无需手动填写</td>"
			+ "<td><input class=\"otherProvInput\" /></td>"
			+ "<td><input class=\"provinceInput\" /></td>"
			+ "<td><input class=\"internationalInput\" /></td>"
			+ "<td><span class=\"clickBtn\" onclick=\"addHBV()\">确定</span>&nbsp;<span class=\"cancelBtn\" onclick=\"cancelHBV()\">取消</span></td>"
			+ "</tr>");
	$(".tables").append($addTr);
};
//湖南省业务量取消按键
function cancelHBV(){
	var pageNum=$(".onPage")[0];
	pageNum.click();
};

//湖南省业务量换页
function changeHBVPage(e){
	var condition=$(".conditionHBVInput").val();
	if(typeof condition=="undefined"){
		condition="";
	}
	conditionSearch="?"/*+"condition="+condition*/;
	$.ajax({
		async: false,
		type : 'GET',
		url : '/logbd_web/ajax/div2'+conditionSearch+'&pageNo='+e,
		dataType : 'JSON',
		success : function(data) {
			// 刷新页面前清除数据
			$(".tables tr").remove();
			$(".xiaLaXuan select,input,span")
					.remove();
			var pageBean=data;
			// 获取后台数据
			var arrs = pageBean.list;
			// 生成表头
			var $th = $("<tr><th>" + '年份'
					+ "</th><th>" + '总业务量'
					+ "</th><th>" + '外省业务量'
					+ "</th><th>" + '省内业务量'
					+ "</th><th>" + '国际业务量'
					+ "</th><th>" + '操作'
					+ "</th></tr>");
			// 添加表头
			$(".tables").append($th);
			for (var i = 0; i < arrs.length; i++) {
				var arr = arrs[i];
				// 创建一个tr元素，用来生成表格内容
				var $tr = $("<tr ><td>"
						+ arr.years
						+ "</td><td>"
						+ arr.total_volume
						+ "</td><td>"
						+ arr.other_provinces
						+ "</td><td>"
						+ arr.province
						+ "</td><td>"
						+ arr.international
						+ "</td>"
						+ "<td><span class=\"delBtn\" onclick=\"delHBV(this)\">删除</span>&nbsp;<span class=\"updateBtn\" onclick=\"toUpdateHBV(this)\">修改</span></td></tr>");
				$(".tables").append($tr);
			}
			//添加页码
			var $fenYeDiv=$(".fenYe");
			var $pageNum="";
			var lastNum;
			for(var i=0;i<pageBean.totalPages;i++){
				var str="";
				if(pageBean.pageNo==(i+1)){
					str="class='onPage'";
				}
				$pageNum=$pageNum+("<span "+str+" onclick=\"changeHBVPage('"+(i+1)+"')\">"+(i+1)+"</span>");
				lastNum=i+1;
			}
			var $pages=$("<span onclick=\"changeHBVPage('1')\">|<</span>"+$pageNum+"<span onclick=\"changeHBVPage('"+lastNum+"')\">>|</span>");
			$fenYeDiv.append($pages);

			// 增加信息
			var $add = $("<span class=\"addBlock fr\" onclick=\"toAddHBV()\" >+&nbsp;增加</span>");
			$(".xiaLaXuan").append($add);
			/*// 条件框
			var $condition = $("<input class=\"conditionHBVInput conditionInput fl\" placeholder=\"年份关键字\" value=\"\"/>");
			$(".xiaLaXuan").append($condition);
			$('.conditionHBVInput').val('').focus().val(condition);*/
		},
		error : function(er) {
			alert("er");
		}
	});
	//条件框改变事件
	$('.conditionHBVInput').bind('keyup', function() {
	    // 绑定键盘按下并松开。。。
	   var condition=$(this).val();
	   $(".div2").click();
	});
}

//湖南省业务量添加HBV
function addHBV() {
	var $years = $("#addTr>td:eq(0)>input").val();
	var $otherProv = $("#addTr>td:eq(2)>input").val();
	var $province = $("#addTr>td:eq(3)>input").val();
	var $international = $("#addTr>td:eq(4)>input").val();
	var hunan_business_volume = {
		"years" : $years,
		"other_provinces" : $otherProv,
		"province" : $province,
		"international" : $international,
	};
	
	$.ajax({
		url : "/logbd_web/ajax/addHunan_business_volume",
		async : false,
		type : "POST",
		contentType : 'application/json',
		dataType : "TEXT",
		data : JSON.stringify(hunan_business_volume),
		success : function(data) {
			$(".active").trigger("click");
		},
		error : function() {
			alert("未知错误,请联系管理员");
			return false;
		}
	});
	$(".fenYe>span:last").click();
}

//湖南省业务量删除HBV
function delHBV(e){
	var years=e.parentElement.parentElement.firstChild.innerHTML;
	var pageNum=$(".onPage")[0];
	$.ajax({
		url : "/logbd_web/ajax/delHunan_business_volume?years="+years,
		async : false,
		type : "POST",
		contentType : 'application/json',
		dataType : "TEXT",
		data : years,
		success : function(data) {
			$(".active").trigger("click");
		},
		error : function() {
			alert("未知错误,请联系管理员");
			return false;
		}
	});
	pageNum.click();
}

//湖南省业务量添加修改栏
function toUpdateHBV(e){
	var $Tr=e.parentElement.parentElement;
	var $totalTd=$Tr.children[1];
	var $otherProvTd=$Tr.children[2];
	var $provinceTd=$Tr.children[3];
	var $internationalTd=$Tr.children[4];
	var otherProv=$otherProvTd.innerHTML;
	var province=$provinceTd.innerHTML;
	var international=$internationalTd.innerHTML;
	$totalTd.innerHTML="";
	$totalInput=$("<input class=\"totalInput\" value=\"无需手动填写\" readonly=\"readonly\"/>");
	$($totalTd).append($totalInput);
	$otherProvTd.innerHTML="";
	$otherProvInput=$("<input class=\"otherProvInput\" value="+otherProv+" />");
	$($otherProvTd).append($otherProvInput);
	$provinceTd.innerHTML="";
	$provinceInput=$("<input class=\"provinceInput\" value="+province+" />");
	$($provinceTd).append($provinceInput);
	$internationalTd.innerHTML="";
	$internationalInput=$("<input class=\"internationalInput\" value="+international+" />");
	$($internationalTd).append($internationalInput);
	
	var $opraTd=$Tr.children[5];
	$opraTd.innerHTML="";
	$btn=$("<span class=\"clickBtn\" onclick=\"updateHBV(this)\">确定</span>&nbsp;<span class=\"cancelBtn\" onclick=\"cancelHBV()\">取消</span>");
	$($opraTd).append($btn);
}
//湖南省业务量 修改 HBV
function updateHBV(e){
	var $Tr=e.parentElement.parentElement;
	var $years=$Tr.children[0].innerHTML;
	var $otherProv = $($Tr).find("td:eq(2)>input").val();
	var $province = $($Tr).find("td:eq(3)>input").val();
	var $international = $($Tr).find("td:eq(4)>input").val();
	var pageNum=$(".onPage")[0];
	var hunan_business_volume = {
			"years" : $years,
			"other_provinces" : $otherProv,
			"province" : $province,
			"international" : $international,
		};
	
	$.ajax({
		url : "/logbd_web/ajax/updateHunan_business_volume",
		async : false,
		type : "POST",
		contentType : 'application/json',
		dataType : "TEXT",
		data : JSON.stringify(hunan_business_volume),
		success : function(data) {
			$(".active").trigger("click");
		},
		error : function() {
			alert("未知错误,请联系管理员");
			return false;
		}
	});
	pageNum.click();
}

/**
 * 湖南省货运收入
 */
$(function() {
	// hunan_freight_income表数据
	$(".div3").click(
	function clickLleft() {
		var condition=$(".conditionHFIInput").val();
		if(typeof condition=="undefined"){
			condition="";
		}
		conditionSearch="?condition="+condition;
		$.ajax({
			async: false,
			type : 'GET',
			url : '/logbd_web/ajax/div3'+conditionSearch,
			dataType : 'JSON',
			success : function(data) {
				// 刷新页面前清除数据
				$(".tables tr").remove();
				$(".xiaLaXuan select,input,span")
						.remove();
				var pageBean=data;
				// 获取后台数据
				var arrs = pageBean.list;
				// 生成表头
				var $th = $("<tr><th>" + '编号'
						+ "</th><th>" + '城市'
						+ "</th><th>" + '货运收入'
						+ "</th><th>" + '操作'
						+ "</th></tr>");
				// 添加表头
				$(".tables").append($th);
				for (var i = 0; i < arrs.length; i++) {
					var arr = arrs[i];
					// 创建一个tr元素，用来生成表格内容
					var $tr = $("<tr ><td>"
							+ arr.id
							+ "</td><td>"
							+ arr.city
							+ "</td><td>"
							+ arr.income
							+ "</td>"
							+ "<td><span class=\"delBtn\" onclick=\"delHFI(this)\">删除</span>&nbsp;<span class=\"updateBtn\" onclick=\"toUpdateHFI(this)\">修改</span></td></tr>");
					$(".tables").append($tr);
				}
				//添加页码
				var $fenYeDiv=$(".fenYe");
				var $pageNum="";
				var lastNum;
				for(var i=0;i<pageBean.totalPages;i++){
					var str="";
					if(pageBean.pageNo==(i+1)){
						str="class='onPage'";
					}
					$pageNum=$pageNum+("<span "+str+" onclick=\"changeHFIPage('"+(i+1)+"')\">"+(i+1)+"</span>");
					lastNum=i+1;
				}
				var $pages=$("<span onclick=\"changeHFIPage('1')\">|<</span>"+$pageNum+"<span onclick=\"changeHFIPage('"+lastNum+"')\">>|</span>");
				$fenYeDiv.append($pages);
				// 增加信息
				var $add = $("<span class=\"addBlock fr\" onclick=\"toAddHFI()\" >+&nbsp;增加</span>");
				$(".xiaLaXuan").append($add);
				// 条件框
				var $condition = $("<input class=\"conditionHFIInput conditionInput fl\" placeholder=\"城市关键字\" value=\"\"/>");
				$(".xiaLaXuan").append($condition);
				$('.conditionHFIInput').val('').val(condition);
			},
			error : function(er) {
				alert("er");
			}
		});
		
		//条件框改变事件
		/*$('.conditionHFIInput').bind('keyup', function() {
		    // 绑定键盘按下并松开。。。
		   var condition=$(this).val();
		   $(".div3").click();
		});*/
		//条件框改变事件
		$('.conditionHFIInput').blur(function() {
		    // 绑定键盘按下并松开。。。
		   var condition=$(this).val();
		   $(".div3").click();
		});
	});
});

//HFI添加增加输入框
function toAddHFI() {
	$(".fenYe>span:last").click();
	var $addTr = $("<tr id=\"addTr\">"
			+ "<td></td>"
			+ "<td><input class=\"cityInput\" /></td>"
			+ "<td><input class=\"incomeInput\" /></td>"
			+ "<td><span class=\"clickBtn\" onclick=\"addHFI()\">确定</span>&nbsp;<span class=\"cancelBtn\" onclick=\"cancelHFI()\">取消</span></td>"
			+ "</tr>");
	$(".tables").append($addTr);
};

//HFI取消按键
function cancelHFI(){
	var pageNum=$(".onPage")[0];
	pageNum.click();
};

//HFI换页
function changeHFIPage(e){
	var condition=$(".conditionHFIInput").val();
	if(typeof condition=="undefined"){
		condition="";
	}
	conditionSearch="?condition="+condition;
	$.ajax({
		async: false,
		type : 'GET',
		url : '/logbd_web/ajax/div3'+conditionSearch+'&pageNo='+e,
		dataType : 'JSON',
		success : function(data) {
			// 刷新页面前清除数据
			$(".tables tr").remove();
			$(".xiaLaXuan select,input,span")
					.remove();
			var pageBean=data;
			// 获取后台数据
			var arrs = pageBean.list;
			// 生成表头
			var $th = $("<tr><th>" + '编号'
					+ "</th><th>" + '城市'
					+ "</th><th>" + '货运收入'
					+ "</th><th>" + '操作'
					+ "</th></tr>");
			// 添加表头
			$(".tables").append($th);
			
			for (var i = 0; i < arrs.length; i++) {
				var arr = arrs[i];
				// 创建一个tr元素，用来生成表格内容
				var $tr = $("<tr ><td>"
						+ arr.id
						+ "</td><td>"
						+ arr.city
						+ "</td><td>"
						+ arr.income
						+ "</td>"
						+ "<td><span class=\"delBtn\" onclick=\"delHFI(this)\">删除</span>&nbsp;<span class=\"updateBtn\" onclick=\"toUpdateHFI(this)\">修改</span></td></tr>");
				$(".tables").append($tr);
			}
			//添加页码
			var $fenYeDiv=$(".fenYe");
			var $pageNum="";
			var lastNum;
			for(var i=0;i<pageBean.totalPages;i++){
				var str="";
				if(pageBean.pageNo==(i+1)){
					str="class='onPage'";
				}
				$pageNum=$pageNum+("<span "+str+" onclick=\"changeHFIPage('"+(i+1)+"')\">"+(i+1)+"</span>");
				lastNum=i+1;
			}
			var $pages=$("<span onclick=\"changeHFIPage('1')\">|<</span>"+$pageNum+"<span onclick=\"changeHFIPage('"+lastNum+"')\">>|</span>");
			$fenYeDiv.append($pages);

			// 条件框
			var $condition = $("<input class=\"conditionHFIInput conditionInput fl\" placeholder=\"城市关键字\" value=\""+condition+"\"/>");
			$(".xiaLaXuan").append($condition);
			
			// 增加信息
			var $add = $("<span class=\"addBlock fr\" onclick=\"toAddHFI()\" >+&nbsp;增加</span>");
			$(".xiaLaXuan").append($add);
			$('.conditionHFIInput').val(condition);
		},
		error : function(er) {
			alert("er");
		}
	});
	//条件框改变事件
	/*$('.conditionHFIInput').bind('keyup', function() {
	    // 绑定键盘按下并松开。。。
	   var condition=$(this).val();
	   $(".div3").click();
	});*/
	//条件框改变事件
	$('.conditionHFIInput').blur(function() {
	    // 绑定键盘按下并松开。。。
	   var condition=$(this).val();
	   $(".div3").click();
	});
};

//hunan_freight_income添加HFI
function addHFI() {
	var $city = $("#addTr>td:eq(1)>input").val();
	var $income = $("#addTr>td:eq(2)>input").val();
	var hunan_freight_income = {
		"id" : "",
		"city" : $city,
		"income" : $income
	};

	$.ajax({
		url : "/logbd_web/ajax/addHunan_freight_income",
		async : false,
		type : "POST",
		contentType : 'application/json',
		dataType : "TEXT",
		data : JSON.stringify(hunan_freight_income),
		success : function(data) {
			$(".active").trigger("click");
		},
		error : function() {
			alert("未知错误,请联系管理员");
			return false;
		}
	});
	$(".fenYe>span:last").click();
}

//hunan_freight_income删除HFI
function delHFI(e){
	var id=e.parentElement.parentElement.firstChild.innerHTML;
	var pageNum=$(".onPage")[0];
	$.ajax({
		url : "/logbd_web/ajax/delHunan_freight_income?id="+id,
		async : false,
		type : "POST",
		contentType : 'application/json',
		dataType : "TEXT",
		data : id,
		success : function(data) {
			$(".active").trigger("click");
		},
		error : function() {
			alert("未知错误,请联系管理员");
			return false;
		}
	});
	pageNum.click();
}

//HFI添加修改栏
function toUpdateHFI(e){
	var $Tr=e.parentElement.parentElement;
	var $cityTd=$Tr.children[1];
	var $incomeTd=$Tr.children[2];
	var city=$cityTd.innerHTML;
	var income=$incomeTd.innerHTML;
	$cityTd.innerHTML="";
	$cityInput=$("<input class=\"cityInput\" value="+city+" />");
	$($cityTd).append($cityInput);
	$incomeTd.innerHTML="";
	$incomeInput=$("<input class=\"incomeInput\" value="+income+" />");
	$($incomeTd).append($incomeInput);
	
	var $opraTd=$Tr.children[3];
	$opraTd.innerHTML="";
	$btn=$("<span class=\"clickBtn\" onclick=\"updateHFI(this)\">确定</span>&nbsp;<span class=\"cancelBtn\" onclick=\"cancelHFI()\">取消</span>");
	$($opraTd).append($btn);
}

//HFI修改用户
function updateHFI(e){
	var $Tr=e.parentElement.parentElement;
	var $id=$Tr.children[0].innerHTML;
	var $city = $($Tr).find("td:eq(1)>input").val();
	var $income = $($Tr).find("td:eq(2)>input").val();
	var pageNum=$(".onPage")[0];
	var hunan_freight_income = {
		"id" : $id,
		"city" : $city,
		"income" : $income
	};
	
	$.ajax({
		url : "/logbd_web/ajax/updateHunan_freight_income",
		async : false,
		type : "POST",
		contentType : 'application/json',
		dataType : "TEXT",
		data : JSON.stringify(hunan_freight_income),
		success : function(data) {
			$(".active").trigger("click");
		},
		error : function() {
			alert("未知错误,请联系管理员");
			return false;
		}
	});
	pageNum.click();
}

/**
 * 湖南省货运量
 * hunan_freight_volume
 */
$(function() {
	// hunan_freight_volume表数据
	$(".div4").click(
	function clickLleft() {
		var condition=$(".conditionHFVInput").val();
		var conditionSearch="?condition="+condition;
		if(typeof condition=="undefined"){
			conditionSearch="";
		}
		$.ajax({
			async: false,
			type : 'GET',
			url : '/logbd_web/ajax/div4'/*+conditionSearch*/,
			dataType : 'JSON',
			success : function(data) {
				// 刷新页面前清除数据
				$(".tables tr").remove();
				$(".xiaLaXuan select,input,span")
						.remove();
				var pageBean=data;
				// 获取后台数据
				var arrs = pageBean.list;
				// 生成表头
				var $th = $("<tr><th>" + '年份'
						+ "</th><th>" + '总货运量'
						+ "</th><th>" + '铁路总货运量'
						+ "</th><th>" + '国家铁路货运量'
						+ "</th><th>" + '地方铁路货运量'
						+ "</th><th>" + '合资铁路货运量'
						+ "</th><th>" + '公路货运量'
						+ "</th><th>" + '水路货运量'
						+ "</th><th>" + '操作'
						+ "</th></tr>");
				// 添加表头
				$(".tables").append($th);
				for (var i = 0; i < arrs.length; i++) {
					var arr = arrs[i];
					// 创建一个tr元素，用来生成表格内容
					var $tr = $("<tr ><td>"
							+ arr.years
							+ "</td><td>"
							+ arr.total
							+ "</td><td>"
							+ arr.total_railway
							+ "</td><td>"
							+ arr.national_railway
							+ "</td><td>"
							+ arr.local_railway
							+ "</td><td>"
							+ arr.joint_venture_railway
							+ "</td><td>"
							+ arr.highway
							+ "</td><td>"
							+ arr.waterway
							+ "</td>"
							+ "<td><span class=\"delBtn\" onclick=\"delHFV(this)\">删除</span>&nbsp;<span class=\"updateBtn\" onclick=\"toUpdateHFV(this)\">修改</span></td></tr>");
					$(".tables").append($tr);
				}
				//添加页码
				var $fenYeDiv=$(".fenYe");
				var $pageNum="";
				var lastNum;
				for(var i=0;i<pageBean.totalPages;i++){
					var str="";
					if(pageBean.pageNo==(i+1)){
						str="class='onPage'";
					}
					$pageNum=$pageNum+("<span "+str+" onclick=\"changeHFVPage('"+(i+1)+"')\">"+(i+1)+"</span>");
					lastNum=i+1;
				}
				var $pages=$("<span onclick=\"changeHFVPage('1')\">|<</span>"+$pageNum+"<span onclick=\"changeHFVPage('"+lastNum+"')\">>|</span>");
				$fenYeDiv.append($pages);

				// 增加信息
				var $add = $("<span class=\"addBlock fr\" onclick=\"toAddHFV()\" >+&nbsp;增加</span>");
				$(".xiaLaXuan").append($add);
				/*// 条件框
				var $condition = $("<input class=\"conditionHFVInput conditionInput fl\" placeholder=\"年份关键字\" value=\"\"/>");
				$(".xiaLaXuan").append($condition);
				$('.conditionHFVInput').val('').focus().val(condition);*/
			},
			error : function(er) {
				alert("er");
			}
		});
		
		//条件框改变事件
		$('.conditionHFVInput').bind('keyup', function() {
		    // 绑定键盘按下并松开。。。
		   var condition=$(this).val();
		   $(".div42").click();
		});
	});
});

//湖南省货运量添加增加输入框
function toAddHFV() {
	$(".fenYe>span:last").click();
	var $addTr = $("<tr id=\"addTr\">"
			+ "<td><input class=\"yearsInput\" /></td>"
			+ "<td>无需手动填写</td>"
			+ "<td>无需手动填写</td>"
			+ "<td><input class=\"nationalRailwayInput\" /></td>"
			+ "<td><input class=\"localRailwayInput\" /></td>"
			+ "<td><input class=\"jointVentureRailwayInput\" /></td>"
			+ "<td><input class=\"highwayInput\" /></td>"
			+ "<td><input class=\"waterwayInput\" /></td>"
			+ "<td><span class=\"clickBtn\" onclick=\"addHFV()\">确定</span>&nbsp;<span class=\"cancelBtn\" onclick=\"cancelHFV()\">取消</span></td>"
			+ "</tr>");
	$(".tables").append($addTr);
};
//湖南省货运量取消按键
function cancelHFV(){
	var pageNum=$(".onPage")[0];
	pageNum.click();
};

//湖南省货运量换页
function changeHFVPage(e){
	var condition=$(".conditionHFVInput").val();
	if(typeof condition=="undefined"){
		condition="";
	}
	conditionSearch="?"/*+"condition="+condition*/;
	$.ajax({
		async: false,
		type : 'GET',
		url : '/logbd_web/ajax/div4'+conditionSearch+'&pageNo='+e,
		dataType : 'JSON',
		success : function(data) {
			// 刷新页面前清除数据
			$(".tables tr").remove();
			$(".xiaLaXuan select,input,span")
					.remove();
			var pageBean=data;
			// 获取后台数据
			var arrs = pageBean.list;
			// 生成表头
			var $th = $("<tr><th>" + '年份'
					+ "</th><th>" + '总货运量'
					+ "</th><th>" + '铁路总货运量'
					+ "</th><th>" + '国家铁路货运量'
					+ "</th><th>" + '地方铁路货运量'
					+ "</th><th>" + '合资铁路货运量'
					+ "</th><th>" + '公路货运量'
					+ "</th><th>" + '水路货运量'
					+ "</th><th>" + '操作'
					+ "</th></tr>");
			// 添加表头
			$(".tables").append($th);
			for (var i = 0; i < arrs.length; i++) {
				var arr = arrs[i];
				// 创建一个tr元素，用来生成表格内容
				var $tr = $("<tr ><td>"
						+ arr.years
						+ "</td><td>"
						+ arr.total
						+ "</td><td>"
						+ arr.total_railway
						+ "</td><td>"
						+ arr.national_railway
						+ "</td><td>"
						+ arr.local_railway
						+ "</td><td>"
						+ arr.joint_venture_railway
						+ "</td><td>"
						+ arr.highway
						+ "</td><td>"
						+ arr.waterway
						+ "</td>"
						+ "<td><span class=\"delBtn\" onclick=\"delHFV(this)\">删除</span>&nbsp;<span class=\"updateBtn\" onclick=\"toUpdateHFV(this)\">修改</span></td></tr>");
				$(".tables").append($tr);
			}
			//添加页码
			var $fenYeDiv=$(".fenYe");
			var $pageNum="";
			var lastNum;
			for(var i=0;i<pageBean.totalPages;i++){
				var str="";
				if(pageBean.pageNo==(i+1)){
					str="class='onPage'";
				}
				$pageNum=$pageNum+("<span "+str+" onclick=\"changeHFVPage('"+(i+1)+"')\">"+(i+1)+"</span>");
				lastNum=i+1;
			}
			var $pages=$("<span onclick=\"changeHFVPage('1')\">|<</span>"+$pageNum+"<span onclick=\"changeHFVPage('"+lastNum+"')\">>|</span>");
			$fenYeDiv.append($pages);

			// 增加信息
			var $add = $("<span class=\"addBlock fr\" onclick=\"toAddHFV()\" >+&nbsp;增加</span>");
			$(".xiaLaXuan").append($add);
			/*// 条件框
			var $condition = $("<input class=\"conditionHFVInput conditionInput fl\" placeholder=\"年份关键字\" value=\"\"/>");
			$(".xiaLaXuan").append($condition);
			$('.conditionHFVInput').val('').focus().val(condition);*/
		},
		error : function(er) {
			alert("er");
		}
	});
	//条件框改变事件
	$('.conditionHFVInput').bind('keyup', function() {
	    // 绑定键盘按下并松开。。。
	   var condition=$(this).val();
	   $(".div4").click();
	});
}

//湖南省货运量添加HFV
function addHFV() {
	var $years = $("#addTr>td:eq(0)>input").val();
	var $nationalRailway = $("#addTr>td:eq(3)>input").val();
	var $localRailway = $("#addTr>td:eq(4)>input").val();
	var $jointVentureRailway = $("#addTr>td:eq(5)>input").val();
	var $highway = $("#addTr>td:eq(6)>input").val();
	var $waterway = $("#addTr>td:eq(7)>input").val();
	var hunan_freight_volume = {
		"years" : $years,
		"national_railway" : $nationalRailway,
		"local_railway" : $localRailway,
		"joint_venture_railway" : $jointVentureRailway,
		"highway" : $highway,
		"waterway" : $waterway,
	};
	
	$.ajax({
		url : "/logbd_web/ajax/addHunan_freight_volume",
		async : false,
		type : "POST",
		contentType : 'application/json',
		dataType : "TEXT",
		data : JSON.stringify(hunan_freight_volume),
		success : function(data) {
			$(".active").trigger("click");
		},
		error : function() {
			alert("未知错误,请联系管理员");
			return false;
		}
	});
	$(".fenYe>span:last").click();
}

//湖南省货运量删除HFV
function delHFV(e){
	var years=e.parentElement.parentElement.firstChild.innerHTML;
	var pageNum=$(".onPage")[0];
	$.ajax({
		url : "/logbd_web/ajax/delHunan_freight_volume?years="+years,
		async : false,
		type : "POST",
		contentType : 'application/json',
		dataType : "TEXT",
		data : years,
		success : function(data) {
			$(".active").trigger("click");
		},
		error : function() {
			alert("未知错误,请联系管理员");
			return false;
		}
	});
	pageNum.click();
}

//湖南省货运量添加修改栏
function toUpdateHFV(e){
	var $Tr=e.parentElement.parentElement;
	var $totalTd=$Tr.children[1];
	var $totalRailwayTd=$Tr.children[2];
	var $nationalRailwayTd=$Tr.children[3];
	var $localRailwayTd=$Tr.children[4];
	var $jointVentureRailwayTd=$Tr.children[5];
	var $highwayTd=$Tr.children[6];
	var $waterwayTd=$Tr.children[7];
	
	var nationalRailway=$nationalRailwayTd.innerHTML;
	var localRailway=$localRailwayTd.innerHTML;
	var jointVentureRailway=$jointVentureRailwayTd.innerHTML;
	var highway=$highwayTd.innerHTML;
	var waterway=$waterwayTd.innerHTML;
	
	$totalTd.innerHTML="";
	$totalInput=$("<input class=\"totalInput\" value=\"无需手动填写\" readonly=\"readonly\"/>");
	$($totalTd).append($totalInput);
	$totalRailwayTd.innerHTML="";
	$totalRailwayInput=$("<input class=\"totalRailwayInput\" value=\"无需手动填写\" readonly=\"readonly\"/>");
	$($totalRailwayTd).append($totalRailwayInput);
	$nationalRailwayTd.innerHTML="";
	$nationalRailwayInput=$("<input class=\"nationalRailwayInput\" value="+nationalRailway+" />");
	$($nationalRailwayTd).append($nationalRailwayInput);
	$localRailwayTd.innerHTML="";
	$localRailwayInput=$("<input class=\"localRailwayInput\" value="+localRailway+" />");
	$($localRailwayTd).append($localRailwayInput);
	$jointVentureRailwayTd.innerHTML="";
	$jointVentureRailwayInput=$("<input class=\"jointVentureRailwayInput\" value="+jointVentureRailway+" />");
	$($jointVentureRailwayTd).append($jointVentureRailwayInput);
	$highwayTd.innerHTML="";
	$highwayInput=$("<input class=\"highwayInput\" value="+highway+" />");
	$($highwayTd).append($highwayInput);
	$waterwayTd.innerHTML="";
	$waterwayInput=$("<input class=\"waterwayInput\" value="+waterway+" />");
	$($waterwayTd).append($waterwayInput);
	
	var $opraTd=$Tr.children[8];
	$opraTd.innerHTML="";
	$btn=$("<span class=\"clickBtn\" onclick=\"updateHFV(this)\">确定</span>&nbsp;<span class=\"cancelBtn\" onclick=\"cancelHFV()\">取消</span>");
	$($opraTd).append($btn);
}
//湖南省货运量 修改 HFV
function updateHFV(e){
	var $Tr=e.parentElement.parentElement;
	var $years=$Tr.children[0].innerHTML;
	var $nationalRailway = $($Tr).find("td:eq(3)>input").val();
	var $localRailway = $($Tr).find("td:eq(4)>input").val();
	var $jointVentureRailway = $($Tr).find("td:eq(5)>input").val();
	var $highway = $($Tr).find("td:eq(6)>input").val();
	var $waterway = $($Tr).find("td:eq(7)>input").val();
	var pageNum=$(".onPage")[0];
	var hunan_freight_volume = {
			"years" : $years,
			"national_railway" : $nationalRailway,
			"local_railway" : $localRailway,
			"joint_venture_railway" : $jointVentureRailway,
			"highway" : $highway,
			"waterway" : $waterway,
	};
	
	$.ajax({
		url : "/logbd_web/ajax/updateHunan_freight_volume",
		async : false,
		type : "POST",
		contentType : 'application/json',
		dataType : "TEXT",
		data : JSON.stringify(hunan_freight_volume),
		success : function(data) {
			$(".active").trigger("click");
		},
		error : function() {
			alert("未知错误,请联系管理员");
			return false;
		}
	});
	pageNum.click();
}

/**
 * 湖南省货运周转量
 * hunan_freight_turnover_volume
 */
$(function() {
	// hunan_freight_turnover_volume表数据
	$(".div5").click(
	function clickLleft() {
		var condition=$(".conditionHFTVInput").val();
		var conditionSearch="?condition="+condition;
		if(typeof condition=="undefined"){
			conditionSearch="";
		}
		$.ajax({
			async: false,
			type : 'GET',
			url : '/logbd_web/ajax/div5'/*+conditionSearch*/,
			dataType : 'JSON',
			success : function(data) {
				// 刷新页面前清除数据
				$(".tables tr").remove();
				$(".xiaLaXuan select,input,span")
						.remove();
				var pageBean=data;
				// 获取后台数据
				var arrs = pageBean.list;
				// 生成表头
				var $th = $("<tr><th>" + '年份'
						+ "</th><th>" + '铁路总货运周转量'
						+ "</th><th>" + '国家铁路货运周转量'
						+ "</th><th>" + '地方铁路货运周转量'
						+ "</th><th>" + '合资铁路货运周转量'
						+ "</th><th>" + '公路货运周转量'
						+ "</th><th>" + '水路货运周转量'
						+ "</th><th>" + '操作'
						+ "</th></tr>");
				// 添加表头
				$(".tables").append($th);
				for (var i = 0; i < arrs.length; i++) {
					var arr = arrs[i];
					// 创建一个tr元素，用来生成表格内容
					var $tr = $("<tr ><td>"
							+ arr.years
							+ "</td><td>"
							+ arr.total_railway
							+ "</td><td>"
							+ arr.national_railway
							+ "</td><td>"
							+ arr.local_railway
							+ "</td><td>"
							+ arr.joint_venture_railway
							+ "</td><td>"
							+ arr.highway
							+ "</td><td>"
							+ arr.waterway
							+ "</td>"
							+ "<td><span class=\"delBtn\" onclick=\"delHFTV(this)\">删除</span>&nbsp;<span class=\"updateBtn\" onclick=\"toUpdateHFTV(this)\">修改</span></td></tr>");
					$(".tables").append($tr);
				}
				//添加页码
				var $fenYeDiv=$(".fenYe");
				var $pageNum="";
				var lastNum;
				for(var i=0;i<pageBean.totalPages;i++){
					var str="";
					if(pageBean.pageNo==(i+1)){
						str="class='onPage'";
					}
					$pageNum=$pageNum+("<span "+str+" onclick=\"changeHFTVPage('"+(i+1)+"')\">"+(i+1)+"</span>");
					lastNum=i+1;
				}
				var $pages=$("<span onclick=\"changeHFTVPage('1')\">|<</span>"+$pageNum+"<span onclick=\"changeHFTVPage('"+lastNum+"')\">>|</span>");
				$fenYeDiv.append($pages);

				// 增加信息
				var $add = $("<span class=\"addBlock fr\" onclick=\"toAddHFTV()\" >+&nbsp;增加</span>");
				$(".xiaLaXuan").append($add);
				/*// 条件框
				var $condition = $("<input class=\"conditionHFTVInput conditionInput fl\" placeholder=\"年份关键字\" value=\"\"/>");
				$(".xiaLaXuan").append($condition);
				$('.conditionHFTVInput').val('').focus().val(condition);*/
			},
			error : function(er) {
				alert("er");
			}
		});
		
		//条件框改变事件
		$('.conditionHFTVInput').bind('keyup', function() {
		    // 绑定键盘按下并松开。。。
		   var condition=$(this).val();
		   $(".div5").click();
		});
	});
});

//湖南省货运周转量添加增加输入框
function toAddHFTV() {
	$(".fenYe>span:last").click();
	var $addTr = $("<tr id=\"addTr\">"
			+ "<td><input class=\"yearsInput\" /></td>"
			+ "<td>无需手动填写</td>"
			+ "<td><input class=\"nationalRailwayInput\" /></td>"
			+ "<td><input class=\"localRailwayInput\" /></td>"
			+ "<td><input class=\"jointVentureRailwayInput\" /></td>"
			+ "<td><input class=\"highwayInput\" /></td>"
			+ "<td><input class=\"waterwayInput\" /></td>"
			+ "<td><span class=\"clickBtn\" onclick=\"addHFTV()\">确定</span>&nbsp;<span class=\"cancelBtn\" onclick=\"cancelHFTV()\">取消</span></td>"
			+ "</tr>");
	$(".tables").append($addTr);
};
//湖南省货运周转量取消按键
function cancelHFTV(){
	var pageNum=$(".onPage")[0];
	pageNum.click();
};

//湖南省货运周转量换页
function changeHFTVPage(e){
	var condition=$(".conditionHFTVInput").val();
	if(typeof condition=="undefined"){
		condition="";
	}
	conditionSearch="?"/*+"condition="+condition*/;
	$.ajax({
		async: false,
		type : 'GET',
		url : '/logbd_web/ajax/div5'+conditionSearch+'&pageNo='+e,
		dataType : 'JSON',
		success : function(data) {
			// 刷新页面前清除数据
			$(".tables tr").remove();
			$(".xiaLaXuan select,input,span")
					.remove();
			var pageBean=data;
			// 获取后台数据
			var arrs = pageBean.list;
			// 生成表头
			var $th = $("<tr><th>" + '年份'
					+ "</th><th>" + '铁路总货运周转量'
					+ "</th><th>" + '国家铁路货运周转量'
					+ "</th><th>" + '地方铁路货运周转量'
					+ "</th><th>" + '合资铁路货运周转量'
					+ "</th><th>" + '公路货运周转量'
					+ "</th><th>" + '水路货运周转量'
					+ "</th><th>" + '操作'
					+ "</th></tr>");
			// 添加表头
			$(".tables").append($th);
			for (var i = 0; i < arrs.length; i++) {
				var arr = arrs[i];
				// 创建一个tr元素，用来生成表格内容
				var $tr = $("<tr ><td>"
						+ arr.years
						+ "</td><td>"
						+ arr.total_railway
						+ "</td><td>"
						+ arr.national_railway
						+ "</td><td>"
						+ arr.local_railway
						+ "</td><td>"
						+ arr.joint_venture_railway
						+ "</td><td>"
						+ arr.highway
						+ "</td><td>"
						+ arr.waterway
						+ "</td>"
						+ "<td><span class=\"delBtn\" onclick=\"delHFTV(this)\">删除</span>&nbsp;<span class=\"updateBtn\" onclick=\"toUpdateHFTV(this)\">修改</span></td></tr>");
				$(".tables").append($tr);
			}
			//添加页码
			var $fenYeDiv=$(".fenYe");
			var $pageNum="";
			var lastNum;
			for(var i=0;i<pageBean.totalPages;i++){
				var str="";
				if(pageBean.pageNo==(i+1)){
					str="class='onPage'";
				}
				$pageNum=$pageNum+("<span "+str+" onclick=\"changeHFTVPage('"+(i+1)+"')\">"+(i+1)+"</span>");
				lastNum=i+1;
			}
			var $pages=$("<span onclick=\"changeHFTVPage('1')\">|<</span>"+$pageNum+"<span onclick=\"changeHFTVPage('"+lastNum+"')\">>|</span>");
			$fenYeDiv.append($pages);

			// 增加信息
			var $add = $("<span class=\"addBlock fr\" onclick=\"toAddHFTV()\" >+&nbsp;增加</span>");
			$(".xiaLaXuan").append($add);
			/*// 条件框
			var $condition = $("<input class=\"conditionHFTVInput conditionInput fl\" placeholder=\"年份关键字\" value=\"\"/>");
			$(".xiaLaXuan").append($condition);
			$('.conditionHFTVInput').val('').focus().val(condition);*/
		},
		error : function(er) {
			alert("er");
		}
	});
	//条件框改变事件
	$('.conditionHFTVInput').bind('keyup', function() {
	    // 绑定键盘按下并松开。。。
	   var condition=$(this).val();
	   $(".div5").click();
	});
}

//湖南省货运周转量添加HFTV
function addHFTV() {
	var $years = $("#addTr>td:eq(0)>input").val();
	var $nationalRailway = $("#addTr>td:eq(2)>input").val();
	var $localRailway = $("#addTr>td:eq(3)>input").val();
	var $jointVentureRailway = $("#addTr>td:eq(4)>input").val();
	var $highway = $("#addTr>td:eq(5)>input").val();
	var $waterway = $("#addTr>td:eq(6)>input").val();
	var hunan_freight_turnover_volume = {
		"years" : $years,
		"national_railway" : $nationalRailway,
		"local_railway" : $localRailway,
		"joint_venture_railway" : $jointVentureRailway,
		"highway" : $highway,
		"waterway" : $waterway,
	};
	
	$.ajax({
		url : "/logbd_web/ajax/addHunan_freight_turnover_volume",
		async : false,
		type : "POST",
		contentType : 'application/json',
		dataType : "TEXT",
		data : JSON.stringify(hunan_freight_turnover_volume),
		success : function(data) {
			$(".active").trigger("click");
		},
		error : function() {
			alert("未知错误,请联系管理员");
			return false;
		}
	});
	$(".fenYe>span:last").click();
}

//湖南省货运周转量删除HFTV
function delHFTV(e){
	var years=e.parentElement.parentElement.firstChild.innerHTML;
	var pageNum=$(".onPage")[0];
	$.ajax({
		url : "/logbd_web/ajax/delHunan_freight_turnover_volume?years="+years,
		async : false,
		type : "POST",
		contentType : 'application/json',
		dataType : "TEXT",
		data : years,
		success : function(data) {
			$(".active").trigger("click");
		},
		error : function() {
			alert("未知错误,请联系管理员");
			return false;
		}
	});
	pageNum.click();
}

//湖南省货运周转量添加修改栏
function toUpdateHFTV(e){
	var $Tr=e.parentElement.parentElement;
	var $totalRailwayTd=$Tr.children[1];
	var $nationalRailwayTd=$Tr.children[2];
	var $localRailwayTd=$Tr.children[3];
	var $jointVentureRailwayTd=$Tr.children[4];
	var $highwayTd=$Tr.children[5];
	var $waterwayTd=$Tr.children[6];
	
	var nationalRailway=$nationalRailwayTd.innerHTML;
	var localRailway=$localRailwayTd.innerHTML;
	var jointVentureRailway=$jointVentureRailwayTd.innerHTML;
	var highway=$highwayTd.innerHTML;
	var waterway=$waterwayTd.innerHTML;
	
	$totalRailwayTd.innerHTML="";
	$totalRailwayInput=$("<input class=\"totalRailwayInput\" value=\"无需手动填写\" readonly=\"readonly\"/>");
	$($totalRailwayTd).append($totalRailwayInput);
	$nationalRailwayTd.innerHTML="";
	$nationalRailwayInput=$("<input class=\"nationalRailwayInput\" value="+nationalRailway+" />");
	$($nationalRailwayTd).append($nationalRailwayInput);
	$localRailwayTd.innerHTML="";
	$localRailwayInput=$("<input class=\"localRailwayInput\" value="+localRailway+" />");
	$($localRailwayTd).append($localRailwayInput);
	$jointVentureRailwayTd.innerHTML="";
	$jointVentureRailwayInput=$("<input class=\"jointVentureRailwayInput\" value="+jointVentureRailway+" />");
	$($jointVentureRailwayTd).append($jointVentureRailwayInput);
	$highwayTd.innerHTML="";
	$highwayInput=$("<input class=\"highwayInput\" value="+highway+" />");
	$($highwayTd).append($highwayInput);
	$waterwayTd.innerHTML="";
	$waterwayInput=$("<input class=\"waterwayInput\" value="+waterway+" />");
	$($waterwayTd).append($waterwayInput);
	
	var $opraTd=$Tr.children[7];
	$opraTd.innerHTML="";
	$btn=$("<span class=\"clickBtn\" onclick=\"updateHFTV(this)\">确定</span>&nbsp;<span class=\"cancelBtn\" onclick=\"cancelHFTV()\">取消</span>");
	$($opraTd).append($btn);
}
//湖南省货运周转量 修改 HFTV
function updateHFTV(e){
	var $Tr=e.parentElement.parentElement;
	var $years=$Tr.children[0].innerHTML;
	var $nationalRailway = $($Tr).find("td:eq(2)>input").val();
	var $localRailway = $($Tr).find("td:eq(3)>input").val();
	var $jointVentureRailway = $($Tr).find("td:eq(4)>input").val();
	var $highway = $($Tr).find("td:eq(5)>input").val();
	var $waterway = $($Tr).find("td:eq(6)>input").val();
	var pageNum=$(".onPage")[0];
	var hunan_freight_turnover_volume = {
			"years" : $years,
			"national_railway" : $nationalRailway,
			"local_railway" : $localRailway,
			"joint_venture_railway" : $jointVentureRailway,
			"highway" : $highway,
			"waterway" : $waterway,
	};
	
	$.ajax({
		url : "/logbd_web/ajax/updateHunan_freight_turnover_volume",
		async : false,
		type : "POST",
		contentType : 'application/json',
		dataType : "TEXT",
		data : JSON.stringify(hunan_freight_turnover_volume),
		success : function(data) {
			$(".active").trigger("click");
		},
		error : function() {
			alert("未知错误,请联系管理员");
			return false;
		}
	});
	pageNum.click();
}

/**
 * 湖南省公共交通
 * hunan_pub_trans
 */
$(function() {
	// hunan_pub_trans表数据
	$(".div6").click(
	function clickLleft() {
		var condition=$(".conditionHPTInput").val();
		var conditionSearch="?condition="+condition;
		if(typeof condition=="undefined"){
			conditionSearch="";
		}
		$.ajax({
			async: false,
			type : 'GET',
			url : '/logbd_web/ajax/div6'/*+conditionSearch*/,
			dataType : 'JSON',
			success : function(data) {
				// 刷新页面前清除数据
				$(".tables tr").remove();
				$(".xiaLaXuan select,input,span")
						.remove();
				var pageBean=data;
				// 获取后台数据
				var arrs = pageBean.list;
				// 生成表头
				var $th = $("<tr><th>" + '年份'
						+ "</th><th>" + '公共交通运营数'
						+ "</th><th>" + '运营线路总长度'
						+ "</th><th>" + '公共交通客运总量'
						+ "</th><th>" + '操作'
						+ "</th></tr>");
				// 添加表头
				$(".tables").append($th);
				for (var i = 0; i < arrs.length; i++) {
					var arr = arrs[i];
					// 创建一个tr元素，用来生成表格内容
					var $tr = $("<tr ><td>"
							+ arr.years
							+ "</td><td>"
							+ arr.total_operations_num
							+ "</td><td>"
							+ arr.total_transline_length
							+ "</td><td>"
							+ arr.total_passengers
							+ "</td>"
							+ "<td><span class=\"delBtn\" onclick=\"delHPT(this)\">删除</span>&nbsp;<span class=\"updateBtn\" onclick=\"toUpdateHPT(this)\">修改</span></td></tr>");
					$(".tables").append($tr);
				}
				//添加页码
				var $fenYeDiv=$(".fenYe");
				var $pageNum="";
				var lastNum;
				for(var i=0;i<pageBean.totalPages;i++){
					var str="";
					if(pageBean.pageNo==(i+1)){
						str="class='onPage'";
					}
					$pageNum=$pageNum+("<span "+str+" onclick=\"changeHPTPage('"+(i+1)+"')\">"+(i+1)+"</span>");
					lastNum=i+1;
				}
				var $pages=$("<span onclick=\"changeHPTPage('1')\">|<</span>"+$pageNum+"<span onclick=\"changeHPTPage('"+lastNum+"')\">>|</span>");
				$fenYeDiv.append($pages);

				// 增加信息
				var $add = $("<span class=\"addBlock fr\" onclick=\"toAddHPT()\" >+&nbsp;增加</span>");
				$(".xiaLaXuan").append($add);
				/*// 条件框
				var $condition = $("<input class=\"conditionHPTInput conditionInput fl\" placeholder=\"年份关键字\" value=\"\"/>");
				$(".xiaLaXuan").append($condition);
				$('.conditionHPTInput').val('').focus().val(condition);*/
			},
			error : function(er) {
				alert("er");
			}
		});
		
		//条件框改变事件
		$('.conditionHPTInput').bind('keyup', function() {
		    // 绑定键盘按下并松开。。。
		   var condition=$(this).val();
		   $(".div6").click();
		});
	});
});

//湖南省公共交通添加增加输入框
function toAddHPT() {
	$(".fenYe>span:last").click();
	var $addTr = $("<tr id=\"addTr\">"
			+ "<td><input class=\"yearsInput\" /></td>"
			+ "<td><input class=\"totalOperationsNumInput\" /></td>"
			+ "<td><input class=\"totalTranslineLengthInput\" /></td>"
			+ "<td><input class=\"totalPassengersInput\" /></td>"
			+ "<td><span class=\"clickBtn\" onclick=\"addHPT()\">确定</span>&nbsp;<span class=\"cancelBtn\" onclick=\"cancelHPT()\">取消</span></td>"
			+ "</tr>");
	$(".tables").append($addTr);
};
//湖南省公共交通取消按键
function cancelHPT(){
	var pageNum=$(".onPage")[0];
	pageNum.click();
};

//湖南省公共交通换页
function changeHPTPage(e){
	var condition=$(".conditionHPTInput").val();
	if(typeof condition=="undefined"){
		condition="";
	}
	conditionSearch="?"/*+"condition="+condition*/;
	$.ajax({
		async: false,
		type : 'GET',
		url : '/logbd_web/ajax/div6'+conditionSearch+'&pageNo='+e,
		dataType : 'JSON',
		success : function(data) {
			// 刷新页面前清除数据
			$(".tables tr").remove();
			$(".xiaLaXuan select,input,span")
					.remove();
			var pageBean=data;
			// 获取后台数据
			var arrs = pageBean.list;
			// 生成表头
			var $th = $("<tr><th>" + '年份'
					+ "</th><th>" + '公共交通运营数'
					+ "</th><th>" + '运营线路总长度'
					+ "</th><th>" + '公共交通客运总量'
					+ "</th><th>" + '操作'
					+ "</th></tr>");
			// 添加表头
			$(".tables").append($th);
			for (var i = 0; i < arrs.length; i++) {
				var arr = arrs[i];
				// 创建一个tr元素，用来生成表格内容
				var $tr = $("<tr ><td>"
						+ arr.years
						+ "</td><td>"
						+ arr.total_operations_num
						+ "</td><td>"
						+ arr.total_transline_length
						+ "</td><td>"
						+ arr.total_passengers
						+ "</td>"
						+ "<td><span class=\"delBtn\" onclick=\"delHPT(this)\">删除</span>&nbsp;<span class=\"updateBtn\" onclick=\"toUpdateHPT(this)\">修改</span></td></tr>");
				$(".tables").append($tr);
			}
			//添加页码
			var $fenYeDiv=$(".fenYe");
			var $pageNum="";
			var lastNum;
			for(var i=0;i<pageBean.totalPages;i++){
				var str="";
				if(pageBean.pageNo==(i+1)){
					str="class='onPage'";
				}
				$pageNum=$pageNum+("<span "+str+" onclick=\"changeHPTPage('"+(i+1)+"')\">"+(i+1)+"</span>");
				lastNum=i+1;
			}
			var $pages=$("<span onclick=\"changeHPTPage('1')\">|<</span>"+$pageNum+"<span onclick=\"changeHPTPage('"+lastNum+"')\">>|</span>");
			$fenYeDiv.append($pages);

			// 增加信息
			var $add = $("<span class=\"addBlock fr\" onclick=\"toAddHPT()\" >+&nbsp;增加</span>");
			$(".xiaLaXuan").append($add);
			/*// 条件框
			var $condition = $("<input class=\"conditionHPTInput conditionInput fl\" placeholder=\"年份关键字\" value=\"\"/>");
			$(".xiaLaXuan").append($condition);
			$('.conditionHPTInput').val('').focus().val(condition);*/
		},
		error : function(er) {
			alert("er");
		}
	});
	//条件框改变事件
	$('.conditionHPTInput').bind('keyup', function() {
	    // 绑定键盘按下并松开。。。
	   var condition=$(this).val();
	   $(".div6").click();
	});
}

//湖南省公共交通添加HPT
function addHPT() {
	var $years = $("#addTr>td:eq(0)>input").val();
	var $totalOperationsNum = $("#addTr>td:eq(1)>input").val();
	var $totalTranslineLength = $("#addTr>td:eq(2)>input").val();
	var $totalPassengers = $("#addTr>td:eq(3)>input").val();
	var hunan_pub_trans = {
		"years" : $years,
		"total_operations_num" : $totalOperationsNum,
		"total_transline_length" : $totalTranslineLength,
		"total_passengers" : $totalPassengers,
	};
	
	$.ajax({
		url : "/logbd_web/ajax/addHunan_pub_trans",
		async : false,
		type : "POST",
		contentType : 'application/json',
		dataType : "TEXT",
		data : JSON.stringify(hunan_pub_trans),
		success : function(data) {
			$(".active").trigger("click");
		},
		error : function() {
			alert("未知错误,请联系管理员");
			return false;
		}
	});
	$(".fenYe>span:last").click();
}

//湖南省公共交通删除HPT
function delHPT(e){
	var years=e.parentElement.parentElement.firstChild.innerHTML;
	var pageNum=$(".onPage")[0];
	$.ajax({
		url : "/logbd_web/ajax/delHunan_pub_trans?years="+years,
		async : false,
		type : "POST",
		contentType : 'application/json',
		dataType : "TEXT",
		data : years,
		success : function(data) {
			$(".active").trigger("click");
		},
		error : function() {
			alert("未知错误,请联系管理员");
			return false;
		}
	});
	pageNum.click();
}

//湖南省公共交通添加修改栏
function toUpdateHPT(e){
	var $Tr=e.parentElement.parentElement;
	var $totalOperationsNumTd=$Tr.children[1];
	var $totalTranslineLengthTd=$Tr.children[2];
	var $totalPassengersTd=$Tr.children[3];
	
	var totalOperationsNum=$totalOperationsNumTd.innerHTML;
	var totalTranslineLength=$totalTranslineLengthTd.innerHTML;
	var totalPassengers=$totalPassengersTd.innerHTML;
	
	$totalOperationsNumTd.innerHTML="";
	$totalOperationsNumInput=$("<input class=\"totalOperationsNumInput\" value="+totalOperationsNum+" />");
	$($totalOperationsNumTd).append($totalOperationsNumInput);
	$totalTranslineLengthTd.innerHTML="";
	$totalTranslineLengthInput=$("<input class=\"totalTranslineLengthInput\" value="+totalTranslineLength+" />");
	$($totalTranslineLengthTd).append($totalTranslineLengthInput);
	$totalPassengersTd.innerHTML="";
	$totalPassengersInput=$("<input class=\"totalPassengersInput\" value="+totalPassengers+" />");
	$($totalPassengersTd).append($totalPassengersInput);
	
	var $opraTd=$Tr.children[4];
	$opraTd.innerHTML="";
	$btn=$("<span class=\"clickBtn\" onclick=\"updateHPT(this)\">确定</span>&nbsp;<span class=\"cancelBtn\" onclick=\"cancelHPT()\">取消</span>");
	$($opraTd).append($btn);
}
//湖南省公共交通 修改 HPT
function updateHPT(e){
	var $Tr=e.parentElement.parentElement;
	var $years=$Tr.children[0].innerHTML;
	var $totalOperationsNum = $($Tr).find("td:eq(1)>input").val();
	var $totalTranslineLength = $($Tr).find("td:eq(2)>input").val();
	var $totalPassengers = $($Tr).find("td:eq(3)>input").val();
	var pageNum=$(".onPage")[0];
	var hunan_pub_trans = {
		"years" : $years,
		"total_operations_num" : $totalOperationsNum,
		"total_transline_length" : $totalTranslineLength,
		"total_passengers" : $totalPassengers,
	};
	
	$.ajax({
		url : "/logbd_web/ajax/updateHunan_pub_trans",
		async : false,
		type : "POST",
		contentType : 'application/json',
		dataType : "TEXT",
		data : JSON.stringify(hunan_pub_trans),
		success : function(data) {
			$(".active").trigger("click");
		},
		error : function() {
			alert("未知错误,请联系管理员");
			return false;
		}
	});
	pageNum.click();
}

/**
 * 湖南省交通就业量
 * hunan_traffic_employment
 */
$(function() {
	// hunan_traffic_employment表数据
	$(".div7").click(
	function clickLleft() {
		var condition=$(".conditionHTEInput").val();
		var conditionSearch="?condition="+condition;
		if(typeof condition=="undefined"){
			conditionSearch="";
		}
		$.ajax({
			async: false,
			type : 'GET',
			url : '/logbd_web/ajax/div7'/*+conditionSearch*/,
			dataType : 'JSON',
			success : function(data) {
				// 刷新页面前清除数据
				$(".tables tr").remove();
				$(".xiaLaXuan select,input,span")
						.remove();
				var pageBean=data;
				// 获取后台数据
				var arrs = pageBean.list;
				// 生成表头
				var $th = $("<tr><th>" + '年份'
						+ "</th><th>" + '铁路运输业'
						+ "</th><th>" + '公路运输业'
						+ "</th><th>" + '水上运输业'
						+ "</th><th>" + '航空运输业'
						+ "</th><th>" + '管道运输业'
						+ "</th><th>" + '装卸搬运和其他运输服务业'
						+ "</th><th>" + '操作'
						+ "</th></tr>");
				// 添加表头
				$(".tables").append($th);
				for (var i = 0; i < arrs.length; i++) {
					var arr = arrs[i];
					// 创建一个tr元素，用来生成表格内容
					var $tr = $("<tr ><td>"
							+ arr.years
							+ "</td><td>"
							+ arr.railway_transportation
							+ "</td><td>"
							+ arr.highway_transportation
							+ "</td><td>"
							+ arr.waterway_transportation
							+ "</td><td>"
							+ arr.air_transportation
							+ "</td><td>"
							+ arr.pipage_transportation
							+ "</td><td>"
							+ arr.others
							+ "</td>"
							+ "<td><span class=\"delBtn\" onclick=\"delHTE(this)\">删除</span>&nbsp;<span class=\"updateBtn\" onclick=\"toUpdateHTE(this)\">修改</span></td></tr>");
					$(".tables").append($tr);
				}
				//添加页码
				var $fenYeDiv=$(".fenYe");
				var $pageNum="";
				var lastNum;
				for(var i=0;i<pageBean.totalPages;i++){
					var str="";
					if(pageBean.pageNo==(i+1)){
						str="class='onPage'";
					}
					$pageNum=$pageNum+("<span "+str+" onclick=\"changeHTEPage('"+(i+1)+"')\">"+(i+1)+"</span>");
					lastNum=i+1;
				}
				var $pages=$("<span onclick=\"changeHTEPage('1')\">|<</span>"+$pageNum+"<span onclick=\"changeHTEPage('"+lastNum+"')\">>|</span>");
				$fenYeDiv.append($pages);

				// 增加信息
				var $add = $("<span class=\"addBlock fr\" onclick=\"toAddHTE()\" >+&nbsp;增加</span>");
				$(".xiaLaXuan").append($add);
				/*// 条件框
				var $condition = $("<input class=\"conditionHTEInput conditionInput fl\" placeholder=\"年份关键字\" value=\"\"/>");
				$(".xiaLaXuan").append($condition);
				$('.conditionHTEInput').val('').focus().val(condition);*/
			},
			error : function(er) {
				alert("er");
			}
		});
		
		//条件框改变事件
		$('.conditionHTEInput').bind('keyup', function() {
		    // 绑定键盘按下并松开。。。
		   var condition=$(this).val();
		   $(".div7").click();
		});
	});
});

//湖南省交通就业量添加增加输入框
function toAddHTE() {
	$(".fenYe>span:last").click();
	var $addTr = $("<tr id=\"addTr\">"
			+ "<td><input class=\"yearsInput\" /></td>"
			+ "<td><input class=\"railwayTransportationInput\" /></td>"
			+ "<td><input class=\"highwayTransportationInput\" /></td>"
			+ "<td><input class=\"waterwayTransportationInput\" /></td>"
			+ "<td><input class=\"airTransportationInput\" /></td>"
			+ "<td><input class=\"pipageTransportationInput\" /></td>"
			+ "<td><input class=\"othersInput\" /></td>"
			+ "<td><span class=\"clickBtn\" onclick=\"addHTE()\">确定</span>&nbsp;<span class=\"cancelBtn\" onclick=\"cancelHTE()\">取消</span></td>"
			+ "</tr>");
	$(".tables").append($addTr);
};
//湖南省交通就业量取消按键
function cancelHTE(){
	var pageNum=$(".onPage")[0];
	pageNum.click();
};

//湖南省交通就业量换页
function changeHTEPage(e){
	var condition=$(".conditionHTEInput").val();
	if(typeof condition=="undefined"){
		condition="";
	}
	conditionSearch="?"/*+"condition="+condition*/;
	$.ajax({
		async: false,
		type : 'GET',
		url : '/logbd_web/ajax/div7'+conditionSearch+'&pageNo='+e,
		dataType : 'JSON',
		success : function(data) {
			// 刷新页面前清除数据
			$(".tables tr").remove();
			$(".xiaLaXuan select,input,span")
					.remove();
			var pageBean=data;
			// 获取后台数据
			var arrs = pageBean.list;
			// 生成表头
			var $th = $("<tr><th>" + '年份'
					+ "</th><th>" + '铁路运输业'
					+ "</th><th>" + '公路运输业'
					+ "</th><th>" + '水上运输业'
					+ "</th><th>" + '航空运输业'
					+ "</th><th>" + '管道运输业'
					+ "</th><th>" + '装卸搬运和其他运输服务业'
					+ "</th><th>" + '操作'
					+ "</th></tr>");
			// 添加表头
			$(".tables").append($th);
			for (var i = 0; i < arrs.length; i++) {
				var arr = arrs[i];
				// 创建一个tr元素，用来生成表格内容
				var $tr = $("<tr ><td>"
						+ arr.years
						+ "</td><td>"
						+ arr.railway_transportation
						+ "</td><td>"
						+ arr.highway_transportation
						+ "</td><td>"
						+ arr.waterway_transportation
						+ "</td><td>"
						+ arr.air_transportation
						+ "</td><td>"
						+ arr.pipage_transportation
						+ "</td><td>"
						+ arr.others
						+ "</td>"
						+ "<td><span class=\"delBtn\" onclick=\"delHTE(this)\">删除</span>&nbsp;<span class=\"updateBtn\" onclick=\"toUpdateHTE(this)\">修改</span></td></tr>");
				$(".tables").append($tr);
			}
			//添加页码
			var $fenYeDiv=$(".fenYe");
			var $pageNum="";
			var lastNum;
			for(var i=0;i<pageBean.totalPages;i++){
				var str="";
				if(pageBean.pageNo==(i+1)){
					str="class='onPage'";
				}
				$pageNum=$pageNum+("<span "+str+" onclick=\"changeHTEPage('"+(i+1)+"')\">"+(i+1)+"</span>");
				lastNum=i+1;
			}
			var $pages=$("<span onclick=\"changeHTEPage('1')\">|<</span>"+$pageNum+"<span onclick=\"changeHTEPage('"+lastNum+"')\">>|</span>");
			$fenYeDiv.append($pages);

			// 增加信息
			var $add = $("<span class=\"addBlock fr\" onclick=\"toAddHTE()\" >+&nbsp;增加</span>");
			$(".xiaLaXuan").append($add);
			/*// 条件框
			var $condition = $("<input class=\"conditionHTEInput conditionInput fl\" placeholder=\"年份关键字\" value=\"\"/>");
			$(".xiaLaXuan").append($condition);
			$('.conditionHTEInput').val('').focus().val(condition);*/
		},
		error : function(er) {
			alert("er");
		}
	});
	//条件框改变事件
	$('.conditionHTEInput').bind('keyup', function() {
	    // 绑定键盘按下并松开。。。
	   var condition=$(this).val();
	   $(".div7").click();
	});
}

//湖南省交通就业量添加HTE
function addHTE() {
	var $years = $("#addTr>td:eq(0)>input").val();
	var $railwayTransportation = $("#addTr>td:eq(1)>input").val();
	var $highwayTransportation = $("#addTr>td:eq(2)>input").val();
	var $waterwayTransportation = $("#addTr>td:eq(3)>input").val();
	var $airTransportation = $("#addTr>td:eq(4)>input").val();
	var $pipageTransportation = $("#addTr>td:eq(5)>input").val();
	var $others = $("#addTr>td:eq(6)>input").val();
	
	var hunan_traffic_employment = {
		"years" : $years,
		"railway_transportation" : $railwayTransportation,
		"highway_transportation" : $highwayTransportation,
		"waterway_transportation" : $waterwayTransportation,
		"air_transportation" : $airTransportation,
		"pipage_transportation" : $pipageTransportation,
		"others" : $others,
	};
	
	$.ajax({
		url : "/logbd_web/ajax/addHunan_traffic_employment",
		async : false,
		type : "POST",
		contentType : 'application/json',
		dataType : "TEXT",
		data : JSON.stringify(hunan_traffic_employment),
		success : function(data) {
			$(".active").trigger("click");
		},
		error : function() {
			alert("未知错误,请联系管理员");
			return false;
		}
	});
	$(".fenYe>span:last").click();
}

//湖南省交通就业量删除HTE
function delHTE(e){
	var years=e.parentElement.parentElement.firstChild.innerHTML;
	var pageNum=$(".onPage")[0];
	$.ajax({
		url : "/logbd_web/ajax/delHunan_traffic_employment?years="+years,
		async : false,
		type : "POST",
		contentType : 'application/json',
		dataType : "TEXT",
		data : years,
		success : function(data) {
			$(".active").trigger("click");
		},
		error : function() {
			alert("未知错误,请联系管理员");
			return false;
		}
	});
	pageNum.click();
}

//湖南省交通就业量添加修改栏
function toUpdateHTE(e){
	var $Tr=e.parentElement.parentElement;
	var $railwayTransportationTd=$Tr.children[1];
	var $highwayTransportationTd=$Tr.children[2];
	var $waterwayTransportationTd=$Tr.children[3];
	var $airTransportationTd=$Tr.children[4];
	var $pipageTransportationTd=$Tr.children[5];
	var $othersTd=$Tr.children[6];
	
	var railwayTransportation=$railwayTransportationTd.innerHTML;
	var highwayTransportation=$highwayTransportationTd.innerHTML;
	var waterwayTransportation=$waterwayTransportationTd.innerHTML;
	var airTransportation=$airTransportationTd.innerHTML;
	var pipageTransportation=$pipageTransportationTd.innerHTML;
	var others=$othersTd.innerHTML;
	
	$railwayTransportationTd.innerHTML="";
	$railwayTransportationInput=$("<input class=\"railwayTransportationInput\" value="+railwayTransportation+" />");
	$($railwayTransportationTd).append($railwayTransportationInput);
	$highwayTransportationTd.innerHTML="";
	$highwayTransportationInput=$("<input class=\"highwayTransportationInput\" value="+highwayTransportation+" />");
	$($highwayTransportationTd).append($highwayTransportationInput);
	$waterwayTransportationTd.innerHTML="";
	$waterwayTransportationInput=$("<input class=\"waterwayTransportationInput\" value="+waterwayTransportation+" />");
	$($waterwayTransportationTd).append($waterwayTransportationInput);
	$airTransportationTd.innerHTML="";
	$airTransportationInput=$("<input class=\"airTransportationInput\" value="+airTransportation+" />");
	$($airTransportationTd).append($airTransportationInput);
	$pipageTransportationTd.innerHTML="";
	$pipageTransportationInput=$("<input class=\"pipageTransportationInput\" value="+pipageTransportation+" />");
	$($pipageTransportationTd).append($pipageTransportationInput);
	$othersTd.innerHTML="";
	$othersInput=$("<input class=\"othersInput\" value="+others+" />");
	$($othersTd).append($othersInput);
	
	var $opraTd=$Tr.children[7];
	$opraTd.innerHTML="";
	$btn=$("<span class=\"clickBtn\" onclick=\"updateHTE(this)\">确定</span>&nbsp;<span class=\"cancelBtn\" onclick=\"cancelHTE()\">取消</span>");
	$($opraTd).append($btn);
}
//湖南省交通就业量 修改 HTE
function updateHTE(e){
	var $Tr=e.parentElement.parentElement;
	var $years=$Tr.children[0].innerHTML;
	var $railwayTransportation = $($Tr).find("td:eq(1)>input").val();
	var $highwayTransportation = $($Tr).find("td:eq(2)>input").val();
	var $waterwayTransportation = $($Tr).find("td:eq(3)>input").val();
	var $airTransportation = $($Tr).find("td:eq(4)>input").val();
	var $pipageTransportation = $($Tr).find("td:eq(5)>input").val();
	var $others = $($Tr).find("td:eq(6)>input").val();
	
	var pageNum=$(".onPage")[0];

	var hunan_traffic_employment = {
		"years" : $years,
		"railway_transportation" : $railwayTransportation,
		"highway_transportation" : $highwayTransportation,
		"waterway_transportation" : $waterwayTransportation,
		"air_transportation" : $airTransportation,
		"pipage_transportation" : $pipageTransportation,
		"others" : $others,
	};
	
	$.ajax({
		url : "/logbd_web/ajax/updateHunan_traffic_employment",
		async : false,
		type : "POST",
		contentType : 'application/json',
		dataType : "TEXT",
		data : JSON.stringify(hunan_traffic_employment),
		success : function(data) {
			$(".active").trigger("click");
		},
		error : function() {
			alert("未知错误,请联系管理员");
			return false;
		}
	});
	pageNum.click();
}

/**
 * 湖南省运输线长度
 * hunan_transline_length
 */
$(function() {
	// hunan_transline_length表数据
	$(".div8").click(
	function clickLleft() {
		var condition=$(".conditionHTLInput").val();
		var conditionSearch="?condition="+condition;
		if(typeof condition=="undefined"){
			conditionSearch="";
		}
		$.ajax({
			async: false,
			type : 'GET',
			url : '/logbd_web/ajax/div8'/*+conditionSearch*/,
			dataType : 'JSON',
			success : function(data) {
				// 刷新页面前清除数据
				$(".tables tr").remove();
				$(".xiaLaXuan select,input,span")
						.remove();
				var pageBean=data;
				// 获取后台数据
				var arrs = pageBean.list;
				// 生成表头
				var $th = $("<tr><th>" + '年份'
						+ "</th><th>" + '铁路里程'
						+ "</th><th>" + '公路里程'
						+ "</th><th>" + '等级公路里程'
						+ "</th><th>" + '高速公路里程'
						+ "</th><th>" + '一级等级公路里程'
						+ "</th><th>" + '二级等级公路里程'
						+ "</th><th>" + '等外公路里程'
						+ "</th><th>" + '操作'
						+ "</th></tr>");
				// 添加表头
				$(".tables").append($th);
				for (var i = 0; i < arrs.length; i++) {
					var arr = arrs[i];
					// 创建一个tr元素，用来生成表格内容
					var $tr = $("<tr ><td>"
							+ arr.years
							+ "</td><td>"
							+ arr.railway_mileage
							+ "</td><td>"
							+ arr.highway_mileage
							+ "</td><td>"
							+ arr.classified_highway
							+ "</td><td>"
							+ arr.highway
							+ "</td><td>"
							+ arr.primary_road
							+ "</td><td>"
							+ arr.secondary_road
							+ "</td><td>"
							+ arr.other_road
							+ "</td>"
							+ "<td><span class=\"delBtn\" onclick=\"delHTL(this)\">删除</span>&nbsp;<span class=\"updateBtn\" onclick=\"toUpdateHTL(this)\">修改</span></td></tr>");
					$(".tables").append($tr);
				}
				//添加页码
				var $fenYeDiv=$(".fenYe");
				var $pageNum="";
				var lastNum;
				for(var i=0;i<pageBean.totalPages;i++){
					var str="";
					if(pageBean.pageNo==(i+1)){
						str="class='onPage'";
					}
					$pageNum=$pageNum+("<span "+str+" onclick=\"changeHTLPage('"+(i+1)+"')\">"+(i+1)+"</span>");
					lastNum=i+1;
				}
				var $pages=$("<span onclick=\"changeHTLPage('1')\">|<</span>"+$pageNum+"<span onclick=\"changeHTLPage('"+lastNum+"')\">>|</span>");
				$fenYeDiv.append($pages);

				// 增加信息
				var $add = $("<span class=\"addBlock fr\" onclick=\"toAddHTL()\" >+&nbsp;增加</span>");
				$(".xiaLaXuan").append($add);
				/*// 条件框
				var $condition = $("<input class=\"conditionHTLInput conditionInput fl\" placeholder=\"年份关键字\" value=\"\"/>");
				$(".xiaLaXuan").append($condition);
				$('.conditionHTLInput').val('').focus().val(condition);*/
			},
			error : function(er) {
				alert("er");
			}
		});
		
		//条件框改变事件
		$('.conditionHTLInput').bind('keyup', function() {
		    // 绑定键盘按下并松开。。。
		   var condition=$(this).val();
		   $(".div8").click();
		});
	});
});

//湖南省运输线长度添加增加输入框
function toAddHTL() {
	$(".fenYe>span:last").click();
	var $addTr = $("<tr id=\"addTr\">"
			+ "<td><input class=\"yearsInput\" /></td>"
			+ "<td><input class=\"railwayMileageInput\" /></td>"
			+ "<td><input class=\"highwayMileageInput\" value=\"无需手动填写\" readonly=\"readonly\"/></td>"
			+ "<td><input class=\"classifiedHighwayInput\" /></td>"
			+ "<td><input class=\"highwayInput\" /></td>"
			+ "<td><input class=\"primaryRoadInput\" /></td>"
			+ "<td><input class=\"secondaryRoadInput\" /></td>"
			+ "<td><input class=\"otherRoadInput\" /></td>"
			+ "<td><span class=\"clickBtn\" onclick=\"addHTL()\">确定</span>&nbsp;<span class=\"cancelBtn\" onclick=\"cancelHTL()\">取消</span></td>"
			+ "</tr>");
	$(".tables").append($addTr);
};
//湖南省运输线长度取消按键
function cancelHTL(){
	var pageNum=$(".onPage")[0];
	pageNum.click();
};

//湖南省运输线长度换页
function changeHTLPage(e){
	var condition=$(".conditionHTLInput").val();
	if(typeof condition=="undefined"){
		condition="";
	}
	conditionSearch="?"/*+"condition="+condition*/;
	$.ajax({
		async: false,
		type : 'GET',
		url : '/logbd_web/ajax/div8'+conditionSearch+'&pageNo='+e,
		dataType : 'JSON',
		success : function(data) {
			// 刷新页面前清除数据
			$(".tables tr").remove();
			$(".xiaLaXuan select,input,span")
					.remove();
			var pageBean=data;
			// 获取后台数据
			var arrs = pageBean.list;
			// 生成表头
			var $th = $("<tr><th>" + '年份'
					+ "</th><th>" + '铁路里程'
					+ "</th><th>" + '公路里程'
					+ "</th><th>" + '等级公路里程'
					+ "</th><th>" + '高速公路里程'
					+ "</th><th>" + '一级等级公路里程'
					+ "</th><th>" + '二级等级公路里程'
					+ "</th><th>" + '等外公路里程'
					+ "</th><th>" + '操作'
					+ "</th></tr>");
			// 添加表头
			$(".tables").append($th);
			for (var i = 0; i < arrs.length; i++) {
				var arr = arrs[i];
				// 创建一个tr元素，用来生成表格内容
				var $tr = $("<tr ><td>"
						+ arr.years
						+ "</td><td>"
						+ arr.railway_mileage
						+ "</td><td>"
						+ arr.highway_mileage
						+ "</td><td>"
						+ arr.classified_highway
						+ "</td><td>"
						+ arr.highway
						+ "</td><td>"
						+ arr.primary_road
						+ "</td><td>"
						+ arr.secondary_road
						+ "</td><td>"
						+ arr.other_road
						+ "</td>"
						+ "<td><span class=\"delBtn\" onclick=\"delHTL(this)\">删除</span>&nbsp;<span class=\"updateBtn\" onclick=\"toUpdateHTL(this)\">修改</span></td></tr>");
				$(".tables").append($tr);
			}
			//添加页码
			var $fenYeDiv=$(".fenYe");
			var $pageNum="";
			var lastNum;
			for(var i=0;i<pageBean.totalPages;i++){
				var str="";
				if(pageBean.pageNo==(i+1)){
					str="class='onPage'";
				}
				$pageNum=$pageNum+("<span "+str+" onclick=\"changeHTLPage('"+(i+1)+"')\">"+(i+1)+"</span>");
				lastNum=i+1;
			}
			var $pages=$("<span onclick=\"changeHTLPage('1')\">|<</span>"+$pageNum+"<span onclick=\"changeHTLPage('"+lastNum+"')\">>|</span>");
			$fenYeDiv.append($pages);

			// 增加信息
			var $add = $("<span class=\"addBlock fr\" onclick=\"toAddHTL()\" >+&nbsp;增加</span>");
			$(".xiaLaXuan").append($add);
			/*// 条件框
			var $condition = $("<input class=\"conditionHTLInput conditionInput fl\" placeholder=\"年份关键字\" value=\"\"/>");
			$(".xiaLaXuan").append($condition);
			$('.conditionHTLInput').val('').focus().val(condition);*/
		},
		error : function(er) {
			alert("er");
		}
	});
	//条件框改变事件
	$('.conditionHTLInput').bind('keyup', function() {
	    // 绑定键盘按下并松开。。。
	   var condition=$(this).val();
	   $(".div8").click();
	});
}

//湖南省运输线长度添加HTL
function addHTL() {
	var $years = $("#addTr>td:eq(0)>input").val();
	var $railwayMileage = $("#addTr>td:eq(1)>input").val();
	var $highwayMileage = $("#addTr>td:eq(2)>input").val();
	var $classifiedHighway = $("#addTr>td:eq(3)>input").val();
	var $highway = $("#addTr>td:eq(4)>input").val();
	var $primaryRoad = $("#addTr>td:eq(5)>input").val();
	var $secondaryRoad = $("#addTr>td:eq(6)>input").val();
	var $otherRoad = $("#addTr>td:eq(7)>input").val();
	
	var hunan_transline_length = {
		"years" : $years,
		"railway_mileage" : $railwayMileage,
		"classified_highway" : $classifiedHighway,
		"highway" : $highway,
		"primary_road" : $primaryRoad,
		"secondary_road" : $secondaryRoad,
		"other_road" : $otherRoad,
	};
	
	$.ajax({
		url : "/logbd_web/ajax/addHunan_transline_length",
		async : false,
		type : "POST",
		contentType : 'application/json',
		dataType : "TEXT",
		data : JSON.stringify(hunan_transline_length),
		success : function(data) {
			$(".active").trigger("click");
		},
		error : function() {
			alert("未知错误,请联系管理员");
			return false;
		}
	});
	$(".fenYe>span:last").click();
}

//湖南省运输线长度删除HTL
function delHTL(e){
	var years=e.parentElement.parentElement.firstChild.innerHTML;
	var pageNum=$(".onPage")[0];
	$.ajax({
		url : "/logbd_web/ajax/delHunan_transline_length?years="+years,
		async : false,
		type : "POST",
		contentType : 'application/json',
		dataType : "TEXT",
		data : years,
		success : function(data) {
			$(".active").trigger("click");
		},
		error : function() {
			alert("未知错误,请联系管理员");
			return false;
		}
	});
	pageNum.click();
}

//湖南省运输线长度添加修改栏
function toUpdateHTL(e){
	var $Tr=e.parentElement.parentElement;
	var $railwayMileageTd=$Tr.children[1];
	var $highwayMileageTd=$Tr.children[2];
	var $classifiedHighwayTd=$Tr.children[3];
	var $highwayTd=$Tr.children[4];
	var $primaryRoadTd=$Tr.children[5];
	var $secondaryRoadTd=$Tr.children[6];
	var $otherRoadTd=$Tr.children[7];
	
	var railwayMileage=$railwayMileageTd.innerHTML;
	var classifiedHighway=$classifiedHighwayTd.innerHTML;
	var highway=$highwayTd.innerHTML;
	var primaryRoad=$primaryRoadTd.innerHTML;
	var secondaryRoad=$secondaryRoadTd.innerHTML;
	var otherRoad=$otherRoadTd.innerHTML;
	
	$railwayMileageTd.innerHTML="";
	$railwayMileageInput=$("<input class=\"railwayMileageInput\" value="+railwayMileage+" />");
	$($railwayMileageTd).append($railwayMileageInput);
	$highwayMileageTd.innerHTML="";
	$highwayMileageInput=$("<input class=\"highwayMileageInput\" value=\"无需手动填写\" readonly=\"readonly\"/>");
	$($highwayMileageTd).append($highwayMileageInput);
	$classifiedHighwayTd.innerHTML="";
	$classifiedHighwayInput=$("<input class=\"classifiedHighwayInput\" value="+classifiedHighway+" />");
	$($classifiedHighwayTd).append($classifiedHighwayInput);
	$highwayTd.innerHTML="";
	$highwayInput=$("<input class=\"highwayInput\" value="+highway+" />");
	$($highwayTd).append($highwayInput);
	$primaryRoadTd.innerHTML="";
	$primaryRoadInput=$("<input class=\"primaryRoadInput\" value="+primaryRoad+" />");
	$($primaryRoadTd).append($primaryRoadInput);
	$secondaryRoadTd.innerHTML="";
	$secondaryRoadInput=$("<input class=\"secondaryRoadInput\" value="+secondaryRoad+" />");
	$($secondaryRoadTd).append($secondaryRoadInput);
	$otherRoadTd.innerHTML="";
	$otherRoadInput=$("<input class=\"otherRoadInput\" value="+otherRoad+" />");
	$($otherRoadTd).append($otherRoadInput);
	
	var $opraTd=$Tr.children[8];
	$opraTd.innerHTML="";
	$btn=$("<span class=\"clickBtn\" onclick=\"updateHTL(this)\">确定</span>&nbsp;<span class=\"cancelBtn\" onclick=\"cancelHTL()\">取消</span>");
	$($opraTd).append($btn);
}
//湖南省运输线长度 修改 HTL
function updateHTL(e){
	var $Tr=e.parentElement.parentElement;
	var $years=$Tr.children[0].innerHTML;
	var $railwayMileage = $($Tr).find("td:eq(1)>input").val();
	var $classifiedHighway = $($Tr).find("td:eq(3)>input").val();
	var $highway = $($Tr).find("td:eq(4)>input").val();
	var $primaryRoad = $($Tr).find("td:eq(5)>input").val();
	var $secondaryRoad = $($Tr).find("td:eq(6)>input").val();
	var $otherRoad = $($Tr).find("td:eq(7)>input").val();
	
	var pageNum=$(".onPage")[0];

	var hunan_transline_length = {
			"years" : $years,
			"railway_mileage" : $railwayMileage,
			"classified_highway" : $classifiedHighway,
			"highway" : $highway,
			"primary_road" : $primaryRoad,
			"secondary_road" : $secondaryRoad,
			"other_road" : $otherRoad,
	};
	
	$.ajax({
		url : "/logbd_web/ajax/updateHunan_transline_length",
		async : false,
		type : "POST",
		contentType : 'application/json',
		dataType : "TEXT",
		data : JSON.stringify(hunan_transline_length),
		success : function(data) {
			$(".active").trigger("click");
		},
		error : function() {
			alert("未知错误,请联系管理员");
			return false;
		}
	});
	pageNum.click();
}

/**
 * 湖南省公路运营汽车
 * public_transportation
 */
$(function() {
	// public_transportation表数据
	$(".div9").click(
	function clickLleft() {
		var condition=$(".conditionPTInput").val();
		var conditionSearch="?condition="+condition;
		if(typeof condition=="undefined"){
			conditionSearch="";
		}
		$.ajax({
			async: false,
			type : 'GET',
			url : '/logbd_web/ajax/div9'/*+conditionSearch*/,
			dataType : 'JSON',
			success : function(data) {
				// 刷新页面前清除数据
				$(".tables tr").remove();
				$(".xiaLaXuan select,input,span")
						.remove();
				var pageBean=data;
				// 获取后台数据
				var arrs = pageBean.list;
				// 生成表头
				var $th = $("<tr><th>" + '年份'
						+ "</th><th>" + '总公路运营量'
						+ "</th><th>" + '公路运营载客量'
						+ "</th><th>" + '公路运营载货量'
						+ "</th><th>" + '操作'
						+ "</th></tr>");
				// 添加表头
				$(".tables").append($th);
				for (var i = 0; i < arrs.length; i++) {
					var arr = arrs[i];
					// 创建一个tr元素，用来生成表格内容
					var $tr = $("<tr ><td>"
							+ arr.years
							+ "</td><td>"
							+ arr.total_vehicles
							+ "</td><td>"
							+ arr.operating_passenger_capacity
							+ "</td><td>"
							+ arr.operating_cargo_capacity
							+ "</td>"
							+ "<td><span class=\"delBtn\" onclick=\"delPT(this)\">删除</span>&nbsp;<span class=\"updateBtn\" onclick=\"toUpdatePT(this)\">修改</span></td></tr>");
					$(".tables").append($tr);
				}
				//添加页码
				var $fenYeDiv=$(".fenYe");
				var $pageNum="";
				var lastNum;
				for(var i=0;i<pageBean.totalPages;i++){
					var str="";
					if(pageBean.pageNo==(i+1)){
						str="class='onPage'";
					}
					$pageNum=$pageNum+("<span "+str+" onclick=\"changePTPage('"+(i+1)+"')\">"+(i+1)+"</span>");
					lastNum=i+1;
				}
				var $pages=$("<span onclick=\"changePTPage('1')\">|<</span>"+$pageNum+"<span onclick=\"changePTPage('"+lastNum+"')\">>|</span>");
				$fenYeDiv.append($pages);

				// 增加信息
				var $add = $("<span class=\"addBlock fr\" onclick=\"toAddPT()\" >+&nbsp;增加</span>");
				$(".xiaLaXuan").append($add);
				/*// 条件框
				var $condition = $("<input class=\"conditionPTInput conditionInput fl\" placeholder=\"年份关键字\" value=\"\"/>");
				$(".xiaLaXuan").append($condition);
				$('.conditionPTInput').val('').focus().val(condition);*/
			},
			error : function(er) {
				alert("er");
			}
		});
		
		//条件框改变事件
		$('.conditionPTInput').bind('keyup', function() {
		    // 绑定键盘按下并松开。。。
		   var condition=$(this).val();
		   $(".div9").click();
		});
	});
});

//湖南省运输线长度添加增加输入框
function toAddPT() {
	$(".fenYe>span:last").click();
	var $addTr = $("<tr id=\"addTr\">"
			+ "<td><input class=\"yearsInput\" /></td>"
			+ "<td>无需手动填写</td>"
			+ "<td><input class=\"operatingPassengerCapacityInput\" /></td>"
			+ "<td><input class=\"operatingCargoCapacityInput\" /></td>"
			+ "<td><span class=\"clickBtn\" onclick=\"addPT()\">确定</span>&nbsp;<span class=\"cancelBtn\" onclick=\"cancelPT()\">取消</span></td>"
			+ "</tr>");
	$(".tables").append($addTr);
};
//湖南省运输线长度取消按键
function cancelPT(){
	var pageNum=$(".onPage")[0];
	pageNum.click();
};

//湖南省运输线长度换页
function changePTPage(e){
	var condition=$(".conditionPTInput").val();
	if(typeof condition=="undefined"){
		condition="";
	}
	conditionSearch="?"/*+"condition="+condition*/;
	$.ajax({
		async: false,
		type : 'GET',
		url : '/logbd_web/ajax/div9'+conditionSearch+'&pageNo='+e,
		dataType : 'JSON',
		success : function(data) {
			// 刷新页面前清除数据
			$(".tables tr").remove();
			$(".xiaLaXuan select,input,span")
					.remove();
			var pageBean=data;
			// 获取后台数据
			var arrs = pageBean.list;
			// 生成表头
			var $th = $("<tr><th>" + '年份'
					+ "</th><th>" + '总公路运营量'
					+ "</th><th>" + '公路运营载客量'
					+ "</th><th>" + '公路运营载货量'
					+ "</th><th>" + '操作'
					+ "</th></tr>");
			// 添加表头
			$(".tables").append($th);
			for (var i = 0; i < arrs.length; i++) {
				var arr = arrs[i];
				// 创建一个tr元素，用来生成表格内容
				var $tr = $("<tr ><td>"
						+ arr.years
						+ "</td><td>"
						+ arr.total_vehicles
						+ "</td><td>"
						+ arr.operating_passenger_capacity
						+ "</td><td>"
						+ arr.operating_cargo_capacity
						+ "</td>"
						+ "<td><span class=\"delBtn\" onclick=\"delPT(this)\">删除</span>&nbsp;<span class=\"updateBtn\" onclick=\"toUpdatePT(this)\">修改</span></td></tr>");
				$(".tables").append($tr);
			}
			//添加页码
			var $fenYeDiv=$(".fenYe");
			var $pageNum="";
			var lastNum;
			for(var i=0;i<pageBean.totalPages;i++){
				var str="";
				if(pageBean.pageNo==(i+1)){
					str="class='onPage'";
				}
				$pageNum=$pageNum+("<span "+str+" onclick=\"changePTPage('"+(i+1)+"')\">"+(i+1)+"</span>");
				lastNum=i+1;
			}
			var $pages=$("<span onclick=\"changePTPage('1')\">|<</span>"+$pageNum+"<span onclick=\"changePTPage('"+lastNum+"')\">>|</span>");
			$fenYeDiv.append($pages);

			// 增加信息
			var $add = $("<span class=\"addBlock fr\" onclick=\"toAddPT()\" >+&nbsp;增加</span>");
			$(".xiaLaXuan").append($add);
			/*// 条件框
			var $condition = $("<input class=\"conditionPTInput conditionInput fl\" placeholder=\"年份关键字\" value=\"\"/>");
			$(".xiaLaXuan").append($condition);
			$('.conditionPTInput').val('').focus().val(condition);*/
		},
		error : function(er) {
			alert("er");
		}
	});
	//条件框改变事件
	$('.conditionPTInput').bind('keyup', function() {
	    // 绑定键盘按下并松开。。。
	   var condition=$(this).val();
	   $(".div9").click();
	});
}

//湖南省运输线长度添加PT
function addPT() {
	var $years = $("#addTr>td:eq(0)>input").val();
	var $operatingPassengerCapacity = $("#addTr>td:eq(2)>input").val();
	var $operatingCargoCapacity = $("#addTr>td:eq(3)>input").val();
	
	var public_transportation = {
		"years" : $years,
		"operating_passenger_capacity" : $operatingPassengerCapacity,
		"operating_cargo_capacity" : $operatingCargoCapacity,
	};
	
	$.ajax({
		url : "/logbd_web/ajax/addPublic_transportation",
		async : false,
		type : "POST",
		contentType : 'application/json',
		dataType : "TEXT",
		data : JSON.stringify(public_transportation),
		success : function(data) {
			$(".active").trigger("click");
		},
		error : function() {
			alert("未知错误,请联系管理员");
			return false;
		}
	});
	$(".fenYe>span:last").click();
}

//湖南省运输线长度删除PT
function delPT(e){
	var years=e.parentElement.parentElement.firstChild.innerHTML;
	var pageNum=$(".onPage")[0];
	$.ajax({
		url : "/logbd_web/ajax/delPublic_transportation?years="+years,
		async : false,
		type : "POST",
		contentType : 'application/json',
		dataType : "TEXT",
		data : years,
		success : function(data) {
			$(".active").trigger("click");
		},
		error : function() {
			alert("未知错误,请联系管理员");
			return false;
		}
	});
	pageNum.click();
}

//湖南省运输线长度添加修改栏
function toUpdatePT(e){
	var $Tr=e.parentElement.parentElement;
	var $totalVehiclesTd=$Tr.children[1];
	var $operatingPassengerCapacityTd=$Tr.children[2];
	var $operatingCargocapacityTd=$Tr.children[3];
	
	var totalVehicles=$totalVehiclesTd.innerHTML;
	var operatingPassengerCapacity=$operatingPassengerCapacityTd.innerHTML;
	var operatingCargocapacity=$operatingCargocapacityTd.innerHTML;
	
	$totalVehiclesTd.innerHTML="";
	$totalVehiclesInput=$("<input class=\"totalVehiclesInput\" value=\"无需手动填写\" readonly=\"readonly\"/>");
	$($totalVehiclesTd).append($totalVehiclesInput);
	$operatingPassengerCapacityTd.innerHTML="";
	$operatingPassengerCapacityInput=$("<input class=\"operatingPassengerCapacityInput\" value="+operatingPassengerCapacity+" />");
	$($operatingPassengerCapacityTd).append($operatingPassengerCapacityInput);
	$operatingCargocapacityTd.innerHTML="";
	$operatingCargocapacityInput=$("<input class=\"operatingCargocapacityInput\" value="+operatingCargocapacity+" />");
	$($operatingCargocapacityTd).append($operatingCargocapacityInput);
	
	var $opraTd=$Tr.children[4];
	$opraTd.innerHTML="";
	$btn=$("<span class=\"clickBtn\" onclick=\"updatePT(this)\">确定</span>&nbsp;<span class=\"cancelBtn\" onclick=\"cancelPT()\">取消</span>");
	$($opraTd).append($btn);
}
//湖南省运输线长度 修改 PT
function updatePT(e){
	var $Tr=e.parentElement.parentElement;
	var $years=$Tr.children[0].innerHTML;
	var $operatingPassengerCapacity = $($Tr).find("td:eq(2)>input").val();
	var $operatingCargocapacity = $($Tr).find("td:eq(3)>input").val();
	
	var pageNum=$(".onPage")[0];

	var public_transportation = {
			"years" : $years,
			"operating_passenger_capacity" : $operatingPassengerCapacity,
			"operating_cargo_capacity" : $operatingCargocapacity,
	};
	
	$.ajax({
		url : "/logbd_web/ajax/updatePublic_transportation",
		async : false,
		type : "POST",
		contentType : 'application/json',
		dataType : "TEXT",
		data : JSON.stringify(public_transportation),
		success : function(data) {
			$(".active").trigger("click");
		},
		error : function() {
			alert("未知错误,请联系管理员");
			return false;
		}
	});
	pageNum.click();
}