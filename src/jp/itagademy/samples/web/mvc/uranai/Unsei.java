package jp.itagademy.samples.web.mvc.uranai;

import java.util.Calendar;

public class Unsei {
	private int bloodType = 0;
	String[] bloodTypes = {"","A","B","O","AB"};
	
	public Unsei(String bloodType) {
		System.err.println(bloodType);
		for(int i=1;i<bloodTypes.length;i++ ){
			System.err.println(i +  bloodTypes[i]);
			if (bloodType.equals(bloodTypes[i])){
				this.bloodType = i;
				break;
			}
		}
	}

	public String getBloodType() {
		return bloodTypes[bloodType];
	}

	public String getUnsei(){
		int unsei = Calendar.getInstance().get(Calendar.DAY_OF_MONTH) * (bloodType + 2) % 5;

		switch(unsei){
		case 0:
			return "‘å‹g";
		case 1:
			return "’†‹g";
		case 2:
			return "¬‹g";
		case 3:
			return "––‹g";
		}
		return "‹¥";
	}
}
