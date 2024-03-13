import java.util.Scanner;

public class ArrayList {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BtArraylist a = new BtArraylist();
		a.TaoDanhSach();
		System.out.println("Danh sach sinh vien !!!");
		a.XuatDanhSach();
		System.out.print("\nNhap ten sinh vien can tim: ");
		String x = sc.nextLine();
		a.searchname(x);
		a.passandfail();
		System.out.println("\nAVG in list: " + a.avg());
		sc.close();
	}
}
