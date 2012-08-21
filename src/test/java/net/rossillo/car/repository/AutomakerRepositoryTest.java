package net.rossillo.car.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import net.rossillo.car.domain.Automaker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:repositories.xml")
public final class AutomakerRepositoryTest {

	@Autowired
	AutomakerRepository automakerRepository;
	
	@Before
	public void setUp() throws Exception {
		automakerRepository.save(new Automaker("Honda"));
	}

	@After
	public void tearDown() throws Exception {
		automakerRepository.deleteAll();
	}

	@Test
	public void testFindByName() {
		assertNotNull(automakerRepository.findByName("Honda"));
		assertNull(automakerRepository.findByName("Foo"));
	}

}
