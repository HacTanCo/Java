package bean1;

import java.util.Date;

public class nhanvien extends nguoi {
	private String mnv, email, sdt;
	private Double hsl;

	public nhanvien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public nhanvien(String mnv, String hoten, boolean gioitinh, Date ngaysinh, String email, String sdt, Double hsl) {
		super(hoten, gioitinh, ngaysinh);
		this.mnv = mnv;
		this.email = email;
		this.sdt = sdt;
		this.hsl = hsl;
	}

	public String getMnv() {
		return mnv;
	}

	public void setMnv(String mnv) {
		this.mnv = mnv;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public Double getHsl() {
		return hsl;
	}

	public void setHsl(Double hsl) {
		this.hsl = hsl;
	}

	@Override
	public String toString() {
		return mnv + "|" + super.toString() + "|" + email + "|" + sdt + "|" + hsl;
	}

}
