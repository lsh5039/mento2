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


@WebServlet("/user/del")
public class UserDelSev extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pk = request.getParameter("pk");
		int intPk = Util.parseToInt(pk, -1);
		if(intPk==-1) {//비정상 진입
			response.sendRedirect("/user/list");
			return;	
		}
		BoardVO vo = new BoardVO();
		vo.setPk(intPk);
		int result = BoardDAO.userDel(vo);//성공시 1, 실패시 0이 반환
		
		if(result == -1) {//잘못된 접근인경우 해당detail페이지로 보내준다.
			RequestDispatcher rd = request.getRequestDispatcher("/detail?pk="+intPk);
			rd.forward(request, response);
			return;
		}
		//정상적인 삭제경로를 이용한경우
		response.sendRedirect("/user/list");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
