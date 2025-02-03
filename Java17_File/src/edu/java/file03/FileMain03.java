package edu.java.file03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*
1. 일반적인 try-catch-finally 구문
try {
	(실행문)
} catch (Exception e) {
	(예외 처리)
} finally {
	(항상 실행할 코드들) // 리소스 삭제
}

2. try-with-resource 구문 : Java 7버전부터 제공
- try() 안에서 생성된 리소스들의 해제 코드(close();)를 자동으로 호출해줌
try(리소스 생성) {
	(실행문)
} catch (Exception e) {
	(예외 처리)
}
*/

public class FileMain03 {

	public static void main(String[] args) {
		InputStream in = null;
		OutputStream out = null;
		
		
		try {
			in = new FileInputStream("temp/big_text.txt");
			out = new FileOutputStream("temp/big_text.txt");
			
			int data = 0;
			int byteCopied = 0;

			byte[] buffer = new byte[1024 * 1024]; // 1MB 공간
			// 1KB = 1024 Bytes
			// 1MB = 1024 * 1024 Bytes
			// 1GB = 1024 * 1024 * 1024 Bytes
			long startTime = System.currentTimeMillis();
			while(true) {
				data = in.read(buffer);
				// read(byte[] b) :
				// 파일에서 읽은 데이터를 매개변수 배열 b에 저장
				// 실제로 읽은 바이트 수를 리턴, 파일 끝은 -1을 리턴
			
				if(data == -1) {
					break;
				}
				out.write(buffer);
				// write(byte[] b) :
				// - 매개변수 배열 b의 내용을 한 번에 파일에 씀
				
				byteCopied += data;
			}
			long endTime = System.currentTimeMillis();
			System.out.println("복사된 바이트 : " + byteCopied);
			System.out.println("복사 경과 시간 : " + (endTime - startTime));
		} catch (Exception e) {
			e.printStackTrace(); // 예외 추적 결과를 출력
		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	} // end main()

} // end FileMain03






