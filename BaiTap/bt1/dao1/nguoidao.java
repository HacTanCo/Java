package dao1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

import bean1.nguoi;
import bean1.nhanvien;
import bean1.sinhvien;

public class nguoidao {
    public boolean checksdt(String sdt) {
        String bt="[0][0-9]{9,10}";
        return Pattern.matches(bt, sdt);
    }
    public boolean checkemail(String email) {
        String bt="[\\w]{1,}@[\\w]{1,}.[\\w]{1,}.[\\w]{0,}";
        return Pattern.matches(bt, email);
    }
    public boolean checkmnvandmsv(String ma) {
        String bt="[\\D][\\w]{1,}";
        return Pattern.matches(bt, ma);
    }
    public boolean checkdatev(String ngaysinh) {
        String bt="^\\d{2}/\\d{2}/\\d{4}$";
        return Pattern.matches(bt, ngaysinh);
    }
    
    ArrayList<nguoi> ds = new ArrayList<nguoi>();
    ArrayList<String> loi = new ArrayList<String>();

    public ArrayList<nguoi> getds() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        FileReader fr = new FileReader("ds1.txt");
        BufferedReader bf = new BufferedReader(fr);
        while(true)
        {
            String l = bf.readLine();
            if(l==null || l=="")
                break;
            String[] che = l.split("[|]");
            if(che.length==3 && checkdatev(che[2])) {
                ds.add(new nguoi(che[0], Boolean.parseBoolean(che[1]), sdf.parse(che[2])));
            }
            else if (che.length==6 && checkdatev(che[3]) && checkmnvandmsv(che[0])) {
                sinhvien sv = new sinhvien(che[0], che[1], Boolean.parseBoolean(che[2]), sdf.parse(che[3]), che[4], Double.parseDouble(che[5]));
                ds.add(sv);
            }
            else if(che.length==7 && checkmnvandmsv(che[0]) && checkdatev(che[3]) && checkemail(che[4]) && checksdt(che[5])) {
                nhanvien nv = new nhanvien(che[0],che[1], Boolean.parseBoolean(che[2]), sdf.parse(che[3]), che[4], che[5], Double.parseDouble(che[6]));
                ds.add(nv);
            }
            else {
                loi.add(l); 
            }
        }
        bf.close();
        FileWriter f = new FileWriter("loi.txt");
        PrintWriter w = new PrintWriter(f);
        for (String i : loi) {
            w.write(i+"\n"); 
        }
        w.close();
        return ds;
    }
    public static void main(String[] args) {
		try {
			nguoidao nd = new nguoidao();
			System.out.println(nd.getds());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
