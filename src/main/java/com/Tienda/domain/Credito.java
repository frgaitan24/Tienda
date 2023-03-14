package com.Tienda.domain;

import jakarta.persistence.Column;
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
@Table(name = "credito")
public class Credito implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_credito")//Permite mapear el campo de la BD que va a conectar
    private Long idCredito;//Transforma en id_credito
    private double limite;

    public Credito() {
    }

    public Credito(double limite) {
        this.limite = limite;
    }
    
}
