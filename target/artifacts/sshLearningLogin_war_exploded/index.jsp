<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>图书馆信息管理系统登陆</title>

    <!-- BOOTSTRAP STYLES-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLES-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <!-- GOOGLE FONTS-->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />

</head>
<body style="background-color: #E2E2E2;">
<div class="container">
    <div class="row text-center " style="padding-top:100px;">
        <div class="col-md-12">
            <img src="assets/img/12.png" />
        </div>
    </div>
    <div class="row ">

        <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">

            <div class="panel-body">
                <form action="user_login.action" method="post">
                    <hr />
                    <h5>图书信息管理系统登录</h5>
                    <br />
                    <div class="form-group input-group">
                        <span class="input-group-addon"><i class="fa fa-tag"  ></i></span>

                        用&nbsp;户&nbsp;名：<input type="text" class="form-control" name="user.username" placeholder="输入用户名" />
                    </div>
                    <div class="form-group input-group">
                        <span class="input-group-addon"><i class="fa fa-lock"  ></i></span>

                        输入密码：<input type="password" class="form-control" name="user.password" placeholder="输入密码" />

                    </div>
                    <div class="form-group">
                        <label class="checkbox-inline">
                            <input type="checkbox" /> 记住密码
                        </label>

                    </div>


                    <input type="submit" value="登录">
                    <input type="reset" value="重置">
                    <hr />
                    如果您还没有注册，请单击<a href="register.jsp">这里</a>注册！
                    <br /><br />

                    <a href="manager.jsp">管理员登陆</a>
                </form>
            </div>

        </div>
    </div>
</div>

</body>
</html>
