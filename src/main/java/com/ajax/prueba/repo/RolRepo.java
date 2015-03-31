package com.ajax.prueba.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ajax.documents.Rol;

@Repository
public interface RolRepo extends MongoRepository<Rol , String> {

}
