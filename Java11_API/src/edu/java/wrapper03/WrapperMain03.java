package edu.java.wrapper03;

import java.math.BigInteger;

// BigInteger : 저장할 수 있는 정수값의 한계가 없는 클래스
// BigDecimal : 실수 계산의 오차를 줄이거나 없애기 위해서 만들어진 클래스
// auto boxing과 auto unboxing 기능을 제공하지 않음
// -> 생성자를 호출하여 인스턴스를 생성해야함
// -> 산술연산(+, - *, / 등등)은 메소드를 사용해야함
public class WrapperMain03 {

   public static void main(String[] args) {
      long n = Long.MAX_VALUE + 1;
      System.out.println(n);
      // long 타입도 저장할 수 있는 한계가 존재
      
      // BigInteger 생성자의 매개변수는 문자열
      BigInteger big = new BigInteger("123456789123456789123456");
      System.out.println(big);
      
      // BigInter의 사칙연산:
      // add(), subtract(), multiply(), divide(), mod() 메소드 사용
      BigInteger x = new BigInteger("10");
      System.out.println(big.add(x));

   } // end main()

} // end WrapperMain03

