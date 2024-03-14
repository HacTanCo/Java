package bean;

public class CanBoBean {
	private String ma,hoten;
	private double hsl;
	public CanBoBean(String ma, String hoten, double hsl) {
		super();
		this.ma = ma;
		this.hoten = hoten;
		this.hsl = hsl;
	}
	public CanBoBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public double getHsl() {
		return hsl;
	}
	public void setHsl(double hsl) {
		this.hsl = hsl;
	}
	public double luong() {
		return hsl*1300;
	}
	@Override
	public String toString() {
        return ma + "|" + hoten + "|" + hsl;
    }
}
