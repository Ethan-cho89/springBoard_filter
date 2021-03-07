package test.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.dao.BoardDao;
import test.vo.BoardVo;

@WebServlet("/board/list")
public class ListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardDao dao = new BoardDao();
		int maxNum = dao.getMaxNum();
		int count = dao.getCount();
		
		String spageNum= req.getParameter("pageNum");
		
		int pageNum=1;
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}
		int startRow =(pageNum-1)*10+1;
		int endRow = startRow+9;
		
		ArrayList<BoardVo> list = dao.list(startRow, endRow);
		int pageCount = (int)Math.ceil(count/10.0);
		
		int startPageNum=((pageNum-1)/10*10)+1;
		int endPageNum= startPageNum+9;
		if(endPageNum>pageCount) {
			endPageNum=pageCount;
		}
		
		req.setAttribute("list", list);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("startPageNum", startPageNum);
		req.setAttribute("endPageNum", endPageNum);
		req.setAttribute("pageNum", pageNum);
		req.getRequestDispatcher("/board/list.jsp").forward(req, resp);
		
	}
}
