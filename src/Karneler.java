import java.sql.*;
import org.postgresql.util.PSQLException;

public class Karneler {
	private int id;
	private int karne_no;
	private String adres;
	private Date okuma_gunu;
	private int koy_dur;
	private  int sayfiye_dur;
	
	public Karneler() {
		super();
	}
	
	public Karneler(int id, int karne_no, String adres, Date okuma_gunu, int koy_dur, int sayfiye_dur) {
		this.id = id;
		this.karne_no = karne_no;
		this.adres = adres;
		this.okuma_gunu = okuma_gunu;
		this.koy_dur = koy_dur;
		this.sayfiye_dur = sayfiye_dur;
	}
	
	public void Karne_Ekle(Connection conn, int id, int karne_no, String adres, String okuma_gunu, int koy_dur, int sayfiye_dur) {
		try {
			PreparedStatement statement = conn.prepareStatement("INSERT INTO karneler VALUES (?,?,?,?,?,?)");
			Date tarih = Date.valueOf(okuma_gunu);
			statement.setInt(1, id);
			statement.setInt(2, karne_no);
			statement.setString(3, adres);
			statement.setDate(4, tarih);
			statement.setInt(5, koy_dur);
			statement.setInt(6, sayfiye_dur);
			statement.execute();
			System.out.println("yazdi");
		}
		catch(PSQLException e) {
			System.out.println("Ayný id'li karne olamaz");
		}
		catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getKarne_no() {
		return karne_no;
	}

	public void setKarne_no(int karne_no) {
		this.karne_no = karne_no;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}
	
	public Date getOkuma_gunu() {
		return okuma_gunu;
	}

	public void setOkuma_gunu(Date okuma_gunu) {
		this.okuma_gunu = okuma_gunu;
	}

	public int getKoy_dur() {
		return koy_dur;
	}

	public void setKoy_dur(int koy_dur) {
		this.koy_dur = koy_dur;
	}

	public int getSayfiye_dur() {
		return sayfiye_dur;
	}

	public void setSayfiye_dur(int sayfiye_dur) {
		this.sayfiye_dur = sayfiye_dur;
	}
	
	
}
