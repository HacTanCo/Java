package bo;

import java.util.ArrayList;

import bean.NhanVienBean;
import bean.SinhVienBean;
import dao.Nguoidao;

public class NhanVienBo {
	public ArrayList<NhanVienBean> ds;
	Nguoidao ndao = new Nguoidao();
	public ArrayList<NhanVienBean> getsv()throws Exception{
		ds = ndao.getnv();
		return ds;
	}
	//liet ke all chuc nang cua nhan vien
}
