package edu.java.array03;
import java.util.Scanner;
public class ArrayMain03 {

	public static void main(String[] args) {
		System.out.println("배열 연습");
		
		//n명의 학생 점수를 입력받아서
		//총합, 평균, 최대값, 최소값 출력
		// Ctrl + Shift + o : 자동 import 단축키
		/*
		Scanner sc = new Scanner(System.in);
		System.out.println("학생 수 입력");		
		int x = sc.nextInt();
				int[] score = new int[x];
		for(int i = 0; i < score.length; i++) {
			System.out.println((i+1)+"번 학생 점수 입력");
			score[i] = sc.nextInt();
		}
		int sum = 0;
		int avg = 0;
		int max = score[0];
		int min = score[0];
		
		for(int i=0; i<score.length; i++) {
			sum += score[i];
	        if(score[i] < min) {
	        	min = score[i];
	        	
	        }
	        if(score[i] > max) {
	        	max = score[i];
	        }
			
		}
		double avg = ((double)sum) / score.length;
		System.out.println("총합 = " + sum);
		System.out.println("평균 = " + avg);
	    System.out.println("최소값 = " + min);
	    System.out.println("최대값 = " + max);
	  
		*/
		Scanner sc = new Scanner(System.in);
		
		System.out.println("학생 수 입력");		
		int n = sc.nextInt();
		int[] scores = new int[n];
		
		// n명의 점수 입력
		for(int i = 0; i < scores.length; i++) {
			System.out.println("학생[" + i + "] 점수 입력>");
			scores[i] = sc.nextInt();
		}	
		// n명의 점수 출력
		for(int i = 0; i < scores.length; i++){
			System.out.printf("scores[%d] = %d\n", i, scores[i]);
		}
		
		// n명의 점수 합
		int sum = 0;
		for(int i = 0; i < scores.length; i++) {
			sum += scores[i];
		}
		System.out.println("합계 = " + sum);
		
		// 평균 출력
		double avg = ((double)sum) / n;
		System.out.println("평균 = " + avg);
		
		//n명의 점수 중 최대값 출력
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < scores.length; i++) {
			if(scores[i] > max) {
				max = scores[i];
			}
		}
		System.out.println("최대값 = " + max);
		
		//n명의 점수 중 최소값 출력
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < scores.length; i++) {
			if(scores[i] < min) {
				min = scores[i];
			}
		}
		System.out.println("최소값 = " + min);
		sc.close();
	}
}

