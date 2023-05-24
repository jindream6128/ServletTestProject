<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>관리자</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=10" />
    <meta http-equiv="imagetoolbar" content="no" />
    <meta name="copyright" content="Copyright 2009 @ high1 all rights reserved" />

    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <!-- 모델1 모델2 -->
    <script>
        $(function(){
            $("#btn").click(function(){
                //제약사항
                $("form").submit();
            });

        });
    </script>
</head>
<body>

<form name="login" method="post" action="${pageContext.request.contextPath}/password.do?cmd=pass&job=${param.job}&no=${param.no}">
    <div id="loginWrapper" style="width: 50%;">
        <div class="loginForm">
            <fieldset>
                <legend>관리자 시스템 비밀번호</legend>
                <dl>
                    <dd>
                        비밀번호:
                        <input type="password" name="pass" class="text" style="width: 100px;" id="user_passwd" />
                        <input type="button" id="btn" value="확인" />
                    </dd>
                </dl>
         </fieldset>
        </div>
    </div>
</form>

</body>
</html>