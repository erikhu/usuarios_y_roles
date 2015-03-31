package com.ajax.documents;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Usuario {

	private String id;
	private String usuario;
	private String clave;
	
	@DBRef 
	private Rol rol;
	
	
	public Rol getRol(){
		return rol;
	}
	
	public void setRol(Rol rol){
		this.rol = rol;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}

}
