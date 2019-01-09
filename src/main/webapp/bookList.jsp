
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/6/20
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
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
                    <h1 class="page-head-line">图书操作</h1>
                    <h2>你好 ,${manager.username}管理员</h2>
                    <h1 class="page-subhead-line">书籍是人类进步的阶梯.<br /> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp---&nbsp列宁</h1>

                </div>
            </div>



            <!-- /. ROW  -->

            <a href="successManage.jsp?manager.username=${manager.username}" >返回主页</a> <br/>
            <h3>图书搜索：</h3>
            <form action="selectBook" method="post">
                书名：<input type="text" name="book.name" ><br/>

                作者：<input type="text" name="book.author"  > <br/>
                出版社：<input type="text" name="book.publisher" ><br/>
                <input type="submit" value="查询">
                <input type="reset" value="重置">
                <br/>

            </form>


            <h3>搜索结果：</h3>

            <div style="margin:0px auto; width:500px">
                <table  cellspacing="0" border="1" width="100%">
                    <tr >

                        <td>删除</td>
                        <td >图书存储序号</td>
                        <td>图书编号</td>
                        <td>书名</td>
                        <td>作者</td>
                        <td>图书类型</td>
                        <td>出版社</td>
                        <td>库存总数量</td>
                        <td>借出数量</td>
                        <td>书籍信息</td>
                        <td>单价</td>
                    </tr>

                    <s:iterator value="%{books}" var="p">

                        <tr>

                            <td><a href="deleteBook.action?book.bookid=${p.bookid}">删除</a> </td>
                            <td>${p.id} </td>
                            <td>${p.bookid}</td>
                            <td>${p.name}</td>
                            <td>${p.author}</td>
                            <td>${p.type}</td>
                            <td>${p.publisher}</td>
                            <td>${p.allmount}</td>
                            <td>${p.mount}</td>
                            <td>${p.remark}</td>
                            <td>${p.price}</td>

                        </tr>
                    </s:iterator>
                </table>

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

