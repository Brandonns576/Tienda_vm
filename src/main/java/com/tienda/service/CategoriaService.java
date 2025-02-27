
package com.tienda.service;

import com.tienda.domain.Categoria;
import com.tienda.repository.CategoriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional(readOnly=true)
    public List<Categoria> getCategorias(boolean activos){
        var lista = categoriaRepository.findAll();
   return lista;
    }

    //se escriben los metodos de un CRUD Create Read Update Delete
    @Transactional(readOnly=true)
    public Categoria getCategoria(Categoria categoria){
       
   return categoriaRepository.findById(categoria.getIdCategoria()).orElse(null);
    }

   @Transactional
    public void delete(Categoria categoria){
       categoriaRepository.delete(categoria);
    }
    
    @Transactional
    public void save(Categoria categoria){
       //si categoria.idCategoria esta vacio se incerta registro
       //si categoria tiene algo se modifica ese registro
        categoriaRepository.save(categoria);
    }
}
