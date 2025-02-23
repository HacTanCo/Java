package Bo;

import java.sql.Date;

import Dao.ChucNangDao;
import Dao.KetNoiSqlDao;

public class ChucNangBo {
	public ChucNangDao cnd = new ChucNangDao();
	
	public void ketnoi() throws Exception{
		KetNoiSqlDao knd = new KetNoiSqlDao();
		knd.ketnoi();
	}
	public boolean checkDangNhap(String user, String pass) throws Exception {
		return cnd.checkDangNhap(user, pass);
	}
	public int dangKyTaiKhoan(String user, String pass, String maNhanSu) throws Exception {
		return cnd.dangKyTaiKhoan(user, pass, maNhanSu);
	}
	public boolean checkma(String user, String maNhanSu) throws Exception {
		return cnd.checkma(user,maNhanSu);
	}
	public int themNhanVien(String maNhanVien ,String hoVaTen, boolean gioiTinh, Date ngaySinh, String sdt, float luong) throws Exception {
		return cnd.themNhanVien(maNhanVien, hoVaTen, gioiTinh, ngaySinh, sdt, luong);
	}
	public int themQuanLy(String maQuanLy ,String hoVaTen, boolean gioiTinh, Date ngaySinh, String sdt, float luong) throws Exception {
		return cnd.themQuanLy(maQuanLy, hoVaTen, gioiTinh, ngaySinh, sdt, luong);
	}
}
	