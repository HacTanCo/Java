package bean;

import java.util.Date;

public class NhanVienBean extends Nguoi{
	private String mnv,email,sdt;
	private Double hsl;
	public NhanVienBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public NhanVienBean(String mnv,String hoten, boolean gioitinh, Date ngaysinh,  String email, String sdt,
			Double hsl) {
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
//		return "NhanVienBean [mnv=" + mnv + ", email=" + email + ", sdt=" + sdt + ", hsl=" + hsl + "]";
		return mnv+"|"+super.toString()+"|"+email+"|"+sdt+"|"+hsl;
	}
	
}
