package bean;

import java.util.Date;

public class SinhVienBean extends Nguoi {
	private String msv, lop;
	private Double avg;

	
	public SinhVienBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SinhVienBean(String msv, String hoten, boolean gioitinh, Date ngaysinh, String lop, Double avg) {
		super(hoten, gioitinh, ngaysinh);
		this.msv = msv;
		this.lop = lop;
		this.avg = avg;
	}


	public String getMsv() {
		return msv;
	}


	public void setMsv(String msv) {
		this.msv = msv;
	}


	public String getLop() {
		return lop;
	}


	public void setLop(String lop) {
		this.lop = lop;
	}


	public Double getAvg() {
		return avg;
	}


	public void setAvg(Double avg) {
		this.avg = avg;
	}


	@Override
	public String toString() {
//		return "SinhVienBean [msv=" + msv + ", lop=" + lop + ", avg=" + avg + "]";
		return msv+"|"+super.toString()+"|"+lop+"|"+avg;
	}
	
}
