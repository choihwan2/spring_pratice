package service.spring2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//기본 이름은 클래스 이름과 똑같음("productService05")
@Service("service2")
public class ProductService05 implements ProductService {
	@Autowired
	ProductDAO dao;

	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}

	@Override
	public ProductVO sell() {
		System.out.println("5월은 30% 세일중입니다");
//		dao = new ProductDAO();
		return dao.sell(0.3, 1);
	}

}
