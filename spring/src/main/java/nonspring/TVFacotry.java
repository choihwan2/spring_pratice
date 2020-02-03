package nonspring;

public class TVFacotry {
	public TV getTV(String name) {
		if (name.equals("멀티")) {
			return new MultiTV();
		} else if (name.equals("아더")) {
			return new OtherTV();
		}
		return null;
	}
}
