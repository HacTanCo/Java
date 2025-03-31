package Bo;

import java.util.ArrayList;

import Bean.SinhVien;
import Dao.ThemSinhVienVaoArr;

public class XuLyChucNang {
	ThemSinhVienVaoArr dsSinhVien = new ThemSinhVienVaoArr();
	public ArrayList<SinhVien> danhSachSinhVien = dsSinhVien.ThemSinhVien();
	
	public void DuyetDanhSachSinhVien() {
		for (SinhVien i : danhSachSinhVien) {
			System.out.println(i.toString());
		}
	}
}
