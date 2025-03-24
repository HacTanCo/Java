package Bean;

import java.io.BufferedReader;
import java.io.FileReader;

public class CauHinh {
	private String loaiNguon,chuoiKetNoi;
	//1
	
	public String getLoaiNguon() {
		return loaiNguon;
	}
	public String getChuoiKetNoi() {
		return chuoiKetNoi;
	}
	//2
	private static CauHinh instance = null;
	//3
	private CauHinh() {}
	private CauHinh(String loaiNguon, String chuoiKetNoi) {
		this.loaiNguon = loaiNguon;
		this.chuoiKetNoi = chuoiKetNoi;
	}
	//4
	public static synchronized CauHinh getInstance() throws Exception {
		if(instance == null) {
			instance = new CauHinh();
			FileReader fr = new FileReader("cauhinh.txt");
			BufferedReader br = new BufferedReader(fr);
			instance.loaiNguon = br.readLine();
			instance.chuoiKetNoi = br.readLine();
			fr.close();
			br.close();
		}
		return instance;
			
	}
	
}
