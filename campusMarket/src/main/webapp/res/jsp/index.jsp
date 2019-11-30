<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>校园小拍 首页</title>
  <link rel="stylesheet" type="text/css" href="../res/static/css/main.css">
  <link rel="stylesheet" type="text/css" href="../res/layui/css/layui.css">
  <script type="text/javascript" src="../res/layui/layui.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
</head>
<body id="list-cont">
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


  <div class="content">
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
    <div class="category-con">
      <div class="category-inner-con w1200">
        <div class="category-type">
          <h3>全部分类</h3>
        </div>
        <div class="category-tab-content">
          <div class="nav-con">
            <ul class="normal-nav layui-clear">
              <li class="nav-item">
                <div class="title">奶粉辅食</div>
                <p><a href="#">奶粉</a><a href="#">捕食</a><a href="#">营养品</a></p>
                <i class="layui-icon layui-icon-right"></i>
              </li>
              <li class="nav-item">
                <div class="title">纸尿裤</div>
                <p><a href="#">纸尿裤</a><a href="#">婴儿湿巾</a></p>
                <i class="layui-icon layui-icon-right"></i>
              </li>
              <li class="nav-item">
                <div class="title">洗护用品</div>
                <p><a href="#">母婴洗护用品</a><a href="#">孕婴童用品</a></p>
                <i class="layui-icon layui-icon-right"></i>
              </li>
              <li class="nav-item">
                <div class="title">儿童玩具</div>
                <p><a href="#">婴幼玩具</a><a href="#">遥控玩具</a><a href="#">积木拼插</a></p>
                <i class="layui-icon layui-icon-right"></i>
              </li>
            </ul>
          </div>
        </div>
      </div>
      <div class="category-banner">
        <div class="w1200">
          <img src="../res/static/img/banner1.JPg">
        </div>
      </div>
    </div>
    <div class="floors">
      <div class="sk">
        <div class="sk_inner w1200">
          <div class="sk_hd">
            <a href="javascript:;">
              <img src="../res/static/img/s_img1.jpg">
            </a>
          </div>
          <div class="sk_bd">
            <div class="layui-carousel" id="test1">
              <div carousel-item>
                <div class="item-box">
                  <div class="item">
                    <a href="javascript:;"><img src="../res/static/img/s_img2.jpg"></a>
                    <div class="title">宝宝五彩袜棉质舒服</div>
                    <div class="price">
                      <span>￥49.00</span>
                      <del>￥99.00</del>
                    </div>
                  </div>
                  <div class="item">
                    <a href="javascript:;"><img src="../res/static/img/s_img3.jpg"></a>
                    <div class="title">宝宝五彩袜棉质舒服</div>
                    <div class="price">
                      <span>￥49.00</span>
                      <del>￥99.00</del>
                    </div>
                  </div>
                  <div class="item">
                    <a href="javascript:;"><img src="../res/static/img/s_img4.jpg"></a>
                    <div class="title">宝宝五彩袜棉质舒服</div>
                    <div class="price">
                      <span>￥49.00</span>
                      <del>￥99.00</del>
                    </div>
                  </div>
                  <div class="item">
                    <a href="javascript:;"><img src="../res/static/img/s_img5.jpg"></a>
                    <div class="title">宝宝五彩袜棉质舒服</div>
                    <div class="price">
                      <span>￥49.00</span>
                      <del>￥99.00</del>
                    </div>
                  </div>
                </div>
                <div class="item-box">
                  <div class="item">
                    <a href="javascript:;"><img src="../res/static/img/s_img2.jpg"></a>
                    <div class="title">宝宝五彩袜棉质舒服</div>
                    <div class="price">
                      <span>￥49.00</span>
                      <del>￥99.00</del>
                    </div>
                  </div>
                  <div class="item">
                    <a href="javascript:;"><img src="../res/static/img/s_img3.jpg"></a>
                    <div class="title">宝宝五彩袜棉质舒服</div>
                    <div class="price">
                      <span>￥49.00</span>
                      <del>￥99.00</del>
                    </div>
                  </div>
                  <div class="item">
                    <a href="javascript:;"><img src="../res/static/img/s_img4.jpg"></a>
                    <div class="title">宝宝五彩袜棉质舒服</div>
                    <div class="price">
                      <span>￥49.00</span>
                      <del>￥99.00</del>
                    </div>
                  </div>
                  <div class="item">
                    <a href="javascript:;"><img src="../res/static/img/s_img5.jpg"></a>
                    <div class="title">宝宝五彩袜棉质舒服</div>
                    <div class="price">
                      <span>￥49.00</span>
                      <del>￥99.00</del>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>    
      </div>
    </div>



    <div class="product-list-box" id="product-list-box">
      <div class="product-list-cont w1200">
        <h4>更多推荐</h4>
        <div class="product-item-box layui-clear">

          <div class="list-item">
            <a href="javascript:;"><img src="../res/static/img/more3.jpg"></a>
            <p>时尚宝宝小黄鸭T恤纯棉耐脏多色可选0-2岁宝宝</p>
            <span>￥100.00</span>
          </div>
          <div class="list-item">
            <a href="javascript:;"><img src="../res/static/img/more1.jpg"></a>
            <p>时尚宝宝小黄鸭T恤纯棉耐脏多色可选0-2岁宝宝</p>
            <span>￥100.00</span>
          </div>
          <div class="list-item">
            <a href="javascript:;"><img src="../res/static/img/more3.jpg"></a>
            <p>时尚宝宝小黄鸭T恤纯棉耐脏多色可选0-2岁宝宝</p>
            <span>￥100.00</span>
          </div>
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

layui.config({
    base: '../res/static/js/util/' //你存放新模块的目录，注意，不是layui的模块目录
  }).use(['mm','carousel'],function(){
      var carousel = layui.carousel,
     mm = layui.mm;
     var option = {
        elem: '#test1'
        ,width: '100%' //设置容器宽度
        ,arrow: 'always'
        ,height:'298' 
        ,indicator:'none'
      }
      carousel.render(option);
      // 模版引擎导入
     // var ins = carousel.render(option);
     // var html = demo.innerHTML;
     // var listCont = document.getElementById('list-cont');
     // // console.log(layui.router("#/about.html"))
     //  mm.request({
     //    url: '../json/index.json',
     //    success : function(res){
     //      console.log(res)
     //      listCont.innerHTML = mm.renderHtml(html,res)
     //      ins.reload(option);
     //    },
     //    error: function(res){
     //      console.log(res);
     //    }
     //  })
    

});
  </script>
</body>
</html>