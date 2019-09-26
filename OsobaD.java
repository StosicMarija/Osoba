package osoba;

public class OsobaD extends Osoba {

	private Datum datumRodjenja;
	
	public OsobaD(String ime, String prezime, String adresa, Datum datumRodjenj) {
		super(ime, prezime, adresa);
		this.datumRodjenja=new Datum(datumRodjenj);
		
	}
	
	public OsobaD(final OsobaD o) {
		
	super(o.getIme(), o.getPrezime(), o.getAdresa());
	datumRodjenja = new Datum(o.datumRodjenja);
	}
	
	public int numeroloskiBroj() {
		
	int sum = zbirBrojeva(datumRodjenja.getDan()) + zbirBrojeva(datumRodjenja.getMesec()) + zbirBrojeva(datumRodjenja.getGodina());
	while (sum > 9)
	sum = zbirBrojeva(sum);
	return sum;
	}
	
	public String metabolizam(final Datum d) {
		
		int zbir = (datumRodjenja.getDan() + d.getDan()) * 1000000 +(datumRodjenja.getMesec() + d.getMesec()) * 10000 +datumRodjenja.getGodina() + d.getGodina();
		String rezultat = String.valueOf(zbir);
		if (rezultat.length() == 7)
		rezultat = "0" + rezultat;
		return rezultat;
	}
	public String toString() {
		return super.toString() + "; numeroloski broj: " + numeroloskiBroj();
	
	}
	
}
