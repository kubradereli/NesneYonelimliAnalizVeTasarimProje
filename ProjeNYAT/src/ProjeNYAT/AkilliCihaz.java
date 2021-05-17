package ProjeNYAT;

public class AkilliCihaz implements IAkilliCihaz {

	IAgArayuzu arayuz = new AgArayuzu();
	ISicaklikAlgilayici sicaklikAlgilayici = new SicaklikAlgilayici();
	IKontrol eyleyici = new Sogutucu();
	
	@Override
	public boolean arayuzeGiri�Yap() {
		return arayuz.girisYap();
	}

	@Override
	public int islemSecimiYap() {
		return arayuz.secenekSecimi();
	}

	@Override
	public void islemiYap() {
		if (arayuzeGiri�Yap()) {
			int secim = 0;			
			do {
				try{ 
					Thread.sleep(1000); 
				}catch(InterruptedException e){} 
				secim = islemSecimiYap();
				if (secim == 1) {
					sicaklikDegeri();
				} else if (secim == 2) {
					sogutucuCalistirma();
				} else if (secim == 3) {
					sogutucuKapama();
				} else if (secim == 4) {
					aarayuzdenCikisYap();
				} else {
					System.out.println("L�tfen ge�erli se�im yap�n�z.");
				}
			} while (secim != 4);
		} else {
			System.out.println("Aray�zden kullan�c� giri�i yapmadan se�im yapamazs�n�z.");
		}
	}

	@Override
	public void sicaklikDegeri() {
		arayuz.sicaklikDegeri(sicaklikAlgilayici);		
	}

	@Override
	public void sogutucuCalistirma() {
		arayuz.sogutucuCalistirma(eyleyici);		
	}

	@Override
	public void sogutucuKapama() {
		arayuz.sogutucuKapama(eyleyici);	
	}

	@Override
	public void aarayuzdenCikisYap() {
		arayuz.cikisYap();
	}
}