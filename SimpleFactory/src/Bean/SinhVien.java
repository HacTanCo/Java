package Bean;

import java.sql.Date;

import Bean.SinhVien;
@lombok.Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
public class SinhVien {
	private String maSinhVien,hoTen;
	private boolean goiTinh;
	private Date ngaySinh;
	@Override
	public String toString() {
		return maSinhVien + ";" + hoTen + ";" + goiTinh + ";"+ ngaySinh;
	}
}