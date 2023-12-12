package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.MemberVO;
import service.MemberService;
import service.MemberServiceImpl;


@WebServlet("/memb/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(MemberController.class);
    private RequestDispatcher rdp;
    private String destpage;
    private MemberService msv;
    private int ok;
    
    public MemberController() {
    	msv = new MemberServiceImpl();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/")+1);
		
//		가입, 로그인, 회원리스트, 회원정보, 회원수정, 회원탈퇴
		switch (path) {
		case "join" :
			destpage = "/Member/join.jsp";
			break;
		case "register" :
			try {
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				String email = request.getParameter("email");
				int age = Integer.parseInt(request.getParameter("age"));
				MemberVO mvo = new MemberVO(id, pwd, email, age);
				ok = msv.register(mvo);
				destpage = "/index.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				log.info("register ERROR");
			}

			break;
		case "login" :
			try {
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				MemberVO mvo = new MemberVO(id, pwd);
				MemberVO loginMvo = msv.login(mvo);
			
				if(loginMvo!=null) {
					HttpSession ses = request.getSession();
					ses.setAttribute("ses", loginMvo);
					request.setAttribute("login", "true");
				}else {
					request.setAttribute("login", "false");

				}
				destpage = "/index.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				log.info("login ERROR");
			}
			break;
		case "list":
			try {
				List<MemberVO> list = msv.getList();
				request.setAttribute("list", list);
				destpage = "/Member/list.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				log.info("list ERROR");
			}
			break;
		case "move":
			destpage="/Member/detail.jsp";
			break;
		case "detail":
			try {
				HttpSession ses = request.getSession();
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				String email = request.getParameter("email");
				int age = Integer.parseInt(request.getParameter("age"));
				MemberVO mvo = new MemberVO(id, pwd, email, age);
				ok = msv.modify(mvo);
				
				if(ok>0) {
					ses.invalidate();
					destpage="/index.jsp";
					request.setAttribute("modify", "true");
				}else {
					request.setAttribute("modify", "false");

				}
			} catch (Exception e) {
				e.printStackTrace();
				log.info("detail ERROR");
			}
			
			break;
		case "remove":
			try {
				HttpSession ses = request.getSession();
				String id = request.getParameter("id");
				ok = msv.remove(id);
				if(ok>0) {
					ses.invalidate();
					request.setAttribute("remove", "true");
					destpage="/index.jsp";
				}else {
					request.setAttribute("remove", "false");

				}
			} catch (Exception e) {
				e.printStackTrace();
				log.info("remove ERROR");
			}
			break;
		case "logout":
			try {
				HttpSession ses= request.getSession();
				MemberVO mvo = (MemberVO)ses.getAttribute("ses");
				
				ok = msv.logout(mvo.getId());
				if(ok>0) {
					ses.invalidate();
					destpage="/index.jsp";
					request.setAttribute("logout", "true");
				}else {
					request.setAttribute("logout", "false");

				}
				
			} catch (Exception e) {
				e.printStackTrace();
				log.info("logout ERROR");
			}
			break;
	
		}
			
		
		
		
		rdp = request.getRequestDispatcher(destpage);
		rdp.forward(request, response); //요청에 필요한 객체를 가지고 destPage 경로로 전송
	}

	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
