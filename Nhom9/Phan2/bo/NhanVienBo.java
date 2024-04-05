package bo;

import java.util.ArrayList;
import java.util.Date;

import bean.NhanVienBean;
import bean.SinhVienBean;
import dao.Ketnoidao;
import dao.Nguoidao;
import dao.nhanviendo;

public class NhanVienBo {
	public ArrayList<NhanVienBean> ds;
	nhanviendo nvdo = new nhanviendo();
	Ketnoidao kndao = new Ketnoidao();
	public void ketnoi() throws Exception{
		kndao.ketnoi();
	}
	public ArrayList<NhanVienBean> getnv() throws Exception {
		ds = nvdo.getnv();
		return ds;
	}
	public ArrayList<NhanVienBean> timkiem(String key) throws Exception {
		return nvdo.timkiem(key);
	}
	public int xoa(String manv) throws Exception {
		for(NhanVienBean i : ds) {
			if(i.getHoten().equals(manv)) {
				ds.remove(i);//xóa trong bộ nhớ trong arraylist
				return nvdo.xoa(manv);//xóa trong csdl
			}
		}
		return 0;
	}
	public int sua(String manv, double hsl) throws Exception {
		for(NhanVienBean i : ds) {
			if(i.getMnv().equals(manv)) {
				i.setHsl(hsl + i.getHsl());
				return nvdo.sua(manv, hsl);
			}
		}
		return 0;
	}
	public int them(String mnv, String hoten, boolean gioitinh, Date ngaysinh, String email, String sdt, Double hsl)throws Exception {
		return nvdo.them(mnv, hoten, gioitinh, ngaysinh, email, sdt, hsl);
	}
	public void savecsdl(String namefile) throws Exception {
		nvdo.savecsdl(namefile);
	}
}
