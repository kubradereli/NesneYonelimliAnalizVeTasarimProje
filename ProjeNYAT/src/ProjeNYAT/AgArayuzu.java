package ProjeNYAT;

import java.util.Scanner;

public class AgArayuzu implements IAgArayuzu,IObserver {

	public AgArayuzu() {
	}
	
	Scanner girdi = new Scanner(System.in);

	@Override
	public boolean girisYap() {
		System.out.println("********************************");
		System.out.println("******* SOÐUTUCU SÝSTEMi *******");
		System.out.println("********************************");
		System.out.println("                                ");
		
		IVeriTabani kullanici = new VeriTabani();
		String kullaniciAdi = "";
        String sifre = "";
        System.out.println("Kullanýcý Adý: ");
        kullaniciAdi = girdi.next();
        System.out.println("Þifre: ");
        sifre = girdi.next();
        boolean sonuc = kullanici.kullaniciDogrulama(kullaniciAdi, sifre);
        if (sonuc) {
            return true;
        }		
		return false;
	}

	@Override
	public int secenekSecimi() {
		int secim = 0;
		System.out.println("                                ");
		System.out.println("            MENÜ                ");
		System.out.println("********************************");
		System.out.println("* 1. Sýcaklýk deðerini göster  *");
		System.out.println("* 2. Soðutucuyu çalýþtýr       *");
		System.out.println("* 3. Soðutucuyu kapat          *");
		System.out.println("* 4. Çýkýþ yap                 *");
		System.out.println("********************************");
		System.out.println("Yapmak istediðiniz seçim : ");
		secim = girdi.nextInt();
		
		if (secim == 1 || secim == 2 || secim == 3|| secim == 4) {
			System.out.println("seçiminiz alýndý... iþlem gerçekleþtirilecek...");
		} else {
			System.out.println("Geçersiz seçim...");
		}
		return secim;
	}

	@Override
	public void sicaklikDegeri(ISicaklikAlgilayici sicaklikAlgilayici) {
		try{ 
			Thread.sleep(1000); 
		}catch(InterruptedException e){} 
		sicaklikAlgilayici.sicaklikDegeri();	
	}



	@Override
	public void cikisYap() {
		try{ 
			Thread.sleep(1000); 
		}catch(InterruptedException e){} 
		System.out.println("!! Çýkýþ yapýlýyor.");
	}

	@Override
	public void sicaklikGüncelle() {
		try{ 
			Thread.sleep(1000); 
		}catch(InterruptedException e){} 
		System.out.println("!! Sýcaklýk deðeri güncellendi.");	
	}

	@Override
	public void sogutucuCalistirma(IKontrol cihaz) {
		try{ 
			Thread.sleep(1000); 
		}catch(InterruptedException e){} 
		cihaz.sogutucuCalistirma();
		sicaklikGüncelle();		
	}

	@Override
	public void sogutucuKapama(IKontrol cihaz) {
		try{ 
			Thread.sleep(1000); 
		}catch(InterruptedException e){} 
		cihaz.sogutucuKapama();	
	}
}