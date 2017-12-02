/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ProductoDao;
import implementacion.productoDaoImp;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import modelo.Productos;

/**
 *
 * @author Paola
 */
@Named(value = "productoControlador")
@ViewScoped
@ManagedBean
public class productoControlador {
    private List<Productos> listaProductos;
    private Productos productos;

    /**
     * Creates a new instance of productoControlador
     */
   public productoControlador() {
    }  

    public void setListaProductos(List<Productos> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos= productos;
    }
 public List<Productos> getListaProductos() {
     ProductoDao pDao = new productoDaoImp();    
     listaProductos=pDao.ListarProductos();
     return listaProductos;
        
    }
 public void prepararNuevoProducto(){
     productos = new Productos();
 }
 public void nuevoProducto(){
     ProductoDao pDao = new productoDaoImp();
     pDao.newProducto(productos);
 }
 
 public void modificarProducto(){
      ProductoDao pDao = new productoDaoImp();
     pDao.updateProducto(productos);
     productos = new Productos();
 }
 
 public void eliminarProducto(){
    ProductoDao pDao = new productoDaoImp();
     pDao.deleteProducto(productos);
     productos = new Productos();
 }
}

