package com.lsh.mento2.board;

public class Util {
	//str이 파싱이되면 str값을 파싱해 리턴 ex) "1","2" 형태
	//str이 파싱불가하면 int set값을 리턴  "rksekk" 등 형태
	public static int parseToInt(String str, int set) {
		int result=-1;
		
		try {
			result = Integer.parseInt(str);//이게 안된다면(파싱불가라면)
		}catch(Exception e) {
			result = set;// set값을 셋팅
		}
		return result;
	}
	
}
