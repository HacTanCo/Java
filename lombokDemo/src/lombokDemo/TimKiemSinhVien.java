package lombokDemo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TimKiemSinhVien {
	public static TimKiemSinhVien timKiemSinhVien = new TimKiemSinhVien();
	public List<SinhVien> DanhSachSinhVien() throws Exception {
		List<SinhVien> listSinhVien = new ArrayList<SinhVien>();
		FileReader fr = new FileReader("sinhvien.txt");
		BufferedReader br = new BufferedReader(fr);
		while(true) {
			String line = br.readLine();
			if(line == null || line =="") break;
			String[] che = line.split(";");
			listSinhVien.add(new SinhVien(che[0], che[1], Boolean.parseBoolean(che[2]), Integer.parseInt(che[3])));
		}
		br.close();
		return listSinhVien;
	}
	static Map<String, SinhVien> cache = new HashMap<String, SinhVien>();
	
	static SinhVien TimKiemTuongDoiSinhVien(String value)throws Exception {
		String maSinhVien = value;
		SinhVien sv = null;
		if(cache.containsKey(maSinhVien) == false) {
			System.out.println("Chưa có Sinh viên trong bộ nhớ cache !");
			for (SinhVien i : timKiemSinhVien.DanhSachSinhVien()) {
				if(i.getMaSinhVien().trim().toLowerCase().equals(maSinhVien)) {
					sv = i;
				}
			}
			cache.put(maSinhVien, sv);
		}
		return cache.get(maSinhVien);
	}
	
	
	public static void main(String[] args)throws Exception {
		for(int i=0;i<10;i++) {
			System.out.print("\nNhập tên sinh viên cần tìm: ");
			Scanner sc = new Scanner(System.in);
			String maSinhVien = sc.nextLine();
			SinhVien x = TimKiemTuongDoiSinhVien(maSinhVien);
			System.out.println(x.toString());	
		}
	}
}
