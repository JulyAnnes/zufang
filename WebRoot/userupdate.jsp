<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<html>
<head>
<title>公租房房屋租赁网站</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312"><LINK href="qtimages/style.css" type=text/css rel=stylesheet>
 <script language="javascript" src="js/Calendar.js"></script>
	<script type="text/javascript" src="js/popup.js"></script>
	    <script type="text/javascript">
	    function up(tt)
	    {
	        var pop=new Popup({ contentType:1,isReloadOnClose:false,width:300,height:50});
            pop.setContent("contentUrl","upload.jsp?Result="+tt);
            pop.setContent("title","文件上传");
            pop.build();
            pop.show();
	    }
	</script>
<style type="text/css">
<!--
.STYLE2 {	color: #0066CC;
	font-weight: bold;
}
-->
</style>
<style type="text/css">
<!--
.STYLE1 {color: #FFFFFF}
.STYLE5 {color: #CCFFCC;
	font-size: 26pt;
}
.STYLE6 {color: #288848}
.STYLE7 {	color: #185838;
	font-weight: bold;
}
-->
</style>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">

<%@ include file="qttop.jsp"%>


<TABLE height=8 cellSpacing=0 cellPadding=0 width=1002 align=center 
bgColor=#ffffff border=0>
  <TBODY>
  <TR>
    <TD></TD></TR></TBODY></TABLE>
<TABLE cellSpacing=0 cellPadding=0 width=1002 align=center bgColor=#ffffff 
border=0>
  <TBODY>
  <TR>
    <TD vAlign=top>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TBODY>
        <TR>
          <TD width=8></TD>
          <TD vAlign=top>
            <TABLE height=27 cellSpacing=0 cellPadding=0 width="100%" 
            background=qtimages/zjgdj_79.gif border=0>
              <TBODY>
              <TR>
                <TD 
                style="BACKGROUND-POSITION: left 50%; PADDING-LEFT: 12px; FONT-WEIGHT: bold; FONT-SIZE: 10.5pt; COLOR: #3d3d3d; BACKGROUND-REPEAT: no-repeat" 
                width=118 background=qtimages/zjgdj_77.gif><IMG 
                  src="qtimages/zjgdj_sy_26.gif" 
                align=absMiddle>&nbsp;${title }</TD>
                <TD style="PADDING-RIGHT: 1px" align=right 
                background=qtimages/zjgdj_79.gif>
                </TD>
                <TD width=7></TD></TR></TBODY></TABLE>
            <TABLE 
            style="BACKGROUND-POSITION: 50% top; BACKGROUND-REPEAT: repeat-x" 
            cellSpacing=0 cellPadding=8 width="100%" 
            background=qtimages/zjgdj_82.gif border=0>
              <TBODY>
              <TR>
                <TD style="PADDING-TOP: 8px" vAlign=top height=185><TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
                    <TBODY>
                    <TR>
                      <TD style="PADDING-TOP: 8px" align=middle class=newsline>
                      
                      
<script type="text/javascript">
function checkfrom()
{
	
	
	
	if (document.getElementById('dianhuaid').value=="")
	{
		alert("手机不能为空");
		return false;
	}
	
	valid=/^0?1[3,4,5,6,7,8,9][0,1,2,3,4,5,6,7,8,9]\d{8}$/;  
	if(!valid.test(document.getElementById('dianhuaid').value)){
		alert("请输入正确的手机格式");
		return false;
	}
	
	
	
	return true;
}
</script>
                      
                      
                      <form name="form1" method="post" action="${url }" onsubmit="return checkfrom()">
                      
                        <table width="98%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#529C33" style="border-collapse:collapse">
                          <tr>
                            <td>用户名：</td>
                            <td>${bean.username }
                             </td>
                          </tr>
                          
                          <tr>
                            <td>姓名：</td>
                            <td>${bean.xingming }</td>
                          </tr>
                          
                          <tr>
                            <td>手机号码：</td>
                            <td><input name='tel' type='text' id='telid' style="width: 300px;" value="${bean.tel }" />&nbsp;*</td>
                          </tr>
                         
                          <tr>
                            <td>&nbsp;</td>
                            <td><input type="submit" name="Submit5" value="提交"  style=" height:30px; border:solid 1px #000000; color:#666666"/>
                                <input type="reset" name="Submit22" value="重置" style=" height:30px; border:solid 1px #000000; color:#666666" /></td>
                          </tr>
                        </table>
                      </form>
                        <p align="center">&nbsp;</p>
                        <p align="center"></p>
                        <p align="center">&nbsp;</p></TD>
                    </TR></TBODY></TABLE></TD></TR></TBODY></TABLE>
            </TD></TR></TBODY></TABLE>
      <TABLE height=8 cellSpacing=0 cellPadding=0 width="100%" align=center 
      border=0>
        <TBODY>
        <TR>
          <TD></TD></TR></TBODY></TABLE>
      </TD>
    <TD width=8></TD>
    <TD vAlign=top width=220><%@ include file="qtleft.jsp"%></TD></TR></TBODY></TABLE>
<TABLE height=8 cellSpacing=0 cellPadding=0 width=1002 align=center 
bgColor=#ffffff border=0>
  <TBODY>
  <TR>
    <TD></TD></TR></TBODY></TABLE>
<TABLE height=8 cellSpacing=0 cellPadding=0 width=1002 align=center 
bgColor=#ffffff border=0>
  <TBODY>
  <TR>
    <TD></TD></TR></TBODY></TABLE>
<TABLE style="BORDER-RIGHT: #cccccc 1px solid; BORDER-LEFT: #cccccc 1px solid" 
cellSpacing=0 cellPadding=0 width=1002 align=center bgColor=#ffffff border=0>
  <TBODY>
  <TR>
    <TD 
    style="PADDING-RIGHT: 8px; PADDING-LEFT: 20px; PADDING-BOTTOM: 8px; PADDING-TOP: 8px" 
    vAlign=top>
      
      </TD></TR></TBODY></TABLE>
<TABLE height=4 cellSpacing=0 cellPadding=0 width=1002 align=center 
bgColor=#ffffff border=0>
  <TBODY>
  <TR>
    <TD width=5><IMG height=3 src="qtimages/zjgdj_64.gif" width=5></TD>
    <TD background=qtimages/zjgdj_65.gif><IMG height=3 
      src="qtimages/zjgdj_65.gif" width=1></TD>
    <TD width=4><IMG height=3 src="qtimages/zjgdj_67.gif" 
  width=4></TD></TR></TBODY></TABLE>
<TABLE height=8 cellSpacing=0 cellPadding=0 width=1002 align=center 
bgColor=#ffffff border=0>
  <TBODY>
  <TR>
    <TD></TD></TR></TBODY></TABLE>
<%@ include file="qtdown.jsp"%>
</body>
</html>