package bo;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


import bean.tinA;
import bean.tinB;
import dao.tinDao;

public class tinBo {
	tinDao td = new tinDao();
	ArrayList<Object> ds ;

	public ArrayList<Object> getds() throws Exception {
		ds = td.getds();
		return ds;
	}
	
	public void tktd() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ten can tim: ");
		String x = sc.nextLine();
		int dem=0;
		for (Object i : td.getds()) 
		{
			if (i instanceof tinA) 
			{
				if (((tinA) i).getHt().trim().toLowerCase().contains(x.trim().toLowerCase()))
				{
					dem++;
					System.out.println(i.toString());
				}
			} 
			else if (i instanceof tinB) 
			{
				if (((tinB) i).getHt().trim().toLowerCase().contains(x.trim().toLowerCase())) 
				{
					dem++;
					System.out.println(i.toString());
				}
			}
		}
		if(dem==0)
		{
			System.out.println("Khong co trong danh sach !!!");
		}

	}
	public void luuf1() throws Exception{
		FileWriter f = new FileWriter("f1.txt");
		PrintWriter w = new PrintWriter(f);
		for(Object i : td.getds())
			if( i instanceof tinA)
				w.print(i.toString()+"\n");
		w.close();
		System.out.println("Da luu f1");
	}
	public void luuf2() throws Exception{
		FileWriter f = new FileWriter("f2.txt");
		PrintWriter w = new PrintWriter(f);
		for(Object i : td.getds())
			if( i instanceof tinB)
				w.print(i.toString()+"\n");
		w.close();
		System.out.println("Da luu f2");
	}
	
}
