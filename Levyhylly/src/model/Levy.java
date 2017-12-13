package model;

public class Levy {
	String levyArtisti, genre, levyNimi, formaatti, levyYhtio;
	int julkaisuVuosi, id;
	Kappale kappale;
	
	public Levy() {
		super();
		
	}
	
	public Levy(String levyArtisti, String genre, String levyNimi, String formaatti, String levyYhtio,
			int julkaisuVuosi, int id, Kappale kappale) {
		super();
		this.levyArtisti = levyArtisti;
		this.genre = genre;
		this.levyNimi = levyNimi;
		this.formaatti = formaatti;
		this.levyYhtio = levyYhtio;
		this.julkaisuVuosi = julkaisuVuosi;
		this.id = id;
		this.kappale = kappale;
	}

	public Levy(String levyArtisti, String levyNimi, int julkaisuVuosi, String formaatti, String levyYhtio, String genre) {
		super();
		this.levyArtisti = levyArtisti;
		this.genre = genre;
		this.levyNimi = levyNimi;
		this.formaatti = formaatti;
		this.levyYhtio = levyYhtio;
		this.julkaisuVuosi = julkaisuVuosi;
	}
	public Levy(String levyArtisti, String levyNimi, String julkaisuVuosi, String formaatti, String levyYhtio, String genre) {
		super();
		this.levyArtisti = levyArtisti;
		this.genre = genre;
		this.levyNimi = levyNimi;
		this.formaatti = formaatti;
		this.levyYhtio = levyYhtio;
		this.julkaisuVuosi = Integer.parseInt(julkaisuVuosi);
	}

	public String getLevyArtisti() {
		return levyArtisti;
	}

	public void setLevyArtisti(String levyArtisti) {
		this.levyArtisti = levyArtisti;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLevyNimi() {
		return levyNimi;
	}

	public void setLevyNimi(String levyNimi) {
		this.levyNimi = levyNimi;
	}

	public String getFormaatti() {
		return formaatti;
	}

	public void setFormaatti(String formaatti) {
		this.formaatti = formaatti;
	}

	public String getLevyYhtio() {
		return levyYhtio;
	}

	public void setLevyYhtio(String levyYhtio) {
		this.levyYhtio = levyYhtio;
	}

	public int getJulkaisuVuosi() {
		return julkaisuVuosi;
	}

	public void setJulkaisuVuosi(int julkaisuVuosi) {
		this.julkaisuVuosi = julkaisuVuosi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Kappale getKappale() {
		return kappale;
	}

	public void setKappale(Kappale kappale) {
		this.kappale = kappale;
	}
	
	
}
