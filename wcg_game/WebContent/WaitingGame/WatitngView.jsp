<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
.row.content {
	height: 550px
}

/* Set gray background color and 100% height */
.sidenav {
	background-color: #f1f1f1;
	height: 100%;
}

/* On small screens, set height to 'auto' for the grid */
@media screen and (max-width: 767px) {
	.row.content {
		height: auto;
	}
}

.roomDiv {
	cursor: pointer;
}
/* The Modal (background) */
.searchModal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 10; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0,0,0); /* Fallback color */
	background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
	}
/* Modal Content/Box */
.search-modal-content {
	background-color: #fefefe;
	margin: 15% auto; /* 15% from the top and centered */
	padding: 20px;
	border: 1px solid #888;
	width: 70%; /* Could be more or less, depending on screen size */
	}
	
/* .col-sm-3 {
	overflow: hidden;
	display: flex;
	align-items: center;
	justify-content: center;
	width: 300px;
	height: 300px;
}

body {
	color: black;
}

td {
	color: black;
} */

#myChShow {
	background: white;
}

#selectNickName {
	background: white;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="../shop_js/shop.js"></script>
<script src="../character_js/character.js"></script>
<script src="../inventory_js/jquery.serializejson.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script>
  	$(function() {
  		waitingRoomList();
  		urlAction = "<%=request.getContextPath()%>/game/waitingGameInfo.ddit";
  		// 상점
  		item="";
  		item_no="";
  		readItem();
  		ch_nickName="";
  		
  		// 현재 로그인 되어 있는 유저 id 값
  		var userInfo = $('#id').val();
  		  		
  		$('#res').on('click','#showItem',function(){//모달open
  			
  			itemNo = $(this).parent().find("#showItemNo").val();
  			//console.log($(this).parent().find("#showItemNo").val());
  			
  			 $("#modal").show();	//클릭시 아이템 자세히 보기
  			 
  			 selectItem(itemNo);	
  		 		 
	  		 $("#buyItem").on('click',function(){	//구입버튼 클릭	
	  			 selectCharacter(userInfo);
	  			 $('#modal').hide();
	  		 });
	  			 
	  		 $('#close').on('click',function(){//모달hide
  			     $('#modal').hide();
	  		 });
  		});
  		//====================================//
  		// 인벤토리
  		aa="1";
        char_nickname = "";  //캐릭터 닉네임 담을 변수(BuyItemINInvettorySelectAll)실행예정
 
        selectId(userInfo);
        
        $('#showItem').on('click','.btn-info',function(){
        	//console.log("---"+id);
        	UpdateItemLinkIMG(userInfo);
        })
    	//====================================//
  	});
  	
  	
  </script>
</head>
<%
	String userId = (String) session.getAttribute("userid");
%>
<input id="id" type="hidden" name="<%=userId%>" value="<%=userId%>">

<div class="container-fluid">
	<div class="row content">
		<div class="col-sm-3 sidenav hidden-xs">
			<h2>한끝</h2>
			<ul class="nav nav-pills nav-stacked">
				<li class="active"><a id="myChShow" href="#section1">내 캐릭터
						이미지 출력</a></li>
				<li><a href="../inventoryMain/main.jsp">내 인벤토리 보기</a></li>
			</ul>
			<br>
		</div>
		<br>

		<div class="tab-content">
			<div id="waiting" class="tab-pane fade in active">
				<div id="roomList" class="col-sm-9"></div>
			</div>
			<div id="shop" class="tab-pane fade">
				<div id="res"></div>
			</div>
			<div id="inventory" class="tab-pane">
				<div class="col-sm-9">
					<div id="showItem"></div>
				</div>
			</div>
		</div>

	</div>
</div>

<!-- 미리보기모달 -->
<div id="modal" class="searchModal">
	<div class="search-modal-content">
		<div class="page-header">
			<h1>미리보기</h1>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="row">
					<div class="col-sm-12">
						<h2 id="contents"></h2>
					</div>
				</div>
			</div>
		</div>

		<input type="hidden" id="itempoint" value="20"> 
		<input type="hidden" id="itempoint" value="40"> 
		<input id="buyItem" type="button" class="btn btn-info" value="구입"> 
		<input id="close" type="button" class="btn btn-info" value="닫기">
		<hr>
		<div style="cursor: pointer; background-color: #DDDDDD; text-align: center; padding-bottom: 10px; padding-top: 10px;" onClick="closeModal();">
			<span class="pop_bt modalCloseBtn" style="font-size: 13pt;"></span>
		</div>
	</div>
</div>


























