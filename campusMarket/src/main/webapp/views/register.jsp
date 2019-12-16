<%@ page language="java" import="model.user.User,model.product.Product,java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>校园小拍 注册</title>
	<link rel="stylesheet" type="text/css" href="res/static/css/main.css">
	<link rel="stylesheet" type="text/css" href="res/layui/css/layui.css">
	<script type="text/javascript" src="res/layui/layui.js"></script>

	<style>
		body{background: url("res/static/img/百货2.jpg")}
	</style>
</head>
<body>
<div >
	<div class="layui-container" style="width: 45%;">
          <div>
			  <h3 align="center" style="">注册</h3>
		  </div>
<div class="layui-card " style="background-color: rgba(210,210,210,0.5)">
	<div class="layui-card-body">
			       <form id="registerForm" class="layui-form" action="register">
				<div class="layui-form-item">


					<div class="layui-input-block"  style="margin-left: 10px">
						<label  class="layui-form-label-col">学号</label>
						<input  placeholder="userid" type="text" name="id" lay-verify="required" autocomplete="off" class="layui-input">
					</div>


					<div class="layui-input-block"  style="margin-left: 10px">
						<label class="layui-form-label-col">姓名</label>
						<input placeholder="name" type="text" name="name" value="" lay-verify="required" autocomplete="off" class="layui-input">
					</div>


					<div class="layui-input-block"  style="margin-left: 10px">
						<label class="layui-form-label-col">密码</label>
						<input placeholder="password" type="password" name="password" lay-verify="required" autocomplete="off" class="layui-input">
					</div>


					<div class="layui-input-block"  style="margin-left: 10px">
						<label class="layui-form-label-col">性别</label>
						<select>
							<option value="1">Male</option>
							<option value="0">Female</option>
						</select>
					</div>


					<div class="layui-input-block"  style="margin-left: 10px">
						<label class="layui-form-label-col">学校</label>
						<input placeholder="school" type="text" name="school" lay-verify="required" autocomplete="off" class="layui-input">
					</div>



					<div class="layui-input-block"  style="margin-left: 10px">
						<label class="layui-form-label-col" >校区</label>
						<input type="text" placeholder="campus" name="campus" value="" lay-verify="required" autocomplete="off" class="layui-input">
					</div>


					<div class="layui-input-block" style="margin-left: 10px">
						<label class="layui-form-label-col">电话</label>
						<input type="text" placeholder="telephone" name="telephone" value="" lay-verify="required" autocomplete="off" class="layui-input">
					</div>


					<div class="layui-input-block" style="margin-left: 10px">
						<label class="layui-form-label-col">头像</label>
						<input type="file" name="file" lay-verify="required" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item"  align="left">
					<div class="layui-input-block">
						<button class="layui-btn" id="registerButton" lay-submit="" lay-filter="demo1" onclick="return false">
							确认修改
						</button>
					</div>
				</div>

			</form>
	</div>
</div>

	</div>
</div>

	<script>


		layui.config({
			base: 'res/static/js/util' //你存放新模块的目录，注意，不是layui的模块目录
		}).use(['jquery','form'],function() {
			var $ = layui.$, form = layui.form;




			$("#registerButton").click(function() {



				$.ajax({
					url:"/campusMarket/register",
					type:"post",
					data:form,
					processData:false,
					contentType:false,

					success:function(ret) {
						console.log("ok");
					},
					error: function(ret) {
						console.log("bad");
					}
				})




			})
		})
	</script>


</div>

</body></html>