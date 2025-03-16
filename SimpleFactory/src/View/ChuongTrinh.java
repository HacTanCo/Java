package View;

import java.util.Scanner;

import Controller.ConVatFactory;
import Model.ConVat;

public class ChuongTrinh {
	public static void main(String[] args) throws Exception {
		while(true) {
			ConVatFactory conVatFactory = new ConVatFactory();
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("Nhap ten con vat(nhap break de thoat): ");
			String loai = scanner.nextLine();
			ConVat conVat = conVatFactory.getConVat(loai);
			if(conVat != null) {
				conVat.Keu();
			}
			else {
				System.out.println("Hien tai chua co con nay !!!");
			}
			
			if(loai.toLowerCase().equals("break")) {
				break;
			}
		}
	}
}
