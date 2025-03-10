package lombokDemo;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@lombok.AllArgsConstructor
@NoArgsConstructor
public class SinhVien {
	private String maSinhVien;
	private String hoTen;
	private boolean gioiTinhNam;
	//private Date ngaySinh;
	private int maNganhDaoTao;
	
}
