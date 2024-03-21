package bean;

public class tinB {
	private String msv,ht;
	private double ex,pp,wed,dtb;
	public tinB() {
		super();
		// TODO Auto-generated constructor stub
	}
	public tinB(String msv, String ht, double ex, double pp, double wed) {
		super();
		this.msv = msv;
		this.ht = ht;
		this.ex = ex;
		this.pp = pp;
		this.wed = wed;
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
	public double getEx() {
		return ex;
	}
	public void setEx(double ex) {
		this.ex = ex;
	}
	public double getPp() {
		return pp;
	}
	public void setPp(double pp) {
		this.pp = pp;
	}
	public double getWed() {
		return wed;
	}
	public void setWed(double wed) {
		this.wed = wed;
	}
	public double avg() {
		dtb = Math.round(((ex+pp+wed)/3)*100.0)/100.0;
		return dtb;
	}
	
	@Override
	public String toString() {
		return msv+";"+ht+";"+ex+";"+pp+";"+wed+";"+dtb;
	}
	
	
}
