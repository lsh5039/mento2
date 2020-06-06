package com.lsh.mento2.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsh.mento2.board.db.BoardDAO;
import com.lsh.mento2.board.vo.BoardVO;


@WebServlet("/user/upd")
public class UserUpdSev extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	//수정하러가기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pk = request.getParameter("pk");
		int intpk = Util.parseToInt(pk, -1);
		if(intpk == -1) {//비정상 경로라면
			RequestDispatcher rd = request.getRequestDispatcher("/detail?pk="+intpk);
			rd.forward(request, response);
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/board/update.jsp");
			
		request.setAttribute("one", BoardDAO.getOne(intpk));
		
		
		rd.forward(request, response);
		
	}

	//실제로 수정이 적
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pk = request.getParameter("pk");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		int intPk = Util.parseToInt(pk, -1);
				
		BoardVO vo = new BoardVO();
		
		vo.setPk(intPk);
		vo.setPw(pw);
		vo.setName(name);
		vo.setId(id);
		
		
		BoardDAO.userUpd(vo);//변경하고
		
		response.sendRedirect("/user/list");
		
		
		
		
	}

}
