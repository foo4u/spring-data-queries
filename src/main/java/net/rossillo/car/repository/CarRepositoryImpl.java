package net.rossillo.car.repository;

import java.util.List;

import net.rossillo.car.domain.Automaker;
import net.rossillo.car.domain.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public final class CarRepositoryImpl implements CustomCarRepository {
	
	@Autowired
	MongoTemplate template;

	@Override
	public List<Car> findCarsByAutomakers(Automaker... makers) {
		Query q = new Query(new Criteria("automaker").in((Object[]) makers));
		return template.find(q, Car.class);
	}

}
