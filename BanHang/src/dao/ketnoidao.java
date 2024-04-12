package dao;
import java.sql.Connection;
import java.sql.DriverManager;

public class ketnoidao {
	public static Connection cn;
	public void ketnoi() throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Da tim thay HQTCSDL");
		cn = DriverManager.getConnection("jdbc:sqlserver://LAB405-05:1433;databaseName=BaiTap; user=sa; password=123");
		System.out.println("Da ket noi thanh cong\n");
	}
	public void ketnoivaomay(String servername,String user,String password) throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Da tim thay HQTCSDL");
		cn = DriverManager.getConnection("jdbc:sqlserver://"+servername+":1433;databaseName=BaiTap; user="+user+"; password="+password);
		System.out.println("Da ket noi thanh cong\n");
	}
//	public static void main(String[] args) {
//		try {
//			ketnoidao knd = new ketnoidao();
//			knd.ketnoi();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
}
