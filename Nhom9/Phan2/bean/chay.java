package bean;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class chay{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Nguoi> listperson = new ArrayList<Nguoi>();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Nguoi a = new Nguoi("lan", false, sdf.parse("12/11/2004"));
			Nguoi a1 = new Nguoi("dat", true, sdf.parse("11/01/2004"));
			//tao ra 2 sinh vien va 2 nhan vien
			SinhVienBean sv1 = new SinhVienBean("22T1020557", "Hac Tan Co", true,sdf.parse("24/04/2004"), "K46H", 10.0);
			SinhVienBean sv2 = new SinhVienBean("22T1020193", "Do Trong Hoang Lan", true, sdf.parse("12/11/2004"), "K46A",9.9);
			NhanVienBean nv1 = new NhanVienBean("Nhanvien1", "Nguyen Van A", false, sdf.parse("01/02/2000"), "nv1@gmail.com", "0123456789", 4.4);
			NhanVienBean nv2 = new NhanVienBean("Nhanvien2", "Nguyen Van B", true, sdf.parse("02/02/2000"), "nv2@gmail.com", "0123456788", 4.3);
			//hien thi thong tin
			System.out.println(sv1.toString());
			System.out.println(sv2.toString());
			System.out.println(nv1.toString());
			System.out.println(nv2.toString());
			//tao ra 1 mang dong luu 2 nguoi,2sinh vien va  2 nhan vien
			ArrayList<Nguoi> ds = new ArrayList<Nguoi>();
			ds.add(a);ds.add(a1);ds.add(sv1);ds.add(sv2);ds.add(nv1);ds.add(nv2);
			//hien thi all gia tri cua mang ra man hinh
			System.out.println("\nDanh sach ALL !!!");
			for(Nguoi i : ds)
				System.out.println(i);
			//hien thi ds nhan vien
			System.out.println("\nDanh sach nhan vien !!!");
			for(Nguoi i : ds)
				if (i instanceof NhanVienBean)
					System.out.println(i);
			//hien thi ds sinh vien
			System.out.println("\nDanh sach sinh vien !!!");
			for(Nguoi i : ds)
				if (i instanceof SinhVienBean) 
					System.out.println(i);
			//hien thi ds nguoi
			System.out.println("\nDanh sach Nguoi !!!");
			for(Nguoi i : ds)
				if (!(i instanceof NhanVienBean)&& !(i instanceof SinhVienBean))
					System.out.println(i);
			//tinh avg cua hsl nhan vien
			double avg=0;
			int dem=0;
			for(Nguoi i : ds)
				if(i instanceof NhanVienBean) {
					avg += ((NhanVienBean) i).getHsl(); 
					dem++;
				}
			System.out.print("\nHe so luong trung binh: "+avg/dem);
					
//			Nguoi a2 = new Nguoi("thinh", false, sdf.parse("19/05/2004"));
//			Nguoi a3 = new Nguoi("co", true, sdf.parse("24/04/2004"));
//			listperson.add(a);
//			listperson.add(a1);
//			listperson.add(a2);
//			listperson.add(a3);
//			System.out.println("Danh sach !!!\n");
//			for(Nguoi i : listperson) {  
//				System.out.println(i.toString());
//			}
//			System.out.println("\nDanh sach tren 30 !!!");
//			for(Nguoi i : listperson) {
//				if(i.getTuoi()>30) {
//					System.out.println(i.toString());
//				}
//			}
//			int b=0,g=0;
//			for(Nguoi x:listperson) {
//				if(x.isGioitinh()==true)b++;
//				else g++;
//			}
//			System.out.println("\nNam : "+b);
//			System.out.println("Nu : "+g);
//			System.out.print("\nNhap ten can tim: ");
//			String x = sc.nextLine();
//			System.out.println("\nDanh sach nhung nguoi ten : "+x);
//			for(Nguoi i : listperson) {
//				if(i.getHoten().trim().toLowerCase().contains(x)) {
//					System.out.println(i.toString());
//				}
//			}
//			//luu mang vao file
//			FileOutputStream f = new FileOutputStream("ds.txt");
//			OutputStreamWriter o = new OutputStreamWriter(f);
//			PrintWriter w = new PrintWriter(o);
//			
//			for(Nguoi i : listperson) {
//				w.write(i.toString()+'\n');
//			}
//			w.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}