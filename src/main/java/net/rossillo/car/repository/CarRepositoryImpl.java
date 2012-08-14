package net.rossillo.car.repository;

import java.util.ArrayList;
import java.util.List;

import net.rossillo.car.domain.Automaker;
import net.rossillo.car.domain.Car;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public final class CarRepositoryImpl implements CustomCarRepository {
	
	@Autowired
	MongoTemplate template;

	@Override
	public List<Car> findCarsByAutomakers(Automaker... makers) {
		
		final List<ObjectId> idList = new ArrayList<ObjectId>(makers.length);
		
		for(final Automaker maker : makers) {
			idList.add(new ObjectId(maker.getId()));
		}
		
		Query q = new Query(new Criteria("automaker.$id").in(idList));
		
		return template.find(q, Car.class);
	}

}
