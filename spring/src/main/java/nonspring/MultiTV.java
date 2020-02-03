package nonspring;

public class MultiTV implements TV {
	// 전원키다 / 끄다
	@Override
	public void powerOn() {
		System.out.println("멀티 tv전원 켜다");
	}

	@Override
	public void powerOff() {
		System.out.println("멀티 tv전원 끄다");
	}

	// 볼륨업 / 다운
	@Override
	public void soundUp() {
		System.out.println("멀티 tv볼륨 높이다");
	}
	@Override
	public void soundDown() {
		System.out.println("멀티 tv볼륨 내리다");
	}
}
