package ProjeNYAT;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SicaklikAlgilayici implements ISicaklikAlgilayici, ISubject{

	public SicaklikAlgilayici() {
	}

	@Override
	public int sicaklikDegeri() {
		
		Random random = new Random();
		int deger = random.nextInt(50);
		System.out.println("!! Ortamýn sýcaklýðý : " + deger + " derecedir.");
		return deger;
	}

	private List<IObserver> observers = new ArrayList<>();
	
	@Override
	public void ekle(IObserver o) {
		observers.add(o);
	}

	@Override
	public void sil(IObserver o) {
		int i = observers.indexOf(o);
		if(i >= 0) {
			observers.remove(i);
		}
	}
	
	@Override
	public void bilgilendir() {
		for (int i = 0; i < observers.size(); i++) {
			IObserver observer = (IObserver)observers.get(i);
			observer.sicaklikGüncelle();
		}		
	}
}