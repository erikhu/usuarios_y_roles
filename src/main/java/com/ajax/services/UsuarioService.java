package com.ajax.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajax.documents.Usuario;
import com.ajax.prueba.repo.RolRepo;
import com.ajax.prueba.repo.UsuarioRepo;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepo usuarioRepo;
	
	@Autowired
	RolRepo rolRepo;
	
		//tipoes de Creacion
	
		public void createUsuario(Usuario usuario){	
			rolRepo.save(usuario.getRol());
			usuarioRepo.save(usuario);
		}
		
		//tipos de lecturas
		
		public List<Usuario> readUsuarios(){
			return usuarioRepo.findAll();
		}
		
		
		//tipos de actualizacion
		
		public void update(){
			
		}
		
		
		//tipos de eliminacion
		
		public void delete(){
			usuarioRepo.deleteAll();
			rolRepo.deleteAll();
		}
}
