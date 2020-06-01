package com.lsh.mento2.board.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lsh.mento2.board.vo.BoardVO;
import com.lsh.mento2.db.Conn;

public class BoardDAO {
	//db관련 메서드를 작성하는 곳
	
	//가입 메서드
	public static void joinUser(BoardVO param) {
		Connection con = null;//db연결용
		PreparedStatement ps = null;//연결된 db에 sql 실행용
		String sql = "insert into user2(id,pw,name) values(?,?,?)";
		
		try {
			con = Conn.getCon();//db연결
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getId());
			ps.setString(2, param.getPw());
			ps.setString(3, param.getName());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}finally {
			Conn.close(con, ps);
			
		}	
	}
	//모든 회원 select 메서드
	//select 에는 무조건 ResultSet을 사용한다.
	//*************어렵다.. 자바기초가 부족하면 이해가 안되니 그냥 외우세요!!!!
	//BoardVO를 리턴	할건데 하나만 할게 아니라 .모든 BoardVO 담을 List 리턴할거다.
	public static List<BoardVO> getList(){
		List<BoardVO> list = new ArrayList<BoardVO>();//리스트 선언
		Connection con = null;//연결용
		PreparedStatement ps = null;//sql 실해용
		ResultSet rs = null;//select에 사용한다. 투플(행) 리턴용
		String sql = "select * from user2";
		try {
			con = Conn.getCon();//db연결하고
			ps = con.prepareStatement(sql);//sql 실행
			rs = ps.executeQuery();//rs는 쿼리결과로 받아노는 db상의 객체(투플, 행)
			
			while(rs.next()) {//리턴된 행이 있다면 ? == 쿼리문(sql)문이 참(true)라면
				BoardVO vo = new BoardVO();
				vo.setPk(rs.getInt("pk")); 
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("name"));
				
				//vo는 pk, id, pw, name이 셋팅이될꺼에요
				//그 세팅된거를 list 에 넣는거에요!
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Conn.close(con, ps, rs);
		}
		return list;
		
	}
	
	//단권조회, 특정 유저 1명의 정보만 리턴받는 메서드
	public static BoardVO getOne(int pk) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from user2 where pk = ? ";
		BoardVO vo = new BoardVO();//담을 그릇을 만든다.
		
		try {
			con = Conn.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, pk);
			rs = ps.executeQuery();
			if(rs.next()) {//그릇에 값 셋팅
				vo.setPk(rs.getInt("pk"));
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("name"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Conn.close(con, ps, rs);
		}
		return vo;//그릇 리턴
	}
}
