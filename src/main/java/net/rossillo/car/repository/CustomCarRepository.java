package net.rossillo.car.repository;

import java.util.List;

import net.rossillo.car.domain.Automaker;
import net.rossillo.car.domain.Car;

public interface CustomCarRepository {
	public List<Car> findCarsByAutomakers(Automaker... makers);
}
