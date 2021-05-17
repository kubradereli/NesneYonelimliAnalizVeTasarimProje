package ProjeNYAT;

public class Eyleyici{

	private IKontrol cihaz = new Sogutucu();
		
	public Eyleyici(IKontrol cihaz) {	
		this.cihaz = cihaz;
	}
	
	public void sogutucuCalistirma() {
		cihaz.sogutucuCalistirma();
	}

	public void sogutucuKapama() {
		cihaz.sogutucuKapama();
	}
	
}