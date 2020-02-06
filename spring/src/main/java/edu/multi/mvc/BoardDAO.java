package edu.multi.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

@Repository("dao")
public class BoardDAO {
	public ArrayList<BoardVO> getList() {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try {
			// 1. jdbc driver 로드
			// 2. db 정보 부여하고 db 연결
			Connection con = BoardDAO.getConnection();
			// 3. sql 정의 - 전송
			PreparedStatement pt = con.prepareStatement("select * from board order by seq desc");
			// 4. ResultSet <- select int <- insert,delete,update == sql 실행 결과 이용
			ResultSet rs = pt.executeQuery();
			while (rs.next()) {
				// rs 가 있으면 계속 반복
				BoardVO vo = new BoardVO();
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setContents(rs.getString("contents"));
				vo.setWriter(rs.getString("writer"));
				vo.setTime(rs.getString("time"));
				vo.setViewcount(rs.getInt("viewcount"));
				list.add(vo);
			}
			// 5. db 연결 해제.
			rs.close();
			pt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 게시물 1개 저장하는 메소드
	public int insertBoard(BoardVO vo) {
		int result = 0;
		try {
			// 2. db 정보 부여하고 db 연결
			Connection con = BoardDAO.getConnection();
			// 3. sql 정의 - 전송
			String insertsql = "INSERT INTO BOARD VALUES ((SELECT MAX(SEQ)+1 FROM BOARD), ?, ?, ?, SYSDATE, ?, 0)";
			PreparedStatement pt = con.prepareStatement(insertsql);
			// 4. ResultSet <- select int <- insert,delete,update == sql 실행 결과 이용
			pt.setString(1, vo.getTitle());
			pt.setString(2, vo.getContents());
			pt.setString(3, vo.getWriter());
			pt.setInt(4, vo.getPassword());
			result = pt.executeUpdate();

			// 5. db 연결 해제.
			pt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 게시물 1개 조회하는 메소드
	public BoardVO getOneBoard(int seq) {
		BoardVO vo = null;
		try {
			Connection con = BoardDAO.getConnection();
			PreparedStatement pt = con.prepareStatement("select * from board where seq=" + seq);
			PreparedStatement update_pt = con.prepareStatement("update board set viewcount = viewcount+1 WHERE seq =" + seq);
			// 4. ResultSet <- select int <- insert,delete,update == sql 실행 결과 이용

			update_pt.executeUpdate();
			ResultSet rs = pt.executeQuery();
			if(rs.next()) {
				vo = new BoardVO();
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setContents(rs.getString("contents"));
				vo.setWriter(rs.getString("writer"));
				vo.setTime(rs.getString("time"));
				vo.setViewcount(rs.getInt("viewcount"));
				vo.setPassword(rs.getInt("password"));
				return vo;
			}
			// rs 가 있으면 계속 반복

			// 5. db 연결 해제.
			rs.close();
			pt.close();
			update_pt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	// 게시물 1개 업데이트 하는 메소드
	public int updateBoard(BoardVO vo) {
		int result = 0;
		try {
			// 2. db 정보 부여하고 db 연결
			Connection con = BoardDAO.getConnection();
			// 3. sql 정의 - 전송
			String insertsql = "update board set title = ?, contents= ?, writer= ?, password= ? WHERE seq = ?";
			PreparedStatement pt = con.prepareStatement(insertsql);
			// 4. ResultSet <- select int <- insert,delete,update == sql 실행 결과 이용
			pt.setString(1, vo.getTitle());
			pt.setString(2, vo.getContents());
			pt.setString(3, vo.getWriter());
			pt.setInt(4, vo.getPassword());
			pt.setInt(5, vo.getSeq());
			result = pt.executeUpdate();

			// 5. db 연결 해제.
			pt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 선택된 게시물 삭제하는 메소드
	public int deleteBoard(int seq, int password) {
		//DELETE FROM BOARD WHERE SEQ = ? and PASSWORD = ?;
		int result = 0;
		try {
			// 2. db 정보 부여하고 db 연결
			Connection con = BoardDAO.getConnection();
			// 3. sql 정의 - 전송
			String insertsql = "DELETE FROM BOARD WHERE SEQ = ? and PASSWORD = ?";
			PreparedStatement pt = con.prepareStatement(insertsql);
			// 4. ResultSet <- select int <- insert,delete,update == sql 실행 결과 이용
			pt.setInt(1, seq);
			pt.setInt(2, password);
			result = pt.executeUpdate();

			// 5. db 연결 해제.
			pt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// db연결하자
	public static Connection getConnection() {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String driver = "oracle.jdbc.OracleDriver";
		String user = "SCOTT";
		String pw = "TIGER";

		Connection con = null;

		try {
			// 1. Driver 로딩 Driver 를 메모리에 올려보자 .
			// 객체 생성문.
			Class.forName(driver);
			// 2. 로딩된 Driver 클래스를 이용해서 Connection요청
			con = DriverManager.getConnection(url, user, pw);

		} catch (Exception e) {
			System.out.println(e);
			System.out.println("데이터베이스 접근에 실패했습니다.");
		}
		return con;
	}

}
