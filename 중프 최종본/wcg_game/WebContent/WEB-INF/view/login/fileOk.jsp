<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<%
    // ������ ����Ǵ� ���
    String path = request.getSession().getServletContext().getRealPath("../img");

    int size = 1024 * 1024 * 10; // ���尡���� ���� ũ��
    String file = ""; // ���ε� �� ������ �̸�(�̸��� ����ɼ� �ִ�)
    String originalFile = ""; // �̸��� ����Ǳ� �� ���� ���� �̸�

    // ������ ���� ���ε��ϴ� ����
    try{
        MultipartRequest multi = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());

        Enumeration files = multi.getFileNames();
        String str = (String)files.nextElement(); // ���� �̸��� �޾ƿ� string���� ����

        file = multi.getFilesystemName(str); // ���ε� �� ���� �̸� ������
        originalFile = multi.getOriginalFileName(str); // ������ �����̸� ������

    } catch (Exception e) {
        e.printStackTrace();
    }
%>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">alert("�Ϸ�Ǿ����ϴ�")</script>
</body>
</html>