<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<link href="https://fonts.googleapis.com/css2?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" href="../css/gameCSS.css">
	<script src="../shop_js/shop.js"></script>
	<script src="../character_js/character.js"></script>
	
</head>
<script>

$(function(){
	
	//selectMyCharacter("issac");	//내 캐릭터 불러오기
	var userInfo = $('#id').val();
	console.log("user : "+userInfo)
	
	selectMyCharacter(userInfo);

})


</script>
<body>
<%
	String userId = (String) session.getAttribute("userid");
%>
<input id="id" type="hidden" name="<%=userId%>" value="<%=userId%>">
<audio id="backgroundMusic" autoplay src="../multichat/backMusic.mp3"></audio>
  <jsp:include page="header.jsp"></jsp:include>
  <jsp:include page="WatitngView.jsp"></jsp:include>
  <jsp:include page="modalTemp.jsp"></jsp:include>
  <jsp:include page="content.jsp"></jsp:include>
  <%-- <jsp:include page="footer.jsp"></jsp:include> --%>
</body>
</html>		