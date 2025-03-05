package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.CauHinhBean;
import Bean.NganhDaoTao;
import Bean.SinhVienBean;

public class NguonDuLieuCSDL implements INguonDuLieu{
	private String chuoiKetNoi;
	private Connection ketnoi = null;
	
	private Connection getKetNoi() throws Exception {
		if(ketnoi == null) {
			CauHinhBean chb = CauHinhBean.getInstance();
			chuoiKetNoi = chb.getChuoiKetNoi();
			ketnoi = DriverManager.getConnection(chuoiKetNoi);
		}
		return ketnoi;
	}
	
	@Override
	public ArrayList<SinhVienBean> docDanhSachSV() throws Exception {
		ArrayList<SinhVienBean> danhSachSV = new ArrayList<SinhVienBean>();
		String sql = "select * from SinhVien";
		ketnoi = getKetNoi();
		PreparedStatement ps = ketnoi.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			String msv = rs.getString("maSinhVien");
			String ht = rs.getString("hoTen");
			String mn = rs.getString("maNganh");
			danhSachSV.add(new SinhVienBean(msv, ht, mn));
		}
		return danhSachSV;
	}
	@Override
	public ArrayList<NganhDaoTao> docDanhSachNDT() throws Exception {
		ArrayList<NganhDaoTao> danhSachNDT = new ArrayList<NganhDaoTao>();
		String sql = "select * from Nganh";
		ketnoi = getKetNoi();
		PreparedStatement ps = ketnoi.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			String mn = rs.getString("maNganh");
			String tndt = rs.getString("tenNganhDaoTao");
			danhSachNDT.add(new NganhDaoTao(mn, tndt));
		}
		return danhSachNDT;
	}
	public static void main(String[] args) throws Exception {
		NguonDuLieuCSDL nguoncsdl = new NguonDuLieuCSDL();
		ArrayList<SinhVienBean> danhsachSV = nguoncsdl.docDanhSachSV();
		ArrayList<NganhDaoTao> danhsachNDT = nguoncsdl.docDanhSachNDT();
		System.out.println("Danh sach sinh vien !!!");
		for (SinhVienBean i : danhsachSV) {
			System.out.println(i.toString());
		}
		System.out.println("\nDanh sach nganh dao tao !!!");
		for (NganhDaoTao i : danhsachNDT) {
			System.out.println(i.toString());
		}
	}
	
}
