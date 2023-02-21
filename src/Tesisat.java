import java.sql.*;

import org.postgresql.util.PSQLException;

public class Tesisat {
	
	private int tesisat_id;
	private int tesisat_no;
	private int karne_id;
	private int sira_no;
	private String adres;
	private int il_kodu;
	private int tarife_kodu;
	private int kurulu_guc;
	private int og_dur;
	
	public Tesisat() {
		super();
	}
	
	public Tesisat(int tesisat_id, int tesisat_no, int karne_id, int sira_no, String adres, int il_kodu,
			int tarife_kodu, int kurulu_guc, int og_dur) {
		this.tesisat_id = tesisat_id;
		this.tesisat_no = tesisat_no;
		this.karne_id = karne_id;
		this.sira_no = sira_no;
		this.adres = adres;
		this.il_kodu = il_kodu;
		this.tarife_kodu = tarife_kodu;
		this.kurulu_guc = kurulu_guc;
		this.og_dur = og_dur;
	}
	
	public void Tesisat_Ekle(Connection conn,int tesisat_id,int tesisat_no,int karne_id,int sira_no,String adres,
			int il_kodu,int tarife_kodu,int kurulu_guc,int og_dur) {
		
		try {
			PreparedStatement statement = conn.prepareStatement("INSERT INTO tesisat VALUES (?,?,?,?,?,?,?,?,?)");
			statement.setInt(1, tesisat_id);
			statement.setInt(2, tesisat_no);
			statement.setInt(3, karne_id);
			statement.setInt(4, sira_no);
			statement.setString(5, adres);
			statement.setInt(6, il_kodu);
			statement.setInt(7, tarife_kodu);
			statement.setInt(8, kurulu_guc);
			statement.setInt(9, og_dur);
			statement.execute();
		}catch(PSQLException e) {
			System.out.println("Ayný id'li tesisat olamaz");
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public int getTesisat_id() {
		return tesisat_id;
	}

	public void setTesisat_id(int tesisat_id) {
		this.tesisat_id = tesisat_id;
	}

	public int getTesisat_no() {
		return tesisat_no;
	}

	public void setTesisat_no(int tesisat_no) {
		this.tesisat_no = tesisat_no;
	}

	public int getKarne_id() {
		return karne_id;
	}

	public void setKarne_id(int karne_id) {
		this.karne_id = karne_id;
	}

	public int getSira_no() {
		return sira_no;
	}

	public void setSira_no(int sira_no) {
		this.sira_no = sira_no;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public int getIl_kodu() {
		return il_kodu;
	}

	public void setIl_kodu(int il_kodu) {
		this.il_kodu = il_kodu;
	}

	public int getTarife_kodu() {
		return tarife_kodu;
	}

	public void setTarife_kodu(int tarife_kodu) {
		this.tarife_kodu = tarife_kodu;
	}

	public int getKurulu_guc() {
		return kurulu_guc;
	}

	public void setKurulu_guc(int kurulu_guc) {
		this.kurulu_guc = kurulu_guc;
	}

	public int getOg_dur() {
		return og_dur;
	}

	public void setOg_dur(int og_dur) {
		this.og_dur = og_dur;
	}

}
