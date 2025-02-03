package edu.java.file02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// 프로그램 <=== FileInputStream <=== 파일
// FileInputStream 클래스의 read() 메소드를 사용하여 파일을 읽음

// 프로그램 ===> FileOutputStream ===> 파일
// FileOutputStream 클래스의 write() 메소드를 사용하여 파일을 씀
public class FileMain02 {

	public static void main(String[] args) {
		// temp/original.txt 파일의 데이터를 읽어서
		// temp/copy.txt 파일에 데이터를 씀
		
		InputStream in = null;
		OutputStream out = null;
		
		try {
			in = new FileInputStream("temp/original.txt");
			out = new FileOutputStream("temp/copy.txt");
			
			int data = 0; // read() 메소드가 리턴하는 값을 저장할 변수
			int byteCopied = 0;
			while(true) {
				// read() : 파일에서 1바이트씩 데이터를 읽어옴
				// 파일 끝에 도달했을 때 -1을 리턴
				
				data = in.read();
				System.out.println(data);
				if(data == -1) {
					break;
				}
				
				// write() : 1바이트씩 파일에 씀
				out.write(data);
				
				byteCopied++;
			}
			
			System.out.println(byteCopied + "바이트 복사됨");
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	} // end main()

} // end FileMain02







