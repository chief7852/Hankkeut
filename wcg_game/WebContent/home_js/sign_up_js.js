chk :$(function () {

	$("#pressDownButton").on("submit", function(){
		var memId = $("#id").val();
		var idChk = $("#idspan").html().trim();
		
		if(chkMemId != memId || idChk!="사용가능ID"){
			alert("ID가 중복됩니다. 새로운 ID를 입력하세요.");
			return false;	// 서버로 전송을 취소한다.
		}
		return true;
	});
	
	
	$('#mail').on('change', function(){
		if($(this).val()=='none'){
			$('#goalbang').replaceWith
			( '<div class="col-sm-3"><input type="text" class="form-control" id="mail"></div>' );
			
		}
	})	

	
    $('#idbtn').on('click', function () {
        idvalue = $('#id').val().trim();

        if (idvalue.length < 1) {
            alert("아이디 입력하세요");
            return false;
        }

        $.ajax({
            url: '/wcggame/ID.do',
            type: 'post',
            data: {
                "id": idvalue
            },
            success: function (res) {
		      var result = $('#idspan').html(res.sw);
		      if(result == "사용불가능한 아이디"){	
		      	$('#idspan').html().empty();
                $('#idspan').html(res.sw).css('color', 'red').css();
		      }else{		      
                $('#idspan').html().empty();
                $('#idspan').html(res.sw).css('color', 'green').css();
		      }
            },
            error: function (xhr) {
                alert("상태 : " + xhr.status);
            },

            dataType: 'json'
        })

    })
    //우편번호 검색 - window
    $('#wzipbtn').on('click', function () {
        // 새로운 창열기
        window.open('zipsearch.html', '_blank', "width=500 height=400");

    })

    //우편번호 검색 - modal = 별동의 이벤트 핸들러 없음
    //<button id="mzipbtn" data-toggle="modal" data-target="#myModal"
    //class="btn btn-success" type="button">번호검색(modal)</button>

    //우편번호 modal에서  동 입력후 확인버튼 클릭 이벤트
    $('#dongbtn').on('click', function () {
        //입력한 값 가져오기
        dongvalue = $('#dong').val().trim();

        //서버로전송(요청)
        $.ajax({
            url: '/member/DongSearch.do',
            data: {
                "dong": dongvalue
            },
            type: 'post',
            success: function (res) {

                code = "<table class='table table-bordered'>";
                code += "<tr><td>우편번호</td><td>주소</td>";
                code += "<td>번지</td></tr>";

                $.each(res, function (i, v) {
                    code += "<tr class='ziptr'><td>" + v.code + "</td>";
                    code += "<td>" + v.addr + "</td>";
                    code += "<td>" + v.bunji + "</td></tr>";
                })
                code += "</table>";

                $('#result1').html(code);
            },
            error: function (xhr) {
                alert("상태 : " + xhr.status); //200(응답은성공,형식잘못), 404(pass잘못쓴거), 403
            },
            dataType: 'json'
        })
    })

    //modal결과에서 원하는 행(주소)를 선택했을때 이벤트
    //동적으로 새롭게 생성된 요소 - delegate방식
    $('#result1').on('click', '.ziptr', function () {
        zipcode = $('td:eq(0)', this).text();
        addr = $('td:eq(1)', this).text();

        //폼에 출력
        $('#zip').val(zipcode);
        $('#add1').val(addr);
        //모달창닫기
        $('#myModal').modal('hide');
        //모달창 내용 지우기
        $('#dong').val("");
        $('#result1').empty();
    })


    //제출버튼 클릭 이벤트


    $('#signUp').on('submit', function () {
        //submit의 고유 기능을 방지 한다
        event.preventDefault();
		emailback = $('#mail').val().trim();
		emailfront = $('#email').val().trim();
		$('#email').val(emailfront + emailback);
		console.log($('#signUp').serializeJSON());
        $.ajax({
            url: '/wcggame/insertMember.do',
            method: 'post',
            data: $('#signUp').serializeJSON(),
            success: function (res) {
                alert("회원가입 되었습니다.");
                window.location.href = "../home_main/index.html";

            },
            error: function (xhr) {
                alert("상태 : " + xhr.status);
            },
            dataType: 'json'
        })
    })



// 모든 버튼 css 이벤트

	$('#idbtn').on('click', function(){
			idval = $('#id').val().trim();
				if (idval.length < 1) {
						$(this).css("-webkit-animation",
									"bounce-top 0.9s both").css(
									"animation", "bounce-top 0.9s both");
		}
	})
	
// 정규식
// 아이디
	$(function() {
		$('#id').on('keyup', function() {

			idvalue = $('#id').val().trim();

			//형식
			re2 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z]$)/
		
			//비교 test() : true 또는 false를 리턴
			if (re2.test(idvalue)) {
			okpro(this);
			} else {
				nopro(this);
			}

		})
	})

	function okpro(vinput) {
		$(vinput).parents('.form-group').find('#id').css('border-color', 'green');
				


	}
	function nopro(vinput) {
		$(vinput).parents('.form-group').find('#id').css('border-color', 'red');

	}
	
	$('#pwd').on('keyup', function(){
		 emailPattern = /^[0-9a-zA-Z]$/
		 pwd1 = $('#pwd').val().trim();
		 /*if()*/
	})
	$('#pwd2').on('keyup', function(){
		 
		 pwd1 = $('#pwd').val().trim();
		 pwd2 = $('#pwd2').val().trim();
		 
	})
})