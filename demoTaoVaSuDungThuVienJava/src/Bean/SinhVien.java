package Bean;

@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class SinhVien {
	private String maSinhVien,hoTen,Lop;

	@Override
	public String toString() {
		return maSinhVien + ";" + hoTen + ";" + Lop ;
	}
	
	
}
