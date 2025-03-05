package Dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import Bean.CauHinhBean;
import Bean.NganhDaoTao;
import Bean.SinhVienBean;

public class NguonDuLieuText implements INguonDuLieu{
	private String duongDanThuMuc;
	
	public NguonDuLieuText() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public NguonDuLieuText(String duongDanThuMuc) {
		super();
		this.duongDanThuMuc = duongDanThuMuc;
	}
	
	public String getDuongDanThuMuc() {
		return duongDanThuMuc;
	}

	public void setDuongDanThuMuc(String duongDanThuMuc) {
		this.duongDanThuMuc = duongDanThuMuc;
	}
	
	@Override
	public String toString() {
		return duongDanThuMuc;
	}

	@Override
	public ArrayList<SinhVienBean> docDanhSachSV() throws Exception {
		CauHinhBean chb = CauHinhBean.getInstance();
		duongDanThuMuc = chb.getChuoiKetNoi()+"/sinhvien.txt";
		ArrayList<SinhVienBean> danhSachSV = new ArrayList<SinhVienBean>();
		
		FileReader fr = new FileReader(duongDanThuMuc);
		BufferedReader br = new BufferedReader(fr);
		while(true) {
			String line = br.readLine();
			if(line == null || line == "")
				break;
			String[] che = line.split(";");
			danhSachSV.add(new SinhVienBean(che[0], che[1], che[2]));
		}
		br.close();
		return danhSachSV;
	}

	@Override
	public ArrayList<NganhDaoTao> docDanhSachNDT() throws Exception {
		CauHinhBean chb = CauHinhBean.getInstance();
		duongDanThuMuc = chb.getChuoiKetNoi();
		FileReader fr = new FileReader(duongDanThuMuc+"/nganh.txt");
		ArrayList<NganhDaoTao> danhSachNganh = new ArrayList<NganhDaoTao>();
		
		BufferedReader br = new BufferedReader(fr);
		while(true) {
			String line = br.readLine();
			if(line == null || line == "")
				break;
			String[] che = line.split(";");
			danhSachNganh.add(new NganhDaoTao(che[0], che[1]) );
		}
		br.close();
		return danhSachNganh;
	}
	
	public static void main(String[] args)throws Exception {
		NguonDuLieuText ndlt = new NguonDuLieuText();
		
		ArrayList<SinhVienBean> danhSachSV = ndlt.docDanhSachSV();
		ArrayList<NganhDaoTao> danhSachNDT = ndlt.docDanhSachNDT();
		
		System.out.println("Danh sach sinh vien !!!");
		for (SinhVienBean i : danhSachSV) {
			System.out.println(i.toString());
		}
		System.out.println("Danh sach nganh dao tao !!!");
		for (NganhDaoTao i : danhSachNDT) {
			System.out.println(i.toString());
		}
	}
	
}
