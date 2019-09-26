package osoba;

public class OsobaJMBG extends Osoba {

	private String JMBG;

	public OsobaJMBG(String ime, String prezime, String adresa, String JMBG) {
		super(ime, prezime, adresa);
		this.JMBG = JMBG;

	}

	public OsobaJMBG(final OsobaJMBG o) {
		this(o.getIme(), o.getPrezime(), o.getAdresa(), o.JMBG);
	}

	public static boolean nadjiJmbg(String JMBG) {
		if (JMBG.length() != 13)
			return false;
		for (int i = 0; i < JMBG.length(); i++)
			if (!Character.isDigit(JMBG.charAt(i)))
				return false;

		int day = Integer.parseInt(JMBG.substring(0, 2));
		int mounth = Integer.parseInt(JMBG.substring(2, 4));
		int year = Integer.parseInt(JMBG.substring(4, 7));

		if (!Datum.nadjiJmbg(year, day, mounth))
			return false;

		return true;
	}

	public int numeroloskiBroj() {
		int sum = 0;
		for (int i = 0; i < 7; i++) {
			sum += JMBG.charAt(i) - '0';
		}
		sum += 1;
		while (sum > 9)
			sum = zbirBrojeva(sum);
		return sum;
	}

	public String metabolizam(final Datum dat) {
		String datum1 = JMBG.substring(0, 4) + "1" + JMBG.substring(4, 7);
		int dI = dat.getDan() * 1000000 + dat.getMesec() * 10000 + dat.getGodina();
		String rezultat = String.valueOf(Integer.parseInt(datum1) + dI);
		if (rezultat.length() == 7)
			rezultat = "0" + rezultat;
		return rezultat;
	}

	public String toString() {
		return super.toString() + "; numeroloski broj: " + numeroloskiBroj();
	}
}
