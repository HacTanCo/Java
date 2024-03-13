package view;

import java.util.ArrayList;

import bean.Nguoi;
import bo.Nguoibo;

public class Nguoiview {
	public static void main(String[] args) {
		try {
			Nguoibo a = new Nguoibo();
			ArrayList<Nguoi> ds = a.getds();
			System.out.println("Danh sach !!!\n");
			a.show();
			System.out.println("\nDanh sach tren 100 tuoi !!!\n");
			System.out.println(a.getdstheotuoi(100));
			System.out.println("\nDanh sach thong ke !!!\n");
			System.out.println(a.thongke());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}