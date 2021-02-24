<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


	<div class="container">
		<ul class="nav nav-tabs nav-justified">
			<li id="Setting">
				<button type="button" class="btn btn-info btn-lg"
					data-toggle="modal" data-target="#setting">
					<span class="material-icons">build</span>
				</button>
			</li>
			<li>
				<button type="button" class="btn btn-info btn-lg"
					data-toggle="modal" data-target="#friend">
					<span class="material-icons">face</span>
				</button>
			</li>
			<li class="active li_width"><a data-toggle="tab" href="#waiting">대기실</a></li>
			<li class="li_width"><a data-toggle="modal" href="#createRoom">방 만들기</a></li>
			<li id="shop" class="li_width"><a data-toggle="tab" href="../shop/shop.html">상점</a></li>
			<li class="li_width"><a data-toggle="tab" href="#rank">랭킹</a></li>
		</ul>
	</div>
