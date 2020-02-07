package mybatis;

//브라우저 내부 여러 서블릿/jsp 객체 공유 :session
//mybatis sqlsession => 다른 의미  jdbc 의 Connection같이 db에 연결하는 것.

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class EmpDAO {

	SqlSession session;

	public void setSession(SqlSession session) {
		this.session = session;
	}

	// test 1. 여러개의 레코드 리턴 조회
	public List<EmpVO> getAllEmp() {
		List<EmpVO> list = session.selectList("allemp");
		return list;
	}

	// test 2 . 한명만 가져오기
	public EmpVO getOneEmp(int id) {
		EmpVO vo = session.selectOne("oneemp", id);
		return vo;
	}

	// test 3 . 0~n개 레코드 리턴 조회 : 이름 Steven
	public List<EmpVO> getNameEmp(String name) {
		List<EmpVO> list = session.selectList("nameemp", name);
		return list;
	}

	// test 4. 아이디가 150이라는 숫자 아래로 있는 사람을 찾아보자
	public List<EmpVO> getIdEmp() {
		List<EmpVO> list = session.selectList("idemp", 150);
		return list;
	}

	// test 5. 날짜를 잘 바꿔보자
	public List<EmpVO> getDateEmp() {
		List<EmpVO> list = session.selectList("dateemp");
		return list;
	}

	// test 6. 퍼스트 네임과 라스트네임을 합쳐서 한번에 first_name으로 받아보자
	public List<EmpVO> getFullNameEmp() {
		List<EmpVO> list = session.selectList("superemp");
		return list;
	}

	// test 7. 새로운 사원 등록 : insert
	// 1000, 홍길동, gil@multi.com, sysdate, 'IT_PROG'
	public void insertEmp(EmpVO vo) {
		session.insert("newemp", vo);
	}

	// test 8. 이미 있는 사원을 수정해보자!
	public int updateEmp(EmpVO vo) {
		int row = session.update("updateemp", vo);
		return row;
	}

	public int deleteEmp(int id) {
		int row = session.delete("deleteemp", id);
		return row;
	}

	public List<EmpVO> pagingEmp(int[] param) {
		List<EmpVO> list = session.selectList("pagingemp", param);
		return list;
	}
}
