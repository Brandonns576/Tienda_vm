
package com.tienda.service;

import com.tienda.domain.Producto;
import com.tienda.repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoService {
    
    @Autowired
    private ProductoRepository productoRepository;
    
    @Transactional(readOnly=true)
    public List<Producto> getProductos(boolean activos) {
        var lista = productoRepository.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
    //se escriben los metodos de un CRUD Create Read Update Delete
    @Transactional(readOnly=true)
    public Producto getProducto(Producto producto){
       
   return productoRepository.findById(producto.getId_Producto()).orElse(null);
    }

   @Transactional
    public void delete(Producto producto){
       productoRepository.delete(producto);
    }
    
    @Transactional
    public void save(Producto producto){
       //si producto.idProducto esta vacio se incerta registro
       //si producto tiene algo se modifica ese registro
        productoRepository.save(producto);
    }
    
      @Transactional(readOnly=true)
    public List <Producto> consultaAmpliada(double precioInf, double precioSup){
   return productoRepository.findByPrecioBetweenOrderByPrecio(precioInf, precioSup);
   }

      @Transactional(readOnly=true)
    public List <Producto> consultaJPQL(double precioInf, double precioSup){
   return productoRepository.consultaJPQL(precioInf, precioSup);
   }

   @Transactional(readOnly=true)
    public List <Producto> consultaSQL(double precioInf, double precioSup){
   return productoRepository.consultaSQL(precioInf, precioSup);
   }

   @Transactional(readOnly=true)
    public List<Producto> consultaAmpliadaPorCategoria(double precioInf, double precioSup, Long idCategoria) {
        return productoRepository.findByPrecioAndCategoria(precioInf, precioSup, idCategoria);
    }
}
