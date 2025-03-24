package Dao;

public class SinhVienDaoFactory {
	public SinhVienDAO getSinhVienDao(String loai) throws Exception{
		if(loai.toLowerCase().equals("txt"))
			return new TextFileSinhVienDAO();
		else if(loai.toLowerCase().equals("csdl"))
			return new DbSinhVienDAO();
		else
			return null;
	}
}
