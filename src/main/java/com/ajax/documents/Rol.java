package com.ajax.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Roles")
public class Rol {

	@Id
	private String id;

	private int rol;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getRol() {
		return rol;
	}
	public void setRol(int rol) {
		this.rol = rol;
	}
}
