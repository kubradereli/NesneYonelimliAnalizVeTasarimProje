package ProjeNYAT;

public class Kullanici {

	  	private int id;
		private String kullaniciAdi;
		private String sifre;
		
		public Kullanici(Builder builder) {
			this.id = builder.id;
			this.kullaniciAdi = builder.kullaniciAdi;
			this.sifre = builder.sifre;
		}
		
		public int getId() {
			return id;
		}
		
		public String getIsim() {
			return kullaniciAdi;
		}
		
		public String getSifre() {
			return sifre;
		}
		
		public static class Builder{
			private int id;
			private String kullaniciAdi;
			private String sifre;
			
			public Builder() {}
			
			public Builder id(int id) {
				this.id = id;
				return this;
			}
			
			public Builder kullaniciAdi(String kullaniciAdi) {
				this.kullaniciAdi = kullaniciAdi;
				return this;
			}
			
			public Builder sifre(String sifre) {
				this.sifre = sifre;
				return this;
			}
			
			public Kullanici build() {
				Kullanici kullanici = new Kullanici(this);
				return kullanici;
			}
		}
}