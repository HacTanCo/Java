package view;

import java.util.ArrayList;

import bean.tinA;
import bean.tinB;
import bo.tinBo;

public class tinView {
	public static void main(String[] args) {
		try {
			tinBo tb = new tinBo();
			ArrayList<Object> ds = tb.getds();
			System.out.println("Danh sach hoc vien tin A and B !!!");
			for(Object i : ds) {
				if(i instanceof tinA) {
					System.out.println(i.toString());
				}
				else if (i instanceof tinB) {
					System.out.println(i.toString());
				}
			}
			tb.tktd();
			tb.luuf1();
			tb.luuf2();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
