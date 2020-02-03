package annotaion.aop1;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class Board {
	public Integer insertBoard(int seq) {
		System.out.println(seq + "번째 게시물을 등록합니다");
		return seq;
	}
	
	public ArrayList<String> getList(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("1번 게시물: 스프링 수업중입니다");
		list.add("2번 게시물: JAVA 수업중입니다");
		list.add("3번 게시물: DB 수업중입니다");
		return list;
	}
}
