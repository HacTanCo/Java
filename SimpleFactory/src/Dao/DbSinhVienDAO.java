package Dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.Buffer;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import Bean.SinhVien;

public class DbSinhVienDAO implements SinhVienDAO {
	public ArrayList<SinhVien> listSinhVien = new ArrayList<SinhVien>();
	@Override
	public ArrayList<SinhVien> DocDanhSach() throws Exception {
		Connection ketNoi = KetNoiCSDL.getConnection();
		String sql = "select * from SinhVien";
		PreparedStatement ps = ketNoi.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			String maSinhVien = rs.getString("maSinhVien");
			String hoTen = rs.getString("hoTen");
			boolean gioiTinh = rs.getBoolean("gioiTinh");
			Date ngaySinh = rs.getDate("ngaySinh");
			listSinhVien.add(new SinhVien(maSinhVien, hoTen, gioiTinh, ngaySinh));
		}
		return listSinhVien;
	}
	public boolean KiemTraMa(String maSinhVien) throws Exception {
		Connection ketNoi = KetNoiCSDL.getConnection();
		String sql = "select * from SinhVien where maSinhVien=?";
		PreparedStatement ps = ketNoi.prepareStatement(sql);
		ps.setString(1, maSinhVien);
		ResultSet rs = ps.executeQuery();
		boolean kq = rs.next();
		rs.close();
		return kq;
	}
	@Override
	public void BoSung(SinhVien x) throws Exception {
		Connection ketNoi = KetNoiCSDL.getConnection();
		if(KiemTraMa(x.getMaSinhVien()) == true) {
			System.out.println("\nMa sinh vien da ton tai");
			return;
		}
			
		String sql = "insert into SinhVien values(?,?,?,?)";
		PreparedStatement ps = ketNoi.prepareStatement(sql);
		ps.setString(1, x.getMaSinhVien());
		ps.setString(2, x.getHoTen());
		ps.setBoolean(3, x.isGoiTinh());
		ps.setDate(4, x.getNgaySinh());
		//ps.executeUpdate();
		int ketQua = ps.executeUpdate();
		listSinhVien.add(x);
		if(ketQua > 0)
			System.out.println("\nThem sinh vien thanh cong !!!");
		else
			System.out.println("\nThem sinh vien khong thanh cong");
	}

	@Override
	public void Xoa(String maSinhVien) throws Exception {
		Connection ketNoi = KetNoiCSDL.getConnection();
		String sql = "delete SinhVien where maSinhVien = ?";
		PreparedStatement ps = ketNoi.prepareStatement(sql);
		ps.setString(1, maSinhVien);
		
		int ketQua = ps.executeUpdate();
		Iterator<SinhVien> iterator = listSinhVien.iterator();
		while(iterator.hasNext()) {
			SinhVien x = iterator.next();
			if(maSinhVien.equals(x.getMaSinhVien()))
				iterator.remove();
		}
		
		
		if(ketQua > 0)
			System.out.println("\nXoa sinh vien thanh cong !!!");
		else
			System.out.println("\nXoa sinh vien khong thanh cong");
		
	}
	public static void main(String[] args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		DbSinhVienDAO dbSinhVienDAO = new DbSinhVienDAO();
		ArrayList<SinhVien> listSinhVien = dbSinhVienDAO.DocDanhSach();
		//doc
		System.out.println("Danh sach sinh vien tren CSDL !!!");
		for (SinhVien i : listSinhVien) {
			System.out.println(i.toString());
		}
		//Them sinh vien
		dbSinhVienDAO.BoSung(new SinhVien("SV004", "Nguyen van F", false, new Date(sdf.parse("2004-4-4").getTime())));
		System.out.println("\nDanh sach sinh vien sau khi them !!!");
		for (SinhVien i : listSinhVien) {
			System.out.println(i.toString());
		}
		//Xoa sinh vien
		dbSinhVienDAO.Xoa("SV004");
		System.out.println("\nDanh sach sinh vien sau khi xoa !!!");
		for (SinhVien i : listSinhVien) {
			System.out.println(i.toString());
		}
	}
}
