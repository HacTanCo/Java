package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Ketnoidao {
	public static Connection cn;
	public void ketnoi() throws Exception {
		//b1: xác định hệ QTCSDL
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");			
		System.out.println("Đã xác định hệ QTCSDL");
		//b2: kết nối vào CSDL
		cn = DriverManager.getConnection("jdbc:sqlserver://LAB405-05:1433;databaseName=nhom9; user=sa; password=123");
		System.out.println("Có thể qua môn");
	}
	public void hienthi() throws Exception {
		//b2: lấy dữ liệu về ( tạo câu lệnh SQL )
		String sql = "select * from nhanvien";
		//b3: TẠO câu lệnh PreparedStatement
		PreparedStatement cmd = Ketnoidao.cn.prepareStatement(sql);
		//b4: truyền tham số vào câu lệnh sql ( nếu có )
		//b5: thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		while(rs.next())
		{
			System.out.println("-------------------------");
			System.out.println(rs.getString("manv"));
			System.out.println(rs.getString("hoten"));
			System.out.println(rs.getBoolean("gioitinh"));
			System.out.println(rs.getDate("ngaysinh"));
			System.out.println(rs.getDouble("hsl"));
			System.out.println("-------------------------");
			
		}
		rs.close();
	}
	public void timkiem(String key)throws Exception {
		//b2: lấy dữ liệu về ( tạo câu lệnh SQL )
		String sql = "select * from nhanvien where hoten like ?";
		//b3: TẠO câu lệnh PreparedStatement
		PreparedStatement cmd = Ketnoidao.cn.prepareStatement(sql);
		//b4: truyền tham số vào câu lệnh sql ( nếu có )
		cmd.setString(1,"%"+key+"%");
		//b5: thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		// duyệt rs
		while(rs.next())
		{
			System.out.println("-------------------------");
			System.out.println(rs.getString("manv"));
			System.out.println(rs.getString("hoten"));
			System.out.println(rs.getBoolean("gioitinh"));
			System.out.println(rs.getDate("ngaysinh"));
			System.out.println(rs.getDouble("hsl"));
			System.out.println("-------------------------");
			
		}
		rs.close();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			//b1: kết nối
			Ketnoidao kndao = new Ketnoidao();
			kndao.ketnoi();
			kndao.hienthi();
			String x = sc.nextLine();
			kndao.timkiem(x);
			
			sc.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
	}	
	
}
