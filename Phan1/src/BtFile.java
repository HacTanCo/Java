import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Random;

public class BtFile {
	public void TaoDanhSach(int n) {
		try {
			FileOutputStream f = new FileOutputStream("sv.txt");
			OutputStreamWriter o = new OutputStreamWriter(f);
			PrintWriter w = new PrintWriter(o);
			Random r = new Random();
			BtMang m = new BtMang();

			for (int i = 1; i <= n; i++) {
				double dtb = r.nextDouble() * 10;
				w.println(m.TaoHoTen() + ";" + m.TaoNgay("01/01/1960", "01/01/2000") + ";" + m.createsex() + ";"
						+ (Math.round(dtb * 10.0) / 10.0) + ";" + m.result(dtb) + ";" + m.level(dtb));
			}

			w.close();
		} catch (Exception e) {
			System.out.println("Loi o ham TaoDanhSach: " + e.getMessage());
		}
	}

	public void XuatDanhSach() {
		try {
			FileInputStream f = new FileInputStream("sv.txt");
			InputStreamReader ir = new InputStreamReader(f);
			BufferedReader r = new BufferedReader(ir);

			while (true) {
				String st = r.readLine();
				if (st == null || st == "")
					break;

				String[] ds = st.split("[;]");
				System.out.println(ds[0] + ";" + ds[1] + ";" + ds[2] + ";" + ds[3] + ";" + ds[4] + ";" + ds[5]);
			}

			r.close();
		} catch (Exception e) {
			System.out.println("Loi o ham XuatDanhSach: " + e.getMessage());
		}
	}

	public void searchname(String ten) {
		try {
			FileInputStream f = new FileInputStream("sv.txt");
			InputStreamReader ir = new InputStreamReader(f);
			BufferedReader r = new BufferedReader(ir);
			while (true) {
				String st = r.readLine();
				if (st == null || st == "")
					break;
				String[] ds = st.split("[;]");
				if (ds[0].trim().toLowerCase().contains(ten.trim().toLowerCase())) {
					System.out.println(ds[0] + ";" + ds[1] + ";" + ds[2] + ";" + ds[3] + ";" + ds[4] + ";" + ds[5]);
				}
			}

			r.close();
		} catch (Exception e) {
			System.out.println("Loi o ham TimKiemTheoTen: " + e.getMessage());
		}
	}

	public void passandfail() {
		try {
			FileInputStream f = new FileInputStream("sv.txt");
			InputStreamReader ir = new InputStreamReader(f);
			BufferedReader r = new BufferedReader(ir);
			int pass = 0;
			int fail = 0;
			while (true) {
				String st = r.readLine();
				if (st == null || st == "")
					break;
				String[] ds = st.split("[;]");
				double dtb = Double.parseDouble(ds[3]);
				if (dtb >= 5.0) {
					pass++;
				} else {
					fail++;
				}
			}

			System.out.println("Dau: " + pass);
			System.out.println("Rot: " + fail);

			r.close();
		} catch (Exception e) {
			System.out.println("Loi o ham DemSinhVienDauRot: " + e.getMessage());
		}
	}

	public void avg() {
		try {
			FileInputStream f = new FileInputStream("sv.txt");
			InputStreamReader ir = new InputStreamReader(f);
			BufferedReader r = new BufferedReader(ir);
			double sumdtb = 0;
			int dem = 0;
			while (true) {
				String st = r.readLine();
				if (st == null || st == "")
					break;
				String[] ds = st.split("[;]");
				double dtb = Double.parseDouble(ds[3]);
				sumdtb += dtb;
				dem++;
			}

			double avg = sumdtb / dem;
			System.out.println("\nTrung binh cong cua diem trung binh la: " + (Math.round(avg * 10.0) / 10.0));

			r.close();
		} catch (Exception e) {
			System.out.println("Loi o ham TinhTrungBinhCong: " + e.getMessage());
		}
	}

	public void error() {
		try {
			FileInputStream f = new FileInputStream("sv.txt");
			InputStreamReader ir = new InputStreamReader(f);
			BufferedReader r = new BufferedReader(ir);

			while (true) {
				String st = r.readLine();
				if (st == null || st == "")
					break;
				String[] ds = st.split("[;]");
				double dtb = Double.parseDouble(ds[3]);
				if (dtb < 0 || dtb > 10) {
					System.out.println("Diem trung binh khong hop le: " + st);
				}
			}
			r.close();
		} catch (Exception e) {
			System.out.println("Loi o ham InDongKhongHopLe: " + e.getMessage());
		}
	}
}
