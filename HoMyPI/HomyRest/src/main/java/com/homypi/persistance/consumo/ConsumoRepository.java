package com.homypi.persistance.consumo;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.homypi.entity.Consumo;

public interface ConsumoRepository extends MongoRepository<Consumo, String> {
	
	@Query(value = "{ 'time' : {$gte : ?0, $lte: ?1 }}")
	public ArrayList<Consumo> findConsumoByDateDesdeHasta(Date desde, Date hasta);
	
	@Query(value = "{ 'sort' : {$natural:-1} }")
	public Consumo findLastItemAdded();

}
