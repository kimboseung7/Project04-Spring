package com.example.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * 사용자에게 회원가입 페이지를 보내주는 서블릿
 * */
@WebServlet(name = "FormServlet", urlPatterns = "/servlet/form")

@ServletComponentScan
@SpringBootApplication
public class FormServLet extends HttpServlet {
		

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//재정의를 함
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		PrintWriter w = resp.getWriter();
		 w.write("<!DOCTYPE html>\n" +
	                "<html>\n" +
	                "<body>\n" +
	                "<form action=\"/servlet/save\" method=\"post\">\n" +
	                "    이름: <input type=\"text\" name=\"username\" />\n" +
	                "    암호: <input type=\"text\" name=\"password\" />\n" +
	                "    <button type=\"submit\">전송</button>\n" +
	                "</form>\n" +
	                "</body>\n" +
	                "</html>\n");
	   
		
	}

}
