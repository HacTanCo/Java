package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import bean.maytinhbanbean;
import bean.maytinhbean;
import bean.maytinhxachtaybean;

public class maytinhdao {
	public ArrayList<maytinhbean> dshople = new ArrayList<maytinhbean>();
	public SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public void infile()throws Exception{
		FileReader fr = new FileReader("hactanco.txt");
		BufferedReader br = new BufferedReader(fr);
		System.out.println("Danh sach trong File !!!");
		while(true) {
			String l = br.readLine();
			if(l==null || l=="") break;
			System.out.println(l);
			String[] c = l.split("[;]");
			if(c.length == 6) {
				dshople.add(new maytinhbanbean(c[0], c[1], new Date(sdf.parse(c[2]).getTime()), Float.parseFloat(c[3]), Integer.parseInt(c[4]), c[5]));
			}
			else if(c.length==7) {
				dshople.add(new maytinhxachtaybean(c[0], c[1], new Date(sdf.parse(c[2]).getTime()), Float.parseFloat(c[3]), Integer.parseInt(c[4]), c[5], Float.parseFloat(c[6])));
			}
		}
	}
	public void inriengbiet() throws Exception {
		System.out.println("\nDanh sach may tinh ban !!!");
		for(maytinhbean i : dshople) {
			if(i instanceof maytinhbanbean) {
				System.out.println(i.toString());
			}
		}
		System.out.println("\nDanh sach may tinh xach tay !!!");
		for(maytinhbean i : dshople) {
			if(i instanceof maytinhxachtaybean) {
				System.out.println(i.toString());
			}
		}
	}
	public boolean checkma(String x) throws Exception{
		String sql = "select * from MTXachTay where mm = ?";
		PreparedStatement ps = ketnoidao.cn.prepareStatement(sql);
		ps.setString(1, x);
		ResultSet rs = ps.executeQuery();
		boolean check = rs.next();
		rs.close();
		return check;
	}
	public void them(String mm, String tm, Date nnh, float gia, int sl, String mau, float kcmh) throws Exception{
		String sql = "insert into MTXachTay(mm,tm,nnh,gia,sl,mau,kcmh) values (?,?,?,?,?,?,?)";
		PreparedStatement ps = ketnoidao.cn.prepareStatement(sql);
		ps.setString(1, mm);
		ps.setString(2, tm);
		ps.setDate(3, nnh);
		ps.setFloat(4, gia);
		ps.setInt(5, sl);
		ps.setString(6, mau);
		ps.setFloat(7, kcmh);
		ps.executeUpdate();
	}
	public void upcsdl() throws Exception{
		for(maytinhbean i : dshople) {
			if(i instanceof maytinhxachtaybean) {
				if(!checkma(i.getMm())) {
					them(i.getMm(), i.getTm(), i.getNnh(), i.getGia(), i.getSl(), ((maytinhxachtaybean) i).getMau(),((maytinhxachtaybean)i).getKcmh() );
				}
			}
		}
		System.out.println("Luu CSDL thanh cong !!!");
	}
	public void update(String mm, int sl) throws Exception{
		String sql = "update MTXachTay set sl =? where mm = ?";
		PreparedStatement ps = ketnoidao.cn.prepareStatement(sql);
		ps.setInt(1, sl);
		ps.setString(2, mm);
		ps.executeUpdate();
	}
	
	public void buycomputer(String mm,int sl) throws Exception{
		int dem = 0;
		for(maytinhbean i : dshople) {
			if(i instanceof maytinhxachtaybean) {
				if(i.getMm().equals(mm) && sl <= i.getSl()) {
					System.out.println("Gia: "+i.getGia() +",So luong: "+sl +",Thanh tien: "+i.getGia()*i.getSl());
					update(i.getMm(), i.getSl() - sl);
					i.setSl(i.getSl() - sl);
					System.out.println("Da ban va cap nhat so luong thanh cong !!!");
					dem++;
				}
				else if(sl > i.getSl()) {
					System.out.println("khong du so luong !!!");
					dem++;
					break;
				}
				
			}
		}
		if(dem==0)System.out.println("Khong ton tai ma may can tim");
	}
//	public static void main(String[] args)throws Exception {
//		maytinhdao mtd = new maytinhdao();
//		ketnoidao knd = new ketnoidao();
//		mtd.infile();
//		mtd.inriengbiet();
//		knd.ketnoi();
//		mtd.upcsdl();
//		Scanner sc = new Scanner(System.in);
//		System.out.print("\nnhap ma may: ");
//		String mm = sc.nextLine();
//		System.out.print("nhap so luong: ");
//		int sl = sc.nextInt();
//		mtd.buycomputer(mm, sl);
//		
//	}
}
