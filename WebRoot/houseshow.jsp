<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
.STYLE7 {	color: #185838;
	font-weight: bold;
}
-->
</style>
</head>
  <%
  String id=request.getParameter("id");
   %>
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
                background=qtimages/zjgdj_79.gif></TD>
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
                      <TD style="PADDING-TOP: 8px" align=middle class=newsline><p align="center">
					  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF" style="border-collapse:collapse">  
   	 <tr>
     <td width='11%'>编号：</td>
     <td width='39%'>${bean.bianhao }</td>
      <td width='11%'>点击数：</td>
     <td width='39%'>${bean.dianji }</td>
    
     </tr>
     
     
      <tr>
     <td width='11%'>房源类型：</td><td width='39%'>${bean.leixing }</td>
     <td width='11%'>面积：</td><td width='39%'>${bean.mianji }</td>
     </tr>
     
     <tr>
     <td width='11%'>房源区域：</td><td width='39%'>${bean.quyu }</td>
     <td width='11%'>房源名称：</td><td width='39%'>${bean.mingchen }</td>
     </tr>
     
     <tr>
     <td width='11%'>装修程度：</td><td width='39%'>${bean.zhuangxiu }</td>
     <td width='11%'>月租金：</td><td width='39%'>${bean.money }</td>
     </tr>
     
     
     
     <tr>
     <td width='11%' height="137">房源图片：</td>
     <td colspan="3">
     <c:if test="${bean.path!=null }">
      <img src="uploadfile/${bean.path }" width="100" height="100" border="0" />
      </c:if>
       <c:if test="${bean.path2!=null }">
     <img src="uploadfile/${bean.path2 }" width="100" height="100" border="0" />
     </c:if>
     
      <c:if test="${bean.path3!=null }">
     <img src="uploadfile/${bean.path3 }" width="100" height="100" border="0" />
     </c:if>
     
     
     </td>
     
     </tr>
     
     <tr>
     <td width='11%' height="137">租赁说明：</td><td colspan="3">${bean.shouming }</td>
     
     </tr>
    
     
     <tr>
     <td colspan=4 align=center>
     <input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />
     &nbsp;&nbsp;
     <input type=button name=Submit52 value=发帖 onClick="window.location.href='indexmethod!tieziadd?houseid=${bean.id }';" />
     &nbsp;&nbsp;
      <input type=button name=Submit52 value=帖子列表 onClick="window.location.href='indexmethod!tiezilist3?houseid=${bean.id }';" />
     &nbsp;&nbsp;
     <input type=button name=Submit52 value=预约租房 onClick="location.href='indexmethod!zufangadd?houseid=${bean.id }';" />
         
         </td>
         </tr>
  </table>
					  </p>
                        </TD>
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
