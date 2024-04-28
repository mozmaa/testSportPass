package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import model.Paket;
import model.dao.PaketDAO;

public class DatabasePaketDAO implements PaketDAO {

	private final Connection conn; 
	
	public DatabasePaketDAO(Connection conn) {
		this.conn = conn;
	}

	@Override
	public Paket get(long id) throws Exception {
		Paket paket = null;
		
		String sql = "SELECT naziv, brojTreninga, trajanje, cena FROM paketi WHERE id = ?";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			
			int param = 0;
			stmt.setLong(++param, id);
			try(ResultSet rset = stmt.executeQuery()){
				while(rset.next()) {
					
					int kolona = 0;
					String naziv = rset.getString(++kolona);
					int brojTreninga = rset.getInt(++kolona);
					int trajanje = rset.getInt(++kolona);
					double cena = rset.getDouble(++kolona);
					
					paket = new Paket(id, naziv, brojTreninga, trajanje, cena);
				}
			}
		}
		return paket;
	}

	@Override
	public Collection<Paket> getAll() throws Exception {
		Collection<Paket> paketi = new ArrayList<>();
		
		String sql = "SELECT id, naziv, brojTreninga, trajanje, cena FROM paketi";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			try(ResultSet rset = stmt.executeQuery()){
				while(rset.next()) {
					
					int kolona = 0;
					long id = rset.getLong(++kolona);
					String naziv = rset.getString(++kolona);
					int brojTreninga = rset.getInt(++kolona);
					int trajanje = rset.getInt(++kolona);
					double cena = rset.getDouble(++kolona);
					
					paketi.add(new Paket(id, naziv, brojTreninga, trajanje, cena));
				}
			}
		}
		return paketi;
	}

}
