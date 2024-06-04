package bean;

import java.sql.Date;

public class maytinhbean {
	private String mm,tm;
	private Date nnh;
	private float gia;
	private int sl;
	public maytinhbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public maytinhbean(String mm, String tm, Date nnh, float gia, int sl) {
		super();
		this.mm = mm;
		this.tm = tm;
		this.nnh = nnh;
		this.gia = gia;
		this.sl = sl;
	}
	public String getMm() {
		return mm;
	}
	public void setMm(String mm) {
		this.mm = mm;
	}
	public String getTm() {
		return tm;
	}
	public void setTm(String tm) {
		this.tm = tm;
	}
	public Date getNnh() {
		return nnh;
	}
	public void setNnh(Date nnh) {
		this.nnh = nnh;
	}
	public float getGia() {
		return gia;
	}
	public void setGia(float gia) {
		this.gia = gia;
	}
	public int getSl() {
		return sl;
	}
	public void setSl(int sl) {
		this.sl = sl;
	}
	@Override
	public String toString() {
		return mm + ";"+ tm + ";" + nnh + ";" + gia + ";" + sl;
	}
}
