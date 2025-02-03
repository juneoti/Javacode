package edu.java.contact05;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ContactDAOImple implements ContactDAO{
	
	// 싱글톤 디자인 패턴 적용
	
	// 1. private static 자기 자신 타입의 변수 선언
	private static ContactDAOImple instance = null;
	
	// 2. private 생성자
	private ContactDAOImple() { //프로그램 실행시 폴더 및 파일 존재 유무 검사 및 없을 시 생성하는 메소드 실행
		initDataDir();
		initDataFile();
	}
	// 3. public static 메소드 - 인스턴스를 리턴하는 메소드 구현
	public static ContactDAOImple getInstance() {
		if(instance == null) {
			instance = new ContactDAOImple();
		}
		return instance;
	}
	// ArrayList Collection 코드
	public ArrayList<ContactVO> list = new ArrayList<>();
	
	// 데이터를 저장할 폴더와 파일 이름 정의
	private static final String DATA_DIR = "data";
	private static final String DATA_FILE = "contact.data"; 
	public static final String DATA_PATH =
			DATA_DIR + File.separator + DATA_FILE;
	
	// data 폴더의 contact.data 파일을 관리할 File 객체 선언
	private File dataDir; // 경로
	private File dataFile; // 파일
	
	// TODO : data 폴더가 있는지 검사하고, 없으면 생성하는 함수
	private void initDataDir() {//fileMain08 참조
		System.out.println("initDataDir()");
		dataDir = new File(DATA_DIR);
		System.out.println("폴더 경로 : " + dataDir.getPath());
		System.out.println("절대 경로 : " + dataDir.getAbsolutePath());
		
		if (!dataDir.exists()) { // 폴더가 없는 경우 폴더 생성
			System.out.println("폴더가 없습니다.");
			if (dataDir.mkdirs()) {
				System.out.println("폴더 생성 성공");
			} else {
				System.out.println("폴더 생성 실패");
			}
		} else {
			System.out.println("폴더가 이미 존재합니다.");
		}
	}
	
	// TODO : 데이터 파일이 존재하는지 검사하고,
	// 없는 경우 - 새로운 데이터 파일 생성
	// 있는 경우 - 기존 파일에서 데이터를 읽어서 ArrayList에 추가
	private void initDataFile() {//FileMain09(새로운 데이터 파일 생성) FileMain06(ArrayList에 추가) 참조
		System.out.println("initDataFile()");
		dataFile = new File(DATA_PATH);
		System.out.println("폴더 경로 : " + dataFile.getPath());
		System.out.println("절대 경로 : " + dataFile.getAbsolutePath());
		
		if (!dataFile.exists()) { // 파일이 없는 경우 파일 생성
			System.out.println("파일이 없습니다.");

			try {
				if (dataFile.createNewFile()) {
					System.out.println("파일 생성 성공");
				} else {
					System.out.println("파일 생성 실패");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			if (dataFile.length()!=0) { // 파일에 저장된 데이터가 있는 경우
				readDataFromFile(); //파일에서 데이터를 읽어 옴
			}
			System.out.println("파일이 이미 존재 합니다.");
		}

/*
			try {
				out = new FileOutputStream(DATA_PATH);
				bout = new BufferedOutputStream(out);
				oout = new ObjectOutputStream(bout);

				oout.writeObject(list);

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					oout.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			*/
		}
	
	
	// TODO : 멤버 변수 list 객체를 data\contact.data 파일에 저장(쓰기)
	private void writeDataToFile() {
		OutputStream out = null;
		BufferedOutputStream bout = null;
		ObjectOutputStream oout = null;

		try {
			out = new FileOutputStream(DATA_PATH);
			bout = new BufferedOutputStream(out);
			oout = new ObjectOutputStream(bout);
			oout.writeObject(list);
			
			System.out.println("데이터 저장 완료");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				oout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	// TODO : data\contact.data 파일에서 ArrayList 객체를 읽어와서
	// 멤버 변수 list에 저장(읽기)
	private void readDataFromFile() {//FileMain07 참조
		InputStream in = null;
		BufferedInputStream bin = null;
		ObjectInputStream oin = null;

		try {
			in = new FileInputStream(DATA_PATH);
			bin = new BufferedInputStream(in);
			oin = new ObjectInputStream(bin);
			list = (ArrayList<ContactVO>) oin.readObject();
			System.out.println("list 데이터 읽기 완료");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				oin.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public int getSize() {
		return list.size();
	}
	
	@Override
	public int insert(ContactVO vo) {
		list.add(vo);
		writeDataToFile();
		return 1;
	}

	@Override
	public ArrayList<ContactVO> select() {
		return list;
	}

	@Override
	public ContactVO select(int index) {
		return list.get(index);
	}

	@Override
	public int update(int index, ContactVO vo) {
		list.get(index).setPhone(vo.getPhone());
		list.get(index).setEmail(vo.getEmail());
		writeDataToFile();
		return 1;
	}
	public int delete(int index) {
		list.remove(index);
		writeDataToFile();
		return 1;
	}
	
	
	
	/* list 배열 코드
	private final int MAX = 100; // 최대 연락처수
	private ContactVO[] list = new ContactVO[MAX]; // 연락처 정보를 저장할 배열
	private int count; // 배열에 저장될 데이터 개수

	@Override
	public int insert(ContactVO vo) {
		list[count] = vo;
		count++;
		return 1; // 0 : 실패, 1 : 성공
	}

	public int getCount() {
		return count;
	}
	
	@Override
	public ContactVO[] select() {
		return list;
	}

	@Override
	public ContactVO select(int index) {
		return list[index];
	}

	@Override
	public int update(int index, ContactVO vo) {
		// 전화번호, 이메일만 변경
		list[index].setPhone(vo.getPhone());
		list[index].setEmail(vo.getEmail());
		return 1;
	}
	
	@Override
	public int delete(int index, ContactVO vo) {
		list[index] = list[index+1];
		count--;
		return 1;
	}
	*/
}
