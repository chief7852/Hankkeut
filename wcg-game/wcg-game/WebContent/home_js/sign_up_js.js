chk :$(function () {
    $('#idbtn').on('click', function () {
        idvalue = $('#id').val().trim();

        if (idvalue.length < 1) {
            alert("아이디 입력하세요");
            return false;
        }

        $.ajax({
            url: '/member/ID.do',
            type: 'post',
            data: {
                "id": idvalue
            },
            success: function (res) {
                $('#idspan').html(res.sw).css('color', 'red').css();
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
    /* $('button[type:submit]').on('click', function() {})
    $('button:submit').on('click', function(){}) */

    $('#ff').on('submit', function () {
        //submit의 고유 기능을 방지 한다
        event.preventDefault();

        /* //입력한 모든값(9개)을 가져온다 - val()
        idvalue = $('#id').val().trim();
        namevalue = $('#name').val().trim();
        passvalue = $('#pwd').val().trim();
        emailvalue = $('#email').val().trim();
        hpvalue = $('#hp').val().trim();
        birvalue = $('#bir').val().trim();
        zipvalue = $('#zip').val().trim();
        add1value = $('#add1').val().trim();
        add2value = $('#add2').val().trim();
        
        datas = {"mem_id" : idvalue,"mem_name" : namevalue,
        		"mem_pass" : passvalue,"mem_email" : emailvalue,
        		"mem_hp" : hpvalue,"mem_bir" : birvalue,
        		"mem_zip" : zipvalue,"mem_add1" : add1value,
        		"mem_add2" : add2value}
        
        console.log(datas);
        datas = "mem_id=" + idvalue+ "&mem_name=" + namevalue+
        "&mem_pass=" + passvalue+"&mem_email=" + emailvalue+
        "&mem_hp=" + hpvalue+"&mem_bir=" + birvalue+
        "&mem_zip=" + zipvalue+"&mem_add1=" + add1value+
        "&mem_add2=" + add2value;
        console.log(datas); */

        /* console.log($('#ff').serialize())
        console.log($('#ff').serializeArray())*/
        console.log($('#ff').serializeJSON()) 
        $.ajax({
            url: '/wcg-game/insertMember.do',
            method: 'post',
            data: $('#ff').serializeJSON(),
            success: function (res) {
                alert("안되냐? : ");
            },
            error: function (xhr) {
                alert("상태 : " + xhr.status);
            },
            dataType: 'json'
        })
    })

})
