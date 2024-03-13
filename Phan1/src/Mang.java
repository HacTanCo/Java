import java.util.Scanner;

public class Mang {

	public static void main(String[] args) {
		BtMang m = new BtMang();
//		for(int i=0;i<100;i++ )
//		{
//			System.out.println(m.TaoHoTen());
//			String ngay1="01/02/1960";
//			String ngay2="12/12/1990";
//			System.out.println(m.TaoNgay(ngay1, ngay2));
//		}
		m.HienThi(10);
		Scanner x = new Scanner(System.in);
		System.out.print("Nhap so luong sinh vien: ");
		int n = x.nextInt();
		m.HienThi(n);
		x.close();
	}
}