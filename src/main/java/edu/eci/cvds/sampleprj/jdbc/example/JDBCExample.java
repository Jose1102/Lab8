/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.cvds.sampleprj.jdbc.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hcadavid
 */
public class JDBCExample {
	private static PreparedStatement updateOrden;
	private static PreparedStatement updatePedido;
	private static PreparedStatement registrarOrden;
	private static ResultSet salidaOrden;
	private static ResultSet salidaPedido = null;
    
    public static void main(String args[]){
        try {
            String url="jdbc:mysql://desarrollo.is.escuelaing.edu.co:3306/bdprueba";
            String driver="com.mysql.jdbc.Driver";
            String user="bdprueba";
            String pwd="prueba2019";
                        
            Class.forName(driver);
            Connection con=DriverManager.getConnection(url,user,pwd);
            con.setAutoCommit(false);
                 
            List<String> variable = nombresProductosPedido(con, 1);
            System.out.println("Valor nombre: " + variable.get(0));
            //System.out.println("Valor total pedido 1:"+valorTotalPedido(con, 2));
            
            List<String> prodsPedido=nombresProductosPedido(con, 1);
            
            
            System.out.println("Productos del pedido 1:");
            System.out.println("-----------------------");
            for (String nomprod:prodsPedido){
                System.out.println(nomprod);
            }
            System.out.println("-----------------------");
            
            
            int suCodigoECI=2159970;
            //registrarNuevoProducto(con, suCodigoECI, "Juan Carlos A", 99999999);            
            con.commit();
                        
            
            con.close();
                                   
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(JDBCExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    /**
     * Agregar un nuevo producto con los parámetros dados
     * @param con la conexión JDBC
     * @param codigo
     * @param nombre
     * @param precio
     * @throws SQLException 
     */
    public static void registrarNuevoProducto(Connection con, int codigo, String nombre,int precio) throws SQLException{
        //Crear preparedStatement
        //Asignar parámetros
        //usar 'execute'
		//Crear prepared statement
		String updateString = "INSERT INTO ORD_PRODUCTOS VALUES (?,?,?);";
		registrarOrden = con.prepareStatement(updateString);
		registrarOrden.setInt(1,codigo);
		registrarOrden.setString(2,nombre);
		registrarOrden.setInt(3,precio);		
		registrarOrden.executeUpdate();
        con.commit();
        
    }
    
    /**
     * Consultar los nombres de los productos asociados a un pedido
     * @param con la conexión JDBC
     * @param codigoPedido el código del pedido
     * @return 
     */
    public static List<String> nombresProductosPedido(Connection con, int codigoPedido){
        List<String> np=new LinkedList<>();
        
        String agregar = null;
        
        
        //Sacar resultados del ResultSet
        //Llenar la lista y retornarla
		
		try{
			//Crear prepared statement
			String updateString = "SELECT nombre FROM ORD_PRODUCTOS WHERE CODIGO = ?;";
			updateOrden = con.prepareStatement(updateString);
			//asignar parámetros
			updateOrden.setInt(1, codigoPedido);
			//usar executeQuery
			salidaOrden = updateOrden.executeQuery();
			
			while(salidaOrden.next()){
				agregar = salidaOrden.getString(1);
				np.add(agregar);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
        
        return np;
    }

    
    /**
     * Calcular el costo total de un pedido
     * @param con
     * @param codigoPedido código del pedido cuyo total se calculará
     * @return el costo total del pedido (suma de: cantidades*precios)
     */
    public static int valorTotalPedido(Connection con, int codigoPedido){
        
        int costo=0;
        
        try{
			//Crear prepared statement
			String updateString = "SELECT SUM(ORD_DETALLE_PEDIDO.CANTIDAD*ORD_PRODUCTOS.PRECIO) FROM ORD_DETALLE_PEDIDO JOIN ORD_PRODUCTOS ON ORD_DETALLE_PEDIDO.PRODUCTO_FK=ORD_PRODUCTOS.CODIGO WHERE ORD_DETALLE_PEDIDO.PRODUCTO_FK=?;";
			updatePedido = con.prepareStatement(updateString);
			//asignar parámetros
			updatePedido.setInt(1, codigoPedido);
			//usar executeQuery
			salidaPedido = updatePedido.executeQuery();
			
			while(salidaPedido.next()){
				//Sacar resultado del ResultSet
				costo = salidaPedido.getInt(1);	
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
        return costo;
    }
    

    
    
    
}