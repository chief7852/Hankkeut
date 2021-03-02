<%@page import="vo.ShopVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="../shop_js/shop.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="../shop_js/shop.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>
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
</style>


<script>
$(function() {
	readItem();
		
	$('#res').on('click','#showItem',function(){//모달open
	
	 $("#modal").show();
		 selectItem();
	 
	 $("#buyItem").on('click',function(){
		 alert("구입폼");
	 })	 
		 
		$('#close').on('click',function(){//모달hide
			$('#modal').hide();
		})
	})
		
	
})
</script>
</head>
<body>
<div id="res"></div>
	
	<div id="modal" class="searchModal">
		<div class="search-modal-content">
			<div class="page-header">
				<h1>미리보기</h1>
			</div>
			<div class="row">
				<div class="col-sm-12">
				<div class="row">
					<div class="col-sm-12">
						<h2 id="contents" name="oneLine"></h2>
					</div>
				</div>
				</div>
			</div>
			<input id="buyItem" type="button" class="btn btn-info" value="구입">
			<input id="close" type="button" class="btn btn-info" value="닫기">
			<hr>
			<div style="cursor:pointer;background-color:#DDDDDD;text-align: center;padding-bottom: 10px;padding-top: 10px;" onClick="closeModal();">
				<span class="pop_bt modalCloseBtn" style="font-size: 13pt;">
				</span>
			</div>
		</div>
	</div>
 
</body>
</html>




















