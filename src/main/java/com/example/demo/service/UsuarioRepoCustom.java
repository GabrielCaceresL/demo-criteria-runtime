package com.example.demo.service;

import com.example.demo.entity.Usuario;

import java.util.List;
import java.util.Map;

public interface UsuarioRepoCustom {

    List<Usuario> filterData(Map<String, Object> mapit);
}
