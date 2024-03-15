package view;

import bean.NhanVienBean;
import bo.NhanVienBo;

public class NhanVienView {
	public static void main(String[] args) {
		try {
			NhanVienBo nvb = new NhanVienBo();
			for(NhanVienBean i : nvb )
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
