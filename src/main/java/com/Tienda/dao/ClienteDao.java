package com.Tienda.dao;

import com.Tienda.domain.Cliente;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Usuario
 */
public interface ClienteDao extends CrudRepository<Cliente, Long> {
       List<Cliente> findByApellidos(String apellidos);
}
