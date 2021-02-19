<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberList페이지</title>
</head>
<body>
	<h2>회원 목록 보기</h2>
	<table border="1">
		<thead>
			<tr>
				<td colspan="4">
					<input type="button" id="addBtn" value="회원추가">
				</td>
			</tr>
			<tr>
				<th>ID</th><th>이름</th><th>전화번호</th><th>주소</th>
			</tr>
		</thead>
		
		<tbody>
			<%
				//서블릿에서 보내온 데이터를 출력한다.
				List<MemberVO> memList = (List<MemberVO>)request.getAttribute("memList");
			
				if(memList==null || memList.size()==0){
			%>
				<tr><td colspan="4">회원이 하나도 없습니다.</td></tr>
			<%
				}else{
					for(MemberVO mvo : memList){
			%>
				<tr>
					<td><%=mvo.getMem_id() %></td>
					<td><%=mvo.getMem_name() %></td>
					<td><%=mvo.getMem_tel() %></td>
					<td><%=mvo.getMem_addr() %></td>				
				</tr>
			<%
					}
				}
			%>
			
		</tbody>
	</table>
</body>
</html>