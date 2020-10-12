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
package edu.eci.cvds.samples.services.client;



import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.SQLException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.TipoItem;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquilerFactory;

/**
 *
 * @author hcadavid
 */
public class MyBatisExample {

    /**
     * Método que construye una fábrica de sesiones de MyBatis a partir del
     * archivo de configuración ubicado en src/main/resources
     *
     * @return instancia de SQLSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = null;
        if (sqlSessionFactory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return sqlSessionFactory;
    }

    /**
     * Programa principal de ejempo de uso de MyBATIS
     * @param args
     * @throws SQLException 
     */
    public static void main(String args[]) throws SQLException {
    	
        SqlSessionFactory sessionfact = getSqlSessionFactory();

        SqlSession sqlss = sessionfact.openSession();
       
        ServiciosAlquiler sA= ServiciosAlquilerFactory.getInstance().getServiciosAlquiler();

        
        //Crear el mapper y usarlo: 
        ClienteMapper cm= sqlss.getMapper(ClienteMapper.class);
        //cm...
        System.out.println("Consulta Clientes");
        System.out.println(cm.consultarClientes());
        System.out.println("----------------------");
        System.out.println("----------------------");
        System.out.println("Consulta cliente -706");
        System.out.println(cm.consultarCliente(-706));
        System.out.println("----------------------");
        System.out.println("----------------------");
        System.out.println("agregar Item a Cliente");
        Date fi = new Date(113,4,5);
        Date ff = new Date(113,5,5);
        cm.agregarItemRentadoACliente(-706, 4, fi, ff);
        System.out.println(cm.consultarCliente(-706));
        System.out.println("----------------------");
        System.out.println("----------------------");
        System.out.println("agregar Item");
        ItemMapper im = sqlss.getMapper(ItemMapper.class);
        TipoItem tip = new TipoItem(2, "Accion");
        Date fecha = new Date(116,6,6);
        //Item itemNuevo = new Item(tip, 2122, "BicicletaNo2", "es un medio de transporte", fecha, 100, "Diario", "Accion");
        //im.insertarItem(itemNuevo);
        System.out.println(im.consultarItem(2122));
        
        sqlss.commit();
        
        
        sqlss.close();

        
        
    }


}
