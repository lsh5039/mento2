package com.lsh.mento2.db;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDAO {
	public static void join(String id, String pw) {
		Connection con = null;//db연결용
		PreparedStatement ps = null;//sql실행용
		String sql = "insert into user(id, pw) values(?,?)";//실행 할 sql
		
		try {
			con = Conn.getCon();//db연결완료
			ps = con.prepareStatement(sql);//sql매핑
			ps.setString(1, id);
			ps.setString(2, pw);
			ps.executeUpdate();//sql실행 하기
		} catch (Exception e) {
			System.out.println("sql명령 실패!");
			e.printStackTrace();
		}finally {
			Conn.close(con, ps, null);
		}
		
	}
}
