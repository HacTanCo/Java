package bo;

import java.util.ArrayList;

import bean.SinhVienBean;
import dao.Nguoidao;

public class SinhVienBo {
	public ArrayList<SinhVienBean> ds;
	Nguoidao ndao = new Nguoidao();
	public ArrayList<SinhVienBean> getsv()throws Exception{
		ds = ndao.getsv();
		return ds;
	}
	//liet ke all chuc nang cua sinh vien
//	public double avg()
}
