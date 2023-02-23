import java.sql.*;
import org.postgresql.util.PSQLException;

public class Karneler {
	private int id;
	private int karne_no;
	private String adres;
	private int okuma_gunu;
	private int koy_dur;
	private  int sayfiye_dur;
	
	public Karneler() {
		super();
	}
	
	public Karneler(int id, int karne_no, String adres, int okuma_gunu, int koy_dur, int sayfiye_dur) {
		this.id = id;
		this.karne_no = karne_no;
		this.adres = adres;
		this.okuma_gunu = okuma_gunu;
		this.koy_dur = koy_dur;
		this.sayfiye_dur = sayfiye_dur;
	}
	
	public void Karne_Ekle_Duzenle(Connection conn, int karne_no, String adres, int okuma_gunu, int koy_dur, int sayfiye_dur, int secenek) {
		try {
			String query;
			if(secenek==0) {
				query ="INSERT INTO karneler VALUES (nextval('karne_id'),?,?,?,?,?)";
			}else{
				query= "UPDATE karneler SET karne_no=?,adres=?,koy_dur=?,sayfiye_dur=?,okuma_gunu=? where karne_no="+karne_no;
			}
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, karne_no);
			statement.setString(2, adres);
			statement.setInt(3, koy_dur);
			statement.setInt(4, sayfiye_dur);
			statement.setInt(5, okuma_gunu);
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
	
	public Karneler Karne_Arama(Connection conn,int karne_no) {
		Karneler k= new Karneler();
		String query="SELECT karne_no,adres,koy_dur,sayfiye_dur,okuma_gunu FROM karneler WHERE karne_no="+karne_no;
		try {
			Statement s= conn.createStatement();
			ResultSet r= s.executeQuery(query);
			r.next();
			k.karne_no=r.getInt(1);
			k.adres=r.getString(2);
			k.koy_dur=r.getInt(3);
			k.sayfiye_dur=r.getInt(4);
			k.okuma_gunu=r.getInt(5);
		} catch (SQLException e) {
			System.out.println("Bu karne_no bulunamadý");
		}
		
		return k;
	}
	
	public void Karne_Duzenle(Connection conn, int id, int karne_no, String adres, int okuma_gunu, int koy_dur, int sayfiye_dur) {
		try {
			PreparedStatement statement = conn.prepareStatement("UPDATE karneler SET karne_no=?,adres=?,okuma_gunu=?,"+
					"koy_dur=?,sayfiye_dur=? where id=?");
			
			
		}
		catch(SQLException e){
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
	
	public int getOkuma_gunu() {
		return okuma_gunu;
	}

	public void setOkuma_gunu(int okuma_gunu) {
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
