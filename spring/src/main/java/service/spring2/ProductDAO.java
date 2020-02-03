package service.spring2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//dao 클래스는 Repository 권장 @Component: 모든 클래스 권장)
@Repository("dao")
public class ProductDAO {
	
	@Autowired
	ProductVO vo; //ProductVO 객체 (이름이 중요한거같은데...아니였습니다! 하나면 에러안남. 두개일경우 다른 annotation 을 붙여서사용해야한다. ProductVO 타입이 중요)자동 전달 받을랭

//	public void setVo(ProductVO vo) {
//		this.vo = vo;
//	}
	
	public ProductVO sell(double sale, int coupon) {
//		ProductVO vo = new ProductVO();
//		vo.setCode(100);
//		vo.setName("멀티컴퓨터");
//		vo.setPrice(100000);
		vo.setSale(sale);
		vo.setCoupon(coupon);
		
		return vo;
	}
	

}
