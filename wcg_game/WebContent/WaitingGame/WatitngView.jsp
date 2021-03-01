<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 550px}
    
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
  </div>
</nav>

<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-3 sidenav hidden-xs">
      <h2>한끝</h2>
      <ul class="nav nav-pills nav-stacked">
        <li class="active"><a id="myChShow" href="#section1">내 캐릭터 이미지 출력</a></li>
        <li><a href="../inventoryMain/main.jsp">내 인벤토리 보기</a></li>
      </ul><br>
    </div>
    <br>
    
    <div class="col-sm-9">
        <div class="col-sm-3">
          <div class="well">
            <h4>방이름</h4>
            <p>방제목</p> 
          </div>
        </div>
        <div class="col-sm-3">
          <div class="well">
            <h4>빈방</h4>
           <p>방을 생성해 주세요</p>
          </div>
        </div>
        <div class="col-sm-3">
          <div class="well">
            <h4>빈방</h4>
           <p>방을 생성해 주세요</p>
          </div>
        </div>
        <div class="col-sm-3">
          <div class="well">
            <h4>빈방</h4>
          <p>방을 생성해 주세요</p>
          </div>
        </div>
         <div class="col-sm-3">
          <div class="well">
            <h4>빈방</h4>
           <p>방을 생성해 주세요</p>
          </div>
        </div>
        <div class="col-sm-3">
          <div class="well">
            <h4>빈방</h4>
           <p>방을 생성해 주세요</p>
          </div>
        </div>
        <div class="col-sm-3">
          <div class="well">
            <h4>빈방</h4>
            <p>방을 생성해 주세요</p>
          </div>
        </div>
        <div class="col-sm-3">
          <div class="well">
            <h4>빈방</h4>
            <p>방을 생성해 주세요</p>
          </div>
        </div>
           <div class="col-sm-3">
          <div class="well">
            <h4>빈방</h4>
          <p>방을 생성해 주세요</p>
          </div>
        </div>
           <div class="col-sm-3">
          <div class="well">
            <h4>빈방</h4>
           <p>방을 생성해 주세요</p>
          </div>
        </div>
           <div class="col-sm-3">
          <div class="well">
            <h4>빈방</h4>
            <p>방을 생성해 주세요</p>
          </div>
        </div>
         <div class="col-sm-3">
          <div class="well">
            <h4>빈방</h4>
            <p>방을 생성해 주세요</p>
          </div>
        </div>
      </div>
    </div>
  </div>