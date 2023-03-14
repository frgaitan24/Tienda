package com.Tienda.service;

import com.Tienda.domain.Articulo;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface ArticuloService {

    public List<Articulo> getArticulos(boolean activos);

    public Articulo getArticulo(Articulo articulo);

    public void save(Articulo articulo);//Insertar y Modificar un registro

    public void delete(Articulo articulo);

}
