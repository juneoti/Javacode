package edu.java.Loop01;

public class LoopMain01 {

	public static void main(String[] args) {
		System.out.println("break");
		// break 키워드
		// 반복문(for, while, do-while) 안에서 break를 만나면
		// break가 있는 위치에서 가장 가까운 곳(포함하는 곳)의 반복문을 종료
		
		for(int i = 1; i <= 10; i++) {
			System.out.println(i);
			//i == 5인 경우 반복문 종
			if(i == 5) {
				break;
			}
		}
		
		System.out.println();
		
		for(int i = 2; i <= 9; i++) {
			for(int j = 1; j <= 9; j++) {
				System.out.println(i + " X " + j + " = " + i * j);
				if(j ==5) {
					break;
				}
			}
		}
		
		//continue 키워드
		// - 반복문 안에서 continue 키워드를 만나면
		// 반복문의 시작점으로 돌아감
		for(int i = 1; i <= 10; i++) {
			if(i == 5) {
				continue;
			}
			System.out.print(i + " ");
		}
	} // end main()

} // end LookMain01
