package jp.itagademy.samples.web.mvc.counter;

public class Counter {
	private int num;

	public Counter() {
		this.num = 0;
	}

	public int getNum() {
		return num;
	}
	
	public void inc(){
		num++;
	}
}
