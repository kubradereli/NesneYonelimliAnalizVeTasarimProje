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
	        	System.out.println("Veritabanýna baðlantý gerçekleþti.");
	        else
	        	System.out.println("Veritabanýna baðlanamadý!!!");
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
				System.out.println("Kullanýcý adý ve þifre doðru. Giriþ baþarýlý !");
				return true;
			} else {
				System.out.println("Kullanýcý adý veya þifre yanlýþ. Tekrar deneyiniz.");
				return false;
			}			
		}catch(SQLException e) {
		}
		return false;
	}	
}