package Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import Model.NguonDuLieu;
import Model.SinhVien;

public class NguonDuLieuText implements NguonDuLieu {
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	public ArrayList<SinhVien> danhSachSV = new ArrayList<SinhVien>();
	@Override
	public ArrayList<SinhVien> DocDanhSachSV() throws Exception{
		
		FileReader fr = new FileReader("sinhvien.txt");
		BufferedReader br = new BufferedReader(fr);
		while(true) {
			String line = br.readLine();
			if(line == "" || line == null)
				break;
			String[] che = line.split(",");
			danhSachSV.add(new SinhVien(che[0], che[1], Boolean.parseBoolean(che[2]), sdf.parse(che[3]) ));
		}
		br.close();
		return danhSachSV;
	}

	@Override
	public void ThemSinhVien(SinhVien sv) throws Exception{
		FileWriter fw = new FileWriter("sinhvien.txt",true);
		PrintWriter ghi = new PrintWriter(fw);
		ghi.println(sv.getMaSinhVien() + "," + sv.getHoVaTen() + "," + sv.getGioiTinh() + "," + sdf.format(sv.getDoB()));
		ghi.close();
		danhSachSV.add(sv);
	}

	@Override
	public void XoaSinhVien(String maSinhVien)throws Exception {
        Iterator<SinhVien> iterator = danhSachSV.iterator();
        while(iterator.hasNext()) {
        	SinhVien sv = iterator.next();
        	if(sv.getMaSinhVien().equals(maSinhVien))
        		iterator.remove();
        }
        
        FileWriter fw = new FileWriter("sinhvien.txt",false);
		PrintWriter ghi = new PrintWriter(fw);
        for (SinhVien i : danhSachSV) {
			ghi.println(i.toString());
		}
        ghi.close();
	}
	public static void main(String[] args) throws Exception{
		NguonDuLieuText a = new NguonDuLieuText();
		List<SinhVien> dssv = a.DocDanhSachSV();
		for (SinhVien i : dssv) {
			System.out.println(i.toString());
		}
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nNhap ma sinh vien: ");
		String maSinhVien = scanner.nextLine();
		System.out.print("Nhap ho va ten sinh vien: ");
		String hoVaTen = scanner.nextLine();
		System.out.print("Nhap gioi tinh sinh vien: ");
		Boolean gioiTinh = scanner.nextBoolean();
		scanner.nextLine();
		System.out.print("Nhap ngay sinh sinh vien (yyyy/MM/dd): ");
		String DoB = scanner.nextLine();
		
		SinhVien sv = new SinhVien(maSinhVien, hoVaTen, gioiTinh, sdf.parse(DoB));
		a.ThemSinhVien(sv);
		System.out.println("\nDanh sach sau khi them !!!");
		for (SinhVien i : dssv) {
			System.out.println(i.toString());
		}
		
		System.out.print("\nNhap ma sinh vien can xoa: ");
		String maSinhVienXoa = scanner.nextLine();
		a.XoaSinhVien(maSinhVienXoa);
		System.out.println("\nDanh sach sau khi xoa !!!");
		for (SinhVien i : dssv) {
			System.out.println(i.toString());
		}
		
	}


}
