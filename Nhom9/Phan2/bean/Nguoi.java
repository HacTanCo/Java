package bean;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Nguoi {
	private String hoten;
	private boolean gioitinh;
	private Date ngaysinh;
	
	public Nguoi() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Nguoi(boolean gioitinh, Date ngaysinh) {
		super();
		this.gioitinh = gioitinh;
		this.ngaysinh = ngaysinh;
	}

	public Nguoi(String hoten, boolean gioitinh, Date ngaysinh) {
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
		return hoten+"|"+gioitinh+"|"+sdf.format(ngaysinh)+"|"+getTuoi();
	}
	
	public int getTuoi() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String ns=sdf.format(ngaysinh);
		int year = Integer.parseInt(ns.split("[/]")[2]);
		Date d = new Date();
		String nht = sdf.format(d);
		int namht=Integer.parseInt(nht.split("[/]")[2]);
		return namht - year;
	}
	
	

}