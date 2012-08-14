package net.rossillo.car.repository;

import net.rossillo.car.domain.Automaker;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomakerRepository extends MongoRepository<Automaker, String> {

	public Automaker findByName(String name);

}
