package ProjeNYAT;

public interface IAgArayuzu {

	public boolean girisYap();
	public int secenekSecimi();
	public void sicaklikDegeri(ISicaklikAlgilayici sicaklikAlgilayici);
	public void sogutucuCalistirma(IKontrol cihaz);
	public void sogutucuKapama(IKontrol cihaz);
	public void cikisYap();
}