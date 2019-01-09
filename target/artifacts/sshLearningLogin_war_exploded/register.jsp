<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/6/13
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>图书管理系统注册</title>

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

    <!-- /. NAV SIDE  -->
    <div id="page-wrapper">
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-head-line">注册页面</h1>
                    <h1 class="page-subhead-line">欢迎光临本图书馆管理系统 </h1>

                </div>
            </div>
            <!-- /. ROW  -->
            <div class="row">
                <div class="col-md-6 col-sm-6 col-xs-12">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            BASIC FORM
                        </div>
                        <div class="panel-body">

                            <form action="register.action" method="post">
                                <div class="form-group">
                                    <label>用&nbsp;户&nbsp;名：</label>
                                    <input type="text" name="user.username" placeholder="输入用户名" />
                                </div>
                                <div class="form-group">
                                    <label> 输入密码：</label>
                                    <input type="password" name="user.password" placeholder="输入密码" />


                                </div>
                                <div class="form-group">
                                    <label>性别：</label>
                                    <input type="text" name="user.sex" placeholder="输入性别"/>
                                </div>

                                <div class="form-group">
                                    <label>学号：</label>
                                    <input type="text" name="user.studentId" placeholder="输入学号"/>
                                </div>

                                <input type="submit" class="btn btn-danger" value="提交" >


                            </form>
                        </div>
                    </div>
                </div>

            </div>


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
