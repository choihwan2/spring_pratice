package proxypattern;

public class ProxyMain {

	public static void main(String[] args) {
		ProxyInter p = new A();
		B b1 = new B();
		b1.setP(p);
		b1.action();
		
		
		System.out.println("================");
		p.action();
	}

}
