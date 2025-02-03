package edu.java.wrapper02;

public class WrapperMain02 {

   public static void main(String[] args) {
      Integer x = 100; // boxing(포장)
      Integer y = 200; 
      
      int add = x.intValue() + y.intValue(); // unboxing
      System.out.println("add = " + add);
      int add2 = x + y; // auto unboxing
      System.out.println("add2 = " + add2);
      
      Integer z = 300;
      System.out.println("z = " + z);

   }

}
