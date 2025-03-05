package View;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestKetNoiCSDL {
	public static void main(String[] args) {
		try {
			String url = "jdbc:sqlserver://localhost:1433;databaseName=Singleton;user=sa;password=123;trustServerCertificate=true;";
			Connection cn = DriverManager.getConnection(url);
			 System.out.println("Kết nối thành công đến SQL Server!");
		} catch (Exception e) {
			System.out.println("Không thể kết nối đến SQL Server.");
            e.printStackTrace();
		}
	}
}
