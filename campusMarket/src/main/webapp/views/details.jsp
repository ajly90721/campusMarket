<%@ page language="java" import="java.util.*,model.product.*,model.user.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>校园小拍  详情</title>
  <link rel="stylesheet" type="text/css" href="res/static/css/main.css">
  <link rel="stylesheet" type="text/css" href="res/layui/css/layui.css">
  <script type="text/javascript" src="res/layui/layui.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
</head>
<body>

  <div class="site-nav-bg">
    <div class="site-nav w1200">
      <p class="sn-back-home">
        <i class="layui-icon layui-icon-home"></i>
        <a href="#">首页</a>
      </p>
      <div class="sn-quick-menu">
      <%! User u=null; String myiconPath=null;int code=0;%>
      <%
      		u=(User)session.getAttribute("user");
      		myiconPath=u.getIconPath();
      		if(u!=null)
      		{
      			out.println(
      			"<div class=\" layui-layout-right\">"
                +"<a href=\"managePage\"><img src=\""+myiconPath+"\" class=\"layui-nav-img\"></a>"
           +"</div>"
      					);
      		code=1;
      		}
      		else
      			out.println("        <div class=\"login\"><a href=\"loginPage\">登录</a></div><div class=\"login\"><a href=\"registerPage\">注册</a></div>");
      %>
      </div>
    </div>
  </div>



  <div class="header">
    <div class="headerLayout w1200">
      <div class="headerCon">
        <h1 class="mallLogo">
          <a href="#" title="校园小拍">
            <img src="res/static/img/logo.png">
          </a>
        </h1>
        <div class="mallSearch">
          <form action="" class="layui-form" novalidate>
            <input type="text" name="title" required  lay-verify="required" autocomplete="off" class="layui-input" placeholder="请输入需要的商品">
            <button class="layui-btn" lay-submit lay-filter="formDemo">
                <i class="layui-icon layui-icon-search"></i>
            </button>
            <input type="hidden" name="" value="">
          </form>
        </div>
      </div>
    </div>
  </div>


  <div class="content content-nav-base datails-content">
    <div class="main-nav">
      <div class="inner-cont0">
        <div class="inner-cont1 w1200">
          <div class="inner-cont2">
            <a href="commodityPage" >所有商品</a>
            <a href="http://www.sc.sdu.edu.cn/">校园资讯</a>
            <a href="aboutPage">关于我们</a>
          </div>
        </div>
      </div>
    </div>
    <%! String name,price,description,iconPath,phone =null;ArrayList<User> user=null; ArrayList<Product> p=null;ArrayList<String> pic=null;%>
    <%	
    	p=(ArrayList<Product>)request.getAttribute("product");
	    user=(ArrayList<User>)request.getAttribute("user");
	    pic=(ArrayList<String>)request.getAttribute("pics");
    	name=p.get(0).getName();
    	price=p.get(0).getPrice();
    	description=p.get(0).getDescription();
    	iconPath=p.get(0).getIconPath();
    	phone=user.get(0).getTelephone();
    %>
    <div class="data-cont-wrap w1200">
      <div class="crumb">
        <a href="indexPage">首页</a>
        <span>></span>
        <a href="commodityPage">所有商品</a>
        <span>></span>
        <a href="">产品详情</a>
      </div>
      <div class="product-intro layui-clear">
        <div class="preview-wrap">
          <a href="javascript:;"><img src="<%=iconPath %>" style="width:400px"></a>
        </div>
        <div class="itemInfo-wrap">
          <div class="itemInfo">
            <div class="title">
              <h4><%=name %> </h4>
            </div>

            <div class="summary" style="height:50%">
              <p class="activity"><span>卖家价格</span><strong class="price"><i>￥</i><%=price %></strong></p>
            </div>

            <div class="description">
              <h6><textarea class="layui-textarea" rows="9" readonly><%=description %></textarea></h6>
            </div>

            <div class="choose-btns">
              <button class="layui-btn layui-btn-primary purchase-btn" id="contact">联系方式</button>
            </div>
          </div>
        </div>
      </div>
      <div class="layui-clear">
          <h2>图片详情</h2>
          <%
          	for(int i=0;i<pic.size();i++)
          	{
          		out.println(
          				"<div class=\"item\">"
          				+"<img src=\""+pic.get(i)+"\" style=\"width:1000px\">"
          				+"</div>"
          				);
          	}
          %>
          <div class="item">
            <img src="<%=iconPath %>" style="width:1000px">
          </div>
        </div>
      </div>
    </div>
  </div>
<script type="text/javascript">
  layui.config({
    base: 'res/static/js/util/' //你存放新模块的目录，注意，不是layui的模块目录
  }).use(['jquery','layer'],function(){
      var $ = layui.$,layer=layui.layer;
      $('#contact').on('click',function(){
    	  if(<%=code %>==0)
        	  layer.msg('请登录！', {
      	        time: 20000, //20s后自动关闭
      	        btn: ['知道了']
      	  })
    	  else
    	  layer.msg('<%=phone %>', {
    	        time: 20000, //20s后自动关闭
    	        btn: ['知道了']
    	  })

      })
      
  });
</script>


</body>
</html>