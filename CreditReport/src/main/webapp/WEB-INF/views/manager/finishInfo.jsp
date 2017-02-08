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
  	<title>完善信息页面</title>
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
          	<li><a href="toShowManagerInfo"><i class="fa fa-circle-o"></i> 添加管理员信息记录</a></li>
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
             	 	<h3 class="box-title">完善个人信息</h3>
            	</div>
            	<!-- /.box-header -->
            	<div class="box-body">
            		<div class="col-sm-3"></div>
            		<div class="col-sm-6">
              		<form role="form" action="finishInfo" method="post">
                		<!-- text input -->
                		<div class="form-group">
                  			<label>管理员编号：</label>
                  			<input type="text" class="form-control" name="managerId" value="${managerId }" placeholder="Enter ...">
                		</div>
                		<div class="form-group">
                  			<label>真实姓名：</label>
                  			<input type="text" class="form-control" name="realName" value="${realName }" placeholder="Enter ...">
                		</div>
                		  <div class="form-group">
                		  	<label>性别：</label>
			                   <div class="radio">
			                   	<label>
			                   		<c:if test="${sex == 'f' }">
			                      		<input type="radio" name="sex" id="optionsRadios1" value="m" >男
			                      	</c:if>
			                      	<c:if test="${sex == 'm' }">
			                      		<input type="radio" name="sex" id="optionsRadios1" value="m" checked>男
			                      	</c:if>
			                      	
			                    </label>
			                      	
			                  </div>
			                  <div class="radio">
			                  	<label>
			                  		<c:if test="${sex=='f' }">
			                    		<input type="radio" name="sex" id="optionsRadios2" value="f" checked>女
			                    	</c:if>
			                    	<c:if test="${sex == 'm' }">
			                      		<input type="radio" name="sex" id="optionsRadios1" value="f" >女
			                      	</c:if>
			                      	
			                    </label>
			                  </div> 
                 
                		</div>

                		<!-- textarea -->
                		<div class="form-group">
                  			<label>工作单位:</label>
                  			<textarea class="form-control" name="workunit" rows="3" placeholder="Enter ...">${workUnit }</textarea>
                		</div>
                		
                		<div class="col-sm-3">
                			<button type="reset" class="btn btn-default">清空</button>
                		</div>
		                <div class="col-sm-9">
		                	<button type="submit" class="btn btn-info pull-right">提交</button>
		                </div>
                	</form>
                	</div>
                	<div class="col-sm-3"></div>
                </div>
              </div>
        </div>
      </div>
      <!-- /.row -->
    </section>
    </div>
 <%--    <footer class="main-footer">
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
</body>
</html>