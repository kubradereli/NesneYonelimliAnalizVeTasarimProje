package ProjeNYAT;

import java.util.Scanner;

public class AgArayuzu implements IAgArayuzu,IObserver {

	public AgArayuzu() {
	}
	
	Scanner girdi = new Scanner(System.in);

	@Override
	public boolean girisYap() {
		System.out.println("********************************");
		System.out.println("******* SO�UTUCU S�STEMi *******");
		System.out.println("********************************");
		System.out.println("                                ");
		
		IVeriTabani kullanici = new VeriTabani();
		String kullaniciAdi = "";
        String sifre = "";
        System.out.println("Kullan�c� Ad�: ");
        kullaniciAdi = girdi.next();
        System.out.println("�ifre: ");
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
		System.out.println("            MEN�                ");
		System.out.println("********************************");
		System.out.println("* 1. S�cakl�k de�erini g�ster  *");
		System.out.println("* 2. So�utucuyu �al��t�r       *");
		System.out.println("* 3. So�utucuyu kapat          *");
		System.out.println("* 4. ��k�� yap                 *");
		System.out.println("********************************");
		System.out.println("Yapmak istedi�iniz se�im : ");
		secim = girdi.nextInt();
		
		if (secim == 1 || secim == 2 || secim == 3|| secim == 4) {
			System.out.println("se�iminiz al�nd�... i�lem ger�ekle�tirilecek...");
		} else {
			System.out.println("Ge�ersiz se�im...");
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
		System.out.println("!! ��k�� yap�l�yor.");
	}

	@Override
	public void sicaklikG�ncelle() {
		try{ 
			Thread.sleep(1000); 
		}catch(InterruptedException e){} 
		System.out.println("!! S�cakl�k de�eri g�ncellendi.");	
	}

	@Override
	public void sogutucuCalistirma(IKontrol cihaz) {
		try{ 
			Thread.sleep(1000); 
		}catch(InterruptedException e){} 
		cihaz.sogutucuCalistirma();
		sicaklikG�ncelle();		
	}

	@Override
	public void sogutucuKapama(IKontrol cihaz) {
		try{ 
			Thread.sleep(1000); 
		}catch(InterruptedException e){} 
		cihaz.sogutucuKapama();	
	}
}