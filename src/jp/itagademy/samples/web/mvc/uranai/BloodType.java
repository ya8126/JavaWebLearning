package jp.itagademy.samples.web.mvc.uranai;

public enum BloodType {
	A(1), B(2), O(3), AB(4);

	private int num;
	
	private BloodType(int num) {
		this.num = num;
	}

	public int getNum() {
		return num;
	}

}
