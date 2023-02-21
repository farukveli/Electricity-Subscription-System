
public class Sayac_Tesisat_Endeks {
	private int id;
	private int sayac_id;
	private int sayac_kodu;
	private int takilma_endeks;
	
	public Sayac_Tesisat_Endeks(int id, int sayac_id, int sayac_kodu, int takilma_endeks) {
		this.id = id;
		this.sayac_id = sayac_id;
		this.sayac_kodu = sayac_kodu;
		this.takilma_endeks = takilma_endeks;
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

	public int getTakilma_endeks() {
		return takilma_endeks;
	}

	public void setTakilma_endeks(int takilma_endeks) {
		this.takilma_endeks = takilma_endeks;
	}
	
	
}
