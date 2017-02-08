<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<title>完善学生信息页面</title>
  	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  	<!-- Bootstrap 3.3.6 -->
  	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  	<!-- Font Awesome -->
  	<link rel="stylesheet" href="css/font-awesome.min.css">
  	<!-- Ionicons -->
  	<link rel="stylesheet" href="css/ionicons.min.css">
  	<!-- Theme style -->
  	<link rel="stylesheet" href="dist/css/AdminLTE.min.css">
  	<!-- iCheck -->
  	 <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
  	 <style type="text/css">
  	 	.table tr
  	 	{
  	 		height:60px !important;
  	 		text-align:center;
  	 	}
  	 	.table tr td{vertical-align:middle}
  	 </style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
			<header class="main-header">
    <!-- Logo -->
    <a href="javascript:void(0)" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>PBC</b></span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>诚信档案管理系统</b></span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </a>

      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <li class="user user-menu">
            <a href="logout">退出</a>
          </li>
        </ul>
      </div>
    </nav>
  </header>
  
	<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <div class="user-panel">
        <div class="pull-left image">
          <img src="dist/img/black.png" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>${userName }</p>
          <a href="javascript:void(0)"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
      </div>
    
      <!-- /.search form -->
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu">
        <li class="header"></li>
        
        <li class="treeview">
          <a href="#">
            <i class="fa fa-dashboard"></i> <span>个人信息</span> <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="toStudentPersonInfo"><i class="fa fa-circle-o"></i> 完善个人信息</a></li>
            <li><a href="toSetPassword"><i class="fa fa-circle-o"></i> 重置密码</a></li>
          </ul>
        </li>
     
       
        <li><a href="watchCreditReport"><i class="fa fa-book"></i> <span>查询征信报告</span></a></li>
       
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>
  
	

	 <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        完善个人信息
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
        <li><a href="#">个人信息</a></li>
        <li class="active">完善个人信息</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-md-12">
         	<div class="box box-warning">
            	<div class="box-header with-border">
             	 	<h3 class="box-title">完善学生个人信息</h3>
            	</div>
            	<!-- /.box-header -->
            	<div class="box-body">
            	<form action="addOrUpdateStudent" method="post" enctype="multipart/form-data">
            	<table class="table table-bordered">
                <tr>
                  <td>姓名</td>
                  <td>
                 	 <div class="form-group">
                 	 	<input type="text" class="form-control" name="studentName" value="${student.studentName }">
                 	 </div>
                  </td>
                  <td>性别 </td>
                  <td>
                  	<div class="form-group">
                  		<select class="form-control" name="sex">
                  			<c:if test="${student.sex == 'f' }">
                  				<option value="m">男</option>
                  				<option value="f" selected>女</option>
                  			</c:if>
                  			<c:if test="${student.sex == 'm' }">
                  				<option value="m" selected>男</option>
                  				<option value="f">女</option>
                  			</c:if>
                  			<c:if test="${empty student.sex }">
                  				<option value="m" selected>男</option>
                  				<option value="f">女</option>
                  			</c:if>
                  		</select>
                  	</div>
                  </td>
                  <td>民族 </td>
                  <td colspan='2'>
                  	<div class="form-group">
                  		<input class="form-control" type="text" name="peoples" value="${student.peoples }">
                  	</div>
                  </td>
                  <td>出生年月</td>
                  <td colspan='2'>
                  	<div class="form-group">
                  		<input class="Wdate " id="closeTime" name="birthday" type="text" onfocus="WdatePicker()" value="${student.birthday }">
                  	</div>
                  </td>
                  <td colspan='2' rowspan="2" style="width:120px;height:200px">
                  	<img alt=""  id="image" width="100%" height="100%" src="${student.uploadImageUrl }">
                  </td>
                </tr>
                <tr>
                  <td>曾用名</td>
                  <td>
                  	<div class="form-group">
                  		<input class="form-control" type="text" name="otherName" value="${student.otherName }">
                  	</div>
                  </td>
                  <td colspan='2'>政治面貌</td>
                  <td colspan='2'>
                  	<div class="form-group">
                  		<input class="form-control" type="text" name="politicalLandscape" value="${student.politicalLandscape }">
                  	</div>
                  </td>
                  <td>籍贯</td>
                  <td colspan='3'>
                  	<div class="form-group">
                  		<input class="form-control" type="text" name="hometown" value="${student.hometown }">
                  	</div>
                  </td>
                </tr>
                <tr>
                  <td colspan='2'>所在学校</td>
                  <td colspan='4'>
                  	<div class="form-group">
                  		<input class="form-control" type="text" name="schoolName" value="${student.schoolName }">
                  	</div>
                  </td>
                  <td colspan='2'>专业</td>
                  <td colspan='4'>
                  	<div class="form-group">
                  		<input class="form-control" type="text" name="major" value="${student.major }">
                  	</div>
                  </td>
                </tr>
                <tr>
                  <td colspan='2'>年级、班级</td>
                  <td colspan='4'>
                  	<div class="form-group">
                  		<input class="form-control" type="text" name="classRoom" value="${student.classRoom }">
                  	</div>
                  </td>
                  <td colspan='2'>学号</td>
                  <td colspan='4'>
                  	<div class="form-group">
                  		<input class="form-control" type="text" name="studentNumber" value="${student.studentNumber }">
                  	</div>
                  </td>
                </tr>
                <tr>
                  <td colspan='2'>身份证号码</td>
                  <td colspan='4'>
                  	<div class="form-group">
                  		<input class="form-control" type="text" name="idCard" value="${student.idCard }">
                  	</div>
                  </td>
                  <td colspan='2'>个人电话</td>
                  <td colspan='4'>
                  	<div class="form-group">
                  		<input class="form-control" type="text" name="personPhone" value="${student.personPhone }">
                  	</div>
                  </td>
                </tr>
                <tr>
                  <td colspan='2'>家庭详细地址</td>
                  <td colspan='6'>
                  	<div class="form-group">
                  		<input class="form-control" type="text" name="address" value="${student.address }">
                  	</div>
                  </td>
                  <td colspan='2'>家庭联系人</td>
                  <td colspan='2'>
                  	<div class="form-group">
                  		<input class="form-control" type="text" name="familyPerson" value="${ student.familyPerson}">
                  	</div>
                  </td>
                </tr>
                <tr>
                  <td colspan='2'>家庭联系电话</td>
                  <td colspan='4'>
                  	<div class="form-group">
                  		<input class="form-control" type="text" name="familyPhone" value="${student.familyPhone }">
                  	</div>
                  </td>
                  <td colspan='2'>邮编</td>
                  <td colspan='4'>
                  	<div class="form-group">
                  		<input class="form-control" type="text" name="postcode" value="${student.postcode }">
                  	</div>
                  </td>
                </tr>
                <tr>
                  <td colspan='2'>学校认定的贫困等级</td>
                  <td colspan='4'>
                  <c:choose>
                  	<c:when test="${fn:contains(student.povertyClass,'特困') }">
                  		<input type="checkbox" name="povertyClass" value="特困" id="tekun" checked>特困
   					</c:when>  
   					<c:otherwise>
   						<input type="checkbox" name="povertyClass" value="特困" id="tekun">特困
   					</c:otherwise>  
   				  </c:choose>
   				  
   				   <c:choose>
                  	<c:when test="${fn:contains(student.povertyClass,'困难') }">
                  		<input type="checkbox" name="povertyClass" value="困难" id="kunnan" checked>困难
   					</c:when>  
   					<c:otherwise>
   						<input type="checkbox" name="povertyClass" value="困难" id="kunnan">困难
   					</c:otherwise>  
   				  </c:choose>
                 
                 <c:choose>
                  	<c:when test="${fn:contains(student.povertyClass,'一般困难') }">
                  		<input type="checkbox" name="povertyClass" value="一般困难" id="yibankunnan" checked>一般困难
   					</c:when>  
   					<c:otherwise>
   						<input type="checkbox" name="povertyClass" value="一般困难" id="yibankunnan">一般困难
   					</c:otherwise>  
   				  </c:choose>
                  	
                  	
                  </td>
                  <td colspan='2'>建档时间</td>
                  <td colspan='4'>
                  	<div class="form-group">
                  		<input class="Wdate " id="createFileTime" name="createFileTime" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="${student.createFileTime }">
                  	
                  	</div>
                  </td>
                </tr>
                
              	</table>
				<div class="col-sm-6">
					<div class="form-group">
						<label>上传照片：</label>
						<input type="file" name="uploadImage" id="uploadImage"  onchange="return setImagePreview()" value="${student.uploadImageUrl }"/>
		            </div>
	  			</div>
	  		
	  							  						
	  			<div class="col-sm-6">
	  				<div class="form-group">
	  					<label>&nbsp;</label><br/>
		                <input type="submit" class="btn btn-primary" />
		             </div>
	  			</div>
              	</form>
              	
                </div>
              </div>
        </div>
      </div>
      <!-- /.row -->
    </section>
    </div>
<%--     <footer class="main-footer">
    <div class="pull-right hidden-xs">
      <b>Version</b> 2.3.3
    </div>
    <strong>Copyright &copy; 2014-2015 <a href="http://almsaeedstudio.com">Almsaeed Studio</a>.</strong> All rights
    reserved.
  </footer> --%>
   <div class="control-sidebar-bg"></div>
    <!-- /.content -->
  </div>
  
  	
  
  
  
  
  
<!-- jQuery 2.2.0 -->
<script src="plugins/jQuery/jQuery-2.2.0.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="bootstrap/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="dist/js/demo.js"></script>
<script type="text/javascript" src="js/DatePicker/WdatePicker.js"></script>
<script type="text/javascript">


function setImagePreview() {
    //input
        var docObj = document.getElementById("uploadImage");
//img
        var imgObjPreview = document.getElementById("image");
        //div
      //  var divs = document.getElementById("localImag");
        if (docObj.files && docObj.files[0]) {
        	//alert("asd");
            //火狐下，直接设img属性
            imgObjPreview.style.display = 'block';
            imgObjPreview.style.width = '170px';
            imgObjPreview.style.height = '170px';
            //imgObjPreview.src = docObj.files[0].getAsDataURL();
            //火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
           imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
        } else {
        	
            //IE下，使用滤镜
            docObj.select();
            docObj.blur();
            var imgSrc = document.selection.createRange().text;
            var localImagId = document.getElementById("image");
            try {
     			localImagId.src = "";
     			localImagId.onerror = "";
     			localImagId.style.cssText="border-radius:100px;overflow:hidden;";
     			localImagId.style.width = "170px";
               	localImagId.style.height = "170px";
                localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
                localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
            } catch(e) {
                alert("您上传的图片格式不正确，请重新选择!");
                return false;
            }
            document.selection.empty();
        }
        return true;
    }
	
</script>
</body>
</html>