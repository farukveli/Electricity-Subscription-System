import java.sql.*;
import java.lang.NullPointerException;
import org.postgresql.util.PSQLException;


public class Abone {
	private int id;
	private int sozlesme_no;
	private int tesisat_no;
	private String unvan;
	private int sahis_durum;
	private int telefon_no;
	private String e_posta;
	private Date sozlesme_tarihi;
	private Date tahliye_tarihi;
	private int tarife_kodu;
	private int puant;
	private int sozlesme_gucu;
	private Date kayit_tarihi;
	
	public Abone() {
		
	}
	
	public Abone(int id, int sozlesme_no, int tesisat_no, String unvan, int sahis_durum, int telefon_no, String e_posta,
			Date sozlesme_tarihi, Date tahliye_tarihi, int tarife_kodu, int puant, int sozlesme_gucu,
			Date kayit_tarihi) {
		super();
		this.id = id;
		this.sozlesme_no = sozlesme_no;
		this.tesisat_no = tesisat_no;
		this.unvan = unvan;
		this.sahis_durum = sahis_durum;
		this.telefon_no = telefon_no;
		this.e_posta = e_posta;
		this.sozlesme_tarihi = sozlesme_tarihi;
		this.tahliye_tarihi = tahliye_tarihi;
		this.tarife_kodu = tarife_kodu;
		this.puant = puant;
		this.sozlesme_gucu = sozlesme_gucu;
		this.kayit_tarihi = kayit_tarihi;
	}
	
	public int Abone_Ekle_Duzenle(Connection conn, int sozlesme_no, int tesisat_no, String unvan, int sahis_durum, int telefon_no, String e_posta,
			String sozlesme_tarihi, String tahliye_tarihi, int tarife_kodu, int puant, int sozlesme_gucu,
			String kayit_tarihi, int secenek) {
		int durum;

		try {
			String query;
			if(secenek==0) {
				query ="INSERT INTO abone VALUES (nextval('karne_id'),?,?,?,?,?,?,?,?,?,?,?,?)";
			}else{
				query= "UPDATE abone SET tesisat_no=?,sozlesme_no=?,unvan=?,sahis_durum=?,telefon_no=?,"
						+ "e_posta=?,sozlesme_tarihi=?,tahliye_tarihi=?,tarife_kodu=?,puant=?,"
						+ "sozlesme_gucu=?,kayit_tarihi=? where karne_no="+sozlesme_no;
			}
			PreparedStatement statement = conn.prepareStatement(query);
			Date tarih_sozlesme = Date.valueOf(sozlesme_tarihi);
			Date tarih_tahliye = Date.valueOf(tahliye_tarihi);
			Date tarih_kayit = Date.valueOf(kayit_tarihi);
			statement.setInt(1, tesisat_no);
			statement.setInt(2, sozlesme_no);
			statement.setString(3, unvan);
			statement.setInt(4, sahis_durum);
			statement.setInt(5, telefon_no);
			statement.setString(6, e_posta);
			statement.setDate(7,tarih_sozlesme);
			statement.setDate(8, tarih_tahliye);
			statement.setInt(9, tarife_kodu);
			statement.setInt(10, puant);
			statement.setInt(11, sozlesme_gucu);
			statement.setDate(12, tarih_kayit);
			statement.execute();
			System.out.println("yazdi");
			durum=0;
		}
		catch(PSQLException e) {
			durum=-1;
		}
		catch (SQLException e) {
			durum=-2;
		}
		catch (java.lang.NullPointerException e) {
			durum=-3;
		}
		
		return durum;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSozlesme_no() {
		return sozlesme_no;
	}

	public void setSozlesme_no(int sozlesme_no) {
		this.sozlesme_no = sozlesme_no;
	}

	public int getTesisat_no() {
		return tesisat_no;
	}

	public void setTesisat_no(int tesisat_no) {
		this.tesisat_no = tesisat_no;
	}

	public String getUnvan() {
		return unvan;
	}

	public void setUnvan(String unvan) {
		this.unvan = unvan;
	}

	public int getSahis_durum() {
		return sahis_durum;
	}

	public void setSahis_durum(int sahis_durum) {
		this.sahis_durum = sahis_durum;
	}

	public int getTelefon_no() {
		return telefon_no;
	}

	public void setTelefon_no(int telefon_no) {
		this.telefon_no = telefon_no;
	}

	public String getE_posta() {
		return e_posta;
	}

	public void setE_posta(String e_posta) {
		this.e_posta = e_posta;
	}

	public Date getSozlesme_tarihi() {
		return sozlesme_tarihi;
	}

	public void setSozlesme_tarihi(Date sozlesme_tarihi) {
		this.sozlesme_tarihi = sozlesme_tarihi;
	}

	public Date getTahliye_tarihi() {
		return tahliye_tarihi;
	}

	public void setTahliye_tarihi(Date tahliye_tarihi) {
		this.tahliye_tarihi = tahliye_tarihi;
	}

	public int getTarife_kodu() {
		return tarife_kodu;
	}

	public void setTarife_kodu(int tarife_kodu) {
		this.tarife_kodu = tarife_kodu;
	}

	public int getPuant() {
		return puant;
	}

	public void setPuant(int puant) {
		this.puant = puant;
	}

	public int getSozlesme_gucu() {
		return sozlesme_gucu;
	}

	public void setSozlesme_gucu(int sozlesme_gucu) {
		this.sozlesme_gucu = sozlesme_gucu;
	}

	public Date getKayit_tarihi() {
		return kayit_tarihi;
	}

	public void setKayit_tarihi(Date kayit_tarihi) {
		this.kayit_tarihi = kayit_tarihi;
	}
	
	
	
}
