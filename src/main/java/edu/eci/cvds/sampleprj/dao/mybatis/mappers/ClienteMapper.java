package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.ItemRentado;

/**
 *
 * @author 2106913
 */
public interface ClienteMapper {
	 
    public Cliente consultarCliente(@Param("documentoCliente")long documento);
	
    
    /**
     * Registrar un nuevo item rentado asociado al cliente identificado
     * con 'idc' y relacionado con el item identificado con 'idi'
     * @param id
     * @param idit
     * @param fechainicio
     * @param fechafin 
     */
    public void agregarItemRentadoACliente(@Param("idcli") int id, 
            @Param("idit") int idit, 
            @Param("fechainicio") Date fechainicio,
            @Param("fechafin") Date fechafin);

    /**
     * Consultar todos los clientes
     * @return 
     */
    public List<Cliente> consultarClientes();
    
    
    public void insertarCliente(@Param("cliente")Cliente cliente);
    
    public List<ItemRentado> consultarItems(@Param("idcliente" )long idcliente);

    public void vetarCliente(@Param("documento") long documento, 
    		@Param("estado") boolean estado);
    
    
}
