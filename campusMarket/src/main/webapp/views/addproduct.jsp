<%@ page language="java" import="java.util.*,model.product.Product,model.user.User" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>

<html>

<head>

    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">

    <title>上架商品</title>
    <link rel="stylesheet" type="text/css" href="res/static/css/main.css">
    <link rel="stylesheet" type="text/css" href="res/layui/css/layui.css">
    <script type="text/javascript" src="res/layui/layui.js"></script>

    <style>
        body{
            background: transparent url("res/static/img/百货4.jpg");
        }
    </style>
</head>

<body>

<div>
    <div class="layui-container" style="width:45%">
        <div>
            <h1 align="center" style="font-family: 华文彩云;font-size: 25px;margin-top: 10px;margin-bottom: 10px">商品上架</h1>
        </div>
        <div class="layui-card"  style="background-color:rgba(210,210,210,0.5) ">
            <div class="layui-card-body">
                <form id="addProductForm" class="layui-form"  action="">
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

                    <div class="layui-form-item" style="margin-left: 10px">
                        <div class="layui-input-block" style="margin-left:0" >
                            <button  class="layui-btn"  id="addProductButton" lay-submit="" lay-filter="demo1" onclick="return false">
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


    $("#addProductButton").click(function() {

        var form = new FormData(document.getElementById("addProductForm"));

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