<%@ page language="java" import="java.util.*,model.product.Product,model.user.User" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改商品信息</title>
    <link rel="stylesheet" type="text/css" href="../res/static/css/main.css">
    <link rel="stylesheet" type="text/css" href="../res/layui/css/layui.css">
    <script type="text/javascript" src="../res/layui/layui.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.2/dist/jquery.min.js"></script>
    <style>
        body{
            background: transparent url("../res/static/img/百货4.jpg");
        }
    </style>
</head>
<body>
<div>
    <div class="layui-container" style="width:45%">
        <div>
            <h1 align="center" style="font-family: 华文彩云;font-size: 25px;margin-top: 10px;margin-bottom: 10px">修改商品</h1>
        </div>
             <div class="layui-card"  style="background-color:rgba(210,210,210,0.5) ">
                 <div class="layui-card-body">
            <form id="updataProductForm" class="layui-form"  action="">
                <div class="layui-form-item">
                    <div class="layui-input-block" style="margin-left: 10px">
                        <label class="layui-form-label-col" >名字</label>
                        <input type="text" name="name" class="layui-input">
                    </div>

                    <div class="layui-input-block" style="margin-left: 10px">
                        <label class="layui-form-label-col">价格</label>
                        <input type="text" name="price" class="layui-input">
                    </div>

                    <div class="layui-input-block" style="margin-left: 10px">
                        <label class="layui-form-label-col">描述</label>
                        <textarea name="description" required lay-verify="required" placeholder="请输入" class="layui-textarea"></textarea>
                    </div>


                    <div class="layui-input-block" style="margin-left: 10px">
                        <label class="layui-form-label-col">类别</label>
                        <select>
                            <option value="1">fruit</option>
                            <option value="0">weapon</option>
                        </select>
                    </div>

                    <div class="layui-input-block" style="margin-left: 10px">
                        <label class="layui-form-label-col">图片1</label>
                        <input type="file" accept=".jpg,.png" name="file" >
                    </div>
                    <div class="layui-input-block" style="margin-left: 10px">
                        <label class="layui-form-label-col">图片2</label>
                        <input type="file" name="file" >
                    </div>
                    <div class="layui-input-block" style="margin-left: 10px">
                        <label class="layui-form-label-col">图片3</label>
                        <input type="file" name="file" >
                    </div>
                </div>

                <div class="layui-form-item" style="margin-left:10px;">
                    <div class="layui-input-block" style="margin-left: 0px">
                        <button  class="layui-btn"  id="addProductButton" lay-submit="" lay-filter="demo1" onclick="return false">
                            确认修改
                        </button>
                        <button  class="layui-btn"  id="delProductButton" lay-filter="demo1">
                            下架
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
        base: '../res/static/js/util' //你存放新模块的目录，注意，不是layui的模块目录
    }).use(['jquery','form','layer'],function() {
        var $ = layui.$, layer=layui.layer,form = layui.form;

       $("#delProductButton").click(function () {
           layer.confirm
           (
               '是否下架'
               ,{btn:['确认','再想想']}
               ,function () {
                   var json = JSON.stringify();
                   $.ajax({
                       url:"#",
                       type:"post",
                       data:json,
                       dataType:"json",
                       async:false,
                       success:function(data) {
                           if(data.success){
                               layer.msg('删除成功', {icon: 1});
                           }else{
                               layer.msg('删除失败', {icon: 2});
                           }
                       }

                   })

               }
           )
       })




        $("#addProductButton").click(function() {

            var form = new FormData(document.getElementById("updataProductForm"));

            var userId = "201700301111";<!--get userId -->

            var time = new Date().toUTCString();<!--get current time -->

            console.log(time);

            form.append("userId", userId);

            form.append("time", time);

            $.ajax({

                url:"/campusMarket/addProduct",

                type:"post",

                data:form,

                processData:false,

                contentType:false,

                success: function(ret) {

                    console.log("ok");

                },

                error: function(ret) {

                    console.log("bad");

                }

            })

        })


    })
</script>
</body>
</html>