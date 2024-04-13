package com.senai.api.services.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.senai.api.dto.UsuarioDto;
import com.senai.api.models.Usuario;
import com.senai.api.repository.UsuarioRepository;
import com.senai.api.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> listarUsuario() {
		return usuarioRepository.findAll();
	}

	@Override
	public ResponseEntity<?> cadastrar(UsuarioDto usuarioDto) {

		Boolean isAvaible = usuarioRepository.findByLogin(usuarioDto.getLogin()).isEmpty();
		String encryptedPassword = new BCryptPasswordEncoder().encode(usuarioDto.getSenha());

		if (isAvaible && usuarioDto != null) {
			Usuario usuario = new Usuario();
			BeanUtils.copyProperties(usuarioDto, usuario);

			usuario.setLogin(usuarioDto.getLogin());
			usuario.setSenha(encryptedPassword);

			usuarioRepository.save(usuario);
			return ResponseEntity.ok("Usuário adicionado com sucesso");

		} else {
			return ResponseEntity.ok("Não foi possivel criar");
		}
	}

	@Override
	public ResponseEntity<?> cadastrarAdmin(String senha) {
		UsuarioDto usuarioDto = new UsuarioDto();
		usuarioDto.setLogin("admin");
		usuarioDto.setSenha(senha);
		usuarioDto.setPerfil("ADMINISTRADOR");
		usuarioDto.setNome("admin");
		usuarioDto.setEmail("administrador@admin.com");

		Boolean isAvaible = usuarioRepository.findByLogin(usuarioDto.getLogin()).isEmpty();
		String encryptedPassword = new BCryptPasswordEncoder().encode(usuarioDto.getSenha());

		if (isAvaible) {
			Usuario usuario = new Usuario();
			BeanUtils.copyProperties(usuarioDto, usuario);

			usuario.setLogin(usuarioDto.getLogin());
			usuario.setSenha(encryptedPassword);

			usuarioRepository.save(usuario);
			return ResponseEntity.ok("Usuário adicionado com sucesso");
		} else {
			return ResponseEntity.ok("Não foi possivel criar");
		}

	}

}
