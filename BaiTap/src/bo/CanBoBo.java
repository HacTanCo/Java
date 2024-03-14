package bo;

import java.util.ArrayList;
import java.util.Iterator;

import bean.CanBoBean;
import dao.CanBoDao;

public class CanBoBo {
		CanBoDao cbdao = new CanBoDao();
		ArrayList<CanBoBean> listcanbo;
//	6.	Tại bo viết các hàm:
//		Hàm getCanBo(): trả về các cán bộ
		public ArrayList<CanBoBean> getCanbo() throws Exception{
			return cbdao.getCanBo();
		}
		public void getCanBo() throws Exception {
			listcanbo = cbdao.getCanBo();
			for(CanBoBean i : listcanbo) {
				System.out.println(i);
			}
		}
//		Hàm TimCanBo(String key) để tìm theo họ tên cán bộ
		public ArrayList<CanBoBean> TimCanBo(String key) throws Exception {
			ArrayList<CanBoBean> ds = new ArrayList<CanBoBean>();
			for(CanBoBean i : listcanbo) {
				if(i.getHoten().trim().toLowerCase().contains(key.trim().toLowerCase())) {
					ds.add(i);
				}
			}
			return ds;
		}
		public void timCanBo(String key) throws Exception {
			for(CanBoBean i : listcanbo) {
				if(i.getHoten().trim().toLowerCase().contains(key.trim().toLowerCase()))
					System.out.println(i);
			}
		}
//		Hàm Xoa(String ma): xóa cán bộ ra khỏi mảng
		public ArrayList<CanBoBean> Xoa(String ma) throws Exception {
			ArrayList<CanBoBean> ds = new ArrayList<CanBoBean>();
			for(CanBoBean i : listcanbo) {
				if(!(i.getMa().toLowerCase().trim().equals(ma.trim().toLowerCase()))) {
					ds.add(i);
				}
			}
			return ds;
		}
		public void xoa(String ma) throws Exception {
		    ArrayList<CanBoBean> xoa = new ArrayList<CanBoBean>();
		    for(CanBoBean i : listcanbo)
		    	if(i.getMa().trim().toLowerCase().equals(ma.trim().toLowerCase()))
		    		xoa.add(i);
		    listcanbo.removeAll(xoa);
		    for(CanBoBean i : listcanbo)
		    	System.out.println(i);
		}

//		Hàm TongLuong(): trả về tổng lương của các cán bộ
		public double TongLuong() {
			ArrayList<CanBoBean> ds = new ArrayList<CanBoBean>();
			double sum=0;
			for(CanBoBean i : listcanbo) {
				sum += i.luong();
			}
			return sum;
		}
		public double sumluong() throws Exception {
			double sum=0;
			for(CanBoBean i : listcanbo)
				sum+=i.luong();
			return sum;
		}
//		Hàm Them(String ma, String hoten, Double hsl) để thêm vào mảng 1 cán bộ
		public ArrayList<CanBoBean> Them(String ma, String hoten, Double hsl) throws Exception {
			CanBoBean cb = new CanBoBean(ma, hoten, hsl);
			listcanbo.add(cb);
			return listcanbo;
		}
		public void them(String ma, String hoten, Double hsl) throws Exception {
			CanBoBean cb = new CanBoBean(ma, hoten, hsl);
			listcanbo.add(cb);
			for(CanBoBean i : listcanbo)
				System.out.println(i);
		}
		
		
}
