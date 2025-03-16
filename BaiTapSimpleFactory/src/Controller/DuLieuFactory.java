package Controller;

import Model.NguonDuLieu;

public class DuLieuFactory {
	public NguonDuLieu getNguonDuLieu(String duongDan) throws Exception {
		if(duongDan.toLowerCase().equals("txt")) {
			return new NguonDuLieuText();
		}
		else if(duongDan.toLowerCase().equals("csdl")) {
			return new NguonDuLieuCSDL();
		}
		else
			return null;
	}
}
