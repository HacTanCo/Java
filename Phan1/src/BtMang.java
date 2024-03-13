import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

public class BtMang {
	public String TaoNgay(String ngay1, String ngay2) {
		try {
			SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
			Date n1 = f.parse(ngay1);
			Date n2 = f.parse(ngay2);
			Random r = new Random();
			while (true) {
				Long t = r.nextLong();
				if (t >= n1.getTime() && t <= n2.getTime()) {
					Date n = new Date(t);
					return f.format(n);
				}
			}
		} catch (Exception tt) {
			System.out.println("Loi: " + tt.getMessage());
			return null;
		}
	}

	public String TaoHoTen() {
		String[] ho = { "Hac", "Do", "Le", "Nguyen" };
		String[] chulot = { "Tan", "Trong Hoang", "Quang", "Quoc" };
		String[] ten = { "Co", "Lan", "Dat", "Thinh" };
		Random r = new Random();
		return ho[r.nextInt(ho.length)] + " " + chulot[r.nextInt(chulot.length)] + " " + ten[r.nextInt(ten.length)];
	}

	public void HienThi(int n) {
		Random r = new Random();
		for (int i = 0; i < n; i++) {
			double dtb = r.nextDouble() * 10;
			System.out.println(TaoHoTen() + ";" + TaoNgay("01/01/1960", "01/01/2000") + ";"
					+ (Math.round(dtb * 10.0) / 10.0) + ";" + createsex() + ";" + result(dtb) + ";" + level(dtb));
		}
	}

	public String result(double dtb) {
		return (dtb >= 5) ? "Dau" : "Rot";
	}

	public String createsex() {
		String[] gt = { "Nam", "Nu" };
		Random r = new Random();
		return gt[r.nextInt(gt.length)];
	}

	public String level(double dtb) {
		if (dtb < 3)
			return "Kem";
		else if (dtb < 5)
			return "Yeu";
		else if (dtb < 6.5)
			return "Trung Binh";
		else if (dtb < 8)
			return "Kha";
		else if (dtb <= 10)
			return "Gioi";
		else
			return "Diem Khong Hop Le";
	}
}