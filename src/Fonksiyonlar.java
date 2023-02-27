import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class Fonksiyonlar {

	public Fonksiyonlar() {
		super();
	}
	
	public void il_tablosu_uret(Connection c) {
        String il_adi;
        String query="select il from mahalleler group by il";
       try {
			Statement s= c.createStatement();
			ResultSet r= s.executeQuery(query);
			PreparedStatement state ;
			Locale trlocale = new Locale("tr","TR");
			while(r.next()) {
				il_adi=r.getString(1);
				il_adi=il_adi.toLowerCase(trlocale);
				state = c.prepareStatement("create table "+il_adi+" (ilce varchar(38))");
				state.execute();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	
	
	public void il_tablosu_doldur(Connection c) {
		String il_adi;
		String ilce_adi;
		String query="select distinct il, ilce from mahalleler";
		try {
			Statement s= c.createStatement();
			ResultSet r= s.executeQuery(query);
			PreparedStatement state;
			Locale trlocale = new Locale("tr","TR");
			while(r.next()) {
				il_adi=r.getString(1);
				ilce_adi=r.getString(2);
				il_adi=il_adi.toLowerCase(trlocale);
				state = c.prepareStatement("insert into "+il_adi+" values('"+ilce_adi+"')");
				state.execute();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void ilce_tablosu_uret(Connection c) {
		String ilce_adi;
		String query = "Select ilce from mahalleler group by ilce";
		Statement s;
		try {
			s = c.createStatement();
			ResultSet r= s.executeQuery(query);
			PreparedStatement state ;
			Locale trlocale = new Locale("tr","TR");
			while(r.next()) {
				ilce_adi=r.getString(1);
				ilce_adi=ilce_adi.toLowerCase(trlocale);	
				state = c.prepareStatement("create table "+ilce_adi+" (mahalle varchar(38))");
				state.execute();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void ilce_tablosu_doldur(Connection c) {
		String ilce_adi;
		String mahalle_adi;
		String query="select ilce, mahalle from mahalleler";
		try {
			Statement s= c.createStatement();
			ResultSet r= s.executeQuery(query);
			PreparedStatement state;
			Locale trlocale = new Locale("tr","TR");
			while(r.next()) {
				ilce_adi=r.getString(1);
				mahalle_adi=r.getString(2);
				ilce_adi=ilce_adi.toLowerCase(trlocale);
				state = c.prepareStatement("insert into "+ilce_adi+" values('"+mahalle_adi+"')");
				state.execute();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
}
