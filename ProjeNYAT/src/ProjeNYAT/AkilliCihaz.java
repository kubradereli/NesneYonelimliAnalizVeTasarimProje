package ProjeNYAT;

public class AkilliCihaz implements IAkilliCihaz {

	IAgArayuzu arayuz = new AgArayuzu();
	ISicaklikAlgilayici sicaklikAlgilayici = new SicaklikAlgilayici();
	IKontrol eyleyici = new Sogutucu();
	
	@Override
	public boolean arayuzeGiriþYap() {
		return arayuz.girisYap();
	}

	@Override
	public int islemSecimiYap() {
		return arayuz.secenekSecimi();
	}

	@Override
	public void islemiYap() {
		if (arayuzeGiriþYap()) {
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
					System.out.println("Lütfen geçerli seçim yapýnýz.");
				}
			} while (secim != 4);
		} else {
			System.out.println("Arayüzden kullanýcý giriþi yapmadan seçim yapamazsýnýz.");
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