<%--
  Created by IntelliJ IDEA.
  User: kinthon
  Date: 17-6-25
  Time: 下午1:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java" %>

<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>图书管理系统</title>

    <!-- BOOTSTRAP STYLES-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLES-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <!--CUSTOM BASIC STYLES-->
    <link href="assets/css/basic.css" rel="stylesheet" />
    <!--CUSTOM MAIN STYLES-->
    <link href="assets/css/custom.css" rel="stylesheet" />
    <!-- GOOGLE FONTS-->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>
<div id="wrapper">
    <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.html">图书管理系统</a>
        </div>

        <div class="header-right">

            <a  class="btn btn-info" title="New Message"><b>30 </b><i class="fa fa-envelope-o fa-2x"></i></a>
            <a  class="btn btn-primary" title="New Task"><b>40 </b><i class="fa fa-bars fa-2x"></i></a>
            <a href="login.html" class="btn btn-danger" title="Logout"><i class="fa fa-exclamation-circle fa-2x"></i></a>

        </div>
    </nav>
    <!-- /. NAV TOP  -->
    <nav class="navbar-default navbar-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="main-menu">
                <li>
                    <div class="user-img-div">
                        <img src="assets/img/111.png" class="img-thumbnail" />

                        <div class="inner-text">
                            东华大学
                            <br />
                            <small>上海市松江区人民北路2999号 </small>
                        </div>
                    </div>
                </li>
                <li>
                    <a class="active-menu"><i class="fa fa-dashboard "></i>首页</a>
                </li>
                <li>

                    <a href="backBook.jsp?user.username=${user.username}"><i class="fa fa-flash "></i>还书</a>
                </li>
                <li>

                    <a href="reBorrow.jsp?user.username=${user.username}"><i class="fa fa-flash "></i>续借</a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-bicycle "></i>信息管理 <span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">

                        <li>

                            <a href="user_getInfo.action?user.username=${user.username}"><i class="fa fa-desktop "></i>查看个人信息</a>
                        </li>
                        <li>

                            <a href="listBook.action?user.username=${user.username}"><i class="fa fa-code "></i>图书搜索</a>
                        </li>


                    </ul>
                </li>
                <li>

                    <a href="user_get.action?user.username=${user.username}"><i class="fa fa-anchor "></i>支付</a>
                </li>

                <li>

                    <a href="index.jsp"><i class="fa fa-sign-in "></i>登录</a>
                </li>

            </ul>

        </div>

    </nav>
    <!-- /. NAV SIDE  -->
    <div id="page-wrapper">
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-head-line">东华大学图书信息中心</h1>
                    <h2>你好 ,${user.username}同学</h2>
                    <h1 class="page-subhead-line">书籍是人类进步的阶梯.<br /> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp---&nbsp列宁</h1>

                </div>
            </div>
            <!-- /. ROW  -->
            <div class="row">
                <div class="col-md-4">
                    <div class="main-box mb-red">
                        <a href="#">
                            <i class="fa fa-bolt fa-5x"></i>
                            <h5>闪电查找</h5>
                        </a>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="main-box mb-dull">
                        <a href="#">
                            <i class="fa fa-plug fa-5x"></i>
                            <h5>联网查询</h5>
                        </a>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="main-box mb-pink">
                        <a href="#">
                            <i class="fa fa-dollar fa-5x"></i>
                            <h5>科学计费</h5>
                        </a>
                    </div>
                </div>

            </div>
            <!-- /. ROW  -->

            <div class="row">
                <div class="col-md-8">
                    <div class="row">

                    </div>
                    <!-- /. ROW  -->
                    <hr />

                    <div class="panel panel-default">

                        <div id="carousel-example" class="carousel slide" data-ride="carousel" style="border: 5px solid #000;">

                            <div class="carousel-inner">
                                <div class="item active">

                                    <img src="assets/img/slideshow/1.jpg" alt="" />

                                </div>
                                <div class="item">
                                    <img src="assets/img/slideshow/2.jpg" alt="" />

                                </div>
                                <div class="item">
                                    <img src="assets/img/slideshow/3.jpg" alt="" />

                                </div>
                            </div>
                            <!--INDICATORS-->
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example" data-slide-to="1"></li>
                                <li data-target="#carousel-example" data-slide-to="2"></li>
                            </ol>
                            <!--PREVIUS-NEXT BUTTONS-->
                            <a class="left carousel-control" href="#carousel-example" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                            </a>
                            <a class="right carousel-control" href="#carousel-example" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                            </a>
                        </div>
                    </div>
                </div>

            </div>
            <!-- /. ROW  -->


            <div class="row">

                <div class="col-md-8">
                    <div class="list-group">
                        <a href="#" class="list-group-item active">

                        </a>
                    </div>
                    <br />
                    <!-- 16:9 aspect ratio -->

                </div>

            </div>
            <!--/.Row-->
            <hr />


        </div>
        <!-- /. PAGE INNER  -->
    </div>
    <!-- /. PAGE WRAPPER  -->
</div>

<!-- /. FOOTER  -->
<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
<!-- JQUERY SCRIPTS -->
<script src="assets/js/jquery-1.10.2.js"></script>
<!-- BOOTSTRAP SCRIPTS -->
<script src="assets/js/bootstrap.js"></script>
<!-- METISMENU SCRIPTS -->
<script src="assets/js/jquery.metisMenu.js"></script>
<!-- CUSTOM SCRIPTS -->
<script src="assets/js/custom.js"></script>



</body>
</html>
