package service.spring;

public class ProductService12 implements ProductService {
	ProductDAO dao;

	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}

	@Override
	public ProductVO sell() {
		System.out.println("12월은 50% 세일중입니다");
//		dao = new ProductDAO();
		return dao.sell(0.5, 0);
	}

}
