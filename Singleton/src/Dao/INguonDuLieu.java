package Dao;

import java.util.ArrayList;
import Bean.NganhDaoTao;
import Bean.SinhVienBean;

public interface INguonDuLieu {
	public ArrayList<SinhVienBean> docDanhSachSV() throws Exception;
	public ArrayList<NganhDaoTao> docDanhSachNDT() throws Exception;
}
