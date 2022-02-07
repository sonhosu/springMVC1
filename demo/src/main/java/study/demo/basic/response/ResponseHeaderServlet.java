package study.demo.basic.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ResponseHeaderServlet", urlPatterns ="/response-header" )
public class ResponseHeaderServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//[status-line]
		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		
		//[response-headers]
		response.setHeader("Content-Type", "text/plain; charset=utf-8");
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("my-header", "hello");
		Cookie cookie = new Cookie("name","good");
		cookie.setMaxAge(600);
		response.addCookie(cookie);
		redirect(response);
		
		
		PrintWriter writer = response.getWriter();
		writer.println("ok");
		
	}
	//redirect 메서드
	private void redirect(HttpServletResponse response) throws IOException {
		 //Status Code 302
		 //Location: /basic/hello-form.html
		 //response.setStatus(HttpServletResponse.SC_FOUND); //302
		 //response.setHeader("Location", "/basic/hello-form.html");
		 response.sendRedirect("/basic/hello-form.html");
		}
}
