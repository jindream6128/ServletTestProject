
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
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

<!-- Bootstrap Core CSS -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/css/clean-blog.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/board.css" rel="stylesheet">

<!-- jQuery -->
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="${pageContext.request.contextPath}/js/clean-blog.min.js"></script>

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


</head>

<body>

	<jsp:include page="header.jsp"></jsp:include>


	<!-- Set your background image for this header on the line below. -->
	<header class="intro-header"
		style="background-image: url('${pageContext.request.contextPath}/img/home-bg.jpg'); height: 200px">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
					<div class="site-heading"
						style="margin-top: 10px; padding-top: 35px; padding-bottom: 35px">
						<h2>SAMPLE</h2>
						<span class="subheading">MY PAGE</span>
					</div>
				</div>
			</div>
		</div>
	</header>
	<div class="col-md-12">
		<div class="col-md-2"></div>
		<div class="col-md-8">
			<div class="list-group col-md-12">
				<a class="list-group-item list-group-item-warning">스크랩한 게시글</a>

				<c:forEach var="i" items="${page}">
					<a href="${pageContext.request.contextPath}/hit.do?cmd=hit&no=${i.NO}&job=info" class="list-group-item">
					<div>
					<div class="board-title">
						<span class="board-category">${i.CATEGORY}</span>${i.TITLE}
						<c:if test="${i.newChk == 'Y'}">
							<span class="badge">new</span>
						</c:if>
						<button class="pull-right" style="margin-top: 10px">삭제</button>	
					</div>
					<div class="board-meta"
						style="font-weight: 400; font-size: 1.2rem; color: #404040">
						<p>
							<i class="glyphicon glyphicon-user"></i> ${i.WRITER}
							<i class="glyphicon glyphicon-comment"></i> [댓글수]
							<i class="glyphicon glyphicon-ok"></i>[스크랩 수: ${i.SCRAPCNT}]
							<i class="glyphicon glyphicon-hit"></i> [조회수: ${i.HIT}]
							<i class="glyphicon glyphicon-time"></i>${i.regdate}
						</p>
					</div>
					</div>
				</a>
				</c:forEach>
			</div>
			<div class="col-md-2"></div>
			<%--<div class="col-md-8">
				<ul class="pagination">
					<li><a href="#">이전</a></li>
					<li><a href="#">1</a></li>
					<li class="active"><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">.더보기.</a></li>
					<li><a href="#">19</a></li>
					<li><a href="#">다음</a></li>
				</ul>
			</div>--%>
		</div>
	</div>
	</div>
	<!-- Footer -->
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
					<ul class="list-inline text-center">
						<li>
							<a href="#">
							<span class="fa-stack fa-lg">
							<i class="fa fa-circle fa-stack-2x"></i>
							<i class="fa fa-envelope-o fa-stack-1x fa-inverse"></i>
							</span>
						</a>
						</li>
						<li>
							<a href="#">
								<span class="fa-stack fa-lg">
									<i class="fa fa-circle fa-stack-2x"></i>
									<i class="fa fa-home fa-stack-1x fa-inverse"></i>
								</span>
							</a>
						</li>
						<li>
							<a href="#">
								<span class="fa-stack fa-lg">
									<i class="fa fa-circle fa-stack-2x"></i>
									<i class="fa fa-github fa-stack-1x fa-inverse"></i>
								</span>
							</a>
						</li>
					</ul>
					<p class="copyright text-muted">Copyright &copy;2016 SIST. All rights reserved | code by milib</p>
				</div>
			</div>
		</div>
	</footer>


</body>

</html>
