package model.dao;

import java.util.Collection;

import model.Clanarina;

public interface ClanarinaDAO {

	Collection<Clanarina> getAll() throws Exception;

	void add(Clanarina clanarina) throws Exception;

}
