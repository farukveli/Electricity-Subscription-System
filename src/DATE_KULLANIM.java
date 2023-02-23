import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.postgresql.util.PSQLException;

public class DATE_KULLANIM {
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
}
