<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="../chat_j2/chat_js.js"></script>
<script type="text/javascript">
test2()
</script>
<title>게임 시작</title>
<style>
body {
	text-align: right;
}

nav {
	border-bottom: 1px solid grey;
	height: 41px;
	text-align: center;
	box-sizing: border-box;
}

#header div {
	display: inline-block;
	border: 1px solid red;
	text-align: center;
	box-sizing: border-box;
}

#roomNo {
	width: 250px;
}

#title {
	width: 690px;
}

#theme {
	width: 250px;
}

#getAllow {
	width: 250px;
}

div {
	text-align: center;
	box-sizing: border-box;
	vertical-align: middle;
}

#recommendWord {
	vertical-align: middle;
	border: 1px solid red;
	height: 100px;
}

#answer {
	box-sizing: border-box;
	text-align: center;
	display: inline-block;
	/* display: grid;
		grid-template-columns : 80% 20%; */
}

#answer #answerBox {
	box-sizing: border-box;
	display: inline-block;
	text-align: center;
	height: 100%;
	margin-right: 200px;
}

#progressBar {
	width: 400px;
}

#myProgress {
	width: 100%;
	background-color: #ddd;
	border: 1px solid lightgrey;
	/* width: 400px; */
}

#roundTime {
	width: 70%;
	height: 30px;
	background-color: #4CAF50;
}

#totalTime {
	width: 80%;
	height: 30px;
	background-color: pink;
}

#bgBox {
	position: relative;
	width: 400px;
	height: 180px;
}

.jb-image img {
	width: 400px;
	height: 180px;
	vertical-align: middle;
}

.jb-text {
	text-align: center;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	padding: 5px 10px;
}

#answer #roundCnt {
	display: inline-block;
}

#roundBox {
	position: relative;
	width: 380px;
	height: 180px;
}

.round-img img {
	width: 300px;
	height: 180px;
	vertical-align: middle;
}

.round-text {
	padding: 5px 10px;
	text-align: center;
	position: absolute;
	top: 40%;
	left: 50%;
	transform: translate(-50%, -50%);
}

#records {
	height: 80px;
	border-top: 1px solid lightgrey;
    text-align: left;
}
#records ul{
	list-style:none;
	padding-left:0px;
	white-space: nowrap;
	overflow-x: visible;
	overflow-y: hidden;
}
#records ul li {
	display: inline-block;
    font-size: 27px;
    font-weight: bold;
    border-left: 1px solid lightgrey;
    padding: 13px;
}
#cont {
	grid-template-columns: auto auto auto;
}
.recordBox {
	border: 1px solid black;
	float: left;
}

#charaters {
	border-top: 1px solid lightgrey;
	border-bottom: 1px solid lightgrey;
}

#charaters img {
	width: 50px;
	height: 150px;
}
</style>
</head>

<body>
	<nav id="header">
		
		
	</nav>
	<div id="recommendWord">
		<h1>제 시 어</h1>
	</div>
	<div id="cont">
		<div id="answer">
			<div id="answerBox">
				<div id="bgBox">
					<div class="jb-image">
						<img alt="" src="../img/answerBox_640.png">
					</div>
					<div class="jb-text">
						<h2>제 시 어</h2>
					</div>
				</div>
				<div id="progressBar">
					<div id="myProgress">
						<div id="roundTime">라운드시간</div>
					</div>
					<div id="myProgress">
						<div id="totalTime">전체시간</div>
					</div>
				</div>
			</div>
			<div id="roundCnt">
				<div id="roundBox">
					<div class="round-img">
						<img alt="" src="../img/round_640.PNG">
					</div>
					<div class="round-text">
						<h2>1</h2>
					</div>
				</div>
			</div>
		</div>
		<div id="records" class="horizontal-scrollable">
			<ul>
				<li>흰머리</li>
				<li>리어카</li>
				<li>카센터</li>
				<li>흰머리</li>
				<li>리어카</li>
				<li>카센터</li>
				<li>흰머리</li>
				<li>리어카</li>
				<li>카센터</li>
				<li>흰머리</li>
				<li>리어카</li>
				<li>카센터</li>
				<li>흰머리</li>
				<li>리어카</li>
				<li>카센터</li>
				<li>흰머리</li>
				<li>리어카</li>
				<li>카센터</li>
			</ul>
		</div>
	</div>
	<div id="charaters">
		<img alt="" src="../img/girl_basic.png"> <img alt=""
			src="../img/boy_basic.png"> <img alt=""
			src="../img/girl_basic.png"> <img alt=""
			src="../img/boy_basic.png">
	</div>

	<div id="chatting" class="form-group">
		<textarea rows="6" class="form-control" id="messageTextArea"
			readonly="readonly"></textarea>
		<input type="text" id="messageText" name="chatInput"
			class="form-control">
			<input type="button" value="Send" id="btnSend">
	</div>
	<script type="text/javascript">
	
	test(roomnum, myid, nick)
	</script>
</body>
</html>