package net.rossillo.car.repository;
import java.util.List;

import net.rossillo.car.domain.Automaker;
import net.rossillo.car.domain.Car;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends MongoRepository<Car, String>, CustomCarRepository {

	public List<Car> findByAutomaker(Automaker make);
	
	public List<Car> findByAutomakerIn(Automaker... makers);
	
}
