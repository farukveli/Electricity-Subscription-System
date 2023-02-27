import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class main {

	public static void main(String[] args) {
		Connect con = new Connect();
		Connection c;
		
        try {
            c=con.connection("Abonelik_Bilgi_Sistemi", "postgres", "1234");
           /* new Karneler().Karne_Ekle(c, 1, 2,"mut", "2019-03-12", 0, 0);
            new Tesisat().Tesisat_Ekle(c, 1, 1, 1, 1, "mut", 0, 0, 0, 0);
            new Sayac().Sayac_Ekle(c, 0, "asd", 0, 0, 0, 0, "2015-12-01");
            new Sayac_Tesisat().Sayac_Tesisat_Ekle(c, 0, 0, 0, "2020-10-21");
        	*/
         //       new Fonksiyonlar().il_tablosu_uret(c);
    //         new Fonksiyonlar().il_tablosu_doldur(c);
     //   new Fonksiyonlar().ilce_tablosu_uret(c);
       //     new Fonksiyonlar().ilce_tablosu_doldur(c);
            
        }
        catch (Exception e) {
            System.out.println("Baðlantý Hatasý!!!");
            e.printStackTrace();
        }
        
        
         AnaMenu anamenu = new AnaMenu(con.getConnection());
         anamenu.setVisible(true);
		
	}

}
