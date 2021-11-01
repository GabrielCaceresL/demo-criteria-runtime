package com.example.demo.entity;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;

@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "cedula")
    private String cedula;

}
