<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.util.Util"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

Util.init(request);

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN""http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>公租房房屋租赁网站</title>
<!--                       CSS                       -->
<!-- Reset Stylesheet -->
<link rel="stylesheet" href="resources/css/reset.css" type="text/css" media="screen" />
<!-- Main Stylesheet -->
<link rel="stylesheet" href="resources/css/style.css" type="text/css" media="screen" />
<!-- Invalid Stylesheet. This makes stuff look pretty. Remove it if you want the CSS completely valid -->
<link rel="stylesheet" href="resources/css/invalid.css" type="text/css" media="screen" />
<!--                       Javascripts                       -->
<!-- jQuery -->
<script type="text/javascript" src="resources/scripts/jquery-1.3.2.min.js"></script>
<!-- jQuery Configuration -->
<script type="text/javascript" src="resources/scripts/simpla.jquery.configuration.js"></script>
<!-- Facebox jQuery Plugin -->
<script type="text/javascript" src="resources/scripts/facebox.js"></script>
<!-- jQuery WYSIWYG Plugin -->
<script type="text/javascript" src="resources/scripts/jquery.wysiwyg.js"></script>

<script type="text/javascript" language="javascript">
function checkform(){
	
	 
	    if (document.getElementById('usernameid').value=="")
	{
		alert("账户不能为空");
		return false;
	}
	
    if (document.getElementById('passwordid').value=="")
	{
		alert("密码不能为空");
		return false;
	}
	
	
	return true;

}
function register(){
	
	 
	    window.location.href='zhuce.jsp';

}

</script>

</head>
<body id="login">
<div id="login-wrapper" class="png_bg">
  <div id="login-top">
    <h1></h1>
  
    <a href="#">
    <span style="font-size: 40px;font-weight: bold;">房屋租赁网站</span>
    </a> </div>
  <!-- End #logn-top -->
  <div id="login-content">
  
     <form method="post"   action="method!login.action" onsubmit="return checkform()">
      
      <p>
        <label>账户：</label>
        <input class="text-input" type="text" name="username" id="usernameid"/>
      </p>
      <div class="clear"></div>
      <p>
        <label>密码：</label>
        <input class="text-input" type="password" name="password" id="passwordid"/>
      </p>
      <div class="clear"></div>
      <p>
      <a href="../">
       返回首页
       </a>
       &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
        <input class="button" type="submit" value="登 录" />
      </p>
    </form>
  </div>
  <!-- End #login-content -->
</div>
<!-- End #login-wrapper -->
</body>
</html>
