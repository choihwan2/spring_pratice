package service.spring2;


public class ProductVO {
	private int code;
	private String name;
	private int price;
	private int coupon;
	private double sale;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCoupon() {
		return coupon;
	}

	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}

	public double getSale() {
		return sale;
	}

	public void setSale(double sale) {
		this.sale = sale;
	}

	@Override
	public String toString() {
		return "상품 코드: " + code + " 상품 이름: " + name + " 가격: " + price + " 세일가격" + price * (1 - sale) + " 쿠폰:" + coupon + " 개를 지급합니다.";
	}

}
