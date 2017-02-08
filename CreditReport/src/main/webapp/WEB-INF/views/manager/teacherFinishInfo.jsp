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
  	<title>完善教师信息页面</title>
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
            <li><a href="toFinishInfo"><i class="fa fa-circle-o"></i> 完善个人信息</a></li>
            <li><a href="toSetPassword"><i class="fa fa-circle-o"></i> 重置密码</a></li>
          </ul>
        </li>
        <li class="treeview">
        <a href="#">
            <i class="fa fa-dashboard"></i> <span>添加诚信记录</span> <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="toStudentInfo"><i class="fa fa-circle-o"></i> 添加学生诚信记录</a></li>
         	<li><a href="toSearchTeacher"><i class="fa fa-circle-o"></i> 添加教师信息记录</a></li>
          	<li><a href="toShowManagerInfo"><i class="fa fa-circle-o"></i> 添加管理员诚信记录</a></li>
          </ul>
        </li>
        
        <li class="treeview">
          <a href="#">
            <i class="fa fa-dashboard"></i> <span>用户帐户管理</span> <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="toAccountList"><i class="fa fa-circle-o"></i> 帐户列表</a></li>
          	<li><a href="toAddAccount"><i class="fa fa-circle-o"></i> 添加帐户</a></li>
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
        添加教师信息记录
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
        <li><a href="#">添加诚信记录</a></li>
        <li class="active">添加教师信息</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-md-12">
         	<div class="box box-warning">
            	<div class="box-header with-border">
             	 	<h3 class="box-title">完善教师个人信息</h3>
            	</div>
            	<!-- /.box-header -->
            	<div class="box-body">
            	<form action="addTeacher" method="post" enctype="multipart/form-data" onsubmit="return check();">
            	<table class="table table-bordered">
                <tr>
                  <td>姓名</td>
                  <td>
                 	 <div class="form-group">
                 	 	<input type="text" class="form-control" name="teacherName" value="${teacher.teacherName }">
                 	 </div>
                  </td>
                  <td>性别 </td>
                  <td>
                  	<div class="form-group">
                  		<select class="form-control" name="sex">
                  			<c:if test="${teacher.sex == 'f' }">
                  				<option value="m">男</option>
                  				<option value="f" selected>女</option>
                  			</c:if>
                  			<c:if test="${teacher.sex == 'm' }">
                  				<option value="m" selected>男</option>
                  				<option value="f">女</option>
                  			</c:if>
                  			<c:if test="${empty teacher.sex }">
                  				<option value="m" selected>男</option>
                  				<option value="f">女</option>
                  			</c:if>
                  		</select>
                  	</div>
                  </td>
                  <td>民族 </td>
                  <td colspan='2'>
                  	<div class="form-group">
                  		<input class="form-control" type="text" name="peoples" value="${teacher.peoples }">
                  	</div>
                  </td>
                  <td>出生年月</td>
                  <td colspan='2'>
                  	<div class="form-group">
                  		<input class="Wdate " id="closeTime" name="birthday" type="text" onfocus="WdatePicker()" value="${teacher.birthday }">
                  	</div>
                  </td>
                  <td colspan='2' rowspan="2" style="width:120px;height:200px">
                  	<img alt=""  id="image" width="100%" height="100%" src="${teacher.uploadImageUrl }">
                  </td>
                </tr>
                <tr>
                  <td>所在学校</td>
                  <td>
                  	<div class="form-group">
                  		<input class="form-control" type="text" name="schoolName" value="${teacher.schoolName }">
                  	</div>
                  </td>
                  <td colspan='2'>政治面貌</td>
                  <td colspan='2'>
                  	<div class="form-group">
                  		<input class="form-control" type="text" name="politicalLandscape" value="${teacher.politicalLandscape }">
                  	</div>
                  </td>
                  <td>籍贯</td>
                  <td colspan='3'>
                  	<div class="form-group">
                  		<input class="form-control" type="text" name="hometown" value="${teacher.hometown }">
                  	</div>
                  </td>
                </tr>
          		<tr>
                  <td colspan='2'>身份证号码</td>
                  <td colspan='4'>
                  	<div class="form-group">
                  		<input class="form-control" type="text" name="idCard" value="${teacher.idCard }">
                  	</div>
                  </td>
                  <td colspan='2'>个人电话</td>
                  <td colspan='4'>
                  	<div class="form-group">
                  		<input class="form-control" type="text" name="personPhone" value="${teacher.personPhone }">
                  	</div>
                  </td>
                </tr>
                <tr>
                  <td colspan='2'>家庭详细地址</td>
                  <td colspan='6'>
                  	<div class="form-group">
                  		<input class="form-control" type="text" name="address" value="${teacher.address }">
                  	</div>
                  </td>
                  <td colspan='2'>建档时间</td>
                  <td colspan='2'>
                  	<div class="form-group">
                  		<input class="Wdate " id="createFileTime" name="createFileTime" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="${teacher.createFileTime }">
                  	</div>
                  </td>
                </tr>
                <tr>
                  <td colspan='2'>教师编号</td>
                  <td colspan='4'>
                  	<div class="form-group">
                  		<input class="form-control" type="text" name="teacherNumber" value="${teacher.teacherNumber }">
                  	</div>
                  </td>
                  <td colspan='2'>教师账号</td>
                  <td colspan='4'>
                  	<div class="form-group">
                  		<input class="form-control" type="text" name="userName" value="${teacherUserName }">
                  	</div>
                  </td>
                </tr>
                

                
              	</table>
              	
              	
              	
	  						<div class="col-sm-3">
			  					<div class="form-group">
		                  			<label>上传照片：</label>
		                  			<input type="file" name="uploadImage" id="uploadImage"  onchange="return setImagePreview()" value="${teacher.uploadImageUrl }"/>
		                		</div>
	  						</div>
	  						<div class="col-sm-6">
	  							<div class="form-group">
	  								<label>教师账号用户名：</label>
	  								<font color="red">(必填)</font><input class="form-control" type="text" name="teacherUserName" id="teacherUserName" value="${teacherUserName }">
	  							</div>
	  						</div>
	  							  						
	  						<div class="col-sm-3">
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
	 function check()
	 {
		 var userName = $("#teacherUserName").val();
		 if(userName == null || userName == ''|| userName == undefine)
		 {
			alert("请填写教师用户名");	 
			return false;
		 }
		 return true;
	 }
</script>
</body>
</html>