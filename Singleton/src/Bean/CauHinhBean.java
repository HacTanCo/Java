package Bean;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class CauHinhBean {
	private String loaiNguon,chuoiKetNoi;
	private static CauHinhBean instance = null;
	private CauHinhBean(String loaiNguon, String chuoiKetNoi) {
		this.loaiNguon = loaiNguon;
		this.chuoiKetNoi = chuoiKetNoi;
	}
	public CauHinhBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getLoaiNguon() {
		return loaiNguon;
	}
	public void setLoaiNguon(String loaiNguon) {
		this.loaiNguon = loaiNguon;
	}
	public String getChuoiKetNoi() {
		return chuoiKetNoi;
	}
	public void setChuoiKetNoi(String chuoiKetNoi) {
		this.chuoiKetNoi = chuoiKetNoi;
	}
	public static CauHinhBean getInstance() throws Exception {
		ArrayList<String> docFile = new ArrayList<String>();
		if(instance == null) {
			instance = new CauHinhBean();
			
			FileReader fr = new FileReader("cauhinh.txt");
			BufferedReader br = new BufferedReader(fr);
			while(true) {
				String line = br.readLine();
				if(line==null || line=="")
					break;
				docFile.add(line);
			}
			br.close();
			instance.loaiNguon = docFile.get(0);
			instance.chuoiKetNoi = docFile.get(1);
		}
		return instance;
	}
	
	public static void main(String[] args) throws Exception{
		CauHinhBean chb = CauHinhBean.getInstance();
		System.out.println(chb.getLoaiNguon());
		System.out.println(chb.getChuoiKetNoi());
	}
}
