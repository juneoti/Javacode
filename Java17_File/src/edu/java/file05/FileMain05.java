package edu.java.file05;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

import edu.java.file04.MemberVO;

// 프로그램 <=== ObjectInputStream <=== FileInputStream <=== 파일(HDD)
public class FileMain05 {

	public static void main(String[] args) {
		InputStream in = null;
		ObjectInput oin = null;
		
		try {
			in = new FileInputStream("temp/member.txt");
			oin = new ObjectInputStream(in);
			
			while(true) {
				try {
					MemberVO m = (MemberVO) oin.readObject();
					System.out.println(m);
					
				} catch (EOFException e) {
					break;
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	}

}
