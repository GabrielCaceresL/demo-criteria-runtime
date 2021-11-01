package com.example.demo.util;

import com.fasterxml.jackson.annotation.JsonAlias;

public enum UsuarioEnum {

    @JsonAlias(value = {"id"})
    ID("id"),
    @JsonAlias(value = {"nombre"})
    NOMBRE("nombre"),
    @JsonAlias(value = {"apellido"})
    APELLIDO("apellido"),
    @JsonAlias(value = {"cedula"})
    CEDULA("cedula");

    private final String property;


    UsuarioEnum(String property) {
        this.property = property;
    }

    public String getProperty() {
        return property;
    }
}
