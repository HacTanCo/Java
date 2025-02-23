package Bean;

import java.sql.Date;

public class NhanVienBean extends NguoiBean{
	private String maNhanVien;

	public NhanVienBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NhanVienBean(String hoVaTen, boolean gioiTinh, Date ngaySinh, String sdt, float luong, String maNhanVien) {
		super(hoVaTen, gioiTinh, ngaySinh, sdt, luong);
		this.maNhanVien = maNhanVien;
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	@Override
	public String toString() {
		return maNhanVien + ";" + super.toString();
	}
}
