package test.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.dao.MyUsersDao;

@WebServlet("/member/login")
public class LoginController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect(req.getContextPath()+"/member/login.jsp");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		MyUsersDao dao = MyUsersDao.getInstance();
		int n = dao.isUser(id, pwd);
		HttpSession session = req.getSession();
		if(n>0) {
			session.setAttribute("id", id);
			resp.sendRedirect(req.getContextPath()+"/main.jsp");
		}else if(n==0){
			req.setAttribute("errMsg", "아이디 또는 비밀번호가 잘못되었습니다");
			req.getRequestDispatcher("/member/login.jsp").forward(req, resp);
		}else {
			req.setAttribute("errMsg", "알수없는 오류가 발생되었습니다. 관리자에게 문의하십시오");
			req.getRequestDispatcher("/member/login.jsp").forward(req, resp);
		}
	}
}
