package bean;

import java.sql.Date;

public class maytinhbanbean extends maytinhbean {
	private String tncc;

	public maytinhbanbean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public maytinhbanbean(String mm, String tm, Date nnh, float gia, int sl, String tncc) {
		super(mm, tm, nnh, gia, sl);
		this.tncc = tncc;
	}

	public String getTncc() {
		return tncc;
	}

	public void setTncc(String tncc) {
		this.tncc = tncc;
	}

	@Override
	public String toString() {
		return super.toString() + ";" + tncc;
	}
	
}
