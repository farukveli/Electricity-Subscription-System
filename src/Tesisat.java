import java.sql.*;

import org.postgresql.util.PSQLException;

public class Tesisat {
	
	private int tesisat_id;
	private int tesisat_no;
	private int karne_id;
	private int sira_no;
	private String ilce;
	private String mahalle;
	private int il_kodu;
	private int tarife_kodu;
	private int kurulu_guc;
	private int og_dur;
	private int abone_no;
	
	public Tesisat() {
		super();
	}
	
	
	
	public Tesisat(int tesisat_id, int tesisat_no, int karne_id, int sira_no, String ilce, String mahalle, int il_kodu,
			int tarife_kodu, int kurulu_guc, int og_dur, int abone_no) {
		this.tesisat_id = tesisat_id;
		this.tesisat_no = tesisat_no;
		this.karne_id = karne_id;
		this.sira_no = sira_no;
		this.ilce = ilce;
		this.mahalle = mahalle;
		this.il_kodu = il_kodu;
		this.tarife_kodu = tarife_kodu;
		this.kurulu_guc = kurulu_guc;
		this.og_dur = og_dur;
		this.abone_no = abone_no;
	}



	public int Tesisat_Ekle_Duzenle(Connection conn,int tesisat_no,int karne_no,int sira_no,int il_kodu,String ilce,
			String mahalle, int tarife_kodu,int kurulu_guc,int og_dur,int abone_no,int secenek) {
		int durum=0;
		Karneler karne_id;
		Karneler sonuc=new Karneler().Karne_Arama(conn, karne_no);
		if(sonuc==null) {
			durum= -2;
		}else {
			karne_id=new Karneler();
			
			try {
				String query= new String();
				if(secenek==0) {
					query="INSERT INTO tesisat VALUES (nextval('tesisat_id'),?,?,?,?,?,?,?,?,?,?)";
				}else {
					query="UPDATE tesisat SET tesisat_no=?,karne_id=?,sira_no=?,il_kodu=?,ilce=?,mahalle=?,tarife_kodu=?"
							+ ",kurulu_guc=?,og_dur=?,abone_no=? where tesisat_no="+tesisat_no;
				}
				PreparedStatement statement = conn.prepareStatement(query);
				statement.setInt(1, tesisat_no);
				statement.setInt(2, karne_id.Karne_Arama(conn, karne_no).getId());
				statement.setInt(3, sira_no);
				statement.setInt(4, il_kodu);
				statement.setString(5, ilce);
				statement.setString(6, mahalle);
				statement.setInt(7, tarife_kodu);
				statement.setInt(8, kurulu_guc);
				statement.setInt(9, og_dur);
				statement.setInt(10, abone_no);
				statement.execute();
				System.out.println("Tesisat Yazildi");
				durum=0;
			}catch(PSQLException e) {
				System.out.println("Ayný id'li tesisat olamaz");
				durum = -1;
			} 
			catch (SQLException e) {
				durum = -2;
			}	
		}
		return durum;
	}
	
	public Tesisat Tesisat_Arama(Connection conn,int tesisat_no) {
		Tesisat k= new Tesisat();
		k.tesisat_no=tesisat_no;
		String query="SELECT tesisat_id,karne_id,sira_no,il_kodu,ilce,mahalle,tarife_kodu,"
				+ "kurulu_guc,og_dur,abone_no FROM tesisat WHERE tesisat_no="+tesisat_no;
		int durum=0;
		try {
			Statement s= conn.createStatement();
			ResultSet r= s.executeQuery(query);
			r.next();
			k.tesisat_id=r.getInt(1);
			k.sira_no=r.getInt(3);
			k.il_kodu=r.getInt(4);
			k.ilce=r.getString(5);
			k.mahalle=r.getString(6);
			k.tarife_kodu=r.getInt(7);
			k.kurulu_guc=r.getInt(8);
			k.og_dur=r.getInt(9);
			k.abone_no=r.getInt(10);
			ResultSet id = s.executeQuery("select karne_no from karneler where id="+ r.getInt(2));
			id.next();
			k.karne_id=id.getInt(1);
		} catch (SQLException e) {
			k=null;
		}
		
		return k;
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

	public String getIlce() {
		return ilce;
	}

	public void setIlce(String ilce) {
		this.ilce = ilce;
	}

	public String getMahalle() {
		return mahalle;
	}

	public void setMahalle(String mahalle) {
		this.mahalle = mahalle;
	}

	public int getAbone_no() {
		return abone_no;
	}

	public void setAbone_no(int abone_no) {
		this.abone_no = abone_no;
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
