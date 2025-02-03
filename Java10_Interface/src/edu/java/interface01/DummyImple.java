package edu.java.interface01;

// 예) 테스트 팀에서 임시 테스트용으로 사용
public class DummyImple implements DataBaseQuery{

	@Override
	public int insert(String id, String pw) {
		// MySQL로 코드 작성
		return 0;
	}

}
