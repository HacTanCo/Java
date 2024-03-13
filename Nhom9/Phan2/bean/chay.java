package bean;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class chay {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Nguoi> listperson = new ArrayList<Nguoi>();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Nguoi a = new Nguoi("lan", false, sdf.parse("12/11/2004"));
			Nguoi a1 = new Nguoi("dat", true, sdf.parse("11/01/2004"));
			Nguoi a2 = new Nguoi("thinh", false, sdf.parse("19/05/2004"));
			Nguoi a3 = new Nguoi("co", true, sdf.parse("24/04/2004"));
			listperson.add(a);
			listperson.add(a1);
			listperson.add(a2);
			listperson.add(a3);
			System.out.println("Danh sach !!!\n");
			for(Nguoi i : listperson) {  
				System.out.println(i.toString());
			}
			System.out.println("\nDanh sach tren 30 !!!");
			for(Nguoi i : listperson) {
				if(i.getTuoi()>30) {
					System.out.println(i.toString());
				}
			}
			int b=0,g=0;
			for(Nguoi x:listperson) {
				if(x.isGioitinh()==true)b++;
				else g++;
			}
			System.out.println("\nNam : "+b);
			System.out.println("Nu : "+g);
			System.out.print("\nNhap ten can tim: ");
			String x = sc.nextLine();
			System.out.println("\nDanh sach nhung nguoi ten : "+x);
			for(Nguoi i : listperson) {
				if(i.getHoten().trim().toLowerCase().contains(x)) {
					System.out.println(i.toString());
				}
			}
			//luu mang vao file
			FileOutputStream f = new FileOutputStream("ds.txt");
			OutputStreamWriter o = new OutputStreamWriter(f);
			PrintWriter w = new PrintWriter(o);
			
			for(Nguoi i : listperson) {
				w.write(i.toString()+'\n');
			}
			w.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}