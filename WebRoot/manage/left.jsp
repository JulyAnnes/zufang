<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
  
%>

<div id="sidebar">
    <div id="sidebar-wrapper">
     <br/>
      
      <a href="#">
      <span style="font-size: 30px;font-weight: bold;">管理菜单</span>
      </a>
     
      
      <ul id="main-nav">
        
        
        <li> <a href="#" class="nav-top-item">系统管理 </a>
          <ul>
            <li><a href="password.jsp">修改密码</a></li>
             <li><a href="method!loginout.action">安全退出</a></li>
          </ul>
        </li>
        
        <li> <a href="#" class="nav-top-item">网站图片</a>
          <ul>
            <li><a href="method!piclist.action">网站图片管理</a></li>
          </ul>
        </li>
        
        
        
        
        
        <li> <a href="#" class="nav-top-item">新闻资讯</a>
          <ul>
            <li><a href="method!xinwenlist.action">新闻资讯管理</a></li>
        
          </ul>
        </li>
        
        
        <li> <a href="#" class="nav-top-item">注册用户</a>
          <ul>
            <li><a href="method!userlist.action">注册用户管理</a></li>
        
          </ul>
        </li>
        
        
        <li> <a href="#" class="nav-top-item">房源信息</a>
          <ul>
            <li><a href="method!houselist.action">待审核房源</a></li>
            
            <li><a href="method!houselist3.action">租赁中房源</a></li>
            
            <li><a href="method!houselist2.action">所有房源</a></li>
        
          </ul>
        </li>
        
        
        <li> <a href="#" class="nav-top-item">帖子回复</a>
          <ul>
            <li><a href="method!tiezilist.action">帖子管理</a></li>
            
            <li><a href="method!huifulist.action">回复管理</a></li>
            
        
          </ul>
        </li>
        
       
      </ul>
    </div>
  </div>



  
  
  
  <!-- End #sidebar -->