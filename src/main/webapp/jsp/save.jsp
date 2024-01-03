<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="com.example.demo.repository.MemberRepository" %>
<%@ page import="com.example.demo.entity.Member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    // WebApplicationContext를 가져옵니다.
    WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(application);
    
    // 컨텍스트를 통해 MemberRepository 빈을 가져옵니다.
    MemberRepository repository = ctx.getBean(MemberRepository.class);
    
    // 요청으로부터 사용자 이름과 비밀번호를 가져옵니다.
    String username = request.getParameter("username");
    String password = request.getParameter("password");  
    
    // Member 엔티티를 생성합니다.
    Member member = Member.builder().userId(username).password(password).build();
    
    // 레포지토리를 사용하여 회원 정보를 저장합니다.
    Member newMember = repository.save(member);
%>

<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
    <p>
        <%= newMember.getNo() %> 번 회원을 등록 했습니다!
    </p>
</body>
</html>