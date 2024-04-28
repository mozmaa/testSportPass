package ui;

import java.sql.Connection;
import java.sql.DriverManager;

import dao.impl.DatabaseClanarinaDAO;
import dao.impl.DatabasePaketDAO;
import model.Clanarina;
import model.dao.PaketDAO;
import model.dao.ClanarinaDAO;
import util.Meni;
import util.Meni.FunkcionalnaStavkaMenija;
import util.Meni.IzlaznaStavkaMenija;
import util.Meni.StavkaMenija;

public class Application {

	private static void initDatabase() throws Exception {
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/sportPass?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Europe/Belgrade", 
				"root", 
				"root");

		PaketDAO paketDAO = new DatabasePaketDAO(conn);
		ClanarinaDAO clanarinaDAO = new DatabaseClanarinaDAO(conn);

		PaketUI.setPaketDAO(paketDAO);
		ClanarinaUI.setClarainaDAO(clanarinaDAO);
		IzvestajUI.setClarainaDAO(clanarinaDAO);
	}

	static {
		try {
			initDatabase();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Greška pri povezivanju sa izvorom podataka!");
			
			System.exit(1);
		}
	}

	public static void main(String[] args) throws Exception {
		Meni.pokreni("Sport Pass", new StavkaMenija[] {
			new IzlaznaStavkaMenija("Izlaz"),
			new FunkcionalnaStavkaMenija("Prikaz paketa") {

				@Override
				public void izvrsi() { PaketUI.prikaz(); }
				
			}, 
			new FunkcionalnaStavkaMenija("Prikaz svih clanarina sa paketima") {

				@Override
				public void izvrsi() { ClanarinaUI.prikazSvih(); }
				
			}, 
			new FunkcionalnaStavkaMenija("Dodavanje clanarine ") {

				@Override
				public void izvrsi() { ClanarinaUI.add(); }
				
			}, 
			new FunkcionalnaStavkaMenija("Izveštavanje") {

				@Override
				public void izvrsi() { IzvestajUI.izvestavanje(); }
				
			}
		});
	}

}
