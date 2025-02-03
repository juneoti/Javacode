package edu.java.homework01;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	/*
    	// 단순 반복문 1287 코드업 문제 풀이
    	Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		if(num>=1 && num<=9){
			int sum;
		    for(int i = 1; i<=9; i++){
		    	sum = i*num;
		    for(int j = 1; j<=sum;j++){
		    	System.out.printf("*");
		            }
		    	System.out.println("");
		        }
		 }
		else {
			System.out.println("1~9 사이의 숫자만 가능합니다.");
		}
		*/
    	
    	/*
    	// 중첩 반복문 1369 코드업 문제 풀이
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int k = sc.nextInt();
    	
    	   for(int i = 1; i <= n; i++){
    	        
    	        for(int j = 1; j <= n; j++){
    	            if((i == 1)||(j == 1)||(i == n)||(j == n)){
    	                System.out.printf("*");
    	            }
    	                else if (k == 1){
        	                System.out.printf("*");
        	          
    	            }
    	            else if((i + j)%k == 1){
    	                System.out.printf("*");
    	            }
    	            else{
    	                System.out.printf(" ");
    	            }
    	        }
    	        System.out.println("");
    	   }
    	   
    	  sc.close();
    	  */
    	// 1차원 배열 1093 코드업 문제 풀이
    	// 학생 번호 부른 횟수 저장용 배열
    	/*
    	Scanner sc = new Scanner(System.in);
    	int[] num = new int[24];
    	int n = sc.nextInt();
    	for(int i = 1; i <= n; i++) {
    		int a = sc.nextInt();
    		num[a]++;
    	}
    	for(int j = 1; j<=23;j++) {
    		System.out.print(num[j]+ " ");
    	}
    	sc.close();
    	*/
    	
    	//1차원 배열 1095 코드업 문제 풀이
    	/*
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int min = Integer.MAX_VALUE;
    	
    	for (int i = 1; i <= n; i++) {
    		int a = sc.nextInt();
    		if(min > a) {
    			min = a;
    		}
    	}
    	System.out.println(min);
    	*/
    	/*
    	//1차원 배열 1402 코드업 문제 풀이
    	 Scanner sc = new Scanner(System.in);
         int x = sc.nextInt();
         int[] n = new int[x];

         for (int i = 0; i < n.length; i++) {
             n[i] = sc.nextInt();
         }

         for (int i = n.length; i >= 1; i--) {
             System.out.print(n[i - 1] + " ");
         }
		*/
    	//1차원 배열 1405 코드업 문제 풀이
    	Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int[] n = new int[x];
        
        for (int i = 0; i < x; i++) {
            n[i] = sc.nextInt();
        }
        
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print(n[(i + j) % x] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}

