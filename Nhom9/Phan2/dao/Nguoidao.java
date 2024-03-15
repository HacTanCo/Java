package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import bean.Nguoi;
import bean.NhanVienBean;
import bean.SinhVienBean;

public class Nguoidao {
	public ArrayList<Nguoi> getds() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Nguoi a = new Nguoi("lan", false, sdf.parse("12/11/2004"));
		Nguoi a1 = new Nguoi("dat", true, sdf.parse("11/01/2004"));
		//tao ra 2 sinh vien va 2 nhan vien
		SinhVienBean sv1 = new SinhVienBean("sv1", "Hac Tan Co", true,sdf.parse("24/04/2004"), "K46H", 10.0);
		SinhVienBean sv2 = new SinhVienBean("sv2", "Do Trong Hoang Lan", true, sdf.parse("12/11/2004"), "K46A",9.9);
		NhanVienBean nv1 = new NhanVienBean("nv1", "Nguyen Van A", false, sdf.parse("01/02/2000"), "nv1@gmail.com", "0123456789", 4.4);
		NhanVienBean nv2 = new NhanVienBean("nv2", "Nguyen Van B", true, sdf.parse("02/02/2000"), "nv2@gmail.com", "0123456788", 4.3);
		//hien thi thong tin
//		System.out.println(sv1.toString());
//		System.out.println(sv2.toString());
//		System.out.println(nv1.toString());
//		System.out.println(nv2.toString());
		//tao ra 1 mang dong luu 2 nguoi,2sinh vien va  2 nhan vien
		ArrayList<Nguoi> ds = new ArrayList<Nguoi>();
		ds.add(a);ds.add(a1);ds.add(sv1);ds.add(sv2);ds.add(nv1);ds.add(nv2);
		return ds;
	}
	public ArrayList<SinhVienBean> getsv() throws Exception{
		ArrayList<SinhVienBean> tam = new ArrayList<SinhVienBean>();
		for(Nguoi i : getds())
			if(i instanceof SinhVienBean)
				tam.add((SinhVienBean)i);
		return tam;
	}
	public ArrayList<NhanVienBean> getnv() throws Exception{
		ArrayList<NhanVienBean> t = new ArrayList<NhanVienBean>();
		for(Nguoi i : getds())
			if( i instanceof NhanVienBean)
				t.add((NhanVienBean)i);
		return t;
	}
}