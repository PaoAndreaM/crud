/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacion;

import dao.ProductoDao;
import java.util.List;
import modelo.Productos;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Paola
 */
public class productoDaoImp implements ProductoDao{
//SE DEFINE UNA CONSULTA
    @Override
    public List<Productos> ListarProductos() {
        List<Productos> lista=null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        
        String hql="from producto";
       try{
           lista=session.createQuery(hql).list();
           t.commit();
           session.close();
       } catch (Exception e){
           t.rollback();
       }
       return lista;  
    }

    @Override
    public void newProducto(Productos productos) {
      Session session=null;
try{
    session= HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.save(productos);
    session.getTransaction().commit();
   }catch(Exception e){
    System.out.println(e.getMessage());
    session.getTransaction().rollback();
} finally{
    if(session!= null){
        session.close();
    }
}  
    }

    @Override
    public void updateProducto(Productos productos) {
     Session session=null;
try {
    session= HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.update(productos);
    session.getTransaction().commit();
} catch (Exception e)  {
    System.out.println(e.getMessage());
    session.getTransaction().rollback();
} finally{
    if(session!=null){
        session.close();
    }
}   
    }

    @Override
    public void deleteProducto(Productos productos) {
           Session session=null;
   try{
       session= HibernateUtil.getSessionFactory().openSession();
       session.beginTransaction();
       session.delete(productos);
       session.getTransaction().commit();
   } catch (Exception e){
       System.out.println(e.getMessage());
       session.getTransaction().rollback();
   }finally{
       if(session!=null){
           session.close();
       }
   }
    }
        
    }
    

