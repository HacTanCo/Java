package Dao;

import java.util.ArrayList;

import Bean.SinhVien;

public class ThemSinhVienVaoArr {
	public ArrayList<SinhVien> ThemSinhVien() {
		ArrayList<SinhVien> danhSachSinhVien = new ArrayList<>();
		danhSachSinhVien.add(new SinhVien("SV1", "Nguyen Van A", "A"));
		danhSachSinhVien.add(new SinhVien("SV2", "Nguyen Van B", "B"));
		danhSachSinhVien.add(new SinhVien("SV3", "Nguyen Van C", "C"));
		return danhSachSinhVien;
	}
}
