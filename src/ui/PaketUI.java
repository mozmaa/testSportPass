package ui;

import java.util.Collection;

import model.Paket;
import model.dao.PaketDAO;
import util.Konzola;

public class PaketUI {

	public static PaketDAO paketDAO;
	
	public static void setPaketDAO(PaketDAO paketDAO) {
		PaketUI.paketDAO = paketDAO;
	}
	
	public static Paket pronalaznje() throws Exception {
		prikazSvih();

		long id = Konzola.ocitajLong("Unesite id paketa");

		Paket paket = paketDAO.get(id);
		if (paket == null)
			Konzola.prikazi("Paket nije pronađen!");

		return paket;
	}

	public static void prikazSvih() {
		try {
			Collection<Paket> paketi = paketDAO.getAll();
			
			for (Paket tempPaket : paketi) {
				System.out.println(tempPaket);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Doslo je do greske");
		}
	}

	public static void prikaz() {
		try {
			Paket paket = pronalaznje();
			if (paket == null) 
				return;
			
			System.out.println(paket);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Doslo je do greske");
		}
		
	}

}
