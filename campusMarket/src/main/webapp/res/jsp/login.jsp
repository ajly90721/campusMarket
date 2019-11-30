<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <title>校园小拍 登录</title>
  <link rel="stylesheet" type="text/css" href="../res/static/css/main.css">
  <link rel="stylesheet" type="text/css" href="../res/layui/css/layui.css">
  <script type="text/javascript" src="../res/layui/layui.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
</head>
<body>

  <div class="site-nav-bg">
    <div class="site-nav w1200">
      <p class="sn-back-home">
        <i class="layui-icon layui-icon-home"></i>
        <a href="index.html">首页</a>
      </p>
      <div class="sn-quick-menu">
        <div class="login"><a href="login.html">登录</a></div>
        <div class="signin"><a href="signin.html">注册</a></div>
      </div>
    </div>
  </div>



  <div class="header">
    <div class="headerLayout w1200">
      <div class="headerCon">
        <h1 class="mallLogo">
          <a href="index.html" title="校园小拍">
            <img src="../res/static/img/logo.png">
          </a>
        </h1>
      </div>
    </div>
  </div>


  <div class="content content-nav-base  login-content">
    <div class="main-nav">
      <div class="inner-cont0">
        <div class="inner-cont1 w1200">
          <div class="inner-cont2">
            <a href="commodity.html" class="active">所有商品</a>
            <a href="information.html">校园资讯</a>
            <a href="about.html">关于我们</a>
          </div>
        </div>
      </div>
    </div>
    <div class="login-bg">
      <div class="login-cont w1200">

        <div class="form-box">
<%--          <form class="layui-form" action="login" method="post">--%>
            <legend>登录</legend>

            <div class="layui-inline iphone">
              <div class="layui-input-inline">
                <i class="layui-icon layui-icon-cellphone iphone-icon"></i>
                <input type="text" name="id" id="id" lay-verify="required" placeholder="ID" autocomplete="off" class="layui-input">
              </div>
            </div>

            <div class="layui-inline iphone">
              <div class="layui-input-inline">
                <i class="layui-icon layui-icon-password iphone-icon"></i>
                <input type="password" name="pwd" id="pwd" lay-verify="required" placeholder="密码" autocomplete="off" class="layui-input">
              </div>
            </div>

            <div class="layui-form-item login-btn">
              <div class="layui-input-block">
                <a href="login"><button class="layui-btn" id="login_btn">登录</button></a>
              </div>
            </div>
<%--          </form>--%>


          <br>
          <br>
        </div>

      </div>
    </div>
  </div>

  <div class="footer">
    <div class="ng-promise-box">
      <div class="ng-promise w1200">

      </div>
    </div>
    <div class="mod_help w1200">                                     
      <p>
        <a href="javascript:;">关于我们</a>
        <span>|</span>
        <a href="javascript:;">帮助中心</a>
        <span>|</span>
        <a href="javascript:;">售后服务</a>
        <span>|</span>
        <a href="javascript:;">校园资讯</a>
        <span>|</span>
        <a href="javascript:;">关于货源</a>
      </p>
      <p class="coty">校园小拍版权所有 &copy; 2012-2020</p>
    </div>
  </div>
  <script type="text/javascript">
    //第一种：主动加载jquery模块
    layui.use(['jquery', 'layer'], function(){
      var $ = layui.$ //重点处
              ,layer = layui.layer;

      //后面就跟你平时使用jQuery一样
<%--      $('#login_btn').on('click',function () {--%>
<%--        layer.msg(window.location.href)--%>
<%--        $.ajax(--%>
<%--                {--%>
<%--                  type:"POST",--%>
<%--                  // url:"/campusMarket/campusMarket/src/main/webapp/res/html/login.html",--%>
<%--                  url:"login",--%>
<%--                  data:{id:$("#id").val(),password:$("#pwd").val()},--%>
<%--                  success:function (data) {--%>
<%--                    if(data)--%>
<%--                    {--%>
<%--                      layer.msg("登录成功")--%>
<%--                      window.location.href="./index.html"--%>
<%--                    }--%>
<%--                    else{--%>
<%--                      layer.msg("登录失败，用户名或密码错误")--%>
<%--                    }--%>
<%--                  }--%>
<%--                }--%>

<%--        );--%>

<%--      });--%>



    });



  </script>

</body>
</html>