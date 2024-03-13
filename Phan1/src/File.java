import java.util.Scanner;

public class File {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BtFile f = new BtFile();
		System.out.print("Nhap so luong sinh vien: ");
		int n = sc.nextInt();
		sc.nextLine();
		f.TaoDanhSach(n);
		f.XuatDanhSach();
		System.out.print("\nNhap ten sinh vien can tim: ");
		String x = sc.nextLine();
		f.searchname(x);
		System.out.println("\nSo sinh vien dau va rot !!! ");
		f.passandfail();
		f.avg();
		f.error();
		sc.close();
	}
}
