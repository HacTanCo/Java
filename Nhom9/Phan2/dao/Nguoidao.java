package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import bean.Nguoi;

public class Nguoidao {
	public ArrayList<Nguoi> getds() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Nguoi a = new Nguoi("lan", false, sdf.parse("19/05/2004"));
		Nguoi a1 = new Nguoi("Bac Ho", true, sdf.parse("19/05/1890"));
		Nguoi a2 = new Nguoi("thinh", false, sdf.parse("19/05/2003"));
		Nguoi a3 = new Nguoi("co", true, sdf.parse("12/03/2004"));
		
		ArrayList<Nguoi> ds = new ArrayList<Nguoi>();
		ds.add(a);
		ds.add(a1);
		ds.add(a2);
		ds.add(a3);
		return ds;
	}
}