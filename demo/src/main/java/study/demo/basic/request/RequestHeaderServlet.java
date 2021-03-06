package study.demo.basic.request;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name=" requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method=req.getMethod();
		String pro=req.getProtocol();
		String scheme=req.getScheme();
		String queryString= req.getQueryString();
		Cookie[] cookie= req.getCookies();
		HttpSession session= req.getSession();
		Locale locale= req.getLocale();
		
		System.out.println("method=="+method);
		System.out.println("protocal=="+pro);
		System.out.println("scheme=="+scheme);
		System.out.println("queryString=="+queryString);
		System.out.println("cookie=="+cookie);
		System.out.println("session=="+session);
		System.out.println("Locale=="+locale);
		

	}

	
}
