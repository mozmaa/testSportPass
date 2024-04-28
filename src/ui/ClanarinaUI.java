package ui;

import java.time.LocalDate;
import java.util.Collection;

import model.Clanarina;
import model.Paket;
import model.dao.ClanarinaDAO;
import util.Konzola;

public class ClanarinaUI {

	private static ClanarinaDAO clanarinaDAO;
	
	public static void setClarainaDAO(ClanarinaDAO clanarinaDAO) {
		ClanarinaUI.clanarinaDAO = clanarinaDAO;
	}

	public static void prikazSvih() {
		try {
			Collection<Clanarina> clanarine = clanarinaDAO.getAll();
			
			for (Clanarina tempClan : clanarine) {
				System.out.println(tempClan);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Doslo je do greske");
		}
		
	}

	public static void add() {
		
		try {
			Paket paket = PaketUI.pronalaznje();
			if(paket == null) 
				return;
			
			Collection<Clanarina> clanarine = clanarinaDAO.getAll();
			
			String korisnickoIme = "";
			while(korisnickoIme.equals(""))
				korisnickoIme = Konzola.ocitajString("Korisnicko ime");
			
			for (Clanarina tempClan : clanarine) {
				if(korisnickoIme.equals(tempClan.getKorisnickoIme()) && tempClan.aktivnaClanarina(tempClan)) {
					System.out.println("Korisnicko ime vec ima aktivnu clanarinu");
					return;
				}
			}
			
			LocalDate datumPocetka = LocalDate.now();
			clanarinaDAO.add(new Clanarina(0, korisnickoIme, datumPocetka, paket));
			
			System.out.println("Uspesno dodavanje");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Doslo je do greske");
		}
	}

}
