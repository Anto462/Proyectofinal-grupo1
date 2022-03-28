package com.proyectofinal.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="colecionismo")
public class Colecionismo implements Serializable{
   private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idColecionismo;
    private String nombre;
    private double precio;
    private int unidades;
    private String marca;
    private boolean certificado;
    private String descripcion;
    
    @JoinColumn(name="id_producto", referencedColumnName = "id_producto")
    @ManyToOne
    private Producto producto;
    
    @JoinColumn(name="id_videojuego", referencedColumnName = "id_videojuego")
    @ManyToOne
    private Videojuego videojuego;

    public Colecionismo() {
    }

    public Colecionismo(Long idColecionismo, String nombre, double precio, int unidades, String marca, boolean certificado, String descripcion, Producto producto, Videojuego videojuego) {
        this.idColecionismo = idColecionismo;
        this.nombre = nombre;
        this.precio = precio;
        this.unidades = unidades;
        this.marca = marca;
        this.certificado = certificado;
        this.descripcion = descripcion;
        this.producto = producto;
        this.videojuego = videojuego;
    }
    
}
