<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC >
<html>

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Start Simple Web</title>
<!---->
<link href="${pageContext.request.contextPath}/css/write.css" rel="stylesheet">

<!-- Bootstrap Core CSS -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/css/clean-blog.css" rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href='http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<!-- jQuery -->
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="${pageContext.request.contextPath}/js/clean-blog.min.js"></script>


<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<!-- jQuery -->
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script>
	$(function(){
		$("button#btnchk").click(function (){
			$("form").submit();
		})
	})

</script>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<!-- Page Header -->
	<!-- Set your background image for this header on the line below. -->
	<header class="intro-header"
		style="background-image: url('${pageContext.request.contextPath}/img/about-bg.jpg'); height: 200px">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
					<div class="site-heading"
						style="margin-top: 10px; padding-top: 35px; padding-bottom: 35px">
						<h2>SAMPLE</h2>
						<span class="subheading">BULLETIN BOARD</span>
					</div>
				</div>
			</div>
		</div>
	</header>
<form action="${pageContext.request.contextPath}/insertBoard.do?cmd=modify&no=${info.NO}" method="post" enctype="multipart/form-data">
	<div id="write-field">
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<table>
				<tr>
					<td class="td1">카테고리</td>
					<td class="td2"><select name="categorybox" class="form-control"
						style="display: inline-block;" >
							<option value=""> 선택해주세요</option>
							<option value="">----------------------</option>
						<c:choose>
							<c:when test="${info.CATEGORY == 'Java'}">
								<option id ="ca1" selected>Java</option>
							</c:when>
							<c:when test="${info.CATEGORY == 'Spring'}">
								<option id ="ca2" selected>Spring</option>
							</c:when>
							<c:when test="${info.CATEGORY == 'Algorithm'}">
								<option id ="ca3" selected>Algorithm</option>
							</c:when>
							<c:when test="${info.CATEGORY == 'Python'}">
								<option id ="ca4" selected>Python</option>
							</c:when>
							<c:when test="${info.CATEGORY == 'JavaScript'}">
								<option id ="ca5" selected>JavaScript</option>
							</c:when>
							<c:otherwise>
								<option id ="default" selected>선택</option>
							</c:otherwise>
						</c:choose>

					</select></td>
				</tr>

				<tr>
					<td class="td2" colspan="2">
						<div class="row row-xs-bskr">
							<div class="col-md-6 col-sm-6 col-xs-bskr">
								<div class="input-title">작성자명</div>
								<div class="input-forms">
									<%--<input type="hidden" name="nick" value="${nickName}"/>--%>
									<input size="20" type="text"  name="nick" value="${nickName}"
										class="form-control input-sm input-name bskr-font user" readonly/>
								</div>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-bskr">
								<div class="input-title">비밀번호</div>
								<div class="input-forms">
									<input size="20" type="password" name="brdpass" value="${info.PASSWORD}"
										class="form-control input-sm input-pwd bskr-font user" />
									<input type="hidden" name="hitcnt" value="${info.HIT}">
								</div>
							</div>
						</div>
					</td>
				</tr>


				<tr>
					<td class="td1">제목</td>
					<td class="td2" valign="middle">
					<input type="text" name="brdtitle" value="${info.TITLE}" class="form-control input-sm bskr-font subject"/></td>
				</tr>


			</table>
			<div class="form-group">
				<table>
					<tr>
						<td class="td1"></td>
						<td calss="td2"><textarea class="form-control col-sm-5" name="brdcontent"
								rows="20">${info.CONTENTS}</textarea></td>
					</tr>
					<tr>
					<td class="td1"></td>
						<td class="td2"><input type="file" name="InputFile"></td>
					</tr>
				</table>
			</div>

			<div class="bottombox">
				<input type="button" value="취소" class="btn btn-default btn-sm"
					onclick="return cancelCheck();" />&nbsp;
				<button id="btnchk" class="btn btn-primary btn-sm">
					<i class="glyphicon glyphicon-ok"></i> 확인
				</button>
			</div>
		</div>
	</div>
</form>

	<!-- Footer -->
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
					<ul class="list-inline text-center">
						<li>
							<a href="#">
								<span class="fa-stack fa-lg">
									<i class="fa fa-circle fa-stack-2x"></i> <i
									class="fa fa-envelope-o fa-stack-1x fa-inverse"></i>
							</span>
						</a></li>
						<li><a href="#"> <span class="fa-stack fa-lg"> <i
									class="fa fa-circle fa-stack-2x"></i> <i
									class="fa fa-home fa-stack-1x fa-inverse"></i>
							</span>
						</a></li>
						<li><a href="#"> <span class="fa-stack fa-lg"> <i
									class="fa fa-circle fa-stack-2x"></i> <i
									class="fa fa-github fa-stack-1x fa-inverse"></i>
							</span>
						</a></li>
					</ul>
					<p class="copyright text-muted">Copyright &copy;2016 SIST. All
						rights reserved | code by milib</p>
				</div>
			</div>
		</div>
	</footer>

</body>

</html>
