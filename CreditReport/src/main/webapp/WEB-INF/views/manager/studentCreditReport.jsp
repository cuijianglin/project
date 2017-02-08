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
        添加学生诚信记录
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
        <li><a href="#">添加诚信记录</a></li>
        <li class="active">添加学生诚信记录</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-md-12">
         	<div class="box box-warning">
            	<div class="box-header with-border">
             	 	<h3 class="box-title">添加学生诚信记录</h3>
            	</div>
            	<!-- /.box-header -->
            	<div class="box-body">
            	<table class="table table-bordered">
                <tr>
                  <td>姓名</td>
                  <td>
                 	 <div class="form-group">
                 	 	${ student.studentName}
                 	 </div>
                  </td>
                  <td>性别 </td>
                  <td>
                  	<div class="form-group">
                  		<c:if test="${ student.sex=='f'}">
                  			女
                  		</c:if>
                  		<c:if test="${ student.sex=='m'}">
                  			男
                  		</c:if>
                  	</div>
                  </td>
                  <td>民族 </td>
                  <td colspan='2'>
                  	<div class="form-group">
                  		${ student.peoples}
                  	</div>
                  </td>
                  <td>出生年月</td>
                  <td colspan='2'>
                  	<div class="form-group">
                  		${ student.birthday}
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
                  		${student.otherName }
                  	</div>
                  </td>
                  <td colspan='2'>政治面貌</td>
                  <td colspan='2'>
                  	<div class="form-group">
                  		${student.politicalLandscape }
                  	</div>
                  </td>
                  <td>籍贯</td>
                  <td colspan='3'>
                  	<div class="form-group">
                  		${ student.hometown}
                  	</div>
                  </td>
                </tr>
                <tr>
                  <td colspan='2'>所在学校</td>
                  <td colspan='4'>
                  	<div class="form-group">
                  		${ student.schoolName}
                  	</div>
                  </td>
                  <td colspan='2'>专业</td>
                  <td colspan='4'>
                  	<div class="form-group">
                  		${ student.major}
                  	</div>
                  </td>
                </tr>
                <tr>
                  <td colspan='2'>年级、班级</td>
                  <td colspan='4'>
                  	<div class="form-group">
                  		${student.classRoom }
                  	</div>
                  </td>
                  <td colspan='2'>学号</td>
                  <td colspan='4'>
                  	<div class="form-group">
                  		${student.studentNumber }
                  	</div>
                  </td>
                </tr>
                <tr>
                  <td colspan='2'>身份证号码</td>
                  <td colspan='4'>
                  	<div class="form-group">
                  		${student.idCard }
                  	</div>
                  </td>
                  <td colspan='2'>个人电话</td>
                  <td colspan='4'>
                  	<div class="form-group">
                  		${student.personPhone }
                  	</div>
                  </td>
                </tr>
                <tr>
                  <td colspan='2'>家庭详细地址</td>
                  <td colspan='6'>
                  	<div class="form-group">
                  		${student.address }
                  	</div>
                  </td>
                  <td colspan='2'>家庭联系人</td>
                  <td colspan='2'>
                  	<div class="form-group">
                  		${student.familyPerson }
                  	</div>
                  </td>
                </tr>
                <tr>
                  <td colspan='2'>家庭联系电话</td>
                  <td colspan='4'>
                  	<div class="form-group">
                  		${student.familyPhone }
                  	</div>
                  </td>
                  <td colspan='2'>邮编</td>
                  <td colspan='4'>
                  	<div class="form-group">
                  		${student.postcode }
                  	</div>
                  </td>
                </tr>
                <tr>
                  <td colspan='2'>学校认定的贫困等级</td>
                  <td colspan='4'>
                  	${ student.povertyClass}
                  </td>
                  <td colspan='2'>建档时间</td>
                  <td colspan='4'>
                  	<div class="form-group">
                  		${ student.createFileTime}
                  	</div>
                  </td>
                </tr>
                
              	</table>
              	
              	<table class="table table-bordered">
              	<caption style="text-align:center"><b>诚信记录</b></caption>
                <tr>
                	<td colspan="1" rowspan="6" style="text-align:center;vertical-align:middle">
                		诚<br/>信<br/>优<br/>良<br/>记<br/>录<br/>
                	</td>
                	<td colspan="1" rowspan="2">第一学年</td>
                	<td colspan="6" rowspan="2">
	                	<div class="form-group">
	                		${creditReport.creditRecordFirstYear }
	                  	</div>
	                </td>
                	<td colspan="1" rowspan="1">记录人签名</td>
                	<td colspan="1" rowspan="1">日期</td>
                </tr>
                <tr>
					<td>
						<div class="form-group">
							${creditReport.creditRecordFirstRecordPerson }
	                  	</div>
					</td>
					
					<td>
						<div class="form-group">
							${creditReport.creditRecordFirstDate }
	                  	</div>
					</td>
  				</tr>
  				<tr>
  					<td colspan="1" rowspan="2">第二学年</td>
  					<td colspan="6" rowspan="2">
						<div class="form-group">
							${creditReport.creditRecordSecondYear }
	                  	</div>
					</td>
  					<td colspan="1" rowspan="1">记录人签名</td>
  					<td colspan="1" rowspan="1">日期</td>
  				</tr>
  				<tr>
  					<td>
						<div class="form-group">
							${creditReport.creditRecordSecondRecordPerson }
	                  	</div>
					</td>
					
					<td>
						<div class="form-group">
	                  		${creditReport.creditRecordSecondDate }
	                  	</div>
					</td>
  				</tr>
  				<tr>
  					<td colspan="1" rowspan="2">第三学年</td>
  					<td colspan="6" rowspan="2">
  						<div class="form-group">
  							${creditReport.creditRecordThirdYear }
	                  	</div>
  					</td>
  					<td colspan="1" rowspan="1">记录人签名</td>
  					<td colspan="1" rowspan="1">日期</td>
  				</tr>
  				<tr>
  					<td>
						<div class="form-group">
							${creditReport.creditRecordThridRecordPerson }
	                  	</div>
					</td>
					
					<td>
						<div class="form-group">
							${creditReport.creditRecordThirdDate }
	                  	</div>
					</td>
  				</tr>
              	
                <tr>
                	<td colspan="1" rowspan="7" style="text-align:center;vertical-align:middle">
                		学<br/>风<br/>考<br/>风<br/>情<br/>况<br/>
                	</td>
                	<td colspan="9" style="text-align:center">包括虚假、涂改成绩，考试作弊，剽窃论文，抄袭论文，伪造数据等情况</td>
                </tr>
                <tr>
                	<td colspan="1" rowspan="2">第一学年</td>
                	<td colspan="6" rowspan="2">
                		<div class="form-group">
                			${creditReport.studyTestFirstYear }
	                  	</div>
                	</td>
                	<td colspan="1" rowspan="1">记录人签名</td>
                	<td colspan="1" rowspan="1">日期</td>
                </tr>
                <tr>
					<td>
						<div class="form-group">
							${creditReport.studyTestFirstRecordPerson }
	                  	</div>
					</td>
					
					<td>
						<div class="form-group">
							${creditReport.studyTestFirstDate }
	                  	</div>
					</td>
  				</tr>
  				<tr>
  					<td colspan="1" rowspan="2">第二学年</td>
  					<td colspan="6" rowspan="2">
  						<div class="form-group">
  							${creditReport.studyTestSecondYear }
	                  	</div>
  					</td>
  					<td colspan="1" rowspan="1">记录人签名</td>
  					<td colspan="1" rowspan="1">日期</td>
  				</tr>
  				<tr>
  					<td>
						<div class="form-group">
							${creditReport.studyTestSecondRecordPerson }
	                  	</div>
					</td>
					
					<td>
						<div class="form-group">
							${creditReport.studyTestSecondDate }
	                  	</div>
					</td>
  				</tr>
  				<tr>
  					<td colspan="1" rowspan="2">第三学年</td>
  					<td colspan="6" rowspan="2">
  						<div class="form-group">
  							${creditReport.studyTestThirdYear }
	                  	</div>
  					</td>
  					<td colspan="1" rowspan="1">记录人签名</td>
  					<td colspan="1" rowspan="1">日期</td>
  				</tr>
  				<tr>
  					<td>
						<div class="form-group">
							${creditReport.studyTestThirdRecordPerson }
	                  	</div>
					</td>
					
					<td>
						<div class="form-group">
							${creditReport.studyTestThirdDate }
	                  	</div>
					</td>
  				</tr>
  				<!--  -->
  				 <tr>
                	<td colspan="1" rowspan="4" style="text-align:center;vertical-align:middle">
                		(新学<br/>年开学<br/>一月<br/>后)<br/>拖欠<br/>费用<br/>情况<br/>
                	</td>
                	<td colspan="2" style="text-align:center">学年</td>
                	
                	<td colspan="2" style="text-align:center">拖欠学费</td>
                	
                	<td colspan="2" style="text-align:center">拖欠住宿费</td>
                	
                	<td colspan="2" style="text-align:center">拖欠其他费用</td>
                	
                	<td colspan="1" style="text-align:center">记录人签名</td>
                </tr>
                <tr>
                	<td colspan="2">一</td>
                	<td colspan="2">
                		<div class="form-group">
                			${creditReport.oweMoneyFirstStudy }
	                  	</div>
                		
                	</td>
                	<td colspan="2">
                		<div class="form-group">
                			${creditReport.oweMoneyFirstAccommodation }
	                  	</div>
                	</td>
                	<td colspan="2">
                		<div class="form-group">
                			${creditReport.oweMoneyFirstOther }
	                  	</div>
                	</td>
                	<td>
                		<div class="form-group">
                			${creditReport.oweMoneyFirstRecordPerson }
	                  	</div>
                	</td>
                	
                </tr>
                <tr>
                	<td colspan="2">二</td>
                	<td colspan="2">
                		<div class="form-group">
                			${creditReport.oweMoneySecondStudy }
	                  	</div>
                	</td>
                	<td colspan="2">
                		<div class="form-group">
                			${creditReport.oweMoneySecondAccommodation }
	                  	</div>
                	</td>
                	<td colspan="2">
                		<div class="form-group">
                			${creditReport.oweMoneySecondOther }
	                  	</div>
                	</td>
                	<td>
                		<div class="form-group">
                			${creditReport.oweMoneySecondRecordPerson }
	                  	</div>
                	</td>
                </tr>
                <tr>
                	<td colspan="2">三</td>
                	<td colspan="2">
                		<div class="form-group">
                			${creditReport.oweMoneyThirdStudy }
	                  	</div>
                	</td>
                	<td colspan="2">
                		<div class="form-group">
                			${creditReport.oweMoneyThirdAccommodation }
	                  	</div>
                	</td>
                	<td colspan="2">
                		<div class="form-group">
                			${creditReport.oweMoneyThirdOther }	
	                  	</div>
                	</td>
                	<td>
                		<div class="form-group">
                			${creditReport.oweMoneyThirdRecordPerson }	
	                  	</div>
                	</td>
                </tr>
                
                
                <!--  -->
                
                 <tr>
                	<td colspan="1" rowspan="7" style="text-align:center;vertical-align:middle">
                		日<br/>常<br/>行<br/>为<br/>情<br/>况<br/>
                	</td>
                	<td colspan="9" style="text-align:center">包括篡改简历，勤工俭学，恶意欺诈，诽谤诬告，交通违法等情况；</td>
                </tr>
                <tr>
                	<td colspan="1" rowspan="2">第一学年</td>
                	<td colspan="6" rowspan="2">
                		<div class="form-group">
                				${creditReport.dailyBehaviorFirstYear }	
	                  	</div>
                	</td>
                	<td colspan="1" rowspan="1">记录人签名</td>
                	<td colspan="1" rowspan="1">日期</td>
                </tr>
                <tr>
					<td>
						<div class="form-group">
							${creditReport.dailyBehaviorFirstRecordPerson }	
	                  	</div>
					</td>
					
					<td>
						<div class="form-group">
							${creditReport.dailyBehaviorFirstDate }	
	                  	</div>
					</td>
  				</tr>
  				<tr>
  					<td colspan="1" rowspan="2">第二学年</td>
  					<td colspan="6" rowspan="2">
  						<div class="form-group">
  							${creditReport.dailyBehaviorSecondYear }	
	                  	</div>
  					</td>
  					<td colspan="1" rowspan="1">记录人签名</td>
  					<td colspan="1" rowspan="1">日期</td>
  				</tr>
  				<tr>
  					<td>
						<div class="form-group">
							${creditReport.dailyBehaviorSecondRecordPerson }	
	                  	</div>
					</td>
					
					<td>
						<div class="form-group">
							${creditReport.dailyBehaviorSecondDate }
	                  	</div>
					</td>
  				</tr>
  				<tr>
  					<td colspan="1" rowspan="2">第三学年</td>
  					<td colspan="6" rowspan="2">
  						<div class="form-group">
  							${creditReport.dailyBehaviorThirdYear }
	                  	</div>
  					</td>
  					<td colspan="1" rowspan="1">记录人签名</td>
  					<td colspan="1" rowspan="1">日期</td>
  				</tr>
  				<tr>
  					<td>
						<div class="form-group">
							${creditReport.dailyBehaviorThirdRecordPerson }
	                  	</div>
					</td>
					
					<td>
						<div class="form-group">
							${creditReport.dailyBehaviorThirdDate }
	                  	</div>
					</td>
  				</tr>
  				
  				<!--  -->
  				 <tr>
                	<td colspan="1" rowspan="7" style="text-align:center;vertical-align:middle">
                		 其<br/>它<br/>表<br/>现<br/>情<br/>况<br/>
                	</td>
                	<td colspan="9" style="text-align:center">包括发送电脑病毒， 编造虚假新闻，信息，偷看他人邮件等等；</td>
                </tr>
                <tr>
                	<td colspan="1" rowspan="2">第一学年</td>
                	<td colspan="6" rowspan="2">
                		<div class="form-group">
                			${creditReport.otherBehaviorFirstYear }
	                  	</div>
                	</td>
                	<td colspan="1" rowspan="1">记录人签名</td>
                	<td colspan="1" rowspan="1">日期</td>
                </tr>
                <tr>
					<td>
						<div class="form-group">
							${creditReport.otherBehaviorFirstRecordPerson }	
	                  	</div>
					</td>
					
					<td>
						<div class="form-group">
							${creditReport.otherBehaviorFirstDate }	
	                  	</div>
					</td>
  				</tr>
  				<tr>
  					<td colspan="1" rowspan="2">第二学年</td>
  					<td colspan="6" rowspan="2">
  						<div class="form-group">
  							${creditReport.otherBehaviorSecondYear }	
	                  	</div>
  					</td>
  					<td colspan="1" rowspan="1">记录人签名</td>
  					<td colspan="1" rowspan="1">日期</td>
  				</tr>
  				<tr>
  					<td>
						<div class="form-group">
							${creditReport.otherBehaviorSecondRecordPerson }	
	                  	</div>
					</td>
					
					<td>
						<div class="form-group">
							${creditReport.otherBehaviorSecondDate }	
	                  	</div>
					</td>
  				</tr>
  				<tr>
  					<td colspan="1" rowspan="2">第三学年</td>
  					<td colspan="6" rowspan="2">
  						<div class="form-group">
  							${creditReport.otherBehaviorThirdYear }	
	                  	</div>
  					</td>
  					<td colspan="1" rowspan="1">记录人签名</td>
  					<td colspan="1" rowspan="1">日期</td>
  				</tr>
  				<tr>
  					<td>
						<div class="form-group">
							${creditReport.otherBehaviorThirdRecordPerson }	
	                  	</div>
					</td>
					
					<td>
						<div class="form-group">
							${creditReport.otherBehaviorThirdDate }	
	                  	</div>
					</td>
  				</tr>
  				
  				<tr>
  					<td  rowspan="6" colspan="10">
  						<div style="width:400px;height:200px;float:right;margin-top:200px" >
  							学校审核盖章：高平市中等专业学校<br/>
  							<br/><br/><br/>
  							&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;&nbsp;
  							
  						</div>
  					</td>
  				</tr>
  				
  				
              	</table>
              	<form action="delCreditReport">
	       			<div class="col-sm-6">
		  				<div class="form-group">
		  					<label>&nbsp;</label><br/>
		  					<input type="hidden" value="${student.id }" name="studentId"/>
			                <input type="submit" class="btn btn-danger" value="删除" />
		  				</div>
		  			</div>
	  			</form>
	  			<form action="modifyCreditReport">			  					
		  			<div class="col-sm-6">
		  				<div class="form-group">
		  					<label>&nbsp;</label><br/>
		  					<input type="hidden" value="${student.id }" name="studentId"/>
			                <input type="submit" class="btn btn-primary" value="修改"/>
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
<script type="text/javascript" src="js/DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	
</script>
</body>
</html>