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
	 
	

	//验证文件的后缀名
	var b= document.getElementById("uploadfileid");
	
	
	
	if(b.value!=""){
	
	var FileName = b.value;
	
	var extension=new String (FileName.substring(FileName.lastIndexOf(".")+1,FileName.length));

	if(!(extension=="jpg" )){
		alert('必须上传jpg格式的图片');
		return false;
	
	}
	

	}
	
	
	
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
        <form action="${url }"   method="post"  enctype="multipart/form-data"  onsubmit="return checkform()" >

            <fieldset>
            <!-- Set class to "column-left" or "column-right" on fieldsets to divide the form into columns -->
            <p>
              <label>原图片</label>
             <img src="<%=basePath %>uploadfile/${bean.path }" width="600" height="150" />
              
            </p>
            
            <p>
              <label>上传新图片</label>
              <input  name="uploadfile"  type="file" id="uploadfileid" />
              
              </p>
            <p>
              <label>图片链接</label>
              <input class="text-input large-input" type="text" id="large-input" name="href" value="${bean.href }" />
            </p>
            
            <p>
              <label>图片说明</label>
              <input class="text-input large-input" type="text" id="large-input" name="info" value="${bean.info }" />
            </p>
           
            
            <p>
              <input class="button" type="submit" value="提交" />
              
              &nbsp;&nbsp;&nbsp;
              
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
