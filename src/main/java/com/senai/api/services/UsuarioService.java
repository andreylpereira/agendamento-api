package com.senai.api.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.senai.api.dto.UsuarioDto;
import com.senai.api.models.Usuario;

public interface UsuarioService {

	List<Usuario> listarUsuario();

	ResponseEntity<?> cadastrar(UsuarioDto usuarioDto);

	ResponseEntity<?> cadastrarAdmin(String senha);

}
