package tvspring;

public class OtherTV implements TV {
	// 전원 켜고 끄고
	// IOT

	public void soundUp() {
		System.out.println("otherTv 볼륨 높이다.");
	}

	public void soundDown() {
		System.out.println("otherTv 볼륨 낮추다.");
	}

	@Override
	public void powerOn() {
		System.out.println("otherTv 전원 켜다");

	}

	@Override
	public void powerOff() {
		System.out.println("otherTv 전원 끄다");

	}
}
