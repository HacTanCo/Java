package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import bean.tinA;
import bean.tinB;

public class tinDao {
	public ArrayList<Object> getds() throws Exception{
		ArrayList<Object> ds = new ArrayList<Object>();
		FileReader f = new FileReader("ds.txt");
		BufferedReader r = new BufferedReader(f);
		while(true) {
			String l = r.readLine();
			if(l==null || l=="")
				break;
			String[] che = l.split(";");
			if(che.length==4) {
				tinA a = new tinA(che[0], che[1], Double.parseDouble(che[2]),  Double.parseDouble(che[3]));
				ds.add(a);
			}
			else if (che.length==5) {
				tinB b = new tinB(che[0], che[1], Double.parseDouble(che[2]),  Double.parseDouble(che[3]),  Double.parseDouble(che[4]));
				ds.add(b);
			}
		}
		r.close();
		return ds;
	}
	
}
