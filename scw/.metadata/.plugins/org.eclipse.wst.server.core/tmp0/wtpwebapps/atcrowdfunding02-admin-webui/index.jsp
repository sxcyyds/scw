<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- http://localhost:8080/atcrowdfunding02-admin-webui/test/ssm.html -->


</head>
<body>
<script type="text/javascript">
	
	$(function(){
		$("#btn1").click(function(){
			$.ajax({
				"url":"send/array.html",
				"type":"POST",
				"data":{
					"array":[2,5,8]
				},
				"dataType":"text",
				"success":function(result){
					alert(result);
				},
				"error":function(result){
					alert(result);
				}
				
			});
		});
		var array=[2,5,10]     //主备好要发送到服务器的数组
		var requestBody=JSON.stringify(array);    //将json数组转换为字符串
		
		$("#btn3").click(function(){
			$.ajax({
				"url":"send/arraythree.html",
				"type":"POST",
				"data":requestBody,
				"contentType":"application/json;charset=UTF-8",  //设置请求体的内容类型
				"dataType":"text",								//如何对待服务器端返回的数据
				"success":function(result){
					alert(result);
				},
				"error":function(result){
					alert(result);
				}
				
			});
		});
		
		$("#btn4").click(function(){
			$.ajax({
				"url":"result.json",
				"type":"GET",
				"dataType":"json",								//如何对待服务器端返回的数据
				"success":function(result){
					console.log(result);
				},
				"error":function(result){
					console.log("错误");
				}
				
			});
		});
		$("#btn6").click(function(){
			layer.msg("aaaa....jdiashdo");
		});
		
	
	});
	

</script>


<a href="test/ssm.html">测试ssm的整合</a><br>

<button id="btn1">Send [5,8,12] one</button><br>

<button id="btn3">Send [5,8,12] one</button><br>
<button id="btn4">ajax查询所有信息</button><br>
<button id="btn5" ><a href="admin/to/login/page.html">跳转带首页</a></button><br>
<hr/>
<button id="btn6">点我弹框</button>

<hr/>
${ pageContext.request.serverName }<br>
${ pageContext.request.serverPort }<br>
${pageContext.request.contextPath}<br>

http://${ pageContext.request.serverName }:${ pageContext.request.serverPort }${pageContext.request.contextPath}

</body>
</html>