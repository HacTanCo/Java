package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class SinhVien {
	private String maSinhVien,hoVaTen;
	private Boolean gioiTinh;
	private Date DoB;
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	@Override
	public String toString() {
		return maSinhVien + "," + hoVaTen + "," + gioiTinh + "," + sdf.format(DoB);
	}
}
