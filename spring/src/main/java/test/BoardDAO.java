package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDAO {
	public ArrayList<BoardVO> getList() {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try {
			// 1. jdbc driver 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. db 정보 부여하고 db 연결
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			// 3. sql 정의 - 전송
			PreparedStatement pt = con.prepareStatement("select * from board");
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
}
