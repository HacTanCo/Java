package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import bean.CanBoBean;

public class CanBoDao {
	public ArrayList<CanBoBean> getCanBo() throws Exception {
		ArrayList<CanBoBean> listcanbo = new ArrayList<CanBoBean>();
		FileReader f = new FileReader("cb.txt");
		BufferedReader r = new BufferedReader(f);
		while(true) {
			String line = r.readLine();
			if(line==null || line=="")
				break;
			String[] che = line.split("\\|");
			String ma=che[0];
			String ht=che[1];
			double hsl = Double.parseDouble(che[2]);
			CanBoBean cb = new CanBoBean(ma,ht,hsl);
			listcanbo.add(cb);
		}
		r.close();
		return listcanbo;
	}
}
