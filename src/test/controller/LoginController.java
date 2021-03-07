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
			req.setAttribute("errMsg", "���̵� �Ǵ� ��й�ȣ�� �߸��Ǿ����ϴ�");
			req.getRequestDispatcher("/member/login.jsp").forward(req, resp);
		}else {
			req.setAttribute("errMsg", "�˼����� ������ �߻��Ǿ����ϴ�. �����ڿ��� �����Ͻʽÿ�");
			req.getRequestDispatcher("/member/login.jsp").forward(req, resp);
		}
	}
}
