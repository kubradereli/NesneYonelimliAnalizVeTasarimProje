package ProjeNYAT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VeriTabani implements IVeriTabani{
	
	public Connection baglan() {
		Connection baglanti = null;
		try {
			baglanti = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AkilliCihazVeriTabani", "postgres", "378378");
	        if(baglanti != null)
	        	System.out.println("Veritaban�na ba�lant� ger�ekle�ti.");
	        else
	        	System.out.println("Veritaban�na ba�lanamad�!!!");
		} catch (SQLException e) {		
		}
		return baglanti;
	}

	@Override
	public boolean kullaniciDogrulama(String kullaniciAdi, String sifre) {
		
		Connection baglanti = this.baglan();
		
		String sqlKullanici = "SELECT * FROM \"public\".\"Kullanici\" WHERE \"kullaniciAdi\" = '" + kullaniciAdi +"'and sifre = '" + sifre +"'";
		try {
			Statement st = baglanti.createStatement();
			ResultSet re = st.executeQuery(sqlKullanici);
		
			baglanti.close();
			
			if(re.next()) {
				System.out.println("Kullan�c� ad� ve �ifre do�ru. Giri� ba�ar�l� !");
				return true;
			} else {
				System.out.println("Kullan�c� ad� veya �ifre yanl��. Tekrar deneyiniz.");
				return false;
			}			
		}catch(SQLException e) {
		}
		return false;
	}	
}