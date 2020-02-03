package nonspring;

public class Main {

	public static void main(String[] args) {
		TV tv = new OtherTV();
		TVFacotry tvFacotry = new TVFacotry();
		TV tv2 = tvFacotry.getTV(args[0]);
		tv.powerOn();
		tv.soundUp();
		tv.soundDown();
		tv.powerOff();
		tv2.powerOn();

	}

}
