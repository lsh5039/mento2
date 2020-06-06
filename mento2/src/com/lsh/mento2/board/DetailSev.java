package com.lsh.mento2.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsh.mento2.board.db.BoardDAO;


@WebServlet("/detail")

public class DetailSev extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/board/detail.jsp");
		//어떤녀석을 보여줄지 알려면 이 서블릿이 pk값이 있어야 한다.
		//pk를 받는방법 1. request.getParameter("pk");
		//pk를 받는방법2.request.getAttribute("pk");  --- 얘는 안된다. getAttribute는 setAttribute했을때만 쓴다.
		
		String pk	= request.getParameter("pk");
		
		if(pk != null) {//정상경로 라면 무조건 pk가 널이 아니다.
			int intPk =Util.parseToInt(pk, -1);//String을 int로 파싱
				if(intPk == -1) {//비정상경로 진입자라면  user/list로 보냄
					response.sendRedirect("/user/list");
					return;
				}
			
			request.setAttribute("one", BoardDAO.getOne(intPk));
			rd.forward(request, response);
			return;//리턴을 안하면 아래 로직이 수행되면서 오류가 발생할 수 있다. 무조건 페이지 이동관련해서는 return으로 마무리
		}
		
		//비정상 경로에 대한 예외처리
		response.sendRedirect("/user/list");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
