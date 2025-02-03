package edu.java.Loop02;

public class LoopMain02 {

	public static void main(String[] args) {
		System.out.println("랜덤 주사위");
		
		// 무한 루프
		// while(true){}
		
		// for(;;){}
		
		// 두 개의 주사위를 던져서 나온 값을 (x, y)와 같은 형식으로 출력
		// 두 개의 주사위가 같은 숫자가 나오면 종료
		int count = 0;
		while(true) {
			count++;
			// random() : 0 <= x < 1 사이의 난수 발생
			double rX = Math.random();
			double rY = Math.random();
			
			int x = (int) (6 * rX + 1);
			int y = (int) (6 * rY + 1);
			
			System.out.println("x : " + x + ", y : " + y);
			if(x == y) {
				System.out.println("같은 수가 나왔습니다.");
				break;
			}
		}
		System.out.println(count + "번 수행");
	} // end main()

} // end LoopMain02
