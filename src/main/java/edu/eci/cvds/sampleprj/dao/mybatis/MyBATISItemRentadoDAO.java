package edu.eci.cvds.sampleprj.dao.mybatis;

import edu.eci.cvds.sampleprj.dao.ItemRentadoDAO;
import java.util.List;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemRentadoMapper;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.sampleprj.dao.PersistenceException;

import com.google.inject.Inject;

import org.mybatis.guice.transactional.Transactional;

import java.sql.Date;

public class MyBATISItemRentadoDAO implements ItemRentadoDAO{
	
	@Inject
	private ItemRentadoMapper itemRentadoMapper;

	@Override
	public ItemRentado load(int id) throws PersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(long docu, int itemId, Date fechaIni, Date fechaFin) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ItemRentado> consultarItemsSinDevolver(long documento) throws PersistenceException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	@Override
	public ItemRentado load(int id) throws PersistenceException{
		try{
			return itemRentadoMapper.getItemRentado(id);
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar el item rentado "+id,e);
		}    
	}
	
	@Transactional
	@Override
	public void save(long docu,int itemId,Date fechaIni,Date fechaFin) throws PersistenceException{
		try{
			itemRentadoMapper.insertItemRentado(docu,itemId,fechaIni,fechaFin);
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al registrar el alquiler del producto "+itemId+" por el cliente "+docu,e);
		}
	}
	

	@Override
	public List<ItemRentado> consultarItemsSinDevolver(long documento) throws PersistenceException {
		try{
			return itemRentadoMapper.consultarItemsSinDevolver(documento);
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar items del cliente: "+documento,e);
		}
	}

	*/
}
