package osoba;

public class Datum {
	private int dan;
	private int mesec;
	private int godina;

	public Datum(int dan, int mesec, int godina) {
		super();
		this.dan = dan;
		this.mesec = mesec;
		this.godina = godina;
	}

	public Datum(final Datum dat) {

		this(dat.dan, dat.mesec, dat.godina);

	}

	public static int prestupna(int godina) {

		if (godina % 400 == 0 || godina % 4 == 0 && godina % 100 != 0)
			return 1;
		return 0;
	}

	public static int danMesec(int mesec, int godina) {

		switch (mesec) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		case 2:
			return 28 + prestupna(godina);
		default:
			return 0;
		}
	}

	public static boolean nadjiJmbg(int g, int d, int m) {
		return g > 1900 && (m >= 1 && m <= 12) && (d >= 1 && d <= danMesec(m, g));
	}

	public static Datum string2datum(String datum1) {

		if (datum1.length() != 11) {

			System.out.println("Pogresna duzina unosa");
			return null;
		}

		if (datum1.charAt(2) != '.' || datum1.charAt(5) != '.' || datum1.charAt(10) != '.') {
			System.out.println("Pogresan unos");
			return null;
		}

		int day = 0;
		int month = 0;
		int year = 0;
		try {
			day = Integer.parseInt(datum1.substring(0, 2));
			month = Integer.parseInt(datum1.substring(3, 5));
			year = Integer.parseInt(datum1.substring(6, 10));
		} catch (NumberFormatException e) {
			System.out.println("Neispravan format unosa");
			return null;
		}
		if (Datum.nadjiJmbg(year, day, month))
			return new Datum(day, month, year);
		else {
			System.out.println("Neispravna vrednost dana, meseca ili godine");
			return null;
		}
	}

	public int getDan() {
		return dan;
	}

	public int getMesec() {
		return mesec;
	}

	public int getGodina() {
		return godina;
	}

	public String toString() {
		String dan1 = (dan < 10) ? "0" + dan : "" + dan;
		String mesec1 = (mesec < 10) ? "0" + mesec : "" + mesec;
		return dan1 + "." + mesec1 + "." + godina + ".";
	}
}
