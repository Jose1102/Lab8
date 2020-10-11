package edu.eci.cvds.sampleprj.dao.mybatis;

import edu.eci.cvds.sampleprj.dao.TipoItemDAO;
import java.util.List;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.TipoItemMapper;
import edu.eci.cvds.samples.entities.TipoItem;
import edu.eci.cvds.sampleprj.dao.PersistenceException;

import com.google.inject.Inject;

public class MyBATISTipoItemDAO implements TipoItemDAO{
	
	@Inject
	private TipoItemMapper tipoItemMapper;
	
	@Override
	public TipoItem load(int id) throws PersistenceException{
		
		try{
			return tipoItemMapper.getTipoItem(id);
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar el tipo item "+id,e);
		}    
	}
	
	@Override
	public List<TipoItem> consultarTiposItem() throws PersistenceException{
		try{
			return tipoItemMapper.getTiposItems();
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar los tipos de item ",e);
		} 
	}

	@Override
	public void save(TipoItem a) throws PersistenceException {
		tipoItemMapper.addTipoItem(a);
	}
}
