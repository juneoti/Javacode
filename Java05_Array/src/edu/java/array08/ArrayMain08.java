package edu.java.array08;

public class ArrayMain08 {

	public static void main(String[] args) {
		System.out.println("2차원 배열");
		
		// 2차원 배열 : 1차원 배열을 원소로 갖는 배열
		int[] korean = {10, 20, 30}; // 1차원 배열
		int[] english = {40, 50 , 60}; // 1차원 배열
		
		int[][] scores = {
				korean,
				english
		}; // 2 x 3인 2차원 배열
		
		System.out.println(scores[1][1]); // 1층 1호 or i = 1, j = 1
		System.out.println(scores[0][2]); // 0층 2호 or i = 0, j = 2
		System.out.println("1의 길이(개수) : " + scores.length);
		System.out.println("i가 0일때 j의 길이(개수) : " + scores[0].length);
		
		// 2차원 배열의 모든 값 출력
		for (int i = 0; i < scores.length; i++) { // i 만큼 반복
			for (int j = 0; j < scores[i].length;j++) {
				System.out.print(scores[i][j]+" ");
			}
			System.out.println();
		}

	}

}
