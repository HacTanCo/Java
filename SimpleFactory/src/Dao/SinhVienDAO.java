package Dao;

import java.util.ArrayList;

import Bean.SinhVien;

public interface SinhVienDAO {
	ArrayList<SinhVien> DocDanhSach() throws Exception;
	void BoSung(SinhVien x) throws Exception;
	void Xoa(String maSinhVien) throws Exception;
}
