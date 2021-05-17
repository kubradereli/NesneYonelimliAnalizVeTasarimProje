package ProjeNYAT;

public class Sogutucu implements IKontrol {

	public Sogutucu() {
	}

	@Override
	public void sogutucuCalistirma() {
		System.out.println("!! Soðutucu çalýþtýrýlýyor.");
		
	}

	@Override
	public void sogutucuKapama() {
		System.out.println("!! Soðutucu kapatýlýyor.");
	}
}