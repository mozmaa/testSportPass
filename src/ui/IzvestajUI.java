package ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import model.Clanarina;
import model.StavkaIzvestaja;
import model.dao.ClanarinaDAO;
import util.Konzola;

public class IzvestajUI {

	private static ClanarinaDAO clanarinaDAO;
	
	public static void setClarainaDAO(ClanarinaDAO clanarinaDAO) {
		IzvestajUI.clanarinaDAO = clanarinaDAO;
	}

	public static void izvestavanje() {
		
		LocalDate datum = Konzola.ocitajDate("Datum");
		
		try {
			Collection<Clanarina> clanarine = clanarinaDAO.getAll();
			
			Set<String> paketi = new LinkedHashSet<>();
			
			for (Clanarina tempCla : clanarine) {
				paketi.add(tempCla.getPaket().getNaziv());
			}
			
			List<StavkaIzvestaja> stavke = new ArrayList<>();
			
			for (String tempPak : paketi) {
				List<String> korisnici = new ArrayList<>();
				String korisnik;
				for(Clanarina tempCla : clanarine) {
					if(tempPak.equals(tempCla.getPaket().getNaziv()) && tempCla.aktivnaClanarina(tempCla, datum))
						korisnici.add(tempCla.getKorisnickoIme());
				}
				
				
//				korisnik = korisnici.stream().max(String::compareTo);
				korisnik = StavkaIzvestaja.compare(korisnici);
				StavkaIzvestaja stavka = new StavkaIzvestaja(tempPak, korisnici, korisnik);
				stavke.add(stavka);
			}
			
			stavke = stavke.stream().sorted((stat1, stat2) -> -Integer.compare(stat1.getKorisnici().size(), stat2.getKorisnici().size()))
					.toList();
			
			for (StavkaIzvestaja tempStavka : stavke) {
				System.out.println(tempStavka);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Doslo je do greske!");
		}
		
		
	}

}
