<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.util.Util"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";


%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<title>公租房房屋租赁网站</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312"><LINK href="qtimages/style.css" type=text/css rel=stylesheet>
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
-->
</style>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" style="background:#FAFAFA;">

<%@ include file="qttop.jsp"%>


<TABLE height=8 cellSpacing=0 cellPadding=0 width=1002 align=center 
bgColor=#ffffff border=0>
  <TBODY>
  <TR>
    <TD></TD></TR></TBODY></TABLE>
<TABLE cellSpacing=0 cellPadding=0 width=1002 align=center bgColor=#ffffff 
border=0 style="padding-right: 5px;">
  <TBODY>
  <TR>
    <TD vAlign=top>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" height="357px" border=0>
        <TBODY>
        <TR>
          <TD width=8></TD>
          <TD vAlign=top>
            <TABLE width=774 height="280" 
border=0 align=center cellPadding=0 cellSpacing=0 bgColor=#ffffff>
  <TBODY>
  <TR>
    <TD vAlign=center width=294 align="center"><SCRIPT type=text/javascript>
var focus_width=284;
var focus_height=251;
var text_height=20;
var swf_height = focus_height+text_height;
var pics="";
var links="";
var texts="";

pics="${pics}";
links="${links}";
texts="${texts}";
document.write('<embed src="qtimages/pixviewer.swf" wmode="opaque" FlashVars="pics='+pics+'&links='+links+'&texts='+texts+'&borderwidth='+focus_width+'&borderheight='+focus_height+'&textheight='+text_height+'" menu="false" bgcolor="#ffffff" quality="Best" width="'+ focus_width +'" height="'+ swf_height +'" allowScriptAccess="sameDomain" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer">');

</SCRIPT></TD>
    <TD vAlign=bottom width=8>&nbsp;</TD>
    <TD width="514" vAlign=top>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TBODY>
        <TR>
          <TD vAlign=top><TABLE height=24 cellSpacing=0 cellPadding=0 width="100%" 
              border=0><TBODY>
              <TR 
              style="BACKGROUND: url(qtimages/zjgdj_sy_15.gif) repeat-x 50% top">
                <TD width=13></TD>
                <TD 
                style="FONT-SIZE: 14px; COLOR: #fff; BACKGROUND-REPEAT: no-repeat" 
                align=middle width=89 
                  background=qtimages/zjgdj_sy_16.gif><STRONG><a href="indexmethod!xinwenlist" ><font class="STYLE1">最新要闻</font></a></STRONG></TD>
                <TD width=27></TD>
               
                <TD style="PADDING-RIGHT: 8px" align=right></TD></TR></TBODY></TABLE>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD 
                style="PADDING-RIGHT: 8px; PADDING-LEFT: 8px; PADDING-BOTTOM: 8px; PADDING-TOP: 8px" 
                vAlign=top class="newsline"><table class="newsline" cellspacing="0" cellpadding="0" width="98%" 
                  align="center" border="0" style="height: 230px;">
                  <tbody>
                    
                    <c:forEach items="${xinwenlist}" var="xinwen">
                    <tr>
                      <td width="4%" height="28" align="center" ><img src="qtimages/1011211706367381564.gif" width="3" height="5"></td>
                      <td width="79%" height="28"><a
                        href="indexmethod!xinwenshow?id=${xinwen.id }">${xinwen.xtitle }</a> </td>
                      <td width="16%" height="28"><SPAN 
                        style="FONT-SIZE: 9pt; COLOR: #b5a073; FONT-FAMILY: 宋体">[${xinwen.ctime }]</SPAN>
                      </td>
                    </tr>
                    </c:forEach>
                    
                  </tbody>
                </table></TD>
              </TR></TBODY></TABLE></TD></TR></TBODY></TABLE></TD>
    </TR></TBODY></TABLE>
            </TD></TR></TBODY></TABLE>
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
                align=absMiddle>&nbsp;所有房源</TD>
                <TD style="PADDING-RIGHT: 1px" align=right 
                background=qtimages/zjgdj_79.gif><A  href="indexmethod!houselist2">更多&gt;&gt;</A></TD>
                <TD width=7></TD></TR></TBODY></TABLE>
            <TABLE 
            style="BACKGROUND-POSITION: 50% top; BACKGROUND-REPEAT: repeat-x" 
            cellSpacing=0 cellPadding=8 width="100%" 
            background=qtimages/zjgdj_82.gif border=0>
              <TBODY>
              <TR>
                <TD style="PADDING-TOP: 8px" vAlign=top height=400><TABLE cellSpacing=0 cellPadding=0 width="100%" height="100%" border=0>
                    <TBODY>
                    <TR>
                      <TD style="PADDING-TOP: 8px" align=middle><table width="100%" height="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <c:forEach items="${houselist}" var="house">
                          <td align="center"><table width="150" border="0" cellspacing="0" cellpadding="0">
                              
                              
                              <tr>
                                <td height="129" align="center">
                                <a href="indexmethod!houseshow?id=${house.id }"><img src="uploadfile/${house.path }" width="129" height="123" border="0" /></a></td>
                              </tr>
                              <tr>
                                <td height="26" align="center">${house.mingchen }</td>
                              </tr>
                             
                              
                          </table>
                          
                          </td>
                           </c:forEach>
                           
                        </tr>
                      </table></TD>
                    </TR></TBODY></TABLE></TD></TR></TBODY></TABLE>
            </TD></TR></TBODY></TABLE>
      <TABLE height=8 cellSpacing=0 cellPadding=0 width="100%" align=center 
      border=0>
        <TBODY>
        <TR>
          <TD></TD></TR></TBODY></TABLE>
      </TD>
    <TD width=8></TD>
    <TD vAlign=top width=220>
    <%@ include file="qtleft.jsp"%></TD></TR></TBODY></TABLE>
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
<TABLE style="BORDER-RIGHT: #cccccc 1px solid; BORDER-LEFT: #cccccc 1px solid;" 
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