package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import bean.NhanVienBean;

public class nhanviendo {
	public ArrayList<NhanVienBean> getnv() throws Exception {
		ArrayList<NhanVienBean> ds = new ArrayList<NhanVienBean>();
		String sql = "select * from nhanvien";
		PreparedStatement ps = Ketnoidao.cn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String mnv = rs.getString("manv");
			String hoten = rs.getString("hoten");
			boolean gioitinh = rs.getBoolean("gioitinh");
			Date ngaysinh = rs.getDate("ngaysinh");
			String email = rs.getString("email");
			String sdt = rs.getString("sodt");
			Double hsl = rs.getDouble("hsl");
			ds.add(new NhanVienBean(mnv, hoten, gioitinh, ngaysinh, email, sdt, hsl));
		}
		rs.close();
		return ds;
	}

	public ArrayList<NhanVienBean> timkiem(String key) throws Exception {
		ArrayList<NhanVienBean> ds = new ArrayList<NhanVienBean>();
		String sql = "select * from nhanvien where hoten like ?";
		PreparedStatement ps = Ketnoidao.cn.prepareStatement(sql);
		ps.setString(1, "%" + key + "%");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String mnv = rs.getString("manv");
			String hoten = rs.getString("hoten");
			boolean gioitinh = rs.getBoolean("gioitinh");
			Date ngaysinh = rs.getDate("ngaysinh");
			String email = rs.getString("email");
			String sdt = rs.getString("sodt");
			Double hsl = rs.getDouble("hsl");
			ds.add(new NhanVienBean(mnv, hoten, gioitinh, ngaysinh, email, sdt, hsl));
		}
		rs.close();
		return ds;
	}

	public int xoa(String manv) throws Exception {
		String sql = "delete from nhanvien where manv=?";
		PreparedStatement ps = Ketnoidao.cn.prepareStatement(sql);
		ps.setString(1, manv);
		return ps.executeUpdate();// thực hiện câu lệnh
	}

	public int sua(String manv, double hsl) throws Exception {
		String sql = "update nhanvien set hsl = hsl + ? where manv=?";
		PreparedStatement ps = Ketnoidao.cn.prepareStatement(sql);
		ps.setDouble(1, hsl);
		ps.setString(2, manv);
		return ps.executeUpdate();// thực hiện câu lệnh
	}

	public boolean checkma(String manv) throws Exception {
		String sql = "select * from nhanvien where manv=?";
		PreparedStatement ps = Ketnoidao.cn.prepareStatement(sql);
		ps.setString(1, manv);
		ResultSet rs = ps.executeQuery();
		boolean kq = rs.next();
		rs.close();
		return kq;
	}

	public int them(String mnv, String hoten, boolean gioitinh, Date ngaysinh, String email, String sdt, Double hsl)throws Exception {
		if (checkma(mnv) == true)
			return 0;
		String sql = "insert into nhanvien(manv,hoten,gioitinh,ngaysinh,hsl,email,sodt) values (?,?,?,?,?,?,?)";
		PreparedStatement ps = Ketnoidao.cn.prepareStatement(sql);
		ps.setString(1, mnv);
		ps.setString(2, hoten);
		ps.setBoolean(3, gioitinh);
		ps.setDate(4, new java.sql.Date(ngaysinh.getTime()));
		ps.setString(5, email);
		ps.setString(6, sdt);
		ps.setDouble(7, hsl);
		return ps.executeUpdate();// thực hiện câu lệnh
	}
	public void savecsdl(String namefile) throws Exception {
		FileReader fr = new FileReader(namefile);
		BufferedReader bf = new BufferedReader(fr);
		while(true) {
			String line = bf.readLine();
			if(line=="" || line==null)
				break;
			String[] che = line.split("[,]");
			String mnv = che[0];
			String hoten = che[1];
			boolean gioitinh = Boolean.parseBoolean(che[2]);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date ngaysinh = sdf.parse(che[3]);
			String email = che[4];
			String sdt = che[5];
			Double hsl = Double.parseDouble(che[6]);
			them(mnv, hoten, gioitinh, ngaysinh, email, sdt, hsl);
		}
		bf.close();			
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Ketnoidao kndao = new Ketnoidao();
			kndao.ketnoi();
			nhanviendo nvdo = new nhanviendo();
//			String x = sc.nextLine();
//			nvdo.xoa(x);
//			String ma = sc.nextLine();
//			double hsl = sc.nextDouble();
//			nvdo.sua(ma, hsl);
			nvdo.savecsdl("data.txt");
			for (NhanVienBean i : nvdo.getnv()) {
				System.out.println(i.toString());
			}
			sc.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
