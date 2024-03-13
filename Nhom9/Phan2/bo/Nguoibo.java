package bo;

import java.util.ArrayList;

import bean.Nguoi;
import bean.ThongkeBean;
import dao.Nguoidao;

public class Nguoibo { 
	Nguoidao ndao = new Nguoidao();
	ArrayList<Nguoi> ds;

	public ArrayList<Nguoi> getds() throws Exception {
		ds = ndao.getds();
		return ds;
	}
	public void show() throws Exception {
		for(Nguoi i : ds) {
			System.out.println(i.toString());
		}
	}
	public ArrayList<Nguoi> getdstheotuoi(int age){
		ArrayList<Nguoi> tam = new ArrayList<Nguoi>();
		for(Nguoi i : ds) {
			if(i.getTuoi()>=age) {
				tam.add(i);
			}
		}
		return tam;
	}
	public ArrayList<ThongkeBean> thongke() throws Exception {
		ArrayList<ThongkeBean> tam = new ArrayList<ThongkeBean>();
		int dem=0;
		for(Nguoi n:ds)
			if(n.isGioitinh()==true) dem++;
		tam.add(new ThongkeBean(true,dem));
		tam.add(new ThongkeBean(false,ds.size()-dem));
		return tam;
	}
}