package com.Tienda.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Usuario
 */
@Data
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;//Transforma en id_categoria
    private String description;
    private boolean activo;

    public Categoria() {
    }

    public Categoria(String description, boolean activo) {
        this.description = description;
        this.activo = activo;
    }

}
