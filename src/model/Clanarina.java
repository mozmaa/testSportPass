package model;

import java.time.LocalDate;
import java.util.Objects;

import util.Konzola;

public class Clanarina {

	private final long id;
	private String korisnickoIme;
	private LocalDate datumPocetka;
	
	Paket paket;

	public Clanarina(long id, String korisnickoIme, LocalDate datumPocetka, Paket paket) {
		this.id = id;
		this.korisnickoIme = korisnickoIme;
		this.datumPocetka = datumPocetka;
		this.paket = paket;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clanarina other = (Clanarina) obj;
		return id == other.id;
	}
	
	

	@Override
	public String toString() {
		return "Clanarina [id=" + id + ", korisnickoIme=" + korisnickoIme + ", datumPocetka=" + Konzola.formatiraj(datumPocetka) + ", paket=" 
				+ this.paket.getNaziv() + ", datumIsteka =" + Konzola.formatiraj(istekClanarine ())  + "]";
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public LocalDate getDatumPocetka() {
		return datumPocetka;
	}

	public void setDatumPocetka(LocalDate datumPocetka) {
		this.datumPocetka = datumPocetka;
	}

	public Paket getPaket() {
		return paket;
	}

	public void setPaket(Paket paket) {
		this.paket = paket;
	}

	public long getId() {
		return id;
	}
	
	private LocalDate istekClanarine () {
		return this.datumPocetka.plusMonths(this.paket.getTrajanje());
	}
	
	public boolean aktivnaClanarina (Clanarina clanarina) {
		if (clanarina.getDatumPocetka().plusMonths(clanarina.getPaket().getTrajanje()).isAfter(LocalDate.now()))
			return true;
		return false;
		
	}
	
	public boolean aktivnaClanarina (Clanarina clanarina , LocalDate datum) {
		if (clanarina.getDatumPocetka().plusMonths(clanarina.getPaket().getTrajanje()).isAfter(datum))
			return true;
		return false;
		
	}
//	private long istekClanarine () {
//		LocalDate istek = this.datumPocetka.plusMonths(this.paket.getTrajanje());
//		if(istek.isBefore(LocalDate.now()))
//			return 0;
//		return ChronoUnit.MONTHS.between(istek, LocalDate.now());
//	}
	
}
