package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.entities.TipoItem;

public interface ItemRentadoMapper {
	
	public ItemRentado getItemRentado(@Param ("ir")int id);
    
	public void insertItemRentado(@Param ("documento")long docu,@Param ("itemId")int itemId,@Param ("fechaInicio")Date fechaIni,@Param ("fechaFin")Date fechaFin);

	public List<ItemRentado> consultarItemsSinDevolver(@Param("documento") long documento);


}
