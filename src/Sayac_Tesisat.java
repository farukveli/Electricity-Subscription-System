import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.postgresql.util.PSQLException;

public class Sayac_Tesisat {
	private int id;
	private int tesisat_id;
	private int sayac_id;
	private String takilma_tarihi;
	private List<Sayac_Tesisat_Endeks> endeks;
	
	public Sayac_Tesisat(int id, int tesisat_id, int sayac_id, String takilma_tarihi) {
		this.id = id;
		this.tesisat_id = tesisat_id;
		this.sayac_id = sayac_id;
		this.takilma_tarihi = takilma_tarihi;
		endeks=new ArrayList<Sayac_Tesisat_Endeks>();
	}

	public Sayac_Tesisat() {
		// TODO Auto-generated constructor stub
	}

	public void Sayac_Tesisat_Ekle(Connection conn,int id, int tesisat_id, int sayac_id, String takilma_tarihi) {
		
		try {
			PreparedStatement statement = conn.prepareStatement("INSERT INTO sayac_tesisat VALUES (?,?,?,?)");
			Date tarih = Date.valueOf(takilma_tarihi);
			statement.setInt(1, id);
			statement.setInt(2, tesisat_id);
			statement.setInt(3, sayac_id);
			statement.setDate(4, tarih);
			statement.execute();
		} 
		catch(PSQLException e) {
			System.out.println("Ayný id'li Sayac_Tesisat olamaz");
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTesisat_id() {
		return tesisat_id;
	}

	public void setTesisat_id(int tesisat_id) {
		this.tesisat_id = tesisat_id;
	}

	public int getSayac_id() {
		return sayac_id;
	}

	public void setSayac_id(int sayac_id) {
		this.sayac_id = sayac_id;
	}

	public String getTakilma_tarihi() {
		return takilma_tarihi;
	}

	public void setTakilma_tarihi(String takilma_tarihi) {
		this.takilma_tarihi = takilma_tarihi;
	}

	public List<Sayac_Tesisat_Endeks> getEndeks() {
		return endeks;
	}

	public void setEndeks(List<Sayac_Tesisat_Endeks> endeks) {
		this.endeks = endeks;
	}

}
