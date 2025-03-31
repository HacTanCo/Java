import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import Bean.SinhVien;

public class CloneObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinhVien x = new SinhVien("SV1", "Nguyen Van A", "K46H");
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		// x -> Json
		String strJson = gson.toJson(x);
		System.out.println(strJson);
		// clone data cua x cho y
		SinhVien y = gson.fromJson(strJson, SinhVien.class);
		System.out.println(y.getMaSinhVien()+";"+y.getHoTen()+";"+y.getLop());
		//
		ArrayList<SinhVien> dsSinhVien = new ArrayList<>();
		dsSinhVien.add(x);
		dsSinhVien.add(new SinhVien("SV2", "Nguyen Van B", "K46H"));
		// in danh sach tu Json
		String strJson1 = gson.toJson(dsSinhVien);
		System.out.println(strJson1);
		System.out.println("-----------------------------");
		TypeToken<Collection<SinhVien>> collectionType = new TypeToken<Collection<SinhVien>>() {};
		Collection<SinhVien> dsSinhVien1 = gson.fromJson(strJson1, collectionType);
		
		for (SinhVien i : dsSinhVien1) {
			System.out.println(i.toString());
		}
	}

}


