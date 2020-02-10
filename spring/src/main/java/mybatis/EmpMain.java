package mybatis;


import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class EmpMain {

	public static void main(String[] args) throws Exception {
		// 1. 설정 파일들 읽기 위한 객체
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

		// 2. SqlSessionFactory = 연결 설정 파일을 읽어라
		// sql 매핑 파일명
		SqlSessionFactory factory = builder.build(Resources.getResourceAsReader("mybatis/mybatis-config.xml"));

		// 3. SqlSession = jdbc Connection 유사 = 연결 생성

//		1. 자동 commit 처리 (true)
		SqlSession session = factory.openSession(true);
		
//		2. 자동 commit 처리 x
//		SqlSession session2 = factory.openSession();

		System.out.println(session.getConnection().getAutoCommit());
		// <select id = "allemp" resultType = "mybatis.EmpVO">
		/////////////////
		EmpDAO dao = new EmpDAO();
		dao.setSession(session);
		
		
		// test 1. 여러개의 레코드 리턴 조회
//		List<EmpVO> list = dao.getAllEmp();
//		for (EmpVO empVO : list) {
//			System.out.println(empVO.getFirst_name() + ":" + empVO.getLast_name());
//		}
		// test 2 . 한명만 가져오기
//		EmpVO vo = dao.getOneEmp(100);
//		System.out.println(vo.getFirst_name());

		// test 3 . 0~n개 레코드 리턴 조회 : 이름 Steven
//		List<EmpVO> list2 = dao.getNameEmp("Steven");
//		for (EmpVO empVO : list2) {
//			System.out.println(empVO.getFirst_name() + ":" + empVO.getFirst_name());
//		}
		// test 4. 아이디가 150이라는 숫자 아래로 있는 사람을 찾아보자
//		List<EmpVO> list3 = dao.getIdEmp();
//		for (EmpVO empVO : list3) {
//			System.out.println(empVO.employee_id);
//		}
		// test 5. 날짜를 잘 바꿔보자
//		List<EmpVO> list4 = dao.getDateEmp();
//		for (EmpVO empVO : list4) {
//			System.out.println(empVO.getFirst_name() + ":" + empVO.getFirst_name());
//		}
		// test 6. 퍼스트 네임과 라스트네임을 합쳐서 한번에 first_name으로 받아보자
//		List<EmpVO> list5 = dao.getDateEmp();
//		for (EmpVO empVO : list5) {
//			System.out.println(empVO.getFirst_name() + ":" + empVO.getFirst_name());
//		}
		
		// test 7. 데이터를 넣어보자!
//		EmpVO vo = new EmpVO();
//		vo.setEmployee_id(1001);
//		vo.setFirst_name("길동");
//		vo.setLast_name("홍");
//		vo.setEmail("gil2@multi.com");
//		vo.setJob_id("IT_PROG");
//		dao.insertEmp(vo);
////		session.commit(); 
//		System.out.println("신규사원을 등록하였습니다.");
		
		// test 8. 데이터를 수정해보자!
//		EmpVO vo = new EmpVO();
//		vo.setFirst_name("석천");
//		vo.setEmail("hong@multi.com");
//		vo.setEmployee_id(1001);
//		System.out.println("업데이트 되었습니다." + dao.updateEmp(vo) + "개 수정되었습니다.");
		
		// test 9 . 데이터를 삭제해보자!
//		int id = 1001;
////		dao.deleteEmp(id);
//		int row = dao.deleteEmp(id);
//		System.out.println(row);
		
		// test 10 . 페이징 처리를 해보자!
		int pagenum = 2;
		int cnt = 10;
		int param[] = new int[2];
		param[0] = (pagenum -1) * cnt + 1;
		param[1] = pagenum * cnt;
		List<EmpVO> list = dao.pagingEmp(param);
		for (EmpVO empVO : list) {
			System.out.println(empVO.getFirst_name() + " : " + empVO.getHire_date());
		}
	}

}
