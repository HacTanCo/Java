package view;

import java.util.Scanner;

import bo.maytinhbo;

public class maytinhview {
	public static void main(String[] args) throws Exception{
		maytinhbo mtb = new maytinhbo();
		mtb.infile();
		mtb.inriengbiet();
		mtb.ketnoi();
		mtb.upcsdl();
		Scanner sc = new Scanner(System.in);
		System.out.print("\nnhap ma may: ");
		String mm = sc.nextLine();
		System.out.print("nhap so luong: ");
		int sl = sc.nextInt();
		mtb.buycomputer(mm, sl);
	}
}
