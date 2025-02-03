package edu.java.oper05;

// SCE (Short-circuit evaluation: 짧은 계산)
// Lazy Evaluation (게으른 계산)
// - A && B 를 계산할 때 A가 false이면, B를 계산하지 않음
// - A || B 를 계산할 때 A가 true이면, B를 계산하지 않음

public class OperatorMain05 {

	public static void main(String[] args) {
	      System.out.println("계산 규칙 확인");
	      int x = 0;
	      int y = 0;
	      
	      boolean b1 = (x += 10) < 0 && (y += 10) > 0;
	      System.out.println(b1);
	      
	      // x += 10 의 연산 결과 : x = 10
	      // 10 < 0 의 연산 결과 : false
	      // 앞 쪽 연산이 false이므로 y += 10은 계산되지 않음
	      System.out.println("x = " + x);
	      System.out.println("y = " + y);

	}

}
