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
<%--<script>
	$(function (){
		$("a#in")
	})
	$(function(){
	$("a#loginbtn").click(function (){
</script>--%>
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script>
$(function (){
	$("#like").click(function (){
		console.log(this.id);
		$.ajax({
			url:'${pageContext.request.contextPath}/emotion.do',
			type:'POST',
			data:{
				"cmd":"emotion","id":"${id}","no":${info.NO},"action":"like"
			},
			success:function (data){
				if(data.trim() == 'true'){
					alert("좋아요/싫어요 버튼을 정상 클릭 하셨습니다.");
					location.reload();
				}else{
					alert("눌러진 버튼 입니다.")
				}
			},
			error:function (){
				console.log("error");
			}
		})
	});
	$("#hate").click(function (){
		console.log(this.id);
		$.ajax({
			url:'${pageContext.request.contextPath}/emotion.do',
			type:'POST',
			data:{
				"cmd":"emotion","id":"${id}","no":${info.NO},"action":"hate"
			},
			success:function (data){
				if(data.trim() == 'true'){
					alert("좋아요/싫어요 버튼을 정상 클릭 하셨습니다.");
					location.reload();
				}else{
					alert("눌러진 버튼 입니다.")
				}
			},
			error:function (){
				console.log("error");
			}
		})
	});
	$("#scrap").click(function (){
		$.ajax({
			url:'${pageContext.request.contextPath}/scrap.do',
			type:'POST',
			data:{
				"cmd":"scrap","id":"${id}", "no":${info.NO}
			},
			success:function (data){
				if(data.trim() == "add"){
					alert("스크랩 완료하였습니다")
					location.reload();
				}
				if(data.trim()=="delete"){
					alert("스크랩 목록에서 제거하였습니다")
					location.reload();
				}
			},
			error:function (){
				console.log("error");
			}
		})

	})
});
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
	<div class="board-field">
		<div class="list-group">
			<div class="list-group-item board-title">
				<div class="board-title">
					<span class="board-category">[${info.CATEGORY}]</span><a href="#">
						${info.TITLE} </a>
				</div>
				<div class="board-meta"
					style="font-weight: 400; font-size: 1.2rem; color: #404040">
					<p>
						<i class="glyphicon glyphicon-user"></i> ${info.WRITER}
						<i class="glyphicon glyphicon-comment"></i> [댓글 수]
						<i class="glyphicon glyphicon-ok"></i> ${info.SCRAPCNT}
						<i class="glyphicon glyphicon-time"></i> ${info.regdate}
					    <i class="glyphicon glyphicon-thumbs-up"></i> ${info.LIKECNT}
						<i class="glyphicon glyphicon-thumbs-down"></i> ${info.HATECNT}
					</p>
				</div>
				<div class="clear"></div>
			</div>
			<div class="list-group-item">
				<span class="board-contents">
					${info.CONTENTS} </span>
				<p style="text-align: center; margin-top: 30px">
					<%--해당 버튼을 눌렀을때 그거에 맞는 함수 불러주기--%>
					<button class="btn btn-success" id="like">
						<i class="glyphicon glyphicon-thumbs-up"></i>좋아요
					</button>
					<button class="btn btn-warning" id="hate">
						<i class="glyphicon glyphicon-thumbs-down"></i>싫어요
					</button>
				</p>
			</div>
			<div class="bottom" style="margin: 10px;margin-top: 20px; text-align: right">
				<a href="${pageContext.request.contextPath}/listSelect.do?cmd=listSelect" class="btn btn-default btn-xs pull-left">목록으로</a>
				<a href="${pageContext.request.contextPath}/views/Password.jsp?job=modify&no=${info.NO}" class="btn btn-default btn-xs">수정</a>
				<a href="${pageContext.request.contextPath}/views/Password.jsp?job=del&no=${info.NO}" class="btn btn-default btn-xs">삭제</a>
				<a href="#" class="btn btn-default btn-xs">답변</a>
				<a class="btn btn-default btn-xs" id="scrap">스크랩</a>
			</div>
			<div class="clear"></div>
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
