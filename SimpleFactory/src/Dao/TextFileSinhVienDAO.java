package Dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Bean.CauHinh;
import Bean.SinhVien;

public class TextFileSinhVienDAO implements SinhVienDAO {
	public SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	public ArrayList<SinhVien> listSinhVien = new ArrayList<SinhVien>();
	@Override
	public ArrayList<SinhVien> DocDanhSach() throws Exception {
		FileReader fr = new FileReader(CauHinh.getInstance().getChuoiKetNoi()+"/sinhvien.txt");
		BufferedReader br = new BufferedReader(fr);
		while(true) {
			String line = br.readLine();
			if(line==null || line=="")
				break;
			String[] che = line.split(";");
			listSinhVien.add(new SinhVien(che[0], che[1], Boolean.parseBoolean(che[2]), new Date(sdf.parse(che[3]).getTime())) );
		}
		fr.close();
		br.close();
		return listSinhVien;
	}

	@Override
	public void BoSung(SinhVien x) throws Exception {
		int dem = 0;
		for (SinhVien i : listSinhVien) {
			if(x.getMaSinhVien().equals(i.getMaSinhVien())) {
				dem++;
				break;
			}
		}
		if(dem == 0 ) {
			FileWriter fw = new FileWriter(CauHinh.getInstance().getChuoiKetNoi()+"/sinhvien.txt",true);
			PrintWriter ghi = new PrintWriter(fw);
			ghi.println(x.getMaSinhVien()+";"+x.getHoTen()+";"+x.isGoiTinh()+";"+sdf.format(x.getNgaySinh()));
			ghi.close();
			listSinhVien.add(x);
		}
		else {
			System.out.println("\nMa sinh vien da ton tai !!!");
		}
		
	}

	@Override
	public void Xoa(String maSinhVien) throws Exception {
		Iterator<SinhVien> iterator = listSinhVien.iterator();
		while(iterator.hasNext()) {
			SinhVien x = iterator.next();
			if(maSinhVien.equals(x.getMaSinhVien()))
				iterator.remove();
		}
		FileWriter fw = new FileWriter(CauHinh.getInstance().getChuoiKetNoi()+"/sinhvien.txt",false);
		PrintWriter ghi = new PrintWriter(fw);
		for (SinhVien x : listSinhVien) {
			ghi.println(x.getMaSinhVien()+";"+x.getHoTen()+";"+x.isGoiTinh()+";"+sdf.format(x.getNgaySinh()));
		}
		ghi.close();
	}
	public static void main(String[] args) throws Exception{
		TextFileSinhVienDAO a = new TextFileSinhVienDAO();
		ArrayList<SinhVien> listSinhVien = a.DocDanhSach();
		//doc
		System.out.println("Danh sach tu file txt !!!");
		for (SinhVien i : listSinhVien) {
			System.out.println(i.toString());
		}
		//them
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		a.BoSung(new SinhVien("sv4", "Nguyen Van D", true, new Date(sdf.parse("2004/4/4").getTime())));
		System.out.println("\nDanh sach sau khi bo sung !!!");
		for (SinhVien i : listSinhVien) {
			System.out.println(i.toString());
		}
		//xoa
		a.Xoa("sv4");
		System.out.println("\nDanh sach sau khi xoa !!!");
		for (SinhVien i : listSinhVien) {
			System.out.println(i.toString());
		}
		
	}
}
