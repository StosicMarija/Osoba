package osoba;

public abstract class Osoba {
	private String ime;
	private String prezime;
	private String adresa;
	
	public Osoba(String ime, String prezime, String adresa) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.adresa = adresa;
	
	}
	
	public abstract int numeroloskiBroj();
	
	public abstract String metabolizam(final Datum dat);
	
	public int zbirBrojeva(int br) {
	int sum = 0;
	
	do {
	sum += br % 10;
	br /= 10;
	} 
	
	while (br != 0); return sum;
	}
	
		public String getIme() {
		return ime;
	}
		
	public String getPrezime() {
		return prezime;
	}
	
	public String getAdresa() {
		return adresa;
	}
	
	public String toString() {
		return prezime + " " + ime + ", " + adresa;
	}
}
