package bo;

import java.util.ArrayList;

import bean.maytinhbean;
import dao.ketnoidao;
import dao.maytinhdao;

public class maytinhbo {
	public maytinhdao mtd = new maytinhdao();
	public void ketnoi () throws Exception{
		ketnoidao knd = new ketnoidao();
		knd.ketnoi();
	}
	public ArrayList<maytinhbean> ds () throws Exception{
		return mtd.dshople;
	}
	public void infile()throws Exception{
		mtd.infile();
	}
	public void inriengbiet() throws Exception {
		mtd.inriengbiet();
	}
	public void upcsdl() throws Exception{
		mtd.upcsdl();
	}
	public void buycomputer(String mm,int sl) throws Exception{
		mtd.buycomputer(mm, sl);
	}
	public static void main(String[] args) throws Exception{
	}
}
