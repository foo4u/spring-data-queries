package net.rossillo.car.repository;

import static org.junit.Assert.assertEquals;
import net.rossillo.car.domain.Automaker;
import net.rossillo.car.domain.Car;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/repositories.xml")
public final class CarRepositoryTest {

	@Autowired
	AutomakerRepository automakerRepository;
	
	@Autowired
	CarRepository carRepository;
	
	private Automaker ford;
	private Automaker honda;
	private Automaker toyota;
	
	@Before
	public void setUp() throws Exception {
		
		ford = automakerRepository.save(new Automaker("Ford"));
		honda = automakerRepository.save(new Automaker("Honda"));
		toyota = automakerRepository.save(new Automaker("Toyota"));
		
		carRepository.save(new Car(ford, "Explorer"));
		
		carRepository.save(new Car(honda, "Accord"));
		carRepository.save(new Car(honda, "Civic"));
		carRepository.save(new Car(honda, "Pilot"));
		
		carRepository.save(new Car(toyota, "Camry"));
		carRepository.save(new Car(toyota, "Yaris"));
		carRepository.save(new Car(toyota, "Highlander"));
	}

	@After
	public void tearDown() throws Exception {
		carRepository.deleteAll();
		automakerRepository.deleteAll();
	}

	@Test
	public void testFindByAutomaker() {
		assertEquals(1, carRepository.findByAutomaker(ford).size());
		assertEquals(3, carRepository.findByAutomaker(honda).size());
		assertEquals(3, carRepository.findByAutomaker(toyota).size());
	}
	
	@Test
	public void testFindByAutomakerIn() {
		assertEquals(4, carRepository.findByAutomakerIn(ford, toyota));
	}
	
	@Test
	public void testFindCarsByAutomakers() {
		assertEquals(4, carRepository.findCarsByAutomakers(ford, honda));
	}

}
