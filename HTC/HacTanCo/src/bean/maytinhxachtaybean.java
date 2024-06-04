package bean;

import java.sql.Date;

public class maytinhxachtaybean extends maytinhbean {
	private String mau;
	private float kcmh;
	public maytinhxachtaybean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public maytinhxachtaybean(String mm, String tm, Date nnh, float gia, int sl, String mau, float kcmh) {
		super(mm, tm, nnh, gia, sl);
		this.mau = mau;
		this.kcmh = kcmh;
	}
	public String getMau() {
		return mau;
	}
	public void setMau(String mau) {
		this.mau = mau;
	}
	public float getKcmh() {
		return kcmh;
	}
	public void setKcmh(float kcmh) {
		this.kcmh = kcmh;
	}
	@Override
	public String toString() {
		return super.toString() + ";"+ mau+ ";"+kcmh;
	}
	
}
