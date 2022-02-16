<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
  <%@include file="/WEB-INF/common/head.jsp" %>
    

	</style>
  </head>
  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <div><a class="navbar-brand" href="index.html" style="font-size:32px;">尚筹网-创意产品众筹平台</a></div>
        </div>
      </div>
    </nav>

    <div class="container">

      <form action="admin/do/logina.html" method="post" class="form-signin" role="form">
        <h2 class="form-signin-heading"><i class="glyphicon glyphicon-log-in"></i> 管理员登录</h2>
		  <div class="form-group has-success has-feedback">
			<input type="text" class="form-control" name="loginAcct" id="inputSuccess4" placeholder="请输入登录账号" autofocus>
			<p>${requestScope.exception.message}</p>
		  </div>
		  <div class="form-group has-success has-feedback">
			<input type="text" class="form-control" name="userPswd" id="inputSuccess4" placeholder="请输入登录密码" style="margin-top:10px;">
			<span class="glyphicon glyphicon-lock form-control-feedback"></span>
		  </div>
   
        <button class="btn btn-lg btn-success btn-block" type="submit">登录</button>
      </form>
    </div>
    <script src="jquery/jquery-2.1.1.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>