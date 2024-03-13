import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BtArraylist {

	public ArrayList<String> DsHoten = new ArrayList<String>();
	public ArrayList<Double> DsDtb = new ArrayList<Double>();

	public void TaoDanhSach() {
		try {
			FileInputStream f = new FileInputStream("sv.txt");
			InputStreamReader ir = new InputStreamReader(f);
			BufferedReader r = new BufferedReader(ir);
			while (true) {
				String st = r.readLine();
				if (st == "" || st == null)
					break;
				String[] ds = st.split("[;]");
				DsHoten.add(ds[0]);
				DsDtb.add(Double.parseDouble(ds[3]));
			}
			r.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Loi o ham XuatDanhSach: " + e.getMessage());
		}
	}

	public void XuatDanhSach() {
		int ss = DsHoten.size();
		for (int i = 0; i < ss; i++) {
			System.out.println(DsHoten.get(i) + ":" + DsDtb.get(i));
		}
	}

	public void searchname(String ten) {
		for (int i = 0; i < DsHoten.size(); i++) {
			if (DsHoten.get(i).trim().toLowerCase().contains(ten.trim().toLowerCase())) {
				System.out.println(DsHoten.get(i));
			}
		}

	}

	public void passandfail() {
		int pass = 0, fail = 0;
		for (Double i : DsDtb) {
			if (i >= 5)
				pass++;
			else
				fail++;
		}
		System.out.println("\nSo sinh vien dau va rot !!!");
		System.out.println("Pass:" + pass);
		System.out.println("Fail:" + fail);
	}

	public double avg() {
		double sum = 0;
		for (Double i : DsDtb) {
			sum += i;
		}
		return (Math.round((sum / DsDtb.size()) * 10.0) / 10.0);
	}
}
