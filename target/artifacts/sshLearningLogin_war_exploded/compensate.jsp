<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/6/20
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>损失填写</title>

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

    <script type="text/javascript">
        function getRadioValue(compensate) {
            for(var i=0;i<compensate.length;i++)
            {
                if(compensate[i].checked)
                {
                    str=compensate[i].value;
                    alert(str);
                }
            }
            return str;
        }

    </script>
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
                    <a class="active-menu"><i class="fa fa-dashboard "></i>111</a>
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
                    <h2>你好 ,${manager.username}管理员，请选择你的操作</h2>
                    <h1 class="page-subhead-line">书籍是人类进步的阶梯.<br /> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp---&nbsp列宁</h1>

                </div>
            </div>



            <!-- /. ROW  -->

            <a href="successManage.jsp?manager.username=${manager.username}">返回主页</a> <br/>
            <form action="compensate.action" method="post">

                用户名：<input  type="type" name="borrowinfo.username" ><br/>
                <%--损失类型：<select name="cType" >--%>
                <%--<option value="0">超期赔偿</option>--%>
                <%--<option value="1">损坏赔偿</option>--%>
                <%--<option value="2">丢失赔偿</option>--%>
                <%--</select>--%>

                损失类型：<input  type="radio" name="type" value="0" checked>超期赔偿<br/>
                <input type="radio" name="type" value="1">损坏赔偿<br/>
                <input type ="radio" name="type" value="2">丢失赔偿<br/>
                图书编号：<input type="text" name="borrowinfo.bookid" ><br/>
                <input  type="submit" value="提交">

            </form>

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

