<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>


<META content="MSHTML 6.00.2800.1106" name=GENERATOR>

</HEAD>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
      <TBODY>
        <TR>
          <TD width=4><IMG height=32 src="qtimages/zjgdj_sy_19.gif" 
            width=4></TD>
          <TD background=qtimages/zjgdj_sy_18.gif><TABLE cellSpacing=0 cellPadding=0 width=108 align=left>
              <TBODY>
                <TR>
                  <TD align=middle width=26><IMG 
                  src="qtimages/zjgdj_sy_23.gif"></TD>
                  <TD 
                style="PADDING-RIGHT: 0px; PADDING-LEFT: 5px; FONT-WEIGHT: bold; FONT-SIZE: 10.5pt; PADDING-BOTTOM: 0px; COLOR: #494949; PADDING-TOP: 0px" 
                align=left width=70>最新房源</TD>
                </TR>
              </TBODY>
          </TABLE></TD>
          <TD style="PADDING-RIGHT: 5px" align=right 
          background=qtimages/zjgdj_sy_18.gif></TD>
          <TD align=right width=4><IMG height=32 
            src="qtimages/zjgdj_sy_20.gif" width=4></TD>
        </TR>
      </TBODY>
</TABLE>
      <TABLE 
      style="BORDER-RIGHT: #dadada 1px solid; BORDER-LEFT: #dadada 1px solid" 
      height=1 cellSpacing=0 cellPadding=0 width="100%" align=center>
        <TBODY>
          <TR>
            <TD align=middle><IMG 
        src="qtimages/zjgdj_sy_21.gif"></TD>
          </TR>
        </TBODY>
      </TABLE>
      
      <%
org.springframework.web.context.WebApplicationContext app = org.springframework.web.context.support.WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());

com.dao.HouseDao houseDao = (com.dao.HouseDao) app.getBean("houseDao");

List<com.model.House> houselist = houseDao.selectBeanList(0,5," where deletestatus=0 and status='租赁中' order by id desc  ");

%>
      
      <TABLE 
      style="BORDER-RIGHT: #cccccc 1px solid; BORDER-LEFT: #cccccc 1px solid;" 
      height=350 cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TBODY>
          <TR>
            <TD height="350" >
            <marquee border="0" direction="up" height="90%" onMouseOut="start()" onMouseOver="stop()"
                scrollamount="1" scrolldelay="50">
            <br/>
        <%
        for(com.model.House bean:houselist){
        %>
         <a href="indexmethod!houseshow?id=<%=bean.getId() %>"><%=bean.getMingchen() %></a>
         <br/><br/>
        <% 	
        }
        %>
        
        </marquee>

          </TD>
          </TR>
        </TBODY>
      </TABLE>
      <TABLE height=4 cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TBODY>
          <TR>
            <TD width=5><IMG height=3 src="qtimages/zjgdj_64.gif" 
width=5></TD>
            <TD background=qtimages/zjgdj_65.gif><IMG height=3 
            src="qtimages/zjgdj_65.gif" width=1></TD>
            <TD width=4><IMG height=3 src="qtimages/zjgdj_67.gif" 
        width=4></TD>
          </TR>
        </TBODY>
      </TABLE>
	  <TABLE height=8 cellSpacing=0 cellPadding=0 width="100%" align=center 
      border=0>
        <TBODY>
          <TR>
            <TD></TD>
          </TR>
        </TBODY>
      </TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TBODY>
          <TR>
            <TD width=4><IMG height=32 src="qtimages/zjgdj_sy_19.gif" 
            width=4></TD>
            <TD background=qtimages/zjgdj_sy_18.gif><TABLE cellSpacing=0 cellPadding=0 width=108 align=left>
                <TBODY>
                  <TR>
                    <TD align=middle width=26><IMG 
                  src="qtimages/zjgdj_147.gif"></TD>
                    <TD 
                style="PADDING-RIGHT: 0px; PADDING-LEFT: 5px; FONT-WEIGHT: bold; FONT-SIZE: 10.5pt; PADDING-BOTTOM: 0px; COLOR: #494949; PADDING-TOP: 0px" 
                align=left width=70>用户登录</TD>
                  </TR>
                </TBODY>
            </TABLE></TD>
            <TD style="PADDING-RIGHT: 5px" align=right 
          background=qtimages/zjgdj_sy_18.gif></TD>
            <TD align=right width=4><IMG height=32 
            src="qtimages/zjgdj_sy_20.gif" width=4></TD>
          </TR>
        </TBODY>
      </TABLE>
      <TABLE 
      style="BORDER-RIGHT: #dadada 1px solid; BORDER-LEFT: #dadada 1px solid" 
      height=1 cellSpacing=0 cellPadding=0 width="100%" align=center>
        <TBODY>
          <TR>
            <TD align=middle><IMG 
        src="qtimages/zjgdj_sy_21.gif"></TD>
          </TR>
        </TBODY>
      </TABLE>
      <TABLE 
      style="BORDER-RIGHT: #cccccc 1px solid; BORDER-LEFT: #cccccc 1px solid;height: 350px" 
      cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TBODY>
          <TR>
            <TD style="PADDING-TOP: 8px" vAlign=top align=middle>
            
            <!-- 用户登录前页面 -->
            <c:if test="${qiantai==null}">
              <table width="88%" height="50%" border="0" align="center" cellpadding="0" cellspacing="0">
                <form name="formlog" method="post" action="indexmethod!login">
                  <tr>
                    <td width="37%" height="30">用户名：</td>
                    <td width="63%" height="30">
                    <input name="username" type="text" id="username" Style="border-right: #cadcb2 1px solid;outline:none;padding-left:10px;
                        border-top: #cadcb2 1px solid; font-size: 12px; border-left: #cadcb2 1px solid;border-radius:10px;
                        width: 100px; color: #81b432; border-bottom: #cadcb2 1px solid; height: 25px" size="12"></td>
                  </tr>
                  <tr>
                    <td height="30">密码：</td>
                    <td height="30">
                    <input name="password" type="password" id="pwd1" Style="border-right: #cadcb2 1px solid;outline:none;padding-left:10px;
                        border-top: #cadcb2 1px solid; font-size: 12px; border-left: #cadcb2 1px solid;border-radius: 10px;
                        width: 100px; color: #81b432; border-bottom: #cadcb2 1px solid; height: 25px"></td>
                  </tr>
                  
                  <tr>
                    <td height="30"></td>
                    <td height="30"><input type="submit" name="Submit" value="登录" style=" height:35px;width: 50px; border:solid 1px #000000; color:#fff;margin-left: -50px; margin-right: 45px; background: #004087;border-radius: 5px;cursor: pointer">
                        <input type="reset" name="Submit2" value="重置" style=" height:35px;width: 50px; border:solid 1px #000000; color:#fff;background: #004087;border-radius: 5px;cursor: pointer"></td>
                  </tr>
                </form>
              </table>
              </c:if>
               <!-- 用户登录后页面 -->
               
              <c:if test="${qiantai!=null}">
              <table width="90%" height="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="31%" height="30">用户名</td>
                  <td width="69%" height="30">${qiantai.username }</td>
                </tr>
                <tr>
                  <td height="30">姓名</td>
                  <td height="30">${qiantai.xingming }</td>
                </tr>
                <tr>
                  <td height="30">用户角色</td>
                  <td height="30">
                  <c:if test="${qiantai.role==2 }">房东</c:if>
                  <c:if test="${qiantai.role==3 }">租赁者</c:if>
                  </td>
                </tr>
                <tr>
                  <td height="30" colspan="2" align="center">
                  <input type="button" name="Submit32" value="个人信息" onClick="javascript:location.href='indexmethod!userupdate';" style="background: #004087; height:35px; border:solid 1px #000000; color:#fff;margin: 10px 5px;border-radius: 5px;cursor: pointer">
                  <input type="button" name="Submit32" value="个人密码" onClick="javascript:location.href='indexmethod!userupdate3';" style="background: #004087; height:35px; border:solid 1px #000000; color:#fff;margin: 10px 5px;border-radius: 5px;cursor: pointer">
                  <c:if test="${qiantai.role==2 }">                 
                  <input type="button" name="Submit32" value="发布房源" onClick="javascript:location.href='indexmethod!houseadd';" style="background: #004087; height:35px; border:solid 1px #000000; color:#fff;margin: 10px 5px;border-radius: 5px;cursor: pointer">
                  <input type="button" name="Submit32" value="房源管理" onClick="javascript:location.href='indexmethod!houselist';" style="background: #004087; height:35px; border:solid 1px #000000; color:#fff;margin: 10px 5px;border-radius: 5px;cursor: pointer">
                  
                  <input type="button" name="Submit32" value="租房管理" onClick="javascript:location.href='indexmethod!zufanglist2';" style="background: #004087; height:35px; border:solid 1px #000000; color:#fff;margin: 10px 5px;border-radius: 5px;cursor: pointer">
                 
                  <input type="button" name="Submit32" value="我的帖子" onClick="javascript:location.href='indexmethod!tiezilist';" style=" background: #004087;height:35px; border:solid 1px #000000; color:#fff;margin: 10px 5px;border-radius: 5px;cursor: pointer">
                  
                  </c:if>
                  
                   <c:if test="${qiantai.role==3 }">                 
                  <input type="button" name="Submit32" value="我的租房" onClick="javascript:location.href='indexmethod!zufanglist';" style="background: #004087; height:35px; border:solid 1px #000000; color:#fff;margin: 10px 5px;border-radius: 5px;cursor: pointer">
                 
                 <input type="button" name="Submit32" value="我的帖子" onClick="javascript:location.href='indexmethod!tiezilist';" style="background: #004087; height:35px; border:solid 1px #000000; color:#fff;margin: 10px 5px;border-radius: 5px;cursor: pointer">
                  
                  </c:if>
                  
                  <input type="button" name="Submit3" value="安全退出" onClick="javascript:location.href='indexmethod!loginout';" style="background: #004087; height:35px; border:solid 1px #000000; color:#fff;margin: 10px 5px;border-radius: 5px;cursor: pointer">
                  
                  </td>
                </tr>
              </table>
               </c:if>
              
       </TD>
          </TR>
        </TBODY>
      </TABLE>
      <TABLE height=4 cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TBODY>
          <TR>
            <TD width=5><IMG height=3 src="qtimages/zjgdj_64.gif" 
width=5></TD>
            <TD background=qtimages/zjgdj_65.gif><IMG height=3 
            src="qtimages/zjgdj_65.gif" width=1></TD>
            <TD width=4><IMG height=3 src="qtimages/zjgdj_67.gif" 
        width=4></TD>
          </TR>
        </TBODY>
      </TABLE>
      <TABLE height=8 cellSpacing=0 cellPadding=0 width="100%" align=center 
      border=0>
        <TBODY>
          <TR>
            <TD></TD>
          </TR>
        </TBODY>
      </TABLE>
      
      
      
      
	  
      
      
      
      
      <TABLE height=4 cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TBODY>
          <TR>
            <TD width=5><IMG height=3 src="qtimages/zjgdj_64.gif" 
width=5></TD>
            <TD background=qtimages/zjgdj_65.gif><IMG height=3 
            src="qtimages/zjgdj_65.gif" width=1></TD>
            <TD width=4><IMG height=3 src="qtimages/zjgdj_67.gif" 
        width=4></TD>
          </TR>
        </TBODY>
      </TABLE>