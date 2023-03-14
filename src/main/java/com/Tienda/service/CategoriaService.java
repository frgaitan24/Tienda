package com.Tienda.service;

import com.Tienda.domain.Categoria;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface CategoriaService {

    public List<Categoria> getCategorias(boolean activos);

    public Categoria getCategoria(Categoria categoria);

    public void save(Categoria categoria);//Insertar y Modificar un registro

    public void delete(Categoria categoria);
}
