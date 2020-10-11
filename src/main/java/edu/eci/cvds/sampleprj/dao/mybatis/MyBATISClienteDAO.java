package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.ItemDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;

import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.guice.transactional.Transactional;

public class MyBATISClienteDAO implements ClienteDAO {
	
	@Inject
	  private ClienteMapper clienteMapper;
	
	

	
	  
	  
	  @Override
		public List<Cliente> consultarClientes() throws PersistenceException{
			try{
				return clienteMapper.consultarClientes();
			}catch(org.apache.ibatis.exceptions.PersistenceException e){
				throw new PersistenceException("Error al consultar los clientes",e);
			}
		}


	@Override
	public void save(Cliente cl) throws PersistenceException {
		  try{
		      clienteMapper.insertarCliente(cl);
		  }
		  catch(org.apache.ibatis.exceptions.PersistenceException e){
		      throw new PersistenceException("Error al registrar el cliente "+cl.toString(),e);
		  }  
		
	}


	@Override
	public List<ItemRentado> loadItems(long idCliente) throws PersistenceException {
		try{
			return clienteMapper.consultarItems(idCliente);
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar el cliente "+idCliente,e);
		}
	}

	@Transactional
	@Override
	public void vetarCliente(long documento, boolean estado) throws PersistenceException {
		try{
			clienteMapper.vetarCliente(documento, estado);
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al vetar Cliente "+documento,e);
		}
		
	}


	  @Override
	  public Cliente load(long documento) throws PersistenceException {
	  try{
	      return clienteMapper.consultarCliente(documento);
	  }
	  catch(org.apache.ibatis.exceptions.PersistenceException e){
	      throw new PersistenceException("Error al consultar el cliente "+documento,e);
	  }
	  }
		


}

