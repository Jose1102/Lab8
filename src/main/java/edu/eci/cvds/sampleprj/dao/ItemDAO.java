package edu.eci.cvds.sampleprj.dao;



import java.util.Date;
import java.util.List;

import edu.eci.cvds.samples.entities.Item;

public interface ItemDAO {

   public void save(Item it) throws PersistenceException;
 
   public Item load(int id) throws PersistenceException;
   
   public int valormultaretraso(int itemId) throws PersistenceException;
   
   public List<Item> consultarItemsDisponibles() throws PersistenceException;
   
   public long consultarCostoAlquiler(int iditem, int ndias) throws PersistenceException;
   
   public void actualizarTarifaItem(int id, long tarifa) throws PersistenceException;

   public long consultarMultaAlquiler(int iditem, Date fechaDevolucion)  throws PersistenceException;

}