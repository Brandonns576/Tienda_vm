
package com.tienda.repository;

import com.tienda.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ProductoRepository extends JpaRepository<Producto, Long>{
     
    
    //consulta ampliada para recuperar los productos entre un rango de precio
    public List<Producto> findByPrecioBetweenOrderByPrecio(double precioInf, double precioSup);

    
    //consulta jpql para recuperar los productos entre un rango de precio
@Query(value = "SELECT a FROM Producto a "
        + "WHERE a.precio "
        + "BETWEEN :precioInf AND :precioSup "
        + "ORDER BY a.precio")
public List<Producto> consultaJPQL(@Param("precioInf") double precioInf, 
                                     @Param("precioSup") double precioSup);
  //consulta SQL para recuperar los productos entre un rango de precio
@Query(nativeQuery = true, value = "SELECT * FROM producto a "
        + "WHERE a.precio "
        + "BETWEEN :precioInf AND :precioSup "
        + "ORDER BY a.precio")
public List<Producto> consultaSQL(@Param("precioInf") double precioInf, 
                                   @Param("precioSup") double precioSup);


    // Consulta ampliada para recuperar productos entre un rango de precio y por categoría
    @Query("SELECT p FROM Producto p WHERE p.precio BETWEEN :precioInf AND :precioSup AND p.categoria.idCategoria = :idCategoria ORDER BY p.precio")
    List<Producto> findByPrecioAndCategoria(@Param("precioInf") double precioInf, 
                                             @Param("precioSup") double precioSup, 
                                             @Param("idCategoria") Long idCategoria);
}

