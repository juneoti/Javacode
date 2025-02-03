package edu.java.homework;


public class MemberService {
	public boolean login(String id, String pw) {
		// id, pw는 주소값이 전송됨
		// id == "test" : 주소값 비교
		// id.equals("test") : 실제 데이터 비교
		if(id.equals("test") && pw.equals("1234")) {
			return true;
		}
		return false;
	}
	public boolean logout(String id) {
		if(id == "test"){
			System.out.println(id + "님이 로그아웃 되었습니다");
			return true;
		}
		return false;
	}

}
