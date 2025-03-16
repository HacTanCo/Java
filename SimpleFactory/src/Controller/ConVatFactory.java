package Controller;

import Model.Cho;
import Model.ConVat;
import Model.Ga;
import Model.Meo;

public class ConVatFactory {
	public ConVat getConVat(String loai) {
		if(loai.toLowerCase().equals("ga")) {
			return new Ga();
		}
		else if(loai.toLowerCase().equals("cho")) {
			return new Cho();
		}
		else if(loai.toLowerCase().equals("meo")) {
			return new Meo();
		}
		else
			return null;
		
	}
}
