package view;

import java.util.ArrayList;
import java.util.Scanner;

import bean.CanBoBean;
import bo.CanBoBo;

public class CanBoView {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			CanBoBo a= new CanBoBo();
			
//			ArrayList<CanBoBean> listcanbo = a.getCanbo();
//			System.out.println("Danh sach !!!\n");
//			System.out.println(a.getCanbo());
//			System.out.print("\nNhap full name can bo can tim: ");
//			String x = sc.nextLine();
//			System.out.println(a.TimCanBo(x));
//			System.out.print("\nNhap ma can bo can xoa: ");
//			String y = sc.nextLine();
//			System.out.println(a.Xoa(y));
//			System.out.print("\nTong luong can bo: "+a.TongLuong());
//			System.out.print("\n\nNhap ma can bo: ");
//			String ma = sc.nextLine();
//			System.out.print("Nhap full name can bo: ");
//			String hvt = sc.nextLine();
//			System.out.print("Nhap he so luong can bo: ");
//			double hsl = sc.nextDouble();
//			System.out.print("\nAdd 1 can bo to the list !!!\n");
//			System.out.println(a.Them(ma, hvt, hsl));
			
			
			System.out.println("Danh sach can bo !!!\n");
			a.getCanBo();
			System.out.print("\nNhap full name can bo can tim: ");
			String x = sc.nextLine();
			a.timCanBo(x);
			System.out.print("\nNhap ma can bo can xoa: ");
			String y = sc.nextLine();
			a.xoa(y);
			System.out.print("\nTong luong can bo: "+a.sumluong());
			System.out.print("\n\nNhap ma can bo: ");
			String ma = sc.nextLine();
			System.out.print("Nhap full name can bo: ");
			String hvt = sc.nextLine();
			System.out.print("Nhap he so luong can bo: ");
			double hsl = sc.nextDouble();
			System.out.print("\nAdd 1 can bo to the list !!!\n");
			a.them(ma, hvt, hsl);
			
			sc.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
