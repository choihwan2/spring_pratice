package empspring;

public class EmpDAO {
	EmpVO vo;

	public void setVo(EmpVO vo) {
		this.vo = vo;
	}

	public void insertEmp() {
		// spring 요청: EmpVo 객체 1개 생성
		System.out.println("사원이름: " + vo.getName());
		System.out.println("사원번호: " + vo.getDeptname());
		System.out.println("사원월급: " + vo.getSalary());
	}
}
