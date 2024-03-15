package view;

import bean.SinhVienBean;
import bo.SinhVienBo;

public class SinhVienView {
	public static void main(String[] args) {
		try {
			SinhVienBo svb = new SinhVienBo();
			for(SinhVienBean i : svb.getsv())
				System.out.println(i);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
