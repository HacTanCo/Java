package bean1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class nguoi {
	private String hoten;
	private boolean gioitinh;
	private Date ngaysinh;
	public nguoi() {
		super();
		// TODO Auto-generated constructor stub
	}
	public nguoi(String hoten, boolean gioitinh, Date ngaysinh) {
		super();
		this.hoten = hoten;
		this.gioitinh = gioitinh;
		this.ngaysinh = ngaysinh;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public boolean isGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(boolean gioitinh) {
		this.gioitinh = gioitinh;
	}
	public Date getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return hoten+"|"+gioitinh+"|"+sdf.format(ngaysinh);
	}
	
}
