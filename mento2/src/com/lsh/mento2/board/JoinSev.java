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

@WebServlet("/board/join/page")
public class JoinSev extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/board/join.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DAO안에 메서드를 호출
		
		request.setCharacterEncoding("UTF-8");//이거는 잘 되는분은 적지마세요!!!! post타임의 utf8지정
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		System.out.println("id :"+id);
		System.out.println("pw :"+pw);
		System.out.println("name :"+name);
		
		BoardVO vo = new BoardVO();
		//값을 넣는방식은 2가지뿐이다. 메서드와 생성자 그중 메서드 이용
		vo.setId(id);
		vo.setPw(pw);
		vo.setName(name);

		
		
		BoardDAO.joinUser(vo);
		response.sendRedirect("/user/list");
		//mvc 패턴 젤 상용화 되어있다.
		//m : model 
		//v : view 보이는 곳
		//c : controller 서블릿
		
		/* 1. board폴더 밑에 write.jsp를 만든다.
		 * 2. write.jsp를 연결할 서블릿을 만든다.(서블릿 이름자유, 주소값만 : /write)
		 * 3. get방식으로 연결시키기  
		 *     15분 시작할게요(다하신분은 쉬다가 다시 어이서 합시다.! 중간중간에 오류제거한다고 다들쉬었으니 오늘 쉬는시간은 이렇게 짧게 할게요 ㅠㅠ)
		 *         --------성공한 분은 채팅으로 했다고 쳐주세요-----------------
		 *         ----------404 NOT found는 오류중에 난이도 최하의 에러이므로 익히고 가야합니다.-------------
		 *  */
		
		
		
	}

}
