package com.ajax.prueba.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ajax.documents.Pedido;

@Repository
public interface PedidoRepo extends MongoRepository<Pedido , String> {

}
