package bean;

public class tinA {
	private String msv,ht;
	private double win,word,dtb;
	public tinA() {
		super();
		// TODO Auto-generated constructor stub
	}
	public tinA(String msv, String ht, double win, double word) {
		super();
		this.msv = msv;
		this.ht = ht;
		this.win = win;
		this.word = word;
		avg();
	}
	public String getMsv() {
		return msv;
	}
	public void setMsv(String msv) {
		this.msv = msv;
	}
	public String getHt() {
		return ht;
	}
	public void setHt(String ht) {
		this.ht = ht;
	}
	public double getWin() {
		return win;
	}
	public void setWin(double win) {
		this.win = win;
	}
	public double getWord() {
		return word;
	}
	public void setWord(double word) {
		this.word = word;
	}
	public double avg() {
		dtb = Math.round(((win+word)/2)*100.0)/100.0;
		return (win+word)/2;
	}
	
	@Override
	public String toString() {
		return  msv+";"+ht+";"+ win+";"+ word+";"+dtb;
	}
	
	
}
