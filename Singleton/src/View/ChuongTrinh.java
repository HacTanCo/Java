package View;

import java.util.ArrayList;

import Bean.CauHinhBean;
import Bean.NganhDaoTao;
import Bean.SinhVienBean;
import Dao.NguonDuLieuCSDL;
import Dao.NguonDuLieuText;

public class ChuongTrinh {
	public static void main(String[] args) throws Exception {
		CauHinhBean chb = CauHinhBean.getInstance();
		if (chb.getLoaiNguon().equals("TXT")) 
		{
			NguonDuLieuText nguontxt = new NguonDuLieuText();
			ArrayList<SinhVienBean> danhSachSV = nguontxt.docDanhSachSV();
			ArrayList<NganhDaoTao> danhSachNDT = nguontxt.docDanhSachNDT();
			
			System.out.println("Danh sach sinh vien trong file text !!!");
			for (SinhVienBean i : danhSachSV) 
			{
				System.out.println(i.toString());
			}
		
			System.out.println("\nDanh sach nganh trong file text !!!");
			for (NganhDaoTao i : danhSachNDT) 
			{
				System.out.println(i.toString());
			}
			
		} 
		else
		{
			NguonDuLieuCSDL nguoncsdl = new NguonDuLieuCSDL();
			ArrayList<SinhVienBean> danhSachSV = nguoncsdl.docDanhSachSV();
			ArrayList<NganhDaoTao> danhSachNDT = nguoncsdl.docDanhSachNDT();
			System.out.println("Danh sach sinh vien tren CSDL !!!");
			for (SinhVienBean i : danhSachSV) {
				System.out.println(i.toString());
			}
			System.out.println("\nDanh sach nganh dao tao tren CSDL !!!");
			for (NganhDaoTao i : danhSachNDT) {
				System.out.println(i.toString());
			}
		}
	}
}
