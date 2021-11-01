package com.example.demo.controller;

import com.example.demo.entity.Usuario;
import com.example.demo.service.UsuarioRepoCustom;
import com.example.demo.util.UsuarioEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class UsuarioController {

    private final UsuarioRepoCustom usuarioCustomRepo;

    public UsuarioController(@Qualifier("usuarioRepoCustomImpl") UsuarioRepoCustom usuarioCustomRepo) {
        this.usuarioCustomRepo = usuarioCustomRepo;
    }

    @PostMapping("/")
    public ResponseEntity<List<Usuario>> getAll(@RequestBody EnumMap<UsuarioEnum, Object> usuarioEnum) {

        Map<String, Object> usuarioMap = new HashMap<>();
        log.info("Size {}", usuarioEnum.size());
        usuarioEnum.forEach((anEnum, o) ->
            usuarioMap.put(anEnum.getProperty(), o)
        );

        return ResponseEntity.ok(usuarioCustomRepo.filterData(usuarioMap));
    }


}
