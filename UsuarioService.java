package com.projetojpa.Validation.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.Validation.Entity.Usuario;
import com.projetojpa.Validation.Repository.UsuarioRepository;

@Service
public class UsuarioService {
	private final UsuarioRepository usuarioRepository;

	@Autowired
	public UsuarioService (UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	public List<Usuario> getAllUsuarios(){
		return usuarioRepository.findAll();
	}
	public Usuario getUsuarioById(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.orElse(null);
	}
	public Usuario salvarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public Usuario updateUsuario(Long id, Usuario updatedUsuario) {
		Optional<Usuario> existingUsuario = usuarioRepository.findById(id);
		if (existingUsuario.isPresent()) {
			updatedUsuario.setId(id);
			return usuarioRepository.save(updatedUsuario);
		}
		return null;
	}

	public boolean deleteUsuario(Long id) {
		Optional<Usuario> existingUsuario = usuarioRepository.findById(id);
		if (existingUsuario.isPresent()) {
			usuarioRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
