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
  	<title>管理员列表</title>
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
        管理员信息
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
        <li><a href="#">用户信息查询</a></li>
        <li class="active">管理员查询</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
      	<div class="col-md-12">
	      	<div class="box box-info">
	            <div class="box-header with-border">
	              <h3 class="box-title">查找管理员</h3>
	            </div>
	         
	            <form class="form-horizontal" method="post" action="toShowManagerInfo">
	              <div class="box-body">
	                <div class="form-group">
	                  
	                  <div class="col-sm-3">
	                    <input type="text" class="form-control" id="userName" name="userName" placeholder="用户名">
	                  </div>
	                  
	                  <div class="col-sm-3">
	                    <input type="text" class="form-control" id="realName" name="realName" placeholder="真实姓名">
	                  </div>
	                  
	                   <div class="col-sm-3">
	                    <input type="text" class="form-control" id="workUnit" name="workUnit" placeholder="工作地点">
	                  </div>
	                  <div class="col-sm-3">
	                    <input type="submit" class="btn btn-primary" value="搜索">
	                  </div>
	                  
	                </div>
	                
	               </div>
				</form>
	        </div>
	       </div>
      	<div class="col-md-12">
          <div class="box">
            <div class="box-header with-border">
              <h3 class="box-title">管理员信息</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table class="table table-bordered">
                <tr>
                  <th style="width: 10px">#</th>
                  <th style="width: 200px">姓名</th>
                  <th style="width: 100px">性别</th>
                  <th>工作地点</th>
                  <th style="width: 100px">操作</th>
                </tr>
                <c:forEach var="item" items="${managerList}" varStatus="status">
                <tr>
                 <td>${item.id}</td>
                  <td>${item.realName}</td>
                  <td>
                  <c:if test="${ item.sex == 'm'}">男</c:if>
                  <c:if test="${ item.sex == 'f'}">女</c:if>
                   	 	
                  </td>
                  <td>${ item.unitWork}</td>
                  <td>
                  	<table>
                  	<tr>
                  		<td>
                  		<form id="delForm${item.id }">
                  			<input type="hidden" name="managerId" id="managerId" value="${item.id }">
	                  		<input type="text" class="btn btn-danger" size="10" onClick="del(${item.id})" value="删除"/>
	                  	</form>
	                  	</td>
	                  	<td>
	                  	<form id="modifyForm${item.id }">
	                  		<input type="hidden" name="managerId" id="managerId" value="${item.id }">
	                  		<input type="text" class="btn btn-primary" size="10" onClick="modify(${item.id})" value="修改"/>
	                  	</form>
	                  	</td>
                  	</tr>
                  	</table>
                  </td>
                </tr>
                </c:forEach>
              </table>
            </div>
            <!-- /.box-body -->
            <div class="box-footer clearfix">
              <ul class="pagination pagination-sm no-margin pull-right">
              	<c:if test="${pageIndex > 1}">
                	<li><a href="toShowManagerInfo?userName=${userName }&realName=${realName}&workUnit=${workUnit}&pageIndex=${pageIndex-1}">&laquo;</a></li>
                </c:if>
                <li><a href="javascript:void(0)">${pageIndex }/${pageCount }</a></li>
               <c:if test="${pageIndex < pageCount }">
                <li><a href="toShowManagerInfo?userName=${userName }&realName=${realName}&workUnit=${workUnit}&pageIndex=${pageIndex+1}">&raquo;</a></li>
             	</c:if>
              </ul>
            </div>
          </div>
         
       	</div>
      </div>
      <!-- /.row -->
    </section>
    </div>
    <%-- <footer class="main-footer">
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
<script>
	function del(id)
	{
		var formId = 'delForm'+id;	
		if (confirm("确认要删除？")) {
			document.getElementById(formId).action='/delManagerById';
			document.getElementById(formId).submit();
        }
	}
	function modify(id)
	{
		var formId = 'modifyForm'+id;	
		document.getElementById(formId).action='/modifyManagerById';
		document.getElementById(formId).submit();
	}
</script>
</body>
</html>