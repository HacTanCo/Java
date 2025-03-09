package Dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class KetNoiSqlDao {
	public static Connection cn;
	public void ketnoi() throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Da tim thay HQTCSDL");
		cn = DriverManager.getConnection("jdbc:sqlserver://HIPC\\SQLEXPRESS:1433;databaseName=QuanLyNhanSu_Java; user=sa; password=123;");
		System.out.println("Da ket noi thanh cong\n");
	}
	public static void main(String[] args) throws Exception {
		KetNoiSqlDao kn = new KetNoiSqlDao();
		kn.ketnoi();
	}
}
