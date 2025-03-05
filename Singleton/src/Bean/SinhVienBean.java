package Bean;

public class SinhVienBean {
	private String maSinhVien, hoTen, maNganh;

	public SinhVienBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SinhVienBean(String maSinhVien, String hoTen, String maNganh) {
		super();
		this.maSinhVien = maSinhVien;
		this.hoTen = hoTen;
		this.maNganh = maNganh;
	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getMaNganh() {
		return maNganh;
	}

	public void setMaNganh(String maNganh) {
		this.maNganh = maNganh;
	}

	@Override
	public String toString() {
		return maSinhVien + ";" + hoTen + ";" + maNganh;
	}
}
