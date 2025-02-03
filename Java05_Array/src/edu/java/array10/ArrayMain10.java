package edu.java.array10;

public class ArrayMain10 {

	public static void main(String[] args) {
	      int[] arr = {1, 9, 6, 7, 3, 5, 1};
	      
	      for(int i = 0; i < arr.length - 1; i++) {
	         int min = arr[i];
	         int least = i;
	         int tmp = 0;
	         for(int j = i + 1; j < arr.length; j++) {
	            if(arr[j] < min) {
	               min = arr[j];
	               least = j;
	            }
	         }
	         
	         tmp = arr[i];
	         arr[i] = arr[least];
	         arr[least] = tmp;
	         
	      }
	      
	      for(int i = 0; i < arr.length; i++) {
	         System.out.println(arr[i]);
	      }


	}

}
