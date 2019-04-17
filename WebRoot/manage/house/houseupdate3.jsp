<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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


<script language="javascript" type="text/javascript">

function checkform()
{
	 
	

	
	return true;
	
}


</script>

</head>
<body>

<div id="body-wrapper">
  <!-- Wrapper for the radial gradient background -->
  
  
  <%@ include file="../left.jsp" %>
  
  
  <div id="main-content">
    
    <div class="clear"></div>
    <!-- End .clear -->
    <div class="content-box">
      <!-- Start Content Box -->
      <div class="content-box-header">
        <h3>${title }</h3>
        <ul class="content-box-tabs">
          
        </ul>
        <div class="clear"></div>
      </div>
      <!-- End .content-box-header -->
      <div class="content-box-content">
        
        
        
      
        <div class="tab-content default-tab" id="tab1">
           <form action="${url }"   method="post" onsubmit="return checkform()"  >
            <fieldset>
            
           
            
            
           <p>
              <label>房源类型</label>
              <input class="large-input" type="text"  name="xtitle" id="xtitleid" value="${bean.leixing }"  readonly="readonly" />
              
            </p>
            <p>
              <label>房源区域</label>
              <input class="large-input" type="text"  name="xtitle" id="xtitleid" value="${bean.quyu }"  readonly="readonly" />
              
            </p>
            <p>
              <label>房源名称</label>
              <input class="large-input" type="text"  name="xtitle" id="xtitleid" value="${bean.mingchen }"  readonly="readonly" />
              
            </p>
            <p>
              <label>装修程度</label>
              <input class="large-input" type="text"  name="xtitle" id="xtitleid" value="${bean.zhuangxiu }"  readonly="readonly" />
              
            </p>
            <p>
              <label>月租金</label>
              <input class="large-input" type="text"  name="xtitle" id="xtitleid" value="${bean.money }"  readonly="readonly" />
              
            </p>
            
            <p>
              <label>面积</label>
              <input class="large-input" type="text"  name="xtitle" id="xtitleid" value="${bean.mianji }"  readonly="readonly" />
              
            </p>
            <p>
              <label>房源图片</label>
              <c:if test="${bean.path!=null}">
              <img src="<%=basePath %>uploadfile/${bean.path }" width="150" height="150" />
              </c:if>
              <c:if test="${bean.path2!=null}">
              <img src="<%=basePath %>uploadfile/${bean.path2 }" width="150" height="150" />
              </c:if>
              <c:if test="${bean.path3!=null}">
              <img src="<%=basePath %>uploadfile/${bean.path3 }" width="150" height="150" />
              </c:if>
              
            </p>
           
            
            
           
            <p>
              <label>租赁说明</label>
             <textarea rows="7" cols="50" name="shouming" readonly="readonly" >${bean.shouming }</textarea>
            </p>
            
            
           
            
            
            
            
            
            <p>
           
             <input class="button" type="button" value="返回"  onclick="javascript:history.go(-1);" />
            </p>
            </fieldset>
            <div class="clear"></div>
            <!-- End .clear -->
          </form>
        </div>
        <!-- End #tab2 -->
      </div>
      <!-- End .content-box-content -->
    </div>
    
  
  </div>
  <!-- End #main-content -->
</div>


</body>

</html>
