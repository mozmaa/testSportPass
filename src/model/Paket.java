package model;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Paket {

	private  final long id;
	private String naziv;
	private int brojTreninga;
	private int trajanje;
	private double cena;
	
	Set<Clanarina> clanarina = new LinkedHashSet<>();
	
	public Paket(long id, String naziv, int brojTreninga, int trajanje, double cena) {
		this.id = id;
		this.naziv = naziv;
		this.brojTreninga = brojTreninga;
		this.trajanje = trajanje;
		this.cena = cena;
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
		Paket other = (Paket) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Paket [id=" + id + ", naziv=" + naziv + ", brojTreninga=" + brojTreninga + ", trajanje=" + trajanje
				+ ", cena=" + cena + "]";
	}

	public int getBrojTreninga() {
		return brojTreninga;
	}

	public void setBrojTreninga(int brojTreninga) {
		this.brojTreninga = brojTreninga;
	}

	public int getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(int trajanje) {
		this.trajanje = trajanje;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public long getId() {
		return id;
	}

	public Set<Clanarina> getClanarina() {
		return Collections.unmodifiableSet(clanarina);
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	
}
