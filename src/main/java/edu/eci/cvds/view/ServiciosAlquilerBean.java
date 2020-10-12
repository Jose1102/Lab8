package edu.eci.cvds.view;
import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;


import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.Date;
import java.util.List;


@ManagedBean(name="ServiciosAlquilerBean")
@SessionScoped
public class ServiciosAlquilerBean extends BasePageBean{

    @Inject
    private ServiciosAlquiler serviciosAlquiler;
    private Cliente clienteSeleccionado;


    public void registrarCliente(String nombre, long documento, String telefono, String direccion, String email){
        try {
            serviciosAlquiler.registrarCliente(new Cliente(nombre, documento, telefono, direccion, email));
        } catch (ExcepcionServiciosAlquiler excepcionServiciosAlquiler) {
            excepcionServiciosAlquiler.printStackTrace();
        }
    }

    public List<Cliente> consultarClientes(){
        List<Cliente> clientes = null;
        try {
            clientes = serviciosAlquiler.consultarClientes();
        } catch (ExcepcionServiciosAlquiler excepcionServiciosAlquiler) {
            excepcionServiciosAlquiler.printStackTrace();
        }
        return clientes;
    }

    public Cliente consultarCliente(long documento){
        Cliente cliente = null;
        try {
            cliente = serviciosAlquiler.consultarCliente(documento);
        } catch (ExcepcionServiciosAlquiler excepcionServiciosAlquiler) {
            excepcionServiciosAlquiler.printStackTrace();
        }
        return cliente;
    }

    public Cliente getClienteSeleccionado() {
        return clienteSeleccionado;
    }

    public void setClienteSeleccionado(Cliente clienteSeleccionado) {
        this.clienteSeleccionado = clienteSeleccionado;
    }

    public List<ItemRentado> consultarItemsCliente(long id){
        List<ItemRentado> itemsDelCliente = null;
        try {
            itemsDelCliente = serviciosAlquiler.consultarItemsCliente(id);
        } catch (ExcepcionServiciosAlquiler excepcionServiciosAlquiler) {
            excepcionServiciosAlquiler.printStackTrace();
        }
        return itemsDelCliente;
    }


    public void registrarAlquilerItem( int it, int numdias) throws ExcepcionServiciosAlquiler{
        Item itObj = serviciosAlquiler.consultarItem(it);
        try {
            serviciosAlquiler.registrarAlquilerCliente(new Date(System.currentTimeMillis()), clienteSeleccionado.getDocumento(), itObj, numdias);
        } catch (ExcepcionServiciosAlquiler excepcionServiciosAlquiler) {
            excepcionServiciosAlquiler.printStackTrace();
        }

    }




}