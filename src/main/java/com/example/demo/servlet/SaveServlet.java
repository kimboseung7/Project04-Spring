package com.example.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * 새로운 회원을 등록하는 서블릿
 * */
@WebServlet(name = "SaveServlet", urlPatterns = "/servlet/save")
public class SaveServlet extends HttpServlet{
	@Autowired
	MemberRepository repository;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		
		String password = req.getParameter("password");
		
		Member member = Member.builder()
				.userId(username).password(password)
				.build();
		Member newMember = repository.save(member);
		
		//응답 메세지 만들기
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		
		PrintWriter w = resp.getWriter();
		w.write("<html>\n" +
                "<body>\n" +
                newMember.getNo() + "번 회원을 등록 했습니다!\n" +
                "</body>\n" +
                "</html>");
	}
	

}
