package file;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class bt 
{
	public static void main(String[] args) 
	{
		ArrayList<String> ds= new ArrayList<String>();
		try
		{
			FileReader f1= new FileReader("hang.txt");
			BufferedReader r= new BufferedReader(f1);
			while(true)	
				{
				String st= r.readLine();
				if(st==null|| st=="")  break;
			    System.out.println(st);
			    //them 1 phan tu vao mang
			    ds.add(st);
				}
			r.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("\nDu lieu trong mang");
		for(String i : ds)
		{
			String[] che = i.split("[;]");
			System.out.println(che[0]);
			System.out.println(che[1]);
			System.out.println(che[2]);
			System.out.println(che[3]);
			System.out.println("--------");
		}
		// nhap vao 1 ma hang -> in ra ten hang va gia
			//nhap ma hang
			//duyet qua cac hang
				//che hang ra thanh 4 thong tin
				// if thong tin == ma hang
					//in ra thong tin thu 3
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ma hang can tim: ");
		String x = sc.nextLine();
		for(String i : ds)
		{
			String[] che = i.split("[;]");
			if(che[0].trim().toLowerCase().equals(x.trim().toLowerCase()))
//			if(che[0].equals(x))
			{
				System.out.println(i);
			}
		}
		//In ra ten hang co gia lon nhat
			//tu lam
//		int max=0;
//		int a;
//		for(String i : ds)
//		{
//			String[] che = i.split("[;]");
//			a = Integer.parseInt(che[3]);
//			if(a>max)
//			{
//				max=a;
//			}
//		}
//		System.out.print("\nTen hang co gia tri lon nhat: ");
//		for(String i : ds)
//		{
//			String[] che = i.split("[;]");
//			a = Integer.parseInt(che[3]);
//			if(a==max)
//			{
//				System.out.println(i);
//			}
//		}
		String[] che=ds.get(0).split("[;]");
		Long max = Long.parseLong(ds.get(0).split("[;]")[3]);
		String th=che[1];
		int n=ds.size();
		for(int i=1;i<n;i++)
		{
			String[] che1 = ds.get(i).split("[;]");
			if(max < Long.parseLong(che1[3]))
			{
				max = Long.parseLong(che1[3]);
				th=che[1];
			}
		}
		System.out.print("\nTen hang: "+th+", Gia ban: "+max+'\n');
		//Nhap vao ten hang -> in ra hang tim dc( tim tuong doi)
		System.out.print("\nNhap ten hang can tim: ");
		String tenhang = sc.nextLine();
		for(String i : ds)
		{
			String[] che2 = i.split("[;]");
			if(che2[1].trim().toLowerCase().contains(tenhang.trim().toLowerCase()))
			{
				System.out.println(i);
			}
		}
		// mo file ra ghi de
		try 
		{
			FileWriter f2 = new FileWriter("luuhang.txt");
			PrintWriter ghi = new PrintWriter(f2);
			for(String i : ds)
			{
				ghi.println(i);
			}
			ghi.close();
			System.out.println("Da luu hang");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		sc.close();
	}
}