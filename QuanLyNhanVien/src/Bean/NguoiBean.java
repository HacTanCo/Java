package Bean;

import java.sql.Date;

public class NguoiBean {
	private String hoVaTen;
	private boolean gioiTinh;
	private Date ngaySinh;
	private String sdt;
	private float luong;
	
	public NguoiBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NguoiBean(String hoVaTen, boolean gioiTinh, Date ngaySinh, String sdt, float luong) {
		super();
		this.hoVaTen = hoVaTen;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.sdt = sdt;
		this.luong = luong;
	}
	
	public String getHoVaTen() {
		return hoVaTen;
	}
	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public float getLuong() {
		return luong;
	}
	public void setLuong(float luong) {
		this.luong = luong;
	}
	@Override
	public String toString() {
		return hoVaTen + ";" + gioiTinh + ";" + ngaySinh + ";" + sdt + ";" + luong ;
	}
}
