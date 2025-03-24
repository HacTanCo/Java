package View;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Bean.CauHinh;
import Bean.SinhVien;
import Dao.DbSinhVienDAO;
import Dao.SinhVienDAO;
import Dao.SinhVienDaoFactory;
import Dao.TextFileSinhVienDAO;

public class ChuongTrinh {
	public static void main(String[] args) throws Exception {
		CauHinh cauHinh = CauHinh.getInstance();
		String nguon = cauHinh.getLoaiNguon();
		
		SinhVienDAO x = null;
		SinhVienDaoFactory f = new SinhVienDaoFactory();
		
//		x = f.getSinhVienDao(nguon);
//		//doc
//		ArrayList<SinhVien> listSinhVien = x.DocDanhSach();
//		System.out.println("Danh sach sinh vien tu CSDL !!!");
//		for (SinhVien i : listSinhVien) {
//			System.out.println(i.toString());
//		}
//		//them
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		x.BoSung(new SinhVien("SV004", "Nguyen van F", false, new Date(sdf.parse("2004-4-4").getTime())));
//		System.out.println("\nDanh sach sinh vien sau khi them !!!");
//		for (SinhVien i : listSinhVien) {
//			System.out.println(i.toString());
//		}
//		//xoa
//		x.Xoa("SV004");
//		System.out.println("\nDanh sach sinh vien sau khi xoa !!!");
//		for (SinhVien i : listSinhVien) {
//			System.out.println(i.toString());
//		}

		
		x = f.getSinhVienDao(nguon);
		//doc
		ArrayList<SinhVien> listSinhVien = x.DocDanhSach();
		System.out.println("Danh sach sinh vien tu file text !!!");
		for (SinhVien i : listSinhVien) {
			System.out.println(i.toString());
		}
		//them
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		x.BoSung(new SinhVien("sv4", "Nguyen van F", false, new Date(sdf.parse("2004/4/4").getTime())));
		System.out.println("\nDanh sach sinh vien sau khi them !!!");
		for (SinhVien i : listSinhVien) {
			System.out.println(i.toString());
		}
		//xoa
		x.Xoa("sv4");
		System.out.println("\nDanh sach sinh vien sau khi xoa !!!");
		for (SinhVien i : listSinhVien) {
			System.out.println(i.toString());
		}
		

		
	}
}			
