package com.ajax.prueba.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ajax.documents.Usuario;

public interface UsuarioRepo extends MongoRepository<Usuario , String> {

}
