package edu.java.homework01;

public class 박정빈_HW2 {
	
	public static void main(String[] args) {
		//과제1: 답안
		int[] arr = new int[5];
		arr[0] = 6;
		arr[1] = 8;
		arr[2] = 4;
		arr[3] = 2;
		arr[4] = 5;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		System.out.println("최대값 = " + max);
		System.out.println();
		
		//과제2: 답안
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		double avg = ((double)sum) / arr.length;
		System.out.println("총합 = " + sum);
		System.out.println("평균 = " + avg);
		System.out.println();
		
		//과제3: 답안
		int[]fibSeq = new int[20];
		for(int i = 0; i < fibSeq.length; i++) {
			if(i == 0) {
				fibSeq[i] = 1;
			}else if(i == 1) {
				fibSeq[i] = 1;
			}else if(i >= 2) {
				fibSeq[i] = fibSeq[i-1] + fibSeq[i-2];
			}
		System.out.println(fibSeq[i]);
		}
		System.out.println();
		
		//과제4: 답안
		Integer[][] array = {
				{95, 86}, 
				{44, 22, 96}, 
				{78, 83, 93, 87, 88}
		};
		int total = 0;
		double avg2 = 0;
		int arrayLength = 0;
		int max2 = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++){
			arrayLength += array[i].length;
			for (int j = 0; j < array[i].length; j++) {
			            total += array[i][j];
			            if (max2 < array[i][j]) {
			            	max2 = array[i][j];
			            }
						}
			}
		avg2 = ((double)total) / arrayLength;
		System.out.println("총합: " + total);
		System.out.println("평균: " + avg2);
		System.out.println("최대값: " + max2);
	}

}

