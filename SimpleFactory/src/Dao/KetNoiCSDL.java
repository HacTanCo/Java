package Dao;

import java.sql.Connection;
import java.sql.DriverManager;

import Bean.CauHinh;

public class KetNoiCSDL {
	private static Connection instance = null;
	
	public static synchronized Connection getConnection() throws Exception {
		if(instance == null) {
			String url = String.format(CauHinh.getInstance().getChuoiKetNoi());
			instance = DriverManager.getConnection(url);
			System.out.println("Da ket noi thanh cong\n");
		}
		return instance;
	}
	public static void main(String[] args) throws Exception {
		getConnection();
	}
}
