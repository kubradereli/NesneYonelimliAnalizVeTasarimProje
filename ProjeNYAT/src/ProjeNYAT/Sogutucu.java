package ProjeNYAT;

public class Sogutucu implements IKontrol {

	public Sogutucu() {
	}

	@Override
	public void sogutucuCalistirma() {
		System.out.println("!! So�utucu �al��t�r�l�yor.");
		
	}

	@Override
	public void sogutucuKapama() {
		System.out.println("!! So�utucu kapat�l�yor.");
	}
}