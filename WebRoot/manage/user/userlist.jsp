<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
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


</head>
<body>

<div id="body-wrapper">
  <!-- Wrapper for the radial gradient background -->
  
  
  <%@ include file="../left.jsp" %>
  
  
  <div id="main-content">
    <!-- Main Content Section with everything -->
    
    <!-- Page Head -->
    
    <!-- End .shortcut-buttons-set -->
    <div class="clear"></div>
    <!-- End .clear -->
    <div class="content-box">
      <!-- Start Content Box -->
      <div class="content-box-header">
        <h3>${title }</h3>
        
        <div class="clear"></div>
      </div>
      <!-- End .content-box-header -->
      <div class="content-box-content">
        <div class="tab-content default-tab" id="tab1">
          <!-- This is the target div. id must match the href of this div's tab -->
          
         
            <div>
           
           <form action="${url }" method="post">
            用户名：<input type="text" name="username"  value="${username }"/>
         
            <input type="submit" value="查询" />
            </form>
            
            
              </div>
          
          
          <table>
            <thead>
              <tr>
               
                <th>用户名</th>
                <th>密码</th>
                <th>用户角色</th>
                <th>姓名</th>
                <th>手机号码</th>
           
                <th>操作</th>
              </tr>
            </thead>
            
            <tbody>
            <c:forEach items="${list}" var="bean">
              <tr>
                
                <td>${bean.username }</td>
              
                <td>${bean.password }</td>
                <td>
                <c:if test="${bean.role==2}">房东</c:if>
                <c:if test="${bean.role==3}">租赁者</c:if>
                </td>
                <td>${bean.xingming }</td>
                <td>${bean.tel }</td>
                
                
                <td>
                
                 <a href="${url2 }delete.action?id=${bean.id }" onclick="return confirm('确定要删除吗?');">删除</a> &nbsp;
                 
                 </td>
              </tr>
              </c:forEach>
             
            </tbody>
            
            
            <tfoot>
              <tr>
                <td colspan="6">
               ${pagerinfo }
                </td>
              </tr>
            </tfoot>
            
          </table>
        </div>
        
        
      
      </div>
 
    </div>
    
    
  
    

   
  </div>
  
</div>


</body>

</html>
