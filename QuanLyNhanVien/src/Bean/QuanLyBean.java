package Bean;

import java.sql.Date;

public class QuanLyBean extends NguoiBean {
	private String maQuanLy;
	
	public QuanLyBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QuanLyBean(String hoVaTen, boolean gioiTinh, Date ngaySinh, String sdt, float luong, String maQuanLy) {
		super(hoVaTen, gioiTinh, ngaySinh, sdt, luong);
		this.maQuanLy = maQuanLy;
	}
	
	public String getMaQuanLy() {
		return maQuanLy;
	}
	public void setMaQuanLy(String maQuanLy) {
		this.maQuanLy = maQuanLy;
	}
	public String toString() {
		return maQuanLy + ";" + super.toString();
	}
	
}
