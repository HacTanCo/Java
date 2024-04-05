package view;

import bean.NhanVienBean;
import bo.NhanVienBo;
import dao.nhanviendo;

public class NhanVienView {
	public static void main(String[] args) {
		try {
			NhanVienBo nvbo = new NhanVienBo();
			nvbo.ketnoi();
			System.out.println("cau 1 hien thi all nhan vien");
			for(NhanVienBean i : nvbo.getnv())
				System.out.println(i.toString());
			System.out.println("cau 2: luu file vao csdl");
			nvbo.savecsdl("data.txt");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
