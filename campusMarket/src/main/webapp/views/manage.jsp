<%@ page language="java" import="model.user.User,model.product.Product,java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>校园小拍  个人信息管理</title>
    <link rel="stylesheet" type="text/css" href="res/static/css/main.css">
    <link rel="stylesheet" type="text/css" href="res/layui/css/layui.css">
    <script type="text/javascript" src="res/layui/layui.js"></script>

    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
</head>
<%! User u=null; String name,gender,campus,school,telephone,iconPath=null; ArrayList<Product> myproduct=null;int pn=0;%>
<%
	myproduct=(ArrayList<Product>)request.getAttribute("myproduct");
	u=(User)session.getAttribute("user");
	name=u.getName();
	gender=u.getGender();
	campus=u.getCampus();
	school=u.getSchool();
	telephone=u.getTelephone();
	iconPath=u.getIconPath();
%>
<body>
  <div class="site-nav-bg">
    <div class="site-nav w1200">
      <p class="sn-back-home">
        <i class="layui-icon layui-icon-home"></i>
        <a href="indexPage">首页</a>
      </p>
      <div class="sn-quick-menu">
      <%
      		if(u!=null)
      			out.println(
      			"<div class=\" layui-layout-right\">"
                +"<a href=\"managePage\"><img src=\""+iconPath+"\" class=\"layui-nav-img\"></a>"
           +"</div>"
      					);
      		else
      			out.println("        <div class=\"login\"><a href=\"loginPage\">登录</a></div><div class=\"login\"><a href=\"registerPage\">注册</a></div>");
      %>
      </div>
    </div>
  </div>
<div class="layui-layout-admin">
    <!--头部-->
    <div class="header" >
        <div class="headerLayout w1200">
            <div class="headerCon">
                <h1 class="mallLogo">
                    <a href="indexPage" title="校园小拍">
                        <img src="res/static/img/logo.png">
                    </a>
                </h1>
            </div>
        </div>
    </div>


    <!--中间主体-->
    <div class="layui-container">
        <div class="layui-tab">
            <ul class="layui-tab-title">
                <li class="layui-this">个人资料</li>
                <li>商品管理</li>
                <li>安全设置</li>
            </ul>
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">
                  <div class="ui container">
                      <div class="ui segment">
                          <div class="layui-form" action="updateUser">
                              <div class="layui-form-item">

                                      <div class="layui-row">
                                          <div class="layui-col-md4">
                                              <label class="layui-form-label-col">头像</label>
                                              <img src="" width="50%" id="ig">
                                            <div>
                                                <input type="file" name="file" id="file" class="layui-input">
                                                <input type="button" class="ui yellow button"  id="modify" lay-submit=""  value="确认修改">
                                            </div>
                                          </div>
                                          <div class="layui-col-md6">
                                              <div class="layui-input-block">
                                                  <label class="layui-form-label-col">名字</label>
                                                  <input placeholder="<%=name%>" type="text" name="name" lay-verify="required" value="" autocomplete="off" class="layui-input">
                                              </div>
                                              <div class="layui-input-block">
                                                  <label class="layui-form-label-col">性别</label>
                                                  <select>
                                                  <%
                                                  if(gender.equals("女"))
                                                  out.println("<option value=\"女\">女</option>"
                                                          +"<option value=\"男\">男</option>");
                                                  else
                                                	  out.println("<option value=\"男\">男</option>"
                                                              +"<option value=\"女\">女</option>");
                                                  %>
                                                      
                                                  </select>
                                              </div>
                                              <div class="layui-input-block">
                                                  <label class="layui-form-label-col">学校</label>
                                                  <input placeholder="<%=school%>" type="text" name="school" lay-verify="required" autocomplete="off" class="layui-input">
                                              </div>
                                              <div class="layui-input-block">
                                                  <label class="layui-form-label-col">校区</label>
                                                  <input type="text" placeholder="<%=campus%>" name="campus" value="" lay-verify="required" autocomplete="off" class="layui-input">
                                              </div>
                                              <div class="layui-input-block">
                                                  <label class="layui-form-label-col">联系电话</label>
                                                  <input type="text" placeholder="<%=telephone%>" name="telephone" value="" lay-verify="required" autocomplete="off" class="layui-input">
                                              </div>
                                          </div>

                                      </div>




                              </div>
                          </div>

                      </div>






                  </div>
                </div>









                <div class="layui-tab-item">
                    <div class="layui-container">
                        <div class="layui-row">
                            <div class="layui-col-md3">
                                <ul class="layui-nav layui-nav-tree" lay-filter="test">
                                    <!-- 侧边导航: <ul class="layui-nav layui-nav-tree layui-nav-side"> -->
                                    <li class="layui-nav-item">
                                        <a href="addPage">商品上新</a>
                                    </li>
                                </ul>
                            </div>
                            <div class="layui-col-md9">
                                <div class="content content-nav-base commodity-content">

                                    <div class="commod-cont-wrap">
                                        <div class="commod-cont w1200 layui-clear">
                                            <div class="cont-wrap">
                                                <div class="right-cont" >
                                                    <div class="cont-list layui-clear" id="list-cont">
<%

pn=myproduct.size();
if(pn!=0)
for(int i=0;i<pn;i++)
{
	out.println(
			"<div class=\"item\">"
			
               + "<div class=\"img\">"
        			+"<a href=\"updateProductPage?code="+myproduct.get(i).getId()+"\"><img src=\""+myproduct.get(i).getIconPath()+"\" style=\"width:280px\"></a>"
      			+"</div>"
      			
			      +"<div class=\"text\">"
			      
			        +"<p class=\"title\">"+myproduct.get(i).getName()+"</p>"
			        
			        +"<p class=\"price\">"
			        
			         +"<span class=\"pri\">￥"+myproduct.get(i).getPrice()+"</span>" 
			         
			        +"</p>"
			        
			      +"</div>"
			      
			+"</div>");
}

%>


                                                    </div>
                                                    <div id="demo0" style="text-align: center;"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>


                    <script>

                        layui.config({
                            base: 'res/static/js/util/' //你存放新模块的目录，注意，不是layui的模块目录
                        }).use(['mm','laypage','jquery',],function(){
                            var laypage = layui.laypage,$ = layui.$,
                                mm = layui.mm;
                            laypage.render({
                                elem: 'demo0'
                                ,count: <%=pn%> //数据总数
                            });


                            // 模版引擎导入
                            //  var html = demo.innerHTML;
                            //  var listCont = document.getElementById('list-cont');
                            // mm.request({
                            //     url: 'json/commodity.json',
                            //     success : function(res){
                            //       console.log(res)
                            //       listCont.innerHTML = mm.renderHtml(html,res)
                            //     },
                            //     error: function(res){
                            //       console.log(res);
                            //     }
                            //   })

                            $('.sort a').on('click',function(){
                                $(this).addClass('active').siblings().removeClass('active');
                            })
                            $('.list-box dt').on('click',function(){
                                if($(this).attr('off')){
                                    $(this).removeClass('active').siblings('dd').show()
                                    $(this).attr('off','')
                                }else{
                                    $(this).addClass('active').siblings('dd').hide()
                                    $(this).attr('off',true)
                                }
                            })

                        });
                    </script>
                </div>







                <div class="layui-tab-item">

				 <div class="layui-container" style="width: 50%">
                     <div class="layui-form" id="updateForm" method="post">
                         <div class="layui-form-item">
                             <div class="layui-input-block">
                                 <input type="password" placeholder="原密码" id="pwd" name="oldpassword" value="" lay-verify="required" autocomplete="off" class="layui-input">
                             </div>
                             <div class="layui-input-block">
                                 <input type="password" placeholder="请输入新密码" id="npaw1" name="" value="" lay-verify="required" autocomplete="off" class="layui-input">
                             </div>
                             <div class="layui-input-block">
                                 <input type="password" placeholder="确认新密码" id="npaw2" name="newpassword" value="" lay-verify="required" autocomplete="off" class="layui-input">
                             </div>
                         </div>
                         <div class="layui-form-item"  align="left">
                             <div class="layui-input-block">
                                 <button class="layui-btn" id="modifypaw" lay-submit="" lay-filter="demo1">
                                   确认修改
                                 </button>
                             </div>
                         </div>
                    </div>
<script type="text/javascript">
   layui.config({
      base: 'res/static/js/util' //你存放新模块的目录，注意，不是layui的模块目录
    }).use(['jquery','form','layer'],function(){
          var $ = layui.$,layer=layui.layer,form = layui.form;
    $("#modifypaw").click(function() {

    var npaw1 = $('#npaw1').val();

    var npaw2 = $('#npaw2').val();
    
    var pwd= $('#pwd').val();
    
    var params = {"oldpassword": pwd,"newpassword":npaw2 };
    var data="'"+params+"'";
    alert(data);
    if(npaw1==npaw2)
    {

    $.ajax({
    url:"updatePassword",
    type:"post",
    data:data,
    processData:false,
    contentType:false,

    success:function(ret) {
    console.log("ok");
    },
    error: function(ret) {
    console.log("bad");
    }
    })

    }
    else{
    layer.msg('草你妈妈没没没没没',{
    time:200000,
    btn:['好的']
    })



    }



    })





    })
  </script>
                     </div>
                 </div>
				
				</div>

            </div>
        </div>
    </div>



</div>

</body>
</html>