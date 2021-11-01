package com.example.demo.dto;

import com.example.demo.util.UsuarioEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.EnumMap;

@Data
@NoArgsConstructor
public class UsuarioRequest {

    private EnumMap<UsuarioEnum, Object> enumMap;
}
