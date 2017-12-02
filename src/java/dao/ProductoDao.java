/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Productos;

/**
 *
 * @author Paola
 */
public interface ProductoDao {
     // Lista todo los productos que estan en la base de datos
    public List <Productos> ListarProductos(); 
   //CRUD DE LOS PRODUCTOS
    public void newProducto(Productos productos);
    public void updateProducto(Productos productos);
    public void deleteProducto(Productos productos);
     
}
