
<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<%@page import="com.ckeditor.CKEditorConfig"%>
<%@page import="com.ckeditor.EventHandler"%>


<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache"> 
    <meta http-equiv="Cache-Control" content="no-cache"> 
    <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
    
    <title>Task Manager | Home</title>
    
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
     <link href="static/css/style.css" rel="stylesheet">
    
    <!--[if lt IE 9]>
		<script src="static/js/html5shiv.min.js"></script>
		<script src="static/js/respond.min.js"></script>
		<script src="//cdn.ckeditor.com/4.6.2/full/ckeditor.js"></script>
	<![endif]-->
</head>
<body>

	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Tin Tuc</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="new-task">New News</a></li>
					<li><a href="all-tasks">All News</a></li>
				</ul>
			</div>
		</div>
	</div>
	<c:choose>
		<c:when test="${mode == 'MODE_HOME'}">
			<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>Welcome to News List</h1>
				</div>
			</div>
		</c:when>
		<c:when test="${mode == 'MODE_TASKS'}">
			<div class="container text-center" id="tasksDiv">
				<h3>News</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>Title</th>
								<th>Edit</th>
								<th>Delete</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="tintuc" items="${tintucs}">
								<tr>
									<td><a href="view-task?id=${tintuc.id}">${tintuc.title}</a></td>
									<td><a href="update-task?id=${tintuc.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
									<td><a href="delete-task?id=${tintuc.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		<c:when test="${mode == 'MODE_NEW' || mode == 'MODE_UPDATE'}">
			<div class="container text-center">
				<h3>Manage News</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="save-task">
					<input type="hidden" name="id" value="${tintuc.id}"/>
					<div class="form-group">
						<label class="control-label col-md-3">Title</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="title" value="${tintuc.title}"/>
						</div>				
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Content</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="content" value="${tintuc.content}"/>
						</div>				
					</div>
					<textarea name="editor1"></textarea>
					<div class="form-group">
						<label class="control-label col-md-3">File</label>
						<div class="col-md-7">
							<input type="file" style="width:200px">
						</div>				
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Save"/>
						<INPUT Type="button" class="btn btn-primary" VALUE="Back" onClick="history.go(-1);return true;">
					</div>
				</form>
				 <script>
				       CKEDITOR.replace( 'editor1' );
				 </script>
			</div>
		</c:when>	
		<c:when test="${mode == 'MODE_VIEW'}">
			<div class="container text-center">
				<h3>View News</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="save-task">
					<input type="hidden" name="id" value="${tintuc.id}"/>
					<div class="form-group">
						<label class="control-label col-md-3">Title</label>
						<div class="col-md-7">
							<input type="text" disabled="disabled" class="form-control" name="title" value="${tintuc.title}"/>
						</div>				
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Content</label>
						<div class="col-md-7">
							<input type="text" disabled="disabled" class="form-control" name="content" value="${tintuc.content}"/>
						</div>				
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Link</label>
						<div class="col-md-7">
							<input type="text" disabled="disabled" class="form-control" name="link" value="${tintuc.link}"/>
						</div>				
					</div>		
					<div class="form-group">
						<INPUT Type="button" class="btn btn-primary" VALUE="Back" onClick="history.go(-1);return true;">
					</div>
				</form>
			</div>
		</c:when>	
	</c:choose>

	<script src="static/js/jquery-1.11.1.min.js"></script>    
    <script src="static/js/bootstrap.min.js"></script>
    <script src="//cdn.ckeditor.com/4.6.2/full/ckeditor.js"></script>
</body>
</html>
