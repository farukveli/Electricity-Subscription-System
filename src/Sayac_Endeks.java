import java.sql.*;
import java.util.List;

import org.postgresql.util.PSQLException;

public class Sayac_Endeks {
	private int id;
	private int sayac_id;
	private int sayac_kodu;
	private int endeks;
	
	public Sayac_Endeks(int id, int sayac_id, int sayac_kodu, int endeks) {
		this.id = id;
		this.sayac_id = sayac_id;
		this.sayac_kodu = sayac_kodu;
		this.endeks = endeks;
	}
	
	public void Sayac_Endeks_Ekle(Connection conn, Sayac s) {
		try {
			PreparedStatement statement = conn.prepareStatement("INSERT INTO sayac_endeks VALUES (?,?,?,?)");
			for (Sayac_Endeks i : s.getEndeks()) {
				statement.setInt(1, i.getId());
				statement.setInt(2, i.getSayac_kodu() );
				statement.setInt(3, i.getSayac_kodu());
				statement.setInt(4, i.getEndeks());
				statement.execute();
			}
			
		}
		catch(PSQLException e) {
			System.out.println("Ayný id'li sayac_endeks olamaz");
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

	public int getSayac_id() {
		return sayac_id;
	}

	public void setSayac_id(int sayac_id) {
		this.sayac_id = sayac_id;
	}

	public int getSayac_kodu() {
		return sayac_kodu;
	}

	public void setSayac_kodu(int sayac_kodu) {
		this.sayac_kodu = sayac_kodu;
	}

	public int getEndeks() {
		return endeks;
	}

	public void setEndeks(int endeks) {
		this.endeks = endeks;
	}
	
	
}
