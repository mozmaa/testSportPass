package model.dao;

import java.util.Collection;

import model.Paket;

public interface PaketDAO {

	Paket get(long id) throws Exception;

	Collection<Paket> getAll() throws Exception;

}
