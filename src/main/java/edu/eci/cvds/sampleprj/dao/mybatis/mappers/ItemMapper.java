package edu.eci.cvds.sampleprj.dao.mybatis.mappers;


import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Item;

/**
 *
 * @author 2106913
 */
public interface ItemMapper {
    
    
    public List<Item> consultarItems();        
    
    public Item consultarItem(@Param("id") int id);
    
    public void insertarItem(@Param("it") Item it);
    
    public int valorMultaRetrasoxDia(@Param("iditem")int id);

	public int valorMultaAlquiler(@Param("item")int item, @Param("fecha")java.sql.Date fecha);

	public List<Item> consultarItemsDisponibles();

	public long consultarCostoAlquiler(@Param("iditem") int iditem);

	public void actualizarTarifaItem(@Param("id")int id, @Param("tarifa")long tarifa);

        
}
