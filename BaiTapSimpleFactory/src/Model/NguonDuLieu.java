package Model;

import java.util.ArrayList;

public interface NguonDuLieu {
	public ArrayList<SinhVien> DocDanhSachSV() throws Exception;
	public void ThemSinhVien(SinhVien sv) throws Exception;
	public void XoaSinhVien(String maSinhVien) throws Exception;
}
