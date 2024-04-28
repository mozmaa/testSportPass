package model;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class StavkaIzvestaja {

	private final String nazivPaketa;
	private final List<String> korisnici;
	private final String  korisnikMaxAktivnih;
	
	public StavkaIzvestaja(String nazivPaketa, List<String> korisnici, String  korisnik) {
		this.nazivPaketa = nazivPaketa;
		this.korisnici = korisnici;
		this.korisnikMaxAktivnih = korisnik;
	}

	@Override
	public String toString() {
		return nazivPaketa + ", korisnici: " + korisniciString () + " korisnikMaxAktivnih="
				+ korisnikMaxAktivnih ;
	}
	
	private List<String> distinctKorisnici(){
		return korisnici.stream().distinct().toList();
	}
	
	private String korisniciString () {
		String strKorisnici = "";
		List<String> korisnici = distinctKorisnici();
		for (String temp : korisnici) {
			strKorisnici = strKorisnici + temp + ",";
		}
		return strKorisnici;
	}

	public List<String> getKorisnici() {
		return korisnici;
	}
	
	public static String compare(Collection<String> korisnici) {
		
		return Collections.max(korisnici);
	}
}
