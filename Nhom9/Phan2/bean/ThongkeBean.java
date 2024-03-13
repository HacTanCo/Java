package bean;

public class ThongkeBean {
	private boolean gioitinh;
	private int soluong;
	public ThongkeBean(boolean gioitinh, int soluong) {
		super();
		this.gioitinh = gioitinh;
		this.soluong = soluong;
	}
	public ThongkeBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public boolean isGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(boolean gioitinh) {
		this.gioitinh = gioitinh;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	@Override
	public String toString() {
		return (gioitinh?"Nam : ":"Nu : ")+soluong;
	}
}