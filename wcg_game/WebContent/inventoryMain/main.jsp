<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="../inventory_js/jquery.serializejson.min.js"></script>
  <script src="../character_js/character.js"></script>
  <script sir =></script>
  <script>
     $(function(){
        
        id = ""; //캐릭터 아이디 담을 변수
        aa="1";
        char_nickname = "";  //캐릭터 닉네임 담을 변수(BuyItemINInvettorySelectAll)실행예정
        
        selectId("issac");
        
        
        
        
     })
  </script>
  <style>
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 550px}Q
    
    /* Set gray background color and 100% height */
    .sidenav {
      background-color: #f1f1f1;
      height: 100%;
    }
        
    /* On small screens, set height to 'auto' for the grid */
    @media screen and (max-width: 767px) {
      .row.content {height: auto;} 
    }
  </style>
</head>
<body>

<nav class="navbar navbar-inverse visible-xs">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Logo</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
      </ul>
    </div>
  </div>
</nav>

<div class="container-fluid">
  <div  class="row content">
    <div class="col-sm-3 sidenav hidden-xs">
      <h2 >캐릭터 닉네임 불러오기</h2>
      <ul class="nav nav-pills nav-stacked">
        <li class="active"><a id="selectNickName" href="#section1">캐릭터 닉네임</a></li>
      </ul><br>
      
       <ul id = "point" class="nav nav-pills nav-stacked">
        <li class="active"><a id="myChShow"href="#section1">캐릭터이미지불러오기</a></li>
      </ul><br>
      
    </div>
    <br>
    
    <div class="col-sm-9">
      <div class="well">
        <h4>이벤토리</h4>
        <p>내 인벤토리 창 입니다</p>
      </div>
      
      <div id="showItem">
      
       <!-- <div class="row">
        <div class="col-sm-3">
          <div class="well">
            <h4>아이템1</h4>
            <p id="show1" class="showclass">이미지출력자리</p>
            <button type="button" class="btn btn-info">착용</button>
          </div>
        </div>
        </div> -->
        
       </div>
      </div> 
      <div class="row">
        <div class="col-sm-8">
          <div class="well">
            <p>현재 포인트</p> 
            <p id="MyPOINT"></p> 
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

</body>
</html>