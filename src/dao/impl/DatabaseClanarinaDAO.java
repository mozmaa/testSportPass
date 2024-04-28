package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import model.Clanarina;
import model.Paket;
import model.dao.ClanarinaDAO;

public class DatabaseClanarinaDAO implements ClanarinaDAO{

	private final Connection conn;
	
	public DatabaseClanarinaDAO(Connection conn) {
		this.conn = conn;
	}

	@Override
	public Collection<Clanarina> getAll() throws Exception {
		Collection<Clanarina> clanarine = new ArrayList<>();
		
		String sql = "SELECT c.id,  c.korisnickoIme, c.datum, p.id, p.naziv, p.brojTreninga, p.trajanje, p.cena " +
					 "FROM clanarine c LEFT JOIN paketi p ON c.idPaket = p.id;";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			try(ResultSet rset = stmt.executeQuery()){
				while(rset.next()) {
					
					int kolona = 0;
					long cId = rset.getLong(++kolona);
					String korisnickoIme = rset.getString(++kolona);
					LocalDate datum = rset.getDate(++kolona).toLocalDate();
					
					long pId = rset.getLong(++kolona);
					String naziv = rset.getString(++kolona);
					int brojTreninga = rset.getInt(++kolona);
					int trajanje = rset.getInt(++kolona);
					double cena = rset.getDouble(++kolona);
					
					clanarine.add(new Clanarina(cId, korisnickoIme, datum, new Paket(pId, naziv, brojTreninga,trajanje, cena)));
				}
			}
		}
		return clanarine;
	}

	@Override
	public void add(Clanarina clanarina) throws Exception {
		
		String sql = "INSERT INTO clanarine (idPaket, korisnickoIme, datum) VALUES (?, ?, ?)";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			int param = 0;
			stmt.setLong(++param, clanarina.getPaket().getId());
			stmt.setString(++param, clanarina.getKorisnickoIme());
			stmt.setDate(++param, Date.valueOf(clanarina.getDatumPocetka()));
			
			stmt.executeUpdate();
		}
		
	}

}
