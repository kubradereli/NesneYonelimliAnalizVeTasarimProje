package ProjeNYAT;

public class Sogutucu implements IKontrol {

	public Sogutucu() {
	}

	@Override
	public void sogutucuCalistirma() {
		System.out.println("!! Soğutucu çalıştırılıyor.");
		
	}

	@Override
	public void sogutucuKapama() {
		System.out.println("!! Soğutucu kapatılıyor.");
	}
}