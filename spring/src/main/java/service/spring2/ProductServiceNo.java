package service.spring2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service3")
public class ProductServiceNo implements ProductService {
	@Autowired
	ProductDAO dao;

	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}

	@Override
	public ProductVO sell() {
		System.out.println("평상시는 정상 판매중입니다");
//		dao = new ProductDAO();
		return dao.sell(0.0, 5);
	}

}
