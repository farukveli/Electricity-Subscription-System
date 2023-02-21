import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.postgresql.util.PSQLException;

public class Sayac {
	private int id;
	private String marka;
	private int sayac_no;
	private int dijit;
	private float carpan;
	private int imal_yili;
	private String damga_tarihi;
	private List<Sayac_Endeks> endeks;
	
	public Sayac(int id, String marka, int sayac_no, int dijit, float carpan, int imal_yili, String damga_tarihi) {
		this.id = id;
		this.marka = marka;
		this.sayac_no = sayac_no;
		this.dijit = dijit;
		this.carpan = carpan;
		this.imal_yili = imal_yili;
		this.damga_tarihi = damga_tarihi;
		this.endeks= new ArrayList<Sayac_Endeks>();
	}
	
	public Sayac() {
	
	}

	public void Sayac_Ekle(Connection conn,int id, String marka, int sayac_no, int dijit, float carpan, int imal_yili, String damga_tarihi) {
		
		try {
			PreparedStatement statement = conn.prepareStatement("INSERT INTO sayac VALUES (?,?,?,?,?,?,?)");
			Date tarih = Date.valueOf(damga_tarihi);
			statement.setInt(1, id);
			statement.setString(2, marka);
			statement.setInt(3, sayac_no);
			statement.setInt(4, dijit);
			statement.setFloat(5, carpan);
			statement.setInt(6, imal_yili);
			statement.setDate(7, tarih);
			statement.execute();
		}
		catch(PSQLException e) {
			System.out.println("Ayný id'li sayac olamaz");
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

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public int getSayac_no() {
		return sayac_no;
	}

	public void setSayac_no(int sayac_no) {
		this.sayac_no = sayac_no;
	}

	public int getDijit() {
		return dijit;
	}

	public void setDijit(int dijit) {
		this.dijit = dijit;
	}

	public float getCarpan() {
		return carpan;
	}

	public void setCarpan(float carpan) {
		this.carpan = carpan;
	}

	public int getImal_yili() {
		return imal_yili;
	}

	public void setImal_yili(int imal_yili) {
		this.imal_yili = imal_yili;
	}

	public String getDamga_tarihi() {
		return damga_tarihi;
	}

	public void setDamga_tarihi(String damga_tarihi) {
		this.damga_tarihi = damga_tarihi;
	}

	public List<Sayac_Endeks> getEndeks() {
		return endeks;
	}

	public void setEndeks(List<Sayac_Endeks> endeks) {
		this.endeks = endeks;
	}

}
