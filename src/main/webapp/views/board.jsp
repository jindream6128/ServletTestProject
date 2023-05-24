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

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<!-- jQuery -->
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="${pageContext.request.contextPath}/js/clean-blog.min.js"></script>

</head>
<body>


<jsp:include page="header.jsp"></jsp:include>


	<!-- Page Header -->
	<!-- Set your background image for this header on the line below. -->
	<header class="intro-header" style="background-image: url('${pageContext.request.contextPath}/img/about-bg.jpg'); height: 200px">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
					<div class="site-heading" style="margin-top: 10px; padding-top: 35px; padding-bottom: 35px">
						<h2>SAMPLE</h2>
						<span class="subheading">BULLETIN BOARD</span>
					</div>
				</div>
			</div>
		</div>
	</header>
	<div class="board-field">
		<div class="col-md-2"></div>
		<div class="col-md-8">
			<div class="board-toolbar" 	style="text-align: right; margin-bottom: 20px">

				<a href="${pageContext.request.contextPath}/views/write.jsp" class="btn btn-primary btn-sm">
					<i class="glyphicon glyphicon-pencil" style="margin-right: 15px"></i>쓰기</a>
			</div>

				<c:forEach var="i" items="${list}">
					<%--이거누르면 info로 들어간다--%>
					<a href="${pageContext.request.contextPath}/hit.do?cmd=hit&no=${i.NO}&job=info" class="list-group-item">
					<div class="board-title">
						<span class="board-category">${i.CATEGORY}</span>${i.TITLE}
						<span class="badge">오늘쓴 글이면 New 나오게 근데 할필요가 있을까?</span>
					</div>
					<div class="board-meta"
						style="font-weight: 400; font-size: 1.2rem; color: #404040">
						<p>
							<i class="glyphicon glyphicon-user"></i> ${i.WRITER}
							<i class="glyphicon glyphicon-comment"></i> [댓글수]
							<i class="glyphicon glyphicon-ok"></i> [스크랩]
							<i class="glyphicon glyphicon-hit"></i> ${i.HIT}
							<i class="glyphicon glyphicon-time"></i>${i.regdate}
						</p>
					</div>
				</a>
				</c:forEach>


			</div>
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<ul class="pagination">
					<li><a href="${pageContext.request.contextPath}/listSelect.do?cmd=listSelect&page=1">처음으로</a></li>

					<c:choose>
						<c:when test="${pageBean.currentBlock>1 }">
						<li><a href="${pageContext.request.contextPath}/listSelect.do?cmd=listSelect&page=${pageBean.startPage-1}">이전</a></li>
						</c:when>

						<c:otherwise>
							<li><a href="#">이전</a></li>
						</c:otherwise>
					</c:choose>

					<c:forEach var = "i" begin="${pageBean.startPage}" end="${pageBean.endPage}">

						<c:choose>
							<c:when test="${i eq pageBean.currentPage }">
								<li class="active"><a href="#">${i}</a></li>
							</c:when>

							<c:otherwise>
								<li><a href="${pageContext.request.contextPath}/listSelect.do?cmd=listSelect&page=${i}">${i}</a></li>
							</c:otherwise>
						</c:choose>

					</c:forEach>

					<c:choose>
						<c:when test="${pageBean.totalPage > pageBean.endPage }">
							<li><a href="${pageContext.request.contextPath}/listSelect.do?cmd=listSelect&page=${pageBean.endPage+1}">다음</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="#">다음</a></li>
						</c:otherwise>
					</c:choose>
					<li><a href="${pageContext.request.contextPath}/listSelect.do?cmd=listSelect&page=${pageBean.totalPage}">마지막으로</a></li>

				</ul>
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
					<p class="copyright text-muted">Copyright &copy;2016 SIST. All
						rights reserved | code by milib</p>
				</div>
			</div>
		</div>
	</footer>


</body>

</html>
