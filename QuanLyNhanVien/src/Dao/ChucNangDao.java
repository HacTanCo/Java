package Dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ChucNangDao {
	public boolean checkDangNhap(String user, String pass) throws Exception {
        String sql = "select * from Account where userName = ? and passWord = ?";
        PreparedStatement ps = KetNoiSqlDao.cn.prepareStatement(sql);
        ps.setString(1, user);
        ps.setString(2, pass);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }
	public boolean checkma(String user,String maNhanSu) throws Exception {
		String sql = "select * from Account where userName=? or maNhanSu=? ";
		PreparedStatement ps = KetNoiSqlDao.cn.prepareStatement(sql);
		ps.setString(1, user);
		ps.setString(2, maNhanSu);
		ResultSet rs = ps.executeQuery();
		boolean result = rs.next();
		rs.close();
		return result;
	}
	public int dangKyTaiKhoan(String user, String pass, String maNhanSu) throws Exception {
	    String sql = "INSERT INTO Account (userName, passWord,maNhanSu) VALUES (?,?,?)";
	    PreparedStatement ps = KetNoiSqlDao.cn.prepareStatement(sql);
	    ps.setString(1, user);
	    ps.setString(2, pass); 
	    ps.setString(3, maNhanSu);
	    return ps.executeUpdate();
	}
	public int themNhanVien(String maNhanVien ,String hoVaTen, boolean gioiTinh, Date ngaySinh, String sdt, float luong) throws Exception {
		String sql = "insert into NhanSu (maNhanSu,hoVaten,gioiTinh,ngaySinh,sdt,luong) values(?,?,?,?,?,?)";
		PreparedStatement ps = KetNoiSqlDao.cn.prepareStatement(sql);
		ps.setString(1, maNhanVien);
		ps.setString(2, hoVaTen);
		ps.setBoolean(3, gioiTinh);
		ps.setDate(4, ngaySinh);
		ps.setString(5, sdt);
		ps.setFloat(6, luong);
		return ps.executeUpdate();
	}
	public int themQuanLy(String maQuanLy ,String hoVaTen, boolean gioiTinh, Date ngaySinh, String sdt, float luong) throws Exception {
		String sql = "insert into NhanSu (maNhanSu,hoVaten,gioiTinh,ngaySinh,sdt,luong) values(?,?,?,?,?,?)";
		PreparedStatement ps = KetNoiSqlDao.cn.prepareStatement(sql);
		ps.setString(1, maQuanLy);
		ps.setString(2, hoVaTen);
		ps.setBoolean(3, gioiTinh);
		ps.setDate(4, ngaySinh);
		ps.setString(5, sdt);
		ps.setFloat(6, luong);
		return ps.executeUpdate();
	}
}
