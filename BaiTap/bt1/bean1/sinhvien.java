package bean1;

import java.util.Date;

public class sinhvien extends nguoi {
	private String msv, lop;
	private Double avg;
	public sinhvien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public sinhvien(String msv,String hoten, boolean gioitinh, Date ngaysinh,  String lop, Double avg) {
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
		return msv+"|"+super.toString()+"|"+lop+"|"+avg;
	}
	
}
