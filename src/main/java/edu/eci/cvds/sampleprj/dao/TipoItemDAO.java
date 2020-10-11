package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.TipoItem;
import java.util.List;

public interface TipoItemDAO{
	
	
	public TipoItem load(int id) throws PersistenceException;
	
	public List<TipoItem> consultarTiposItem() throws PersistenceException;

	public void save(TipoItem a) throws PersistenceException;
	
}