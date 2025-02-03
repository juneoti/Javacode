package edu.java.contact06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import oracle.jdbc.OracleDriver;

public class ContactDAOImple implements ContactDAO, OracleQuery {

	private static ContactDAOImple instance = null;

	private int count;

	private ContactDAOImple() { // 싱글톤 객체 초기화 시 바로 파일 확인 하도록 함.
	}

	public static ContactDAOImple getInstance() {
		if (instance == null) {
			instance = new ContactDAOImple();
		}
		return instance;
	}

	public int getCount() {

		return count;
	}

	@Override
	public int insert(ContactVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			pstmt = conn.prepareStatement(OracleQuery.SQL_INSERT);

			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPhone());
			pstmt.setString(3, vo.getEmail());
			result = pstmt.executeUpdate();
			count++;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		System.out.println(result);
		return result; // 0 : 실패, 1 : 성공
	}

	@Override
	public ArrayList<ContactVO> select() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<ContactVO> list = new ArrayList<>();
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(OracleQuery.SQL_SELLECT_ALL);

			while (rs.next()) {
				int contactId = rs.getInt(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);
				list.add(new ContactVO(contactId, name, phone, email));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println(list.toString());
		return list;
	}

	@Override
	public ContactVO select(int index) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ContactVO vo = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			pstmt = conn.prepareStatement(SQL_SELECT_BY_CONTACT_ID);
			pstmt.setInt(1, index);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int contactId = rs.getInt(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);
				vo = new ContactVO(contactId, name, phone, email);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(vo.toString());
		return vo;
	}

	@Override
	public int update(int index, ContactVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			pstmt = conn.prepareStatement(SQL_UPDATE);

			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPhone());
			pstmt.setString(3, vo.getEmail());
			pstmt.setInt(4, index);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(result);
		return result;
	}

	@Override
	public int delete(int index) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			pstmt = conn.prepareStatement(SQL_DELETE);

			pstmt.setInt(1, index);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		count--;
		System.out.println(result);
		return result;
	}

	// DB의 존재하지 않는 값에 접근으로 인한 에러 대비
	public int checkId(int index) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			pstmt = conn.prepareStatement(SQL_CHECKID);
			pstmt.setInt(1, index);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
			System.out.println("1 유 0 무 :" + result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

}