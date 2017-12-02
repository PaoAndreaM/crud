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
import javax.faces.view.ViewScoped;
import modelo.Productos;



/**
 *
 * @author Paola
 */

@ViewScoped
@ManagedBean

public class productoContro1 {

   private List<Productos> listaProductos;
    private Productos productos;
    
public productoContro1() {
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

