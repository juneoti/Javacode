package edu.java.homework01;
/* 
1. 반복문을 사용해서, 'A'부터 'Z'까지 출력하는 프로그램

2. While문과 Math.random() 함수를 이용해서 두 개의 주사위를 던졌을 때 나오는
   눈의 합이 5이면 실행을 멈추고 5가 아니면 주사위를 계속 던지는 코드를 작성
   예시) 합의 5가 나올때까지 아래와 같이 실행
   (1, 3)
   (2, 6)
   (3, 1)
   (4, 1) // 끝

3. 숫자가 1 + (-2) + 3 + (-4) + 5 + ... + n 형태로 더해진다. (n은 값이 정해지지 않았음)
sum = 1 + (-2) + 3 + (-4) + 5 + ... + n 의 값이 100 이상으로 넘어갔을 때의 n의 값과 sum의 값을 출력

4. 다음과 같이 출력하는 프로그램(보너스 문제)
*
**
***
****
*****
*****
 ****
  ***
   **
    *


*/


public class 박정빈_HW1 {

	public static void main(String[] args) {
		
		/*
		//1. 반복문을 사용해서, 'A'부터 'Z'까지 출력하는 프로그램
		*/
		System.out.println("1번 문제 답안");
		for(int i='A'; i<='Z'; i++) {
			System.out.print((char)i + " ");
		}
			
		
		/*
		//2. While문과 Math.random() 함수를 이용해서 두 개의 주사위를 던졌을 때 나오는
   			 눈의 합이 5이면 실행을 멈추고 5가 아니면 주사위를 계속 던지는 코드를 작성
   			 예시) 합의 5가 나올때까지 아래와 같이 실행
   				(1, 3)
   				(2, 6)
   				(3, 1)
   				(4, 1)  끝
		*/
		
		System.out.println("2번 문제 답안");
		int count = 0;
		while(true) {
			count++;
			double rX = Math.random();
			double rY = Math.random();
			
			int x = (int) (6 * rX + 1);
			int y = (int) (6 * rY + 1);
			
			System.out.println("(" + x + ", " + y + ")");
			if((x + y) == 5) {
				System.out.println("두 주사위의 합이 5가 나왔습니다.");
				break;
			}
		}
		System.out.println(count + "번 수행");
		

		/*3. 숫자가 1 + (-2) + 3 + (-4) + 5 + ... + n 형태로 더해진다. (n은 값이 정해지지 않았음)
			 sum = 1 + (-2) + 3 + (-4) + 5 + ... + n 의 값이 100 이상으로 넘어갔을 때의 n의 값과 sum의 값을 출력
		 */
	/*
		System.out.println("3번 문제 답안");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		
		for(int i = 1; i <= n; i++) {
			if(i%2==0){
				sum -= i;
			}
			else {
				sum += i;
			}
			if(sum>=100) {
			System.out.println(sum);
			System.out.println(n);
			}
		}
	*/	
		/*3번 문제 모범 답안*/
		
		System.out.println("3번 문제 답안");
		int n = 1;
		int sum = 0;
		while(true) {
			if(n % 2 == 0) {
			sum = sum - n;
			}
			else {
			sum = sum +n;
			}
			if(sum >= 100) {
				break;
			}
			n++;
		}
		System.out.println("sum = " + sum + ", n = " + n);
		
		
		
		/*4. 다음과 같이 출력하는 프로그램(보너스 문제)
		*
		**
		***
		****
		*****
		*****
		 ****
		  ***
		   **
		    *
		*/
		
		System.out.println("4번 문제 답안"); 
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (i <= j) {
					System.out.print("");
				} 
				else
					System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (i > j) {
					System.out.print(" ");
				} 
				else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	} // end main()

} //end 박정빈_HW1
